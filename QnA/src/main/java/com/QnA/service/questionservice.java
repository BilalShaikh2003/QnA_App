package com.QnA.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.QnA.quiz_questions;
import com.QnA.questiondao.Dao;

@Service
public class questionservice {

    @Autowired
    Dao Questiondao;

    public ResponseEntity<List<quiz_questions>> getallquestions() {
        try {
            return new ResponseEntity<>(Questiondao.findAll(), HttpStatus.OK);
        } 
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<quiz_questions>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(Questiondao.findByCategory(category), HttpStatus.OK);
        } 
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    }

    public ResponseEntity<String> addQuestion(quiz_questions question) {
        try {
            Questiondao.save(question);
            return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add question", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deletequestionById(Integer id) {
        if (Questiondao.existsById(id)) {
            Questiondao.deleteById(id);
            return new ResponseEntity<>("Question with id " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Question with id " + id + " not available", HttpStatus.NOT_FOUND);
        }   }

    public ResponseEntity<String> updateQuestion(Integer id, quiz_questions updatedQuestion) {
        if (Questiondao.existsById(id)) {
            quiz_questions existing = Questiondao.findById(id).get();

            existing.setCategory(updatedQuestion.getCategory());
            existing.setDifficultylevel(updatedQuestion.getDifficultylevel());
            existing.setQuestion_title(updatedQuestion.getQuestion_title());
            existing.setOption1(updatedQuestion.getOption1());
            existing.setOption2(updatedQuestion.getOption2());
            existing.setOption3(updatedQuestion.getOption3());
            existing.setOption4(updatedQuestion.getOption4());
            existing.setRight_answer(updatedQuestion.getRight_answer());

            Questiondao.save(existing);
            return new ResponseEntity<>("Question with id " + id + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Question with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
