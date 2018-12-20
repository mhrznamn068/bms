package com.bms.controller;

import java.io.File;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bms.model.Bag;
import com.bms.service.BagService;
import com.bms.service.BrandService;
import com.bms.service.CategoryService;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


@Controller
@RequestMapping(value="/moderator")
public class BagController
{
	//private static final String Upload_Directory="/files";
    //private static final int size=1024*1024*4; // 4 mb file upload
	@Autowired
	private BagService bagService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BrandService brandService;
  
	
	
    private static final String ALGO = "AES";
    private static final byte[] keyValue
            = new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't',
                'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

	public static  String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static  String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
	
    @RequestMapping(value="/addbag",method=RequestMethod.POST)
	public String uploadfile(@ModelAttribute Bag bag,@RequestParam("brandid")String brandid,@RequestParam("catid")String catid,@RequestParam("file") MultipartFile file,HttpServletRequest request,Model model) throws Exception{
    	String filename = new String();                
	    try {
	         if(!file.isEmpty()){
	        	 String path=request.getSession().getServletContext().getRealPath("resources/bagimages/ ") ; 
	        	 filename=file.getOriginalFilename();
//					redirectAttributes.addFlashAttribute("message",
//							"You successfully uploaded " + file.getOriginalFilename() + "!");
	        	 file.transferTo(new File(path+filename));
	        	 System.out.println(path+"\\"+filename);
	        	 model.addAttribute("success", "file Uploaded sucessfully");
	        	 model.addAttribute("file", filename);
	        	 bag.setImage(" "+filename);
	        }
	         else{
	             model.addAttribute("failure","file not selected");
	             }
	     } catch (Exception e) {
	           e.printStackTrace();
	           model.addAttribute("failure", "file not uploaded");
	       }
	       model.addAttribute("categorylist", this.categoryService.categorylist());
	       if(bag.getBid()==0){
	    	   
	    	   System.out.println("Adding Bag");
	    	   this.bagService.addBag(bag,catid, brandid);
	    	   System.out.println("Bag Added");
	       }
	       else{
	            System.out.println("Updating Bag");
	            this.bagService.updateBag(bag,catid, brandid);
	            System.out.println("Bag Updated");
	       }
	       return "redirect:/moderator/baglist";
	}
	  
  @RequestMapping(value="/bagform",method=RequestMethod.GET)
  public String bagform(Model model){
    model.addAttribute("bag", new Bag());
    model.addAttribute("categorylist", this.categoryService.categorylist());
    model.addAttribute("brandlist", this.brandService.brandlist());
    return "bagform";
  }
  
  @RequestMapping(value="/baglist",method=RequestMethod.GET)
  public String baglist(Model model){
    model.addAttribute("baglist", this.bagService.baglist());
    model.addAttribute("categorylist", this.categoryService.categorylist());
    model.addAttribute("brandlist", this.brandService.brandlist());
    return "baglist";
  }
  

  @RequestMapping(value="/editbag/{bid}",method=RequestMethod.GET)
  public String editbag(Model model,@PathVariable("bid") String bid){
    model.addAttribute("bag",this.bagService.getBagById(bid));
    model.addAttribute("categorylist", this.categoryService.categorylist());
    model.addAttribute("brandlist", this.brandService.brandlist());
    return "bagform";
    
  }
  
  @RequestMapping(value="/deletebag/{bid}",method=RequestMethod.GET)
  public String deletebag(Model model,@PathVariable("bid") String bid){
	 
    this.bagService.deleteBag(bid);
    return "redirect:/moderator/baglist";
  }
  
  
}
