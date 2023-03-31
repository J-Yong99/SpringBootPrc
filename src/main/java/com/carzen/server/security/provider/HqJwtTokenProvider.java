package com.carzen.server.security.provider;

import com.carzen.server.repository.HqUserRepository;
import com.carzen.server.security.token.JwtAuthenticationToken;
import com.carzen.server.security.userdetails.CustomerUserDetails;
import com.carzen.server.security.userdetails.HqUserDetails;
import com.carzen.server.security.userdetails.HqUserDetailsService;
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
public class HqJwtTokenProvider implements AuthenticationProvider {

    @Autowired
    public HqJwtTokenProvider(HqUserDetailsService hqUserDetailsService, HqUserRepository hqUserRepository, JwtTokenUtils jwtTokenUtils) {
        this.hqUserDetailsService = hqUserDetailsService;
        this.hqUserRepository = hqUserRepository;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    final HqUserDetailsService hqUserDetailsService;
    final HqUserRepository hqUserRepository;
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
            if (!Objects.equals(iss, "HQ")){return null;}
            // 만약 iss가 customer가 아니면 return null
            String loginId = oauthInfo.getSub();
            HqUserDetails user = (HqUserDetails) hqUserDetailsService.loadUserByUsername(loginId);
            if (user == null) {
                throw new BadCredentialsException("HqUserDetails is null");
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
