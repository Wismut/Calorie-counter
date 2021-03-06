package javawebinar.topjava;

import javawebinar.topjava.model.Role;
import javawebinar.topjava.model.User;
import javawebinar.topjava.to.UserTo;
import javawebinar.topjava.util.UserUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Set;

import static java.util.Objects.requireNonNull;


public class LoggedUser implements UserDetails, Serializable {
    private UserTo userTo;
    private final boolean enabled;
    private final Set<Role> roles;
    private final String encodedPassword;

    public LoggedUser(User user) {
        this.userTo = UserUtil.asTo(user);
        this.enabled = user.isEnabled();
        this.roles = user.getRoles();
        this.encodedPassword = user.getPassword();
    }

    public static LoggedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser) ? (LoggedUser) user : null;
    }

    public static LoggedUser get() {
        LoggedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    public static int id() {
        return get().userTo.getId();
    }

    @Override
    public Set<Role> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return encodedPassword;
    }

    @Override
    public String getUsername() {
        return userTo.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void updateUserTo(UserTo userTo) {
        userTo.setId(this.userTo.getId());
        this.userTo = UserUtil.asTo(userTo);
    }
}
