package com.bms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.model.Bag;
import com.bms.model.Billing;
import com.bms.model.Users;
import com.bms.service.BillingService;
import com.bms.service.MenuService;

@Controller
public class BillController {

	  @Autowired
	  private MenuService menuService;
	  
	  @Autowired
	  private BillingService billingService;
	  
	@RequestMapping(value="/billing")
	public String ship(Model model,HttpSession session){
		Users user=(Users) session.getAttribute("user");
		if(user==null){
			return "redirect:/login";
		}
		else{
		model.addAttribute("menulist",this.menuService.listMenu());
		model.addAttribute("bill", new Billing());
		
		System.out.println(user);
		return "billing";
		}
	}
	
	 @ModelAttribute("countrylist")
	  public List<String> getCountry()
	  {
	    List<String> countryList = new ArrayList<String>();
	    countryList.add("Nepal");
	    countryList.add("France");
	    countryList.add("Japan");
	    countryList.add("England");
	    countryList.add("USA");
	    countryList.add("Denmark");
	    countryList.add("Australia");
	    countryList.add("Spain");
	    countryList.add("Mexico");
	    return countryList;
	  }
	 
	 @ModelAttribute("statelist")
	  public List<String> getState()
	  {
	    List<String> stateList = new ArrayList<String>();
	    stateList.add("Bagmati");
	    stateList.add("Gandaki");
	    stateList.add("Mechi");
	    stateList.add("Koshi");
	    stateList.add("Sagarmatha");
	    stateList.add("Narayani");
	    stateList.add("Lumbini");
	    stateList.add("Dhaulagiri");
	    stateList.add("Rapti");
	    return stateList;
	  }

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/shipit",method=RequestMethod.POST)
	public String addBill(@ModelAttribute Billing bill,Model model,HttpSession session){
		 Users user=(Users) session.getAttribute("user");
		 List<Bag> cart=(List<Bag>) session.getAttribute("cartlist");
		 bill.setUser(user);
		 System.out.println(user);
		 bill.setBaglist(cart);
		 this.billingService.shipit(bill);
		 return "redirect/orderconfirmed";
	 }
	
	@RequestMapping(value="/orderconfirmed",method=RequestMethod.GET)
	public String orderConfirmed(Model model,HttpSession session){
		 //Users user=(Users) session.getAttribute("user");
		 model.addAttribute("msg", "Dear Sir,Your Order has been confirmed. Click the NEXT button for shipping to your address");
		return "payment";
	}
}
