package com.bms.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import com.bms.model.PhotoModel;
import com.bms.service.PhotoService;

@Controller
@RequestMapping(value="/admin")
public class PhotoController
{

  @Autowired
  private PhotoService photoService;
  
  @RequestMapping(value="/imageform", method=RequestMethod.GET)
  public String photoform(Model model){
    model.addAttribute("photo", new PhotoModel());
    return "photo";
  }
  
  @RequestMapping(value="/photolist", method=RequestMethod.GET)
  public String photolist(Model model){
    List<PhotoModel> photolist=this.photoService.listImage();
    model.addAttribute("imagelist", photolist);
    return "photolist";
  }
  
  @RequestMapping(value="/addimage",method=RequestMethod.POST)
  public String addimage(@ModelAttribute PhotoModel photo,Model model,@RequestParam("file") MultipartFile file,HttpServletRequest request){
   
	  String filename = new String();                  
try {
  if(!file.isEmpty()){
  	 String path=request.getSession().getServletContext().getRealPath("resources/carousel/ "); 
 
                
                filename=file.getOriginalFilename();

                file.transferTo(new File(path+filename));
                System.out.println("path="+path);
                System.out.println(path+"\\"+filename);
                model.addAttribute("success", "file Uploaded sucessfully");
                photo.setImage(" "+filename);
                if(photo.getId()==0){
                	
                  photoService.addPhoto(photo);
                  System.out.println("Carousal Added");
                }
                else{
                  photoService.editPhoto(photo);
                }
                
                }
                else{
              	  model.addAttribute("failure","file not selected");
                }
} catch (Exception e) {
	e.printStackTrace();
model.addAttribute("failure", "file not uploaded");
}
	return "redirect:/admin/photolist";
    
  }
  
  @RequestMapping(value="/editimage/{id}",method=RequestMethod.GET)
  public String editPub(@PathVariable("id")int id,Model model){
   
    model.addAttribute("photo", this.photoService.getPhotoById(id));
    
    return "photo";
  }
  
  @RequestMapping(value="/delimage/{id}",method=RequestMethod.GET)
  public String deletePub(@PathVariable("id")int id,Model model){
    
    this.photoService.deletePhoto(id);
    return "redirect:/admin/photolist";
    
  }
  
  @RequestMapping(value="/welcome",method=RequestMethod.GET)
  public String welcome(){
 
    return "welcome";
    
  }
  
/*  @RequestMapping(value = "/getImg{id}", method = RequestMethod.GET,
      produces = MediaType.IMAGE_JPEG_VALUE)
public ResponseEntity<byte[]> ListImage(@PathVariable int id) throws IOException{
  PhotoModel p = photoService.getPhotoById(id);
  byte [] image = p.getImage();
  final HttpHeaders headers = new HttpHeaders();
  headers.setContentType(MediaType.IMAGE_JPEG);
  return new ResponseEntity<byte[]>(image, headers, HttpStatus.CREATED);
}*/
  
}
