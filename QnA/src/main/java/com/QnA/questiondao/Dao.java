package com.QnA.questiondao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QnA.quiz_questions;


@Repository
public interface Dao extends JpaRepository<quiz_questions, Integer>  {

}
