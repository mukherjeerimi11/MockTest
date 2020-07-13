package com.hackathon.mocktest.api.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.mocktest.dto.client.services.MockTest;
import com.hackathon.mocktest.services.IMockTestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class MockTestController {

	@Autowired
	@Qualifier("mockTestService")
	private IMockTestService<MockTest, String> mockTestService;

	@GetMapping("/mocktest/{orgId}/{subId}")
	@ApiOperation(notes = "method will fetch any random mock test depending on orgId and Subject code", value = "To fetch one mock test", response = MockTest.class)
	public ResponseEntity<MockTest> getMockTest(@ApiParam(value="Value of Organization Id", required= true) @PathVariable("orgId") String orgId,
			@ApiParam(value="Value of Subject Code", required= true) @PathVariable("subId") String subId) {
		MockTest mockTest = mockTestService.getMockTest(orgId, subId);
		return new ResponseEntity<MockTest>(mockTest, HttpStatus.OK);
	}

	@GetMapping("/mocktest/all/{orgId}/{subId}")
	@ApiOperation(notes = "method will fetch all mock tests depending on orgId and Subject code", value = "To fetch all mock tests", response = MockTest.class)
	public ResponseEntity<List<MockTest>> getAllMockTest(@ApiParam(value="Value of Organization Id", required= true)@PathVariable("orgId") String orgId,
			@ApiParam(value="Value of Subject Code", required= true) @PathVariable("subId") String subId){
		List<MockTest> mockTests = mockTestService.getAllMockTests(orgId, subId);
		return new ResponseEntity<List<MockTest>>(mockTests, HttpStatus.OK);
	}

	@PostMapping("/mocktest")
	@ApiOperation(notes = "method will create mock test", value = "To create mock test", response = MockTest.class)
	public ResponseEntity<MockTest> createMockTest(@RequestBody MockTest mocktest) {
		mocktest = mockTestService.createMockTest(mocktest);
		return new ResponseEntity<MockTest>(mocktest, HttpStatus.OK);
	}

	@PutMapping("/mocktest")
	public ResponseEntity<String> updateMockTest(@RequestBody MockTest mocktest) {
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}

	@DeleteMapping("/mocktest/{mockTestId}")
	public ResponseEntity<String> deleteMockTest(@PathVariable("mockTestId") String mockTestId) {
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}
}
