package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class Usercontroller {

	@Autowired
	UserDAO registerdao;
	@Autowired
	LoginDAO logindao;
	

	@RequestMapping("Manageuser")
	public ModelAndView userList(){
		ModelAndView mv9 = new ModelAndView("Manageuser");
		return mv9;
	}
	@RequestMapping("viewuser")
	public ModelAndView viewuser(){
		ModelAndView mv9 = new ModelAndView("viewuser");
		return mv9;
	}
	@RequestMapping(value = "viewuser", method = RequestMethod.GET)
	public ModelAndView viewPro(@RequestParam int id, @ModelAttribute User loginuser) {
		User user = logindao.getSingleUser(id);
		return new ModelAndView("viewuser", "user", user);
	}
	@RequestMapping(value="edituser", method=RequestMethod.GET)
	public ModelAndView edituser(@RequestParam int id){
		User u1=logindao.get(id);
		return new ModelAndView("edituser","User",u1);
	}
	@RequestMapping(value = "listusers", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showList()
	{
		List list = logindao.getAllUsers();
		Gson x = new Gson();
		String json = x.toJson(list);
		return json;
	}

	@RequestMapping("Login")
	public ModelAndView display1() {
		ModelAndView mv1 = new ModelAndView("Login");
		return mv1;
	}

	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public ModelAndView loginerror(ModelMap model) {
		return new ModelAndView("Login", "error", true);
	}

	@RequestMapping("reg")
	public ModelAndView display2() {

		ModelAndView mv2 = new ModelAndView("Register");
		return mv2;
	}

	@RequestMapping(value = "storeUser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("UserDetails") UserDetails registeruser,BindingResult result) {
		if (result.hasErrors()) {
			return "Register";
		}
		registerdao.save(registeruser);
		User loginuser = new User();
		loginuser.setId(registeruser.getId());
		loginuser.setUsername(registeruser.getUsername());
		loginuser.setPassword(registeruser.getPassword());
		loginuser.setStatus(registeruser.isStatus());
		logindao.save(loginuser);
		return "Register";
	}

	@RequestMapping("deleteuser")
	public ModelAndView deleteUser(@RequestParam int id,@Valid @ModelAttribute("User")User loginuser) {
		logindao.delete(id);
		ModelAndView m1 = new ModelAndView("ManageUsers");
		return m1;
	}
	@ModelAttribute("UserDetails")
	public UserDetails registerUser() {
		return new UserDetails();

	}

	@ModelAttribute("User")
	public User createUser() {
		return new User();

	}

	@RequestMapping("/AdminHome")
	public ModelAndView display5() {
		ModelAndView m5 = new ModelAndView("AdminHome");
		return m5;
	
	}
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request,@Valid @ModelAttribute("User")User editlogin,BindingResult result)
    {
		logindao.update(editlogin);
		return new ModelAndView("Manageuser");
    }

}

