package com.pis.redSocial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


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
    	File localFile = new File("/RedSocial/src/main/webapp/fotos/"+uploaded.getOriginalFilename());
    	FileOutputStream os = null;
    	
    	try {
    		
    		os = new FileOutputStream(localFile);
    		os.write(uploaded.getBytes());
    		
    	} finally {
    		if (os != null) {
    			try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
		/*
		try {
			File inFile = new File(sourceFile);
			File outFile = new File(destinationFile);

			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;
			while( (c = in.read() ) != -1)
			out.write(c);

			in.close();
			out.close();
			} catch(IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!");
			}
			*/
	}
/* FIN SUBIDA FOTOS*/
	
}
