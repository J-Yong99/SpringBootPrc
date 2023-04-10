package com.carzen.server.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carzen.server.security.token.JwtAuthenticationToken;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtTokenFilter extends AbstractAuthenticationProcessingFilter {
    final String AUTH_HEADER_NAME = "Authorization";
    final String BEARER_NAME = "Bearer";

    final Map<String, List<HttpMethod>> EXCLUDED_PATHS = new HashMap<>();

    public JwtTokenFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/**"));
        setAuthenticationManager(authenticationManager);
        // "/device/**" 경로에서 HTTP GET 메소드를 제외
        EXCLUDED_PATHS.put("/hqUser", Collections.singletonList(HttpMethod.POST));
        EXCLUDED_PATHS.put("/login", Collections.singletonList(HttpMethod.POST));
        EXCLUDED_PATHS.put("/customer1", Collections.singletonList(HttpMethod.POST));
        EXCLUDED_PATHS.put("/customer2", Collections.singletonList(HttpMethod.POST));
        EXCLUDED_PATHS.put("/device", Collections.singletonList(HttpMethod.POST));
        EXCLUDED_PATHS.put("/api/recall", Collections.singletonList(HttpMethod.POST));
        EXCLUDED_PATHS.put("/api/biztalk/token", Collections.singletonList(HttpMethod.GET));
        EXCLUDED_PATHS.put("/toss/card/reqSuccess", Collections.singletonList(HttpMethod.GET));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getRequestURI().substring(request.getContextPath().length());
        HttpMethod method = HttpMethod.valueOf(request.getMethod());

        // 경로와 HTTP 메소드가 일치하는 경우 필터링을 제외
        if (EXCLUDED_PATHS.containsKey(path) && EXCLUDED_PATHS.get(path).contains(method)) {
            chain.doFilter(req, res);
            return;
        }

        super.doFilter(req, res, chain);
    }

//    public JwtTokenFilter(AuthenticationManager authenticationManager) {
//        super(new OrRequestMatcher(
//                new AntPathRequestMatcher("/customer/**"),
//                new AntPathRequestMatcher("/company/**"),
//                new AntPathRequestMatcher("/device/**", "GET"),
//                new AntPathRequestMatcher("/hqUser", "GET")
//        ));
//        setAuthenticationManager(authenticationManager);
//
//    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        System.out.println("enter JwtTokenFilter.attemptAuthentication");
        String token = extractToken(request);
        token = token;
        if (StringUtils.hasText(token)) {
            return this.getAuthenticationManager().authenticate(new JwtAuthenticationToken(token));
        }
        throw new AuthenticationCredentialsNotFoundException("No JWT token found in request headers");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("enter JwtTokenFilter.successfulAuthentication");
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);
        chain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader(AUTH_HEADER_NAME);
        if (authHeader == null || authHeader.isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Auth header does not exists");
        }
        String[] authHeaderValue = authHeader.split(" ");
        if (authHeaderValue.length != 2){
            throw new AuthenticationCredentialsNotFoundException("invalid auth header, require token");
        }
        if(!BEARER_NAME.equals(authHeaderValue[0])) {
            throw new BadCredentialsException("invalid auth header, require bearer");
        }
        return authHeaderValue[1];
    }
}