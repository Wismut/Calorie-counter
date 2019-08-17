package javawebinar.topjava;


import javawebinar.topjava.model.Role;
import javawebinar.topjava.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class LoggedUser implements UserDetails {
	protected int id = 0;
	protected Set<Role> roles = Collections.singleton(Role.ROLE_USER);
	protected boolean enabled = true;

	private static LoggedUser LOGGED_USER = new LoggedUser();

	public LoggedUser(User user) {
		id = user.getId();
		roles = user.getRoles();
		enabled = user.isEnabled();
	}

	public LoggedUser() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public static LoggedUser get() {
		return LOGGED_USER;
	}

	public static int id() {
		return get().id;
	}

	public static LoggedUser safeGet() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return null;
		}
		Object user = auth.getPrincipal();
		return user instanceof LoggedUser ? (LoggedUser) user : null;
	}
}
