package org.animopts.db;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {

	public static void addCookie(String name, String value, int expiry, HttpServletRequest request,
			HttpServletResponse response) {

		if (value == null)
			return;

		// Remove cookie first for replacement (if exists)
		removeCookie(name, request, response);

		Cookie c = new Cookie(name, value);
		c.setMaxAge(expiry); // 1 day
		response.addCookie(c);

		System.out.println("ADDED A COOKIEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	}

	public static Cookie getCookie(String name, HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();

		if (cookies != null)
			for (int i = 0; i < cookies.length; i++) {
				System.out.println("COOKIE = " + cookies[i].getName());
				if (cookies[i].getName().equals(name))
					return cookies[i];
			}

		return null;

	}

	public static void addCookie(String name, String value, HttpServletRequest request, HttpServletResponse response) {
		addCookie(name, value, Integer.MAX_VALUE, request, response);
	}

	public static void removeCookie(String name, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		// Kill cookie
		if (cookies != null)
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(name)) {
					System.out.println("removeCookie: " + name);
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
	}
}
