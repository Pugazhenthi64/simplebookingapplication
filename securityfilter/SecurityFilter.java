//package com.te.simplebookingsystem.securityfilter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.te.simplebookingsystem.security.config.JwtUtils;
//
//public class SecurityFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private JwtUtils utils;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		String token = request.getHeader("Authorization");
//		if(token != null) {
//		}
//		filterChain.doFilter(request, response);
//	 	
//	}
//
//}
///*
// * String bearerToken = request.getHeader("Authorization");
//		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//			String token = bearerToken.substring(7);
//			String usernameFromToken = jwtUtils.getUsername(token);
//			UserDetails userFromDb = userDetailsService.loadUserByUsername(usernameFromToken);
//			if (usernameFromToken != null && userFromDb.getUsername() != null
//					&& SecurityContextHolder.getContext().getAuthentication() == null) {
//				if (jwtUtils.validateToken(token, userFromDb.getUsername())) {
//
//					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//							userFromDb.getUsername(), userFromDb.getPassword(), userFromDb.getAuthorities());
//
//					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//				}
//			}
//		}
//		filterChain.doFilter(request, response);
//	}
// */
