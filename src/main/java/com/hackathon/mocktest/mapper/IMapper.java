package com.hackathon.mocktest.mapper;

public interface IMapper<R,S> {
	
	R getEntity(S client);
	S getClient(R entity);

}
