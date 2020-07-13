package com.hackathon.mocktest.services;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import com.hackathon.mocktest.data.MockTestRepository;
import com.hackathon.mocktest.dto.client.services.MockTest;
import com.hackathon.mocktest.mapper.IMapper;

@Service("mockTestService")
public class MockTestService implements IMockTestService<com.hackathon.mocktest.dto.client.services.MockTest, String> {

	@Autowired
	@Qualifier("mockMapper")
	private IMapper<com.hackathon.mocktest.entity.MockTest, com.hackathon.mocktest.dto.client.services.MockTest> mockMapper;
	
	@Autowired
	private MockTestRepository mockTestRepository;
	
	@Override
	public MockTest getMockTest(String orgId, String subId) {
		/*MockTest mockTest = new MockTest();
		mockTest.setOrganizationId(orgId);
		mockTest.setSubjectCode(subId);*/
		List<com.hackathon.mocktest.entity.MockTest> mockTestList = mockTestRepository.findByOrganizationIdAndSubjectCode(orgId, subId);
		Collections.shuffle(mockTestList);
		return mockMapper.getClient(mockTestList.get(0));
	}

	@Override
	public MockTest createMockTest(MockTest mocktest) {
		mocktest.setMockTestId(UUID.randomUUID().toString());
		mocktest = mockMapper.getClient(mockTestRepository.insert(mockMapper.getEntity(mocktest)));
		return mocktest;
	}

	@Override
	public MockTest updateMockTest(MockTest mocktest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMockTest(String mockTestId) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<MockTest> getAllMockTests(String orgId, String subId) {
		com.hackathon.mocktest.entity.MockTest mockTest = new com.hackathon.mocktest.entity.MockTest();
		mockTest.setOrganizationId(orgId);
		//mockTest.setSubjectCode(subId);
		/*ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("organizationId", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.EXACT))
				.withMatcher("subjectCode", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.EXACT));*/
		Example example = Example.of(mockTest);
		List<com.hackathon.mocktest.entity.MockTest> mockTestList = mockTestRepository.findByOrganizationIdAndSubjectCode(orgId, subId);
		return mockTestList.stream().map(mocktest -> mockMapper.getClient(mocktest)).collect(Collectors.toList());
	}
}
