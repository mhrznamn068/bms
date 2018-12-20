package com.bms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.model.Users;
import com.bms.service.MenuService;
import com.bms.service.UserService;


@Controller
public class LoginController
{

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
  @RequestMapping(value="/login")
  public String loginform(Model model){
	model.addAttribute("menulist",this.menuService.listMenu());
    model.addAttribute("user", new Users());
    return "login";
  }
  
  @RequestMapping(value="/user")
  public String usersuccess(Model model,HttpSession session){
	  //Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  System.out.println(auth.getName());
	  String name=auth.getName();
	  Users user=this.userService.getUserByName(name);
	  System.out.println(user);
	  session.setAttribute("user",user);
    return "redirect:/home";
    
  }
  
  @RequestMapping(value="/noaccess")
  public String noAccess(Model model){
    Authentication auth=SecurityContextHolder.getContext().getAuthentication();
    String username="";
    if(!(auth instanceof AnonymousAuthenticationToken)){
      UserDetails userDetails=(UserDetails) auth.getPrincipal();
      username=userDetails.getUsername();
    }
    model.addAttribute("username", username);
    return "accessdenied";
  }
  
  @RequestMapping(value="/loginfailed")
  public String loginfailed(Model model){
    model.addAttribute("user", new Users());
    model.addAttribute("error", "Invalid Account");
   
    return "login";
    
  }
  
  @RequestMapping(value="/logout")
  public String logoutPage (HttpSession session) {
	  SecurityContextHolder.getContext().setAuthentication(null);
	  session.removeAttribute("user");
    return "redirect:/login";
  }
  
  
  @RequestMapping(value="/admin", method=RequestMethod.GET)
  public String adminloginned(HttpSession session){
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  System.out.println(auth.getName());
	  Users user=this.userService.getUserByName(auth.getName());
	  System.out.println(user);
	  session.setAttribute("user",user);
    return "welcome";
}

  @RequestMapping(value="/moderator", method=RequestMethod.GET)
  public String moderatorloginned(HttpSession session){
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  System.out.println(auth.getName());
	  Users user=this.userService.getUserByName(auth.getName());
	  System.out.println(user);
	  session.setAttribute("user",user);
    return "baglist";
}
  
}
