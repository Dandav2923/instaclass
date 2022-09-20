package com.clan.instaclass.classService.filter;

import com.clan.instaclass.classService.services.impl.ClassServiceImpl;
import com.clan.instaclass.classService.utility.JWTUtility;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private JWTUtility jwtUtility;
    private ClassServiceImpl classService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String token = null;
        boolean authOk = false;
        if (null != authorization && authorization.startsWith("Bearer ")) {
            token = authorization.substring(7);
            if (jwtUtility.validateToken(token)){
                authOk = true;
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(token,
                        null, new ArrayList<>());
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        if (!authOk) {
            generateError(response);
        }
        filterChain.doFilter(request, response);
    }
    private void generateError(HttpServletResponse response){
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}