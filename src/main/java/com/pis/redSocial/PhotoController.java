package com.pis.redSocial;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;



@Controller
@RequestMapping("photo")
public class PhotoController {

	/*INICIO FOTOS*/
	@RequestMapping(method = RequestMethod.GET)
	public @ModelAttribute("fileFormBean") FileFormBean getInitialMessage() {
		return new FileFormBean();
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public @ModelAttribute("message") String guardaFichero(@ModelAttribute FileFormBean fileFormBean) {
    	try {
			grabarFicheroALocal(fileFormBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "No se ha podido grabar el fichero";
		}
    	return "Fichero grabado correctamente";
    }
	
	
	private void grabarFicheroALocal(FileFormBean fileFormBean) throws Exception {
		CommonsMultipartFile uploaded = fileFormBean.getFichero();
		    	
    	//Cloudinary
    	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
    			  "cloud_name", "dtajtzcgw",
    			  "api_key", "942888456823941",
    			  "api_secret", "FefbhNW6ZnniBf4wFH0d6JUcn84"));
    	
    	Map upload = cloudinary.uploader().upload(uploaded.getBytes(), ObjectUtils.emptyMap());
    	

	}
/* FIN SUBIDA FOTOS*/
	
}
