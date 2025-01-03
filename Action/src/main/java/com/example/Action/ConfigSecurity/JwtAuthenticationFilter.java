//package com.example.Action.ConfigSecurity;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Collections;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final String SECRET_KEY = "a3h57U3fJwG5QpZ9YzPc8fF0UiM+Qo1lBhI5b63P1lI=";
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException {
//        String token = request.getHeader("Authorization");
//
//        if (token != null && token.startsWith("Bearer ")) {
//            token = token.substring(7);
//
//            try {
//                Claims claims = Jwts.parser()
//                        .setSigningKey(SECRET_KEY.getBytes())
//                        .parseClaimsJws(token)
//                        .getBody();
//
//                String username = claims.getSubject();
//
//                if (username != null) {
//                    UsernamePasswordAuthenticationToken authenticationToken =
//                            new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken); // Set the authentication context
//                }
//            } catch (Exception e) {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("Invalid Token");
//                return;
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
