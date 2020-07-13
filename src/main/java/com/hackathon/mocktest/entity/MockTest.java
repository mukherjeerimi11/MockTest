
package com.hackathon.mocktest.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("mocktestCollection")
public class MockTest {

	@Id
	@Field("mockTestId")
    private String mockTestId;
    private String organizationId;
    private String subjectCode;
    private String associateId;
    private List<Question> questions = new ArrayList<Question>();

    public String getMockTestId() {
        return mockTestId;
    }

    public void setMockTestId(String mockTestId) {
        this.mockTestId = mockTestId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
