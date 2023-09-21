package com.airline.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.ticketbooking.model.Category;
import com.airline.ticketbooking.model.Passanger;
import com.airline.ticketbooking.model.PassangerDto;
import com.airline.ticketbooking.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
   
	@PostMapping
	public String addCategory(@RequestBody Category category) {
		
		categoryService.addCategory(category);
		return "Added Category successfully";
	}
	
	@GetMapping("/{id}")
   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Category getCategory(@PathVariable int id)
	{
		return categoryService.getCategory(id);
	}
	
	@GetMapping("/get")    
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Category> getAllCategory(){
		return categoryService.getAllCategory();
	}
	@PutMapping("/{id}")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
	public String updateCategory(@RequestBody Category category,@PathVariable int id)
	{
		categoryService.updateCategory(category,id);
		return "updated successfully";
	}
	@DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
	public String deleteCategory(@PathVariable int id)
	{
		categoryService.deleteCategory(id);
		return "Successfully Deleted Category record";
	}

}
