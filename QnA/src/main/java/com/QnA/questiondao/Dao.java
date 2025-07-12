package com.QnA.questiondao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.QnA.quiz_questions;


@Repository
public interface Dao extends JpaRepository<quiz_questions, Integer>  {
	


	List<quiz_questions> findByCategory(String category);

	@Query(value = "SELECT * FROM quiz_questions q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	List<quiz_questions> findRandomByCategory(@Param("category") String category, @Param("numQ") int numQ);


}
