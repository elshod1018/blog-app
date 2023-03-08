package com.company.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigurer {
    private final UserUserDetailsService userUserDetailsService;

    public SecurityConfigurer(UserUserDetailsService userUserDetailsService) {
        this.userUserDetailsService = userUserDetailsService;
    }

    public static final String[] WHITE_LIST = {
            "/css/**",
            "/js/**",
            "/auth/login",
            "/auth/register"
    };

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(WHITE_LIST)
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                            .loginPage("/auth/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/home", false)
                })
                .logout(httpSecurityLogoutConfigurer -> {
                    httpSecurityLogoutConfigurer
                            .logoutUrl("/auth/logout")
                            .clearAuthentication(true)
                            .deleteCookies("JSESSION", "rememberMe")
                            .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logou", "POST"));
                })
                .rememberMe(httpSecurityRememberMeConfigurer ->
                        httpSecurityRememberMeConfigurer
                                .rememberMeParameter("rememberMe")
                                .key("WIEHEBHWIK@$KKAL$JNNGY$JHGCFKJN$")
                                .tokenValiditySeconds(60 * 60)
                                .rememberMeCookieName("rememberMe")
                                .userDetailsService(userUserDetailsService)
                );
        return http.build();
    }

}
