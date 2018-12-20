package com.bms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bms.model.MenuModel;
import com.bms.service.MenuService;

@Controller
@RequestMapping(value="/admin")
public class MenuController
{

  @Autowired
  private MenuService menuService;
  

  
  @RequestMapping(value="/menuform",method=RequestMethod.GET)
  public String imageform(Model model){
    model.addAttribute("menu", new MenuModel());
  
    return "menucrud";
    
  }
  
  @RequestMapping(value="/menulist",method=RequestMethod.GET)
  public String listimage(Model model){
    List<MenuModel> menulist=this.menuService.listMenu();
    model.addAttribute("menulist", menulist);
    return "menulist";
    
  }
  
  @RequestMapping(value="/addmenu",method=RequestMethod.POST)
  public String addimage(@ModelAttribute MenuModel menu,Model model,@RequestParam("description")String description){
   
    if(menu.getMid()==0){
    	menu.setDescription(description);
      menuService.addMenu(menu);
    }
    else{
      menuService.editMenu(menu);
    }
    return "redirect:/admin/menulist";
    
  }
  
  @RequestMapping(value="/editmenu/{mid}",method=RequestMethod.GET)
  public String editPub(@PathVariable("mid")int mid,Model model){
    model.addAttribute("menu", this.menuService.getMenuById(mid));
    return "menucrud";
  }
  
  @RequestMapping(value="/delmenu/{mid}",method=RequestMethod.GET)
  public String deletePub(@PathVariable("mid")int mid,Model model){
    
    this.menuService.deleteMenu(mid);
    return "redirect:/admin/menulist";
    
  }
  
/*  @RequestMapping(method = RequestMethod.POST, value = "/DemoAjax")
  public @ResponseBody String uploadFile(@RequestParam("rr") CommonsMultipartFile file,HttpServletRequest request) throws FileNotFoundException, IOException {
     String filePath = request.getSession().getServletContext().getRealPath("resources/tinymce/ ");
      // file.transferTo(new File(filePath + File.separator+file.getOriginalFilename()));
      System.out.println(request.getParameter("rr"));
     String filename = file.getOriginalFilename();
      filePath = filePath.replaceAll("\\\\", "/");

      System.out.println(filePath + "/" + filename);

      byte[] bytes = file.getBytes();
      BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + File.separator + filename)));
      stream.write(bytes);
      stream.flush();
      stream.close(); 
      String path=filePath+"/"+filename;
      System.out.println(path);
//       JSONObject obj = new JSONObject();
//      String location = "/assets";
//      obj.put("Location", location);      
//      //System.out.println(obj);
      
      return path;       

  }*/
  
  @RequestMapping(value="/tinyUpload",method=RequestMethod.POST)
  public @ResponseBody String tinyUpload(@RequestParam("rr") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
   
	  String filename = new String();                  

  if(!file.isEmpty()){
  	 String path=request.getSession().getServletContext().getRealPath("resources/tinymce/ "); 
 
                
                filename=file.getOriginalFilename();

               file.transferTo(new File(path+filename));
                System.out.println("path="+path);
                System.out.println(path+"\\"+filename);
                String filepath=path+filename;
                System.out.println(filename);
                System.out.println(filepath);
                return filename;
                
    
  }
return null;

  }

}
