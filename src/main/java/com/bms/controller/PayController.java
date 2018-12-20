package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.model.Bag;
import com.bms.service.BagService;

@RestController
public class PayController {

	@Autowired
	private BagService bagService;
	
	@RequestMapping(value = "/employees")
	public List<Bag> getAllbagsbyrest() 
	{
	    
	    return this.bagService.baglist();
	}
	
}
