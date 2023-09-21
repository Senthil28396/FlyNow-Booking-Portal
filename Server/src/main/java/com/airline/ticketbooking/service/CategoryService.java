package com.airline.ticketbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.ticketbooking.exceptions.CategoryNotFoundException;
import com.airline.ticketbooking.model.Category;
import com.airline.ticketbooking.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	public Category getCategory(int id) {
		Optional<Category> categories = categoryRepo.findById(id);

		if (categories.isPresent()) {
			return categories.get();
		} 
		else {
			throw new CategoryNotFoundException("No category record exist for given id");
		}
	}

		public List<Category> getAllCategory() {
		List<Category> categories = categoryRepo.findAll();

		if (categories.size() > 0) {
			return categories;
		} 
		else {
			return new ArrayList<Category>();
		}
	}

		public void updateCategory(Category category, int id) {
		Optional<Category> students=categoryRepo.findById(id);
		if(students.isPresent())
		{
			Category newCategory=students.get();
			//newStudent.setId(student.getId());
			newCategory.setCategory(category.getCategory());
			newCategory.setAmount(category.getAmount());
			newCategory=categoryRepo.save(newCategory);
		}
		else {
			throw new CategoryNotFoundException("No category record exist for given id");
		}
	}

		public void deleteCategory(int id) {
		Optional<Category> student = categoryRepo.findById(id);

		if (student.isPresent()) {
			categoryRepo.deleteById(id);
		} 
		else {
			throw new CategoryNotFoundException("No category record exist for given id");
		}
	}

}
