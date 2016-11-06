package com.niit.shoppingcart.controller;

	
	import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.ProductDAO;
	import com.niit.shoppingcart.dao.SupplierDAO;
	import com.niit.shoppingcart.model.Product;
	import com.niit.shoppingcart.model.Supplier;
	@Controller
	public class Productcontroller {

		@Autowired
		ProductDAO pd;
		@Autowired
		SupplierDAO sd;

		@ModelAttribute("Product")
		public Product createProduct() {
			return new Product();
		}
		@RequestMapping("Manageproduct")
		public ModelAndView display11() {
			ModelAndView m10 = new ModelAndView("Manageproduct");
			return m10;
		}
		@RequestMapping("/Addproduct")
		public ModelAndView display3() {

			ModelAndView mv3 = new ModelAndView("Addproduct");
			mv3.addObject("supplier", new Supplier());
	        List suppliers= sd.getAllSuppliers();
	        mv3.addObject("suppliers", suppliers);
	        return mv3;
		}
		
		@RequestMapping("storeproduct")
		public String addproduct(HttpServletRequest request, @Valid @ModelAttribute("Product") Product product,BindingResult result) {
			if (result.hasErrors()) {
				return "Addproduct";
			}
			String filename = product.getImg().getOriginalFilename();
			product.setImage(filename);

			try {
				byte[] bytes = new byte[product.getImg().getInputStream().available()];
				product.getImg().getInputStream().read(bytes);
				BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
				MultipartFile file = product.getImg();
				String path = request.getServletContext().getRealPath("/") + "resources/images";
				File rootPath = new File(path);
				if (!rootPath.exists())
					rootPath.mkdirs();
				File store = new File(rootPath.getAbsolutePath() + "/" + filename);
				System.out.println("Image path :" + path);
				OutputStream os = new FileOutputStream(store);
				os.write(bytes);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			pd.saveOrUpdate(product);
			return "Manageproduct";

		}
	
		@RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody String showList()
		{
			List list = pd.getAllProducts();
			Gson x = new Gson();
			String json = x.toJson(list);
			return json;
		}

		@RequestMapping("/delete")
		public ModelAndView deleteProduct(@RequestParam int id) {
			pd.delete(id);
			ModelAndView m1 = new ModelAndView("Manageproduct");
			return m1;
		}
		

		@RequestMapping("/viewproduct")
		public ModelAndView display12() {
			ModelAndView m6 = new ModelAndView("Viewproduct");
			return m6;

		}
			
	
		@RequestMapping(value = "Viewproduct", method = RequestMethod.GET)
		public ModelAndView viewPro(@RequestParam int id, @ModelAttribute Product products) {
			Product product = pd.getSingleProduct(id);
			return new ModelAndView("Viewproduct", "product", product);
		}
		 		 
		 @RequestMapping("/editproduct")
			public ModelAndView display15() {
				ModelAndView m6 = new ModelAndView("Editproduct");
				return m6;

			}		 		 
		 @RequestMapping(value="Editproduct",method=RequestMethod.GET)
		    public ModelAndView editPro(@RequestParam int id){
			 Product product1=pd.getSingleProduct(id);
		    	return new ModelAndView("Editproduct","Product",product1);
		    }
		 @RequestMapping(value="/update",method=RequestMethod.POST)
		    public ModelAndView updateProduct(HttpServletRequest request,@Valid @ModelAttribute("Product")Product product,BindingResult result)
		    {
		    	
		    	String filename=product.getImg().getOriginalFilename();
		    	
		    	product.setImage(filename);
	     	
		    	try{
	     		byte[] bytes=new byte[product.getImg().getInputStream().available()];
	     		product.getImg().getInputStream().read(bytes);
	     		BufferedInputStream buffer=new BufferedInputStream(product.getImg().getInputStream());
	     		MultipartFile file=product.getImg();
	     		String path=request.getServletContext().getRealPath("/")+"resources/images";
	     		File rootPath=new File(path);
	     		if(!rootPath.exists())
	     			rootPath.mkdirs();
	     		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
	     		System.out.println("Image path :"+path);
	     		OutputStream os=new FileOutputStream(store);
	     		os.write(bytes);
	     	}
	     	catch(Exception e){
	     		System.out.println(e.getMessage());
	     	}
	     		        
		    	pd.saveOrUpdate(product);
		    	return new ModelAndView("Manageproduct");
		    }	 
	}



