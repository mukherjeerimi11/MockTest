
package com.hackathon.mocktest.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Question {

    private String questionId;
    private String question;
    private List<String> answerForOption = new ArrayList<String>();
    private String correctAnswer;
    private Double marks;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswerForOption() {
        return answerForOption;
    }

    public void setAnswerForOption(List<String> answerForOption) {
        this.answerForOption = answerForOption;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

	/**
	 * @return the marks
	 */
	public Double getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(Double marks) {
		this.marks = marks;
	}
}
