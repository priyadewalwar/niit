package com.niit.shoppingcart.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;





@Controller
public class Suppliercontroller {
	
	@Autowired
	SupplierDAO s1;
	@ModelAttribute("Supplier")
	public Supplier addsupplier(){
		return new Supplier();
	}

	
    @RequestMapping("Managesupplier")
	public ModelAndView display5() {

		ModelAndView mv2 = new ModelAndView("Managesupplier");
		return mv2;
	}
	@RequestMapping("/Addsupplier")
	public ModelAndView display6() {

		ModelAndView mv3 = new ModelAndView("Addsupplier");
		return mv3;
	}
	
	   @RequestMapping(value = "storesupplier", method = RequestMethod.POST)
	   public String addUser1(@Valid @ModelAttribute("Supplier") Supplier addsupplier,BindingResult result)
	   {
			if (result.hasErrors()) 
			{
				return "Addsupplier";
			}
			 s1.saveOrUpdate(addsupplier);
				return "Managesupplier";
	   }
	   @RequestMapping(value = "listsup", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody String showList()
		{
			List list = s1.getAllSuppliers();
			Gson x = new Gson();
			String json = x.toJson(list);
			return json;
		}

		@RequestMapping("/deletesupplier")
		public ModelAndView deleteSupplier(@RequestParam int id) {
			s1.delete(id);
			ModelAndView m1 = new ModelAndView("Managesupplier");
			return m1;
		}
		@RequestMapping("/viewsupplier")
		public ModelAndView display7(){
			ModelAndView mv4 =new ModelAndView("Viewsupplier");
			return mv4;
		}
@RequestMapping(value = "/viewsupplier", method = RequestMethod.GET)
public ModelAndView viewSup(@RequestParam int id, @ModelAttribute Supplier suppliers) {
	Supplier supplier = s1.getSingleSupplier(id);
	return new ModelAndView("Viewsupplier", "supplier", supplier);
}
 		 
 @RequestMapping("/editsupplier")
	public ModelAndView display15() {
		ModelAndView m6 = new ModelAndView("Editsupplier");
		return m6;

	}		 		 
 @RequestMapping(value="editsupplier",method=RequestMethod.GET)
    public ModelAndView editSupplier(@RequestParam int id){
	 Supplier supplier1=s1.getSingleSupplier(id);
    	return new ModelAndView("Editsupplier","Supplier",supplier1);
    }
 @RequestMapping(value="updatesupplier",method=RequestMethod.POST)
    public ModelAndView updateSupplier(HttpServletRequest request,@Valid @ModelAttribute("Supplier")Supplier editsupplier,BindingResult result,Model model)
    {
		s1.update(editsupplier);
		return new ModelAndView("Managesupplier");
    }
}