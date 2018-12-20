package com.bms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.StateDao;
import com.bms.model.State;
import com.bms.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDao stateDao;
	
	@Override
	@Transactional
	public void addState(State state) {
	this.stateDao.addState(state);	
		
	}

	@Override
	@Transactional
	public void updateState(State state) {
		this.stateDao.updateState(state);
	}

	@Override
	@Transactional
	public void deleteState(int stateid) {
		this.stateDao.deleteState(stateid);
		
	}

	@Override
	@Transactional
	public List<State> statelist() {
		
		return this.stateDao.statelist();
	}

	@Override
	@Transactional
	public State getStateById(int stateid) {
		
		return this.stateDao.getStateById(stateid);
	}

}
