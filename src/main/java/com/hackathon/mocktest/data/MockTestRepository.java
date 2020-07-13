package com.hackathon.mocktest.data;


import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.mocktest.entity.MockTest;

@Repository
public interface MockTestRepository extends MongoRepository<MockTest, String> {
	List<MockTest> findByOrganizationIdAndSubjectCode(String orgId, String subCode);
}
