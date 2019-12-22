package com.travel.vision.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import java.util.Collection;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.travel.vision.api"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final Collection<AuthenticationProvider> authenticationProviders;

    public SecurityConfig(
            AuthenticationEntryPoint authenticationEntryPoint,
            Collection<AuthenticationProvider> authenticationProviders
    ) {
        super();
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationProviders = authenticationProviders;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .csrf().disable()
                .cors().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.authorizeRequests()
                .antMatchers("/api/startup").permitAll()
                .anyRequest()
                .authenticated()
        ;
    }

    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers(HttpMethod.POST, "/api/v1/auth/facebook/login","/api/v1/auth/facebook/sign-up","/api/v1/auth/login", "/api/v1/auth/registration", "/api/v1/auth/new-password");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/v1/auth/verify-email/**","/api/v1/auth/check-email/**","/api/v1/auth/forgot-password/**");
        web.ignoring().antMatchers( HttpMethod.OPTIONS, "/**" );
        web
                .ignoring()
                .antMatchers();
        web.ignoring().antMatchers(
                HttpMethod.GET,
                "/resources/**",
                "/static/**",
                "/css/**",
                "/js/**",
                "/img/**",
                "/icons/**",
                "/logos/**",
                "/",
                "/webjars/**",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/webjars/**"
        );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        authenticationProviders.forEach(auth::authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

