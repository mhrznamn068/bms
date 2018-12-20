package com.bms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.StateDao;
import com.bms.model.State;

@Repository
public class StateDaoImpl implements StateDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addState(State state) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(state);
	}

	@Override
	public void updateState(State state) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(state);
	}

	@Override
	public void deleteState(int stateid) {
		Session session=this.sessionFactory.getCurrentSession();
		State state=(State)session.load(State.class, new Integer(stateid));
		if(state!=null){
		session.delete(state);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<State> statelist() {
		Session session=this.sessionFactory.getCurrentSession();
		List<State> statelist=session.createQuery("from State").list();
		return statelist;
	}

	@Override
	public State getStateById(int stateid) {
		Session session=this.sessionFactory.getCurrentSession();
		State state=(State)session.load(State.class, new Integer(stateid));
		return state;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<State> getStatesByIds(List<Integer> statesids) {
		Session session=this.sessionFactory.getCurrentSession();
		List<State> statesid=session.createQuery("from State where stateid='"+statesids+"'").list();
		return statesid;
	}

}
