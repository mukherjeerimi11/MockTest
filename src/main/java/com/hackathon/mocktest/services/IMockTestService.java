package com.hackathon.mocktest.services;

import java.util.List;

public interface IMockTestService<P, R> {

	P getMockTest(R orgId, R subId);
	
	List<P> getAllMockTests(R orgId, R subId);

	P createMockTest(P mocktest);

	P updateMockTest(P mocktest);

	void deleteMockTest(R mockTestId);

}
