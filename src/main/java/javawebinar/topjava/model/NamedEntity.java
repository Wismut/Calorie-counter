package javawebinar.topjava.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity extends BaseEntity {
	@NotEmpty
	@Column(name = "name", nullable = false)
	protected String name;

	public NamedEntity() {

	}

	protected NamedEntity(String name) {
		this.name = name;
	}

	public NamedEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
