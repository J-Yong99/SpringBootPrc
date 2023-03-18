package com.springboot.prc.jykim.filter;

import com.springboot.prc.jykim.domain.HqUser;
import com.springboot.prc.jykim.domain.AdminUserDetails;
import com.springboot.prc.jykim.service.HqUserService;
import com.springboot.prc.jykim.service.UserDetailsServiceImpl;
import com.springboot.prc.jykim.utils.JwtTokenUtils;
import com.springboot.prc.jykim.utils.OauthInfo;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

//    @Lazy
    @Autowired
    UserDetailsServiceImpl userDetailsService;
//    @Lazy
    @Autowired
    JwtTokenUtils jwtTokenUtils;
//    @Lazy
    @Autowired
HqUserService hqUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken beforeToken = (JwtAuthenticationToken) authentication;
        String jwtToken = beforeToken.getCredential();

        try {
            if (!jwtTokenUtils.validate(jwtToken)){
                throw  new BadCredentialsException("token not valid");
            }
            OauthInfo oauthInfo = jwtTokenUtils.getOauthInfo(jwtToken);
            String loginId = oauthInfo.getLoginId();
            String loginPw = oauthInfo.getLoginPw();
            HqUser user = hqUserService.findByloginId(loginId);
            if (!loginPw.equals(user.getLoginPw())){
                throw new Exception("PW not correct!");
            }

            AdminUserDetails adminUser = userDetailsService.loadUserByUsername(loginId);
            return new JwtAuthenticationToken(adminUser, adminUser.getAuthorities());
        } catch (ExpiredJwtException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getLocalizedMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
