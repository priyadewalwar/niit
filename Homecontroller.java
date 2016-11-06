package com.niit.shoppingcart.controller;

	import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserDetails;

	@Controller


	public class Homecontroller
	{
		@Autowired
		UserDAO registerdao;
		@Autowired
		LoginDAO logindao;

		@ModelAttribute("UserDetails")
		public UserDetails registerUser() {
			return new UserDetails();

		}
			@RequestMapping("/")
		 public ModelAndView fun1()
		 {
			ModelAndView m1= new ModelAndView("Home");
			return m1;
		 }
			@RequestMapping("/Logout")
			public ModelAndView logoutpage(){
				ModelAndView mv9 = new ModelAndView("logoutsuccess");
				return mv9;
			}

			

	

	}


