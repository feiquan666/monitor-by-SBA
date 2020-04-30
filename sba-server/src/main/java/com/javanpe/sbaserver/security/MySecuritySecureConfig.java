package com.javanpe.sbaserver.security;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import java.util.UUID;

/**
 * description: 安全配置
 * date: 2020-04-28 17:13:36
 * @author: 飞拳
 */
@Configuration(proxyBeanMethods = false)
public class MySecuritySecureConfig extends WebSecurityConfigurerAdapter {
    private final AdminServerProperties adminServer;

    public MySecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminServer = adminServerProperties;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(this.adminServer.path("/"));

        http.authorizeRequests()
                // 允许访问静态资源和登录页面
                .antMatchers(this.adminServer.path("/assets/**")).permitAll()
                .antMatchers(this.adminServer.path("/login")).permitAll()
                // 其他请求必须经过验证
                .anyRequest().authenticated()
                .and()
                // 配置登录和注销
                .formLogin().loginPage(this.adminServer.path("/login")).successHandler(successHandler)
                .and()
                .logout().logoutUrl(this.adminServer.path("/logout"))
                .and()
                // 启用http-base支持，这是sba-client需要的
                .httpBasic()
                .and()
                .csrf()
                // 启用csrf保护
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringRequestMatchers(
                        // 禁用csrf保护的使用sba-client注册的端点
                        new AntPathRequestMatcher(this.adminServer.path("/instances"), HttpMethod.POST.toString()),
                        // 禁用csrf保护的使用sba-client注册的端点
                        new AntPathRequestMatcher(this.adminServer.path("/instances/*"), HttpMethod.DELETE.toString()),
                        // 禁用csrf保护Actuator的端点
                        new AntPathRequestMatcher(this.adminServer.path("/actuator/**"))
                )
                .and()
                .rememberMe().key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600);
        // @formatter:on
    }

    /**
     * 通过Java代码配置用户,优先级高于配置文件
     * Required to provide UserDetailsService for "remember functionality"
    */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{bcrypt}$2a$10$GbkIrw7xOt50SXQu7tIGcemSWcD73MwMhLSrjCkyvFhssirdBOEsG").roles("USER");
    }

    /**
     * 密码生成器
    */
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("需要加密的密码"));
    }
}
