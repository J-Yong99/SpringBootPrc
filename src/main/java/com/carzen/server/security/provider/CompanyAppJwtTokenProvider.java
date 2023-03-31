package com.carzen.server.security.provider;

import com.carzen.server.domain.Company;
import com.carzen.server.repository.CompanyRepository;
import com.carzen.server.security.token.JwtAuthenticationToken;
import com.carzen.server.security.userdetails.CompanyUserDetails;
import com.carzen.server.security.userdetails.CompanyUserDetailsService;
import com.carzen.server.security.userdetails.CustomerUserDetails;
import com.carzen.server.utils.JwtTokenUtils;
import com.carzen.server.utils.OauthInfo;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Component
public class CompanyAppJwtTokenProvider implements AuthenticationProvider {

    @Autowired
    public CompanyAppJwtTokenProvider(CompanyUserDetailsService companyUserDetailsService, CompanyRepository companyRepository, JwtTokenUtils jwtTokenUtils) {
        this.companyUserDetailsService = companyUserDetailsService;
        this.companyRepository = companyRepository;
        this.jwtTokenUtils = jwtTokenUtils;
    }
    final CompanyUserDetailsService companyUserDetailsService;
    final CompanyRepository companyRepository;
    final JwtTokenUtils jwtTokenUtils;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String jwtToken = authentication.getCredentials().toString();

        // JwtToken을 검증하고 사용자 정보를 가져오는 로직
        try {
            if (!jwtTokenUtils.validate(jwtToken)){
                throw  new BadCredentialsException("token not valid");
            }
            OauthInfo oauthInfo = jwtTokenUtils.getOauthInfo(jwtToken);
            String iss = oauthInfo.getIss();
            if (!Objects.equals(iss, "company")){return null;}
            // 만약 iss가 company가 아니면 return null
            String serialNumber = oauthInfo.getSub();
            CompanyUserDetails user = (CompanyUserDetails) companyUserDetailsService.loadUserByUsername(serialNumber);
            if (user == null) {
                throw new BadCredentialsException("CompanyUserDetails is null");
            }
            return new JwtAuthenticationToken(user, user.getAuthorities());
        } catch (ExpiredJwtException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getLocalizedMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(JwtAuthenticationToken.class);
    }
}
