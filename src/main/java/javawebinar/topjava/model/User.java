package javawebinar.topjava.model;

import javawebinar.topjava.util.AbstractUser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
		@NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1"),
		@NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name, u.email"),
})
public class User extends NamedEntity implements AbstractUser {
	public static final String DELETE = "User.delete";
	public static final String ALL_SORTED = "User.getAllSorted";
	public static final String BY_EMAIL = "User.getByEmail";

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
	protected Date registered = new Date();

	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//	@JsonIgnore
	protected Set<Role> roles;
	protected Integer caloriesPerDay = 0;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserMeal> userMeals = new LinkedList<>();

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

	@Override
	public int getCaloriesPerDay() {
		return caloriesPerDay;
	}

	@Override
	public void setCaloriesPerDay(int caloriesPerDay) {
		this.caloriesPerDay = caloriesPerDay;
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

	public void setRoles(Role... authorities) {
		setRoles(Arrays.asList(authorities));
	}

	public void setRoles(Collection<Role> authorities) {
		this.roles = EnumSet.copyOf(authorities);
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
}
