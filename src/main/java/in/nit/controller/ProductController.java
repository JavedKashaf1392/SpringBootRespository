package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.nit.model.Product;
import in.nit.service.IProductService;
import in.nit.validator.ProductValidator;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@Autowired
	private ProductValidator validator;
	

	//1. Display Register page
	@RequestMapping("/register")
	public String showPage(Model model) {
		//form Backing Object 
		model.addAttribute("product",new Product());
		return "ProductRegister";
	}
	
	//2. Read Form data as ModelAttribute and save
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveData(
			
			@ModelAttribute Product product,
			//Errors errors,
			Model model
 			)
	{
		
		//call before save operation
		//validator.validate(product, errors);
		//save data in DB
		//if(!errors.hasErrors()) {
		Integer id=service.saveProduct(product);
		//create message
		String msg="Product'"+id+"saved";
		//send to UI
		model.addAttribute("message",msg);
		//clear form data
		model.addAttribute("product",new Product());
		//}else {
		//	model.addAttribute("message","Please checks all errors!!" );
		//}
		//Go to UI page back
		return "ProductRegister";
	}
	
	
	//3. Fetch all records from DB and display at UI
	@RequestMapping("/all")
	public String fetchAll(
			Model model) {
		//read data from db
		List<Product> list=service.getAllProducts();
		//send data to UI
		model.addAttribute("list",list);
		return "ProductData";
		
	}
	
	//4. Delete row by Id   .../delete?pid=10
	@RequestMapping("/delete")
	public String deleteOne(
			@RequestParam("pid")Integer id,
			Model model
			) 
	{
		service.deleteById(id);
		model.addAttribute("message","Product'"+id+"'Deleted");
		//send remaing data 
		//read data form dba
		List<Product> list=service.getAllProducts();
		//send data to UI
		model.addAttribute("list",list);
				return "ProductData";
	}
	
	
	@RequestMapping("/edit")
	public String showEdit(
			@RequestParam("pid")Integer id,
			Model model
			) 
	{
		Product p=service.fetchOneProduct(id);
		//send data to html fill in HTML 
		model.addAttribute("product",p);
		
		return "ProductEdit";
		
	}
	//6.update Product
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateOne(
			@ModelAttribute Product product,
			Model model
			) 
	{
		service.updateProduct(product);
		//send data to UI
		model.addAttribute("message", "Product '"+product.getProdId()+"' Updated");
		//send othre data
		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);
		return "ProductData";
	}
	
	//... /all?page=3&size=25
		//... /all
		@GetMapping("/all")
		public String fetchAll(
				@PageableDefault(page = 0,size = 3)Pageable p,
				Model model)
		{
			Page<Product> page=service.getProductPage(p);
			model.addAttribute("page",page);
			return "ProductData";
		}
		
		public @ResponseBody String  validateCode(@RequestParam String prodCode) {
			
			String msg=" ";
			int count=service.countProductCode(prodCode);
			System.out.println(count);
			if(count>0) {
				 msg=prodCode+"Already Exist";
			}
			return msg;
		}

}
