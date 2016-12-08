//	NAO DELETAR ESSA CLASSE - PODE SER IMPORTANTE FUTURAMENTE POIS ELA DEFINE AS UM CAMINHO ALTERNATIVO AS URLS

//package com.br.pb.sisbus.config;
//
//import java.io.IOException;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.WebAttributes;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException {
//		
//		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//        if (roles.contains("USER")) {
//            response.sendRedirect("/index");
//        }
//        if (roles.contains("ADMIN")) {
//            response.sendRedirect("/admin");
//        }
//        if (roles.contains("GESTOR")) {
//            response.sendRedirect("/gestor");
//        }
//		
//	}
//
//	protected void clearAuthenticationAttributes(HttpServletRequest request) {
//		HttpSession session = request.getSession(false);
//		if (session == null) {
//			return;
//		}
//		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//	}
//
//	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
//		this.redirectStrategy = redirectStrategy;
//	}
//
//	protected RedirectStrategy getRedirectStrategy() {
//		return redirectStrategy;
//	}
//
//}