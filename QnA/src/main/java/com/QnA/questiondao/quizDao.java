package com.QnA.questiondao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QnA.model.quiz;

public interface quizDao extends JpaRepository<quiz , Integer>{

	
}
