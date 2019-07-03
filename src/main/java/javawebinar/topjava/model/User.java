package javawebinar.topjava.model;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

public class User extends NamedEntity {
	protected String email;
	protected String password;
	protected boolean enabled = true;
	protected Date registered = new Date();
	protected Set<Role> roles;
	protected Integer caloriesPerDay = 0;

	public User() {

	}

	public User(User user) {
		this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled(), user.getRoles());
	}

	public User(Integer id, String name, String email, String password, boolean enabled, Role role, Role... roles) {
		this(id, name, email, password, enabled, EnumSet.of(role, roles));
	}

	public User(Integer id, String name, String email, String password, boolean enabled, Set<Role> roles) {
		super(id, name);
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addAuthority(Role authority) {
		if (roles == null) {
			roles = EnumSet.of(authority);
		} else {
			roles.add(authority);
		}
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				", registered=" + registered +
				", roles=" + roles +
				'}';
	}

	public Integer getCaloriesPerDay() {
		return caloriesPerDay;
	}
}
