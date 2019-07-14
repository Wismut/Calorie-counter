package javawebinar.topjava.model;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class TestUser extends User {

	public TestUser(User u) {
		this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.isEnabled(), u.getRoles());
	}

	public TestUser(String name, String email, String password, Role role, Role... roles) {
		this(null, name, email, password, true, EnumSet.of(role, roles));
	}

	public TestUser(Integer id, String name, String email, String password, boolean enabled, Role role, Role... roles) {
		this(id, name, email, password, enabled, EnumSet.of(role, roles));
	}

	public TestUser(Integer id, String name, String email, String password, boolean enabled, Set<Role> roles) {
		super(id, name, email, password, enabled, roles);
	}

	public User copyAsUser() {
		return new User(this);
	}

	public User asUser() {
		return new User(this);
	}

	@Override
	public String toString() {
		return "User (" +
				"id=" + id +
				", email=" + email +
				", name=" + name +
				", enabled=" + enabled +
				", password=" + password +
				", authorities=" + roles +
				')';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TestUser that = (TestUser) o;

		return //comparePassword(this.password, that.password) &&
				Objects.equals(this.id, that.id)
						&& Objects.equals(this.name, that.name)
						&& Objects.equals(this.email, that.email)
						&& Objects.equals(this.enabled, that.enabled)
						&& Objects.equals(this.roles, that.roles);
//                    && Objects.equals(this.caloriesPerDay, that.caloriesPerDay); FIXME
	}
}