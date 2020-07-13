package com.hackathon.mocktest.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hackathon.mocktest.entity.MockTest;
import com.hackathon.mocktest.entity.Question;

@Component("mockMapper")
public class MockMapper implements IMapper<MockTest, com.hackathon.mocktest.dto.client.services.MockTest> {

	@Override
	public MockTest getEntity(com.hackathon.mocktest.dto.client.services.MockTest client) {
		MockTest mockTest = new MockTest();
		mockTest.setMockTestId(client.getMockTestId());
		mockTest.setOrganizationId(client.getOrganizationId());
		mockTest.setSubjectCode(client.getSubjectCode());
		mockTest.setAssociateId(client.getAssociateId());
		if (!CollectionUtils.isEmpty(client.getQuestions())) {
			mockTest.setQuestions(client.getQuestions().stream().map(question -> getQuestionEntity(question))
					.collect(Collectors.toList()));
		}
		return mockTest;
	}

	private Question getQuestionEntity(com.hackathon.mocktest.dto.client.services.Question clientQuestion) {
		Question question = new Question();
		question.setAnswerForOption(clientQuestion.getAnswerForOption());
		question.setCorrectAnswer(clientQuestion.getCorrectAnswer());
		question.setQuestion(clientQuestion.getQuestion());
		question.setQuestionId(clientQuestion.getQuestionId());
		question.setMarks(clientQuestion.getMarks());
		return question;
	}

	@Override
	public com.hackathon.mocktest.dto.client.services.MockTest getClient(MockTest entity) {
		com.hackathon.mocktest.dto.client.services.MockTest mockTest = new com.hackathon.mocktest.dto.client.services.MockTest();
		mockTest.setMockTestId(entity.getMockTestId());
		mockTest.setOrganizationId(entity.getOrganizationId());
		mockTest.setSubjectCode(entity.getSubjectCode());
		mockTest.setAssociateId(entity.getAssociateId());
		if (!CollectionUtils.isEmpty(entity.getQuestions())) {
			mockTest.setQuestions(entity.getQuestions().stream().map(question -> getQuestionClient(question))
					.collect(Collectors.toList()));
		}
		return mockTest;
	}

	private com.hackathon.mocktest.dto.client.services.Question getQuestionClient(Question entityQuestion) {
		com.hackathon.mocktest.dto.client.services.Question question = new com.hackathon.mocktest.dto.client.services.Question();
		question.setAnswerForOption(entityQuestion.getAnswerForOption());
		question.setCorrectAnswer(entityQuestion.getCorrectAnswer());
		question.setQuestion(entityQuestion.getQuestion());
		question.setQuestionId(entityQuestion.getQuestionId());
		question.setMarks(entityQuestion.getMarks());
		return question;
	}
}
