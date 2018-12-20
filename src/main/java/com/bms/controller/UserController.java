package com.bms.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.model.Users;
import com.bms.service.UserService;

@Controller
public class UserController
{

	FrontController frontController;
 
	@Autowired
	private UserService userService;
  
	
/*  @InitBinder
  public void initBinder(WebDataBinder binder){
	  SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
	  binder.registerCustomEditor(Date.class,"dob",new CustomDateEditor(sdf,false));
  }*/
  
  public String encodePassword(String password){
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	  String hashedPassword = passwordEncoder.encode(password);
	  return hashedPassword;
	  
  }
  
  @RequestMapping(value="/register",method=RequestMethod.POST)
  public String adduser(@Valid @ModelAttribute("users") Users users,BindingResult result,Model model) throws Exception{
	 
	  if(result.hasErrors()){
		  return "login";
	  }
	
	//String idEncrypt=frontController.encrypt(id);
	String password=users.getPassword();
	String cpassword=users.getCpassword();
		
	System.out.println(password);
	System.out.println(cpassword);
	password=encodePassword(password);
	cpassword=encodePassword(cpassword);
	
	users.setPassword(password);
	users.setCpassword(cpassword);
    if(users.getUserid()==0){
     
      users.setRole("ROLE_USER");
      users.setStatus(false);
      this.userService.addUser(users);
    	}
    	
    
    else{
      return "redirect:/login";
    }
    //sendEmailToUser(users.getEmail(),idEncrypt);
    System.out.println(users.getEmail());
	System.out.println(users.getUserid());
	return "sendemail";
	
  }
  
  @RequestMapping(value="/activateaccount/{userid}")
  public String activateAccount(@PathVariable("userid")String userid) throws Exception{
	  String decryptedId=frontController.decrypt(userid);
	  this.userService.setStatus(decryptedId);
	  return "redirect:/login";
  }

 public String sendEmailToUser(String email,String id){
	 System.out.println("Send Email in"+email);
	final String username = "nepbagz@gmail.com ";
	final String password = "nepbagz2016";
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	String link="http://localhost:8080/bms/activateaccount/"+id+"";
	Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });
	        //for buyer
	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
//		message.setRecipients(Message.RecipientType.TO,
//			InternetAddress.parse(email));
	                message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(email));
		message.setSubject("Activate Your Account");
		message.setText("Please click the link below to activate your account");
		message.setText(link);
		Transport.send(message);

		System.out.println("Done for buyer");

	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}	return "sendemail";

  }
 
 	
  
 
}
