package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Login;
import model.User;
import service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	User user;
	@RequestMapping(value="/home",method=RequestMethod.GET)
	 public ModelAndView ShowHome() {
		 ModelAndView mav=new ModelAndView("home");
		 return mav;
	 }
	@RequestMapping(value="/login",method=RequestMethod.GET)
	 public ModelAndView ShowLogin() {
		 ModelAndView mav=new ModelAndView("Login");
		 return mav;
	 }
	@RequestMapping(value="/loginProcess",method=RequestMethod.POST)
	 public ModelAndView loginProcess(HttpServletRequest request,HttpServletResponse Response ,Login login) {
		ModelAndView mav=null;
		
		user=userService.validateUser(login);
				
				if(user!=null) {
					mav=new ModelAndView("Welcome","user",user.getFirstname());
					
				}
				else {
					mav=new ModelAndView("Login","message","username or password is wrong");
				}
				return mav;
		 }
}