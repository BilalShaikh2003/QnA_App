package com.QnA.questiondao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QnA.quiz_questions;


@Repository
public interface Dao extends JpaRepository<quiz_questions, Integer>  {
	


	List<quiz_questions> findByCategory(String category);
	 

}
