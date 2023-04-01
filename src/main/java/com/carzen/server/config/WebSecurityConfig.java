package com.carzen.server.config;

import com.carzen.server.security.provider.CompanyAppJwtTokenProvider;
import com.carzen.server.security.provider.CustomerAppJwtTokenProvider;
import com.carzen.server.security.JwtTokenFilter;
import com.carzen.server.security.provider.HqJwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomerAppJwtTokenProvider customerAppJwtTokenProvider;

    @Autowired
    private CompanyAppJwtTokenProvider companyAppJwtTokenProvider;

    @Autowired
    private HqJwtTokenProvider hqJwtTokenProvider;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public JwtTokenFilter jwtTokenFilter() throws Exception {
        return new JwtTokenFilter(authenticationManagerBean());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CORS 비활성화
        // CSRF 비활성화
        // JSESSION 비활성화
        // 회원 가입을 제외한 모든 요청에 대해 인증 진행
        // UsernamePasswordAuthenticationFilter 앞 단에 Jwt Handler Filter
        http
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/hqUser").permitAll()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/hqUser").hasRole("HQA")
                    .antMatchers(HttpMethod.POST, "/customer1").permitAll()
                    .antMatchers(HttpMethod.POST, "/customer2").permitAll()
                    .antMatchers("/company/**").hasAnyRole("HQA","COMPANY")
                    .antMatchers(HttpMethod.POST, "/device").permitAll()
                    .antMatchers(HttpMethod.GET, "/device").hasRole("HQA")
                    .antMatchers("/customer/**").hasRole("CUSTOMERA")

                    .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)

        ;
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/register/**")
        ;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customerAppJwtTokenProvider);
        auth.authenticationProvider(companyAppJwtTokenProvider);
        auth.authenticationProvider(hqJwtTokenProvider);
    }
}