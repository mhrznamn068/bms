package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.model.Category;
import com.bms.service.CategoryService;

@Controller
@RequestMapping(value="/admin")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="/category")
	public String categoryform(Model model){
		model.addAttribute("cat", new Category());
	
		return "category";
	}
	
	
	@RequestMapping(value="/catlist")
	public String catList(Model model){
		model.addAttribute("catlist", this.categoryService.categorylist());
		return"catlist";
	}
	
	@RequestMapping(value="/addcat",method=RequestMethod.POST)
	public String addcat(@ModelAttribute Category cat){
		if(cat.getCatid()==0){
			
			this.categoryService.addCategory(cat);
		}
		else{
			System.out.println("Category Id="+cat.getCatid());
			this.categoryService.updateCategory(cat);
		}
		return "redirect:/admin/catlist";
	}
	
	@RequestMapping(value="/updatecat/{catid}")
	public String updateCat(@PathVariable("catid")String catid,Model model){
		model.addAttribute("cat", this.categoryService.getCatById(catid));
		return"category";
	}

	
	@RequestMapping(value="/deletecat/{catid}")
	public String delcat(@PathVariable("catid") String catid){
		this.categoryService.deleteCategory(catid);
		return "redirect:/admin/catlist";
	}
}
