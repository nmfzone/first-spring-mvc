package com.nmfzone.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nmfzone.app.model.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long> {

	public List<Skill> findByLabel(String label);

}
