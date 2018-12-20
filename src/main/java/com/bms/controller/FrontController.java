package com.bms.controller;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.model.Bag;
import com.bms.model.PhotoModel;
import com.bms.model.Users;
import com.bms.service.BagService;
import com.bms.service.BrandService;
import com.bms.service.CategoryService;
import com.bms.service.MenuService;
import com.bms.service.PhotoService;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller
public class FrontController
{
  
  @Autowired
  private MenuService menuService;
  
  @Autowired
  private PhotoService photoService;
  
  @Autowired
  private BagService bagService;
  
  @Autowired
  private CategoryService categoryService;
  
  @Autowired
  private BrandService brandService;
  
  private static List<Bag> list=new ArrayList<Bag>();
  
  private static final String ALGO = "AES";
  private static final byte[] keyValue
          = new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't',
              'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

  public  String encrypt(String Data) throws Exception {
      Key key = generateKey();
      Cipher c = Cipher.getInstance(ALGO);
      c.init(Cipher.ENCRYPT_MODE, key);
      byte[] encVal = c.doFinal(Data.getBytes());
      String encryptedValue = new BASE64Encoder().encode(encVal);
      return encryptedValue;
  }

  public  String decrypt(String encryptedData) throws Exception {
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

  
  @RequestMapping(value="/getSearch",method=RequestMethod.GET)
  public @ResponseBody List<Bag> getSearch(@RequestParam("searchName") String searchName){
	  
	  System.out.println("Term entered is"+searchName);
	  return this.bagService.searchBag(searchName);
  }
  

  @RequestMapping(value="/home", method=RequestMethod.GET)
  public String homepage(Model model,HttpSession session){
	model.addAttribute("menulist",this.menuService.listMenu());
    List<PhotoModel> photolist=this.photoService.listImage();
    session.getAttribute("user");
    model.addAttribute("popularitems",this.bagService.getPopularBags());
    model.addAttribute("imagelist", photolist);
    model.addAttribute("baglist", this.bagService.isFeatured());
    model.addAttribute("categorylist",this.categoryService.categorylist());
    model.addAttribute("brandlist", this.brandService.brandlist());
    return "home";
  }
  
  
  @RequestMapping(value="/services", method=RequestMethod.GET)
  public String ourServices(Model model,HttpSession session){
	/*String name="SERVICES";
	MenuModel menu=this.menuService.getMenuByName(name);
	model.addAttribute("desc", menu.getDescription());
    */model.addAttribute("menulist",this.menuService.listMenu());
    //List<PhotoModel> photolist=this.photoService.listImage();
    session.getAttribute("user");
   /* model.addAttribute("popularitems",this.bagService.getPopularBags());
    model.addAttribute("imagelist", photolist);
    model.addAttribute("baglist", this.bagService.baglist());*/
    model.addAttribute("categorylist",this.categoryService.categorylist());
    model.addAttribute("brandlist", this.brandService.brandlist());
    return "services";
  }
  
  @RequestMapping(value="/aboutus", method=RequestMethod.GET)
  public String aboutUs(Model model,HttpSession session){
/*	String name="ABOUT US";
	MenuModel menu=this.menuService.getMenuByName(name);
	model.addAttribute("desc", menu.getDescription());
*/    model.addAttribute("menulist",this.menuService.listMenu());
    //List<PhotoModel> photolist=this.photoService.listImage();
    session.getAttribute("user");
   /* model.addAttribute("popularitems",this.bagService.getPopularBags());
    model.addAttribute("imagelist", photolist);
    model.addAttribute("baglist", this.bagService.baglist());*/
    model.addAttribute("categorylist",this.categoryService.categorylist());
    model.addAttribute("brandlist", this.brandService.brandlist());
    return "about";
  }
  
  @RequestMapping(value="/product/{bid}", method=RequestMethod.GET)
  public String product(Model model,@PathVariable("bid") String bid) throws Exception{
	  model.addAttribute("menulist",this.menuService.listMenu());
	  model.addAttribute("brandlist", this.brandService.brandlist());
	  /*bid=decrypt(bid);
	  System.out.println("Bag id="+bid);*/
	  Bag bag=this.bagService.getBagById(bid);
	  model.addAttribute("bag",bag);
	  //bag.setBid(bag.getBid().substring(bag.getBid().length()-1));
	  //System.out.println(bag.getBid());
	  this.bagService.increaseview(bid);
    return "product";
  }
  
  @SuppressWarnings("unchecked")
  @RequestMapping(value="/cart", method=RequestMethod.GET)
  public String cart(Model model,HttpSession session){
	  List<Bag> baglist=(List<Bag>) session.getAttribute("cartlist");
	  System.out.println(baglist.size());
	  System.out.println(baglist);
	  model.addAttribute("baglist", baglist);
	  return "cart";
  }
  
@RequestMapping(value="/addtocart/{bid}",method=RequestMethod.GET)
  public String addToCart(Model model, HttpSession session,@PathVariable("bid") String bid){
		System.out.println(list.size());
	  Bag bag=this.bagService.getBagById(bid);
	  
	  list.add(bag);
	  System.out.println(list.size());
	  session.setAttribute("cartlist",list);
	 
	  return "redirect:/home";
  }

	@RequestMapping(value="/cart/update")
	public String calcutateCartTotal(@RequestParam("bid")String bid, Model model,@RequestParam("quantity")int quantity){
		Bag bag=this.bagService.getBagById(bid);
		
		double total=bag.getBprice()+quantity;
		System.out.println(total);
		model.addAttribute("total", total);
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/category/{catid}")
	public String getCatPage(Model model,@PathVariable("catid")String catid,@RequestParam(value = "page", defaultValue="0", required=false)int page){
		List<Bag> bagcat=this.bagService.getBagByCatWithPag(catid, page);
		model.addAttribute("bagcat", bagcat);
		model.addAttribute("menulist",this.menuService.listMenu());
	    List<PhotoModel> photolist=this.photoService.listImage();
	    model.addAttribute("imagelist", photolist);
	    model.addAttribute("categorylist",this.categoryService.categorylist());
	    model.addAttribute("brandlist", this.brandService.brandlist());
	    model.addAttribute("catid", catid);
	    int countbag=this.bagService.getBagByCategory(catid).size();
	    System.out.println("No of bags="+countbag);
	    int startpage = 1;
	    int endpage = countbag/2;
	    model.addAttribute("startpage",startpage);
	    model.addAttribute("endpage",endpage);
		return "catpage";
	}
	
	@RequestMapping(value="/brand/{brandid}")
	public String getBrandPage(Model model,@PathVariable("brandid")String brandid,@RequestParam(value = "page", defaultValue="0", required=false)int page){
		List<Bag> bagbrand=this.bagService.getBagByBrand(brandid, page);
		model.addAttribute("bagbrand", bagbrand);
		model.addAttribute("menulist",this.menuService.listMenu());
	    List<PhotoModel> photolist=this.photoService.listImage();
	    model.addAttribute("imagelist", photolist);
	    model.addAttribute("categorylist",this.categoryService.categorylist());
	    model.addAttribute("brandlist", this.brandService.brandlist());
	    model.addAttribute("brandid", brandid);
	    int countbag=this.bagService.getBagByBrandNoPag(brandid).size();
	    System.out.println("No of bags="+countbag);
	    int startpage = 1;
	    int endpage = countbag/2;
	    model.addAttribute("startpage",startpage);
	    model.addAttribute("endpage",endpage);
		return "brandpage";
	}
	
	
	@RequestMapping(value="/account",method=RequestMethod.GET)
	public String userAccount(Model model,HttpSession session){
		Users users=(Users) session.getAttribute("user");
		if(users==null){
			return "redirect:/login";
		}
		model.addAttribute("user",users);
		return "account";
	}

 }
