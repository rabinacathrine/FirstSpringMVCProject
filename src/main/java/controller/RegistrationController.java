package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.UserService;




@Controller
public class RegistrationController {
	
	@Autowired
	public UserService userService;
	
 @RequestMapping(value="/",method=RequestMethod.GET)
 public ModelAndView ShowHome() {
	 ModelAndView mav=new ModelAndView("home");
	 return mav;
 }
 
 @RequestMapping(value="/register",method=RequestMethod.GET)
 public ModelAndView ShowRegister() {
	 ModelAndView mav=new ModelAndView("Register");
	 return mav;
 }
 
 @RequestMapping(value="/registerProcess",method=RequestMethod.POST)
 public ModelAndView addUser(HttpServletRequest request,HttpServletResponse Response ,User  user) {
	userService.register(user);
	 return new ModelAndView("Welcome","user",user.getFirstname());
 }


}