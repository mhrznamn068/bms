package com.bms.dao;

import java.util.List;

import com.bms.model.State;

public interface StateDao {
	
	public void addState(State state);
	
	public void updateState(State state);
	
	public void deleteState(int stateid);
	
	public List<State> statelist();
	
	public State getStateById(int stateid);
	
	public List<State> getStatesByIds(List<Integer> statesids);

}
