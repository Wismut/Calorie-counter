package javawebinar.topjava.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity extends BaseEntity {
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
