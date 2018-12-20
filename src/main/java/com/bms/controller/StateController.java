package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.model.State;
import com.bms.service.StateService;

@Controller
@RequestMapping(value="/moderator")
public class StateController {

	@Autowired
	private StateService stateService;
	
	@RequestMapping(value="/state")
	public String stateform(Model model){
		model.addAttribute("state", new State());
		return "state";
	}
	
	@RequestMapping(value="/statelist")
	public String statelist(Model model){
		model.addAttribute("statelist",this.stateService.statelist());
		return "statelist";
	}
	
	@RequestMapping(value="/addstate",method=RequestMethod.POST)
	public String addState(@ModelAttribute State state,Model model){
		if(state.getStateid()==0){
			stateService.addState(state);
		}
		else{
			stateService.updateState(state);
		}
		return"redirect:/moderator/statelist";
	}
	
	@RequestMapping(value="/editstate/{stateid}")
	public String editState(@PathVariable("stateid")int stateid,Model model){
		model.addAttribute("state", this.stateService.getStateById(stateid));
		return "state";
	}
	
	@RequestMapping(value="/delstate/{stateid}")
	public String deleteState(@PathVariable("stateid")int stateid){
		this.stateService.deleteState(stateid);
		return"redirect:/moderator/statelist";
	}
}
