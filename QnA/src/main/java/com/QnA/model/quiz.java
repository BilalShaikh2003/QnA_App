package com.QnA.model;

import java.util.List;

import com.QnA.quiz_questions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<quiz_questions> getQuestion() {
		return question;
	}
	public void setQuestion(List<quiz_questions> question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "quiz [id=" + id + ", title=" + title + ", question=" + question + "]";
	}

	private String title;
	
	@ManyToMany
	private List<quiz_questions> question;
	
}
