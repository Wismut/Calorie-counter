package javawebinar.topjava.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "meals")
@NamedQueries({
		@NamedQuery(name = UserMeal.GET, query = "SELECT m FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
		@NamedQuery(name = UserMeal.ALL_SORTED, query = "SELECT m FROM UserMeal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC"),
		@NamedQuery(name = UserMeal.DELETE_ALL, query = "DELETE FROM UserMeal i WHERE i.user.id=:userId"),
		@NamedQuery(name = UserMeal.DELETE, query = "DELETE FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
		@NamedQuery(name = UserMeal.GET_BETWEEN,
				query = "SELECT m from UserMeal m WHERE m.user.id=:userId "+
						" AND m.dateTime>:after and m.dateTime<:before ORDER BY m.dateTime DESC"),
})
public class UserMeal extends BaseEntity {
	public static final String GET = "UserMeal.get";
	public static final String ALL_SORTED = "UserMeal.getAll";
	public static final String DELETE = "UserMeal.delete";
	public static final String DELETE_ALL = "UserMeal.deleteAll";
	public static final String GET_BETWEEN = "UserMeal.getBetween";

	@Column(name = "datetime", nullable = false)
	private Date dateTime;

	@Column(name = "description", nullable = false)
	@NotEmpty
	private String description;

	@Column(name = "calories", nullable = false)
	private int calories;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public UserMeal() {

	}

	public UserMeal(UserMeal meal) {
		this(meal.id, meal.dateTime, meal.description, meal.calories);
	}

	public UserMeal(final Integer id, final Date dateTime, final String description, final int calories) {
		super(id);
		this.dateTime = dateTime;
		this.description = description;
		this.calories = calories;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCalories() {
		return calories;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "UserMeal{" +
				"dateTime=" + dateTime +
				", description='" + description + '\'' +
				", calories=" + calories +
				", id=" + id +
				'}';
	}
}
