package com.bms.service;

import java.util.List;

import com.bms.model.State;

public interface StateService {
	
	public void addState(State state);
	
	public void updateState(State state);
	
	public void deleteState(int stateid);
	
	public List<State> statelist();
	
	public State getStateById(int stateid);
}
