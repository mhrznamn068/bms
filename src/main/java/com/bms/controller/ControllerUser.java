package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.model.Users;
import com.bms.service.UserService;

@Controller
@RequestMapping(value="/admin")
public class ControllerUser {
	 
	@Autowired
	private UserService userService;
	
	
  public String encodePassword(String password){
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	  String hashedPassword = passwordEncoder.encode(password);
	  return hashedPassword;
	  
  }
  
	@RequestMapping(value="/userform",method=RequestMethod.GET)
	public String userForm(Model model){
		model.addAttribute("user", new Users());
 		return "userform";
 	}
	
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String userList(Model model){
		model.addAttribute("userlist",this.userService.userlist());
		return "userlist";
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String addUser(@ModelAttribute Users user,Model model){
		String password=user.getPassword();
		System.out.println(password);
		String cpassword=user.getCpassword();
		System.out.println(cpassword);
		if(user.getUserid()==0){
			System.out.println("User id="+user.getUserid());
			user.setPassword(encodePassword(password));
			user.setCpassword(encodePassword(cpassword));
			this.userService.addUser(user);
		}
		else{
			user.setPassword(encodePassword(password));
			user.setCpassword(encodePassword(cpassword));
			this.userService.updateUser(user);
		}
		return "redirect:/admin/userlist";
	}
	
	@RequestMapping(value="/edituser/{userid}",method=RequestMethod.GET)
	public String editUser(@PathVariable("userid") String userid,Model model){
		model.addAttribute("user", this.userService.getUserById(userid));
		return "userform";
	}
	
	@RequestMapping(value="/deleteuser/{userid}",method=RequestMethod.GET)
	public String deleteUser(@PathVariable("userid") String userid){
		this.userService.deleteUser(userid);
		return "redirect:/admin/userlist";
	}
}
