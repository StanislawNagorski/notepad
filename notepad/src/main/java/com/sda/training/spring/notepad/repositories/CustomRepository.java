package com.sda.training.spring.notepad.repositories;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.sda.training.spring.notepad.models.Note;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CustomRepository {
	private final EntityManager entityManager;

	public Note otherCustomMethod(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Note> query = criteriaBuilder.createQuery(Note.class);
		//TBD and so on...
		return null;
	}
}
