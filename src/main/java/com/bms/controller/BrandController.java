package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.model.Brand;
import com.bms.service.BrandService;

@Controller
@RequestMapping(value="/admin")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value="/brand")
	public String categoryform(Model model){
		model.addAttribute("brand", new Brand());
		return "brandform";
	}
	
	
	@RequestMapping(value="/brandlist")
	public String catList(Model model){
		model.addAttribute("brandlist", this.brandService.brandlist());
		return "brandlist";
	}

	
	@RequestMapping(value="/addbrand",method=RequestMethod.POST)
	public String addcat(@ModelAttribute Brand brand,Model model){
		if(brand.getBrandid()==0){
			this.brandService.addBrand(brand);
			System.out.println("Brand Added");
		}
		else{
			System.out.println(brand.getBrandid());
			this.brandService.updateBrand(brand);
			System.out.println("Brand Updated");
		}
		return "redirect:/admin/brandlist";
	}
	
	@RequestMapping(value="/updatebrand/{brandid}")
	public String updateCat(@PathVariable("brandid")String brandid,Model model){
		model.addAttribute("brand", this.brandService.getBrandById(brandid));
		return"brandform";
	}

	
	@RequestMapping(value="/deletebrand/{brandid}")
	public String delcat(@PathVariable("brandid") String brandid,Model model){
		this.brandService.deleteBrand(brandid);
		return "redirect:/admin/brandlist";
	}

}
