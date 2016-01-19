package com.nmfzone.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.persistence.Table;

@Table(name="developer")
@Entity
public class Developer implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
	private long id;
    @Column(name="firstName")
	private String firstName;
    @Column(name="lastName")
	private String lastName;
    @Column(name="email")
	private String email;
	@ManyToMany
	private List<Skill> skills;

    public Developer() {}

	public Developer(String firstName, String lastName, String email, List<Skill> skills)
    {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.skills = skills;
	}

	public long getId()
    {
		return id;
	}

	public void setId(long id)
    {
		this.id = id;
	}

	public String getFirstName()
    {
		return firstName;
	}

	public void setFirstName(String firstName)
    {
		this.firstName = firstName;
	}

	public String getLastName()
    {
		return lastName;
	}

	public void setLastName(String lastName)
    {
		this.lastName = lastName;
	}

	public String getEmail()
    {
		return email;
	}

	public void setEmail(String email)
    {
		this.email = email;
	}

	public List<Skill> getSkills()
    {
		return skills;
	}

	public void setSkills(List<Skill> skills)
    {
		this.skills = skills;
	}

	public boolean hasSkill(Skill skill)
    {
		for (Skill containedSkill: getSkills()) {
			if (containedSkill.getId() == skill.getId()) {
				return true;
			}
		}
		return false;
	}

}
