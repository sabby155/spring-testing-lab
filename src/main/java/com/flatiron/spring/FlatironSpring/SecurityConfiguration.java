package com.flatiron.spring.FlatironSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests()
                .antMatchers("/api/status")
                .hasAuthority("admin")

                .antMatchers("/api/price")
                .hasAuthority("admin");



        http.authorizeRequests()
//                .anyRequest()
                .antMatchers("/api/**")
                .authenticated()
                .and()
//                .formLogin()
                .oauth2Login() // change httpBasic() to oauth2Login() for API resources
                .and()
                .logout();

        // adding a rule to require authentication for all content via OAuth
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();

        UserDetails user1 = User.withUsername("mary")
                .password(passwordEncoder().encode("test"))
                .authorities("read")
                .build();

        userDetailService.createUser(user1);

        UserDetails adminUser1 = User.withUsername("admin")
                .password(passwordEncoder().encode("test"))
                .authorities("admin")
                .build();
        userDetailService.createUser(adminUser1);

        return userDetailService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}