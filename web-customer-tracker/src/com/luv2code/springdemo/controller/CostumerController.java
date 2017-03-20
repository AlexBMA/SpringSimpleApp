package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CostumerController {

	// need to inject the customer service
	@Autowired
	private CustomerService customerService;

	/// @RequestMapping("/list")
	// new in spring 5.33
	@GetMapping("/list")
	public String listCostumer(Model theModel) {

		System.out.println("in here");
		// get customer from the customer service
		List<Customer> theCustomers = customerService.getCustomers();

		// add to the customers to the model
		theModel.addAttribute("customers", theCustomers);

		String pageName = "list-customers";
		return pageName;
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		// theCustomer.setEmail(req);

		theModel.addAttribute("customer", theCustomer);

		String pageName = "customer-form";
		return pageName;
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult theBidingResult) {

		
		if(theBidingResult.hasErrors())
		{
			return "customer-form";
		}
		else {
			customerService.saveCustomer(theCustomer);

			String pageName = "redirect:/customer/list";
			return pageName;
		}
		
		
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		String pageName = "customer-form";
		return pageName;
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCostumer, BindingResult theBidingResult) {
		
		if(theBidingResult.hasErrors())
		{
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
	}

}
