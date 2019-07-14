package javawebinar.topjava.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
public class User extends NamedEntity {
	@Column(name = "email", nullable = false, unique = true)
	@Email
	@NotEmpty
	protected String email;

	@Column(name = "password", nullable = false)
	@NotEmpty
	@Length(min = 5)
	protected String password;

	@Column(name = "enabled", nullable = false)
	protected boolean enabled = true;

	@Column(name = "registered", columnDefinition = "timestamp default now()")
	protected Date registered;

	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)
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
