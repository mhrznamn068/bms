package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bms.model.Country;
import com.bms.service.CountryService;
import com.bms.service.StateService;


@Controller
@RequestMapping(value="/moderator")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@RequestMapping(value="/country", method=RequestMethod.GET)
	public String countryForm(Model model){
		model.addAttribute("country", new Country());
		//model.addAttribute("statelist", this.stateService.statelist());
		return "country";
	}
	
	@RequestMapping(value="/countrylist", method=RequestMethod.GET)
	public String countryList(Model model){
		model.addAttribute("countrylist", this.countryService.countrylist());
		//model.addAttribute("statelist", this.stateService.statelist());
		return"countrylist";
	}
	
	@RequestMapping(value="/addcountry", method=RequestMethod.POST)
	public String addCountry(@ModelAttribute Country country){
		if(country.getCountryid()==0){
		
			this.countryService.addCountry(country);
			
		}
		else{
			this.countryService.updateCountry(country);
		}
		return "redirect:/moderator/countrylist";
		
	}
	
	@RequestMapping(value="/joinconst", method=RequestMethod.GET)
	public String joinconst(Model model){
		model.addAttribute("countrylist",this.countryService.countrylist());
		model.addAttribute("statelist", this.stateService.statelist());
		return "joinconst";
	}
	
	@RequestMapping(value="/joinconst", method=RequestMethod.POST)
	public String joinconst(Model model,@RequestParam("stateid")int stateid,@RequestParam("countryid")int countryid){
		this.countryService.joinCountryState(countryid, stateid);
		return "redirect:/moderator/countrylist";
		
	}
	
	@RequestMapping(value="/editcountry/{countryid}", method=RequestMethod.GET)
	public String editCountry(Model model,@PathVariable("countryid") int countryid){
		model.addAttribute("country", this.countryService.getCountryById(countryid));
		return "country";
	}
	
	@RequestMapping(value="/delcountry/{countryid}", method=RequestMethod.GET)
	public String deleteCountry(Model model,@PathVariable("countryid") int countryid){
		this.countryService.deleteCountry(countryid);
		return "redirect:/moderator/countrylist";
	}
}
