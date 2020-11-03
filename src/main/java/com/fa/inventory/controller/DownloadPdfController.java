package com.fa.inventory.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fa.inventory.service.GeneratePdfService;

@Controller
public class DownloadPdfController {
	
	
	@Resource
	GeneratePdfService generatePdfService;
	
	protected final Logger logger = Logger.getLogger(DownloadPdfController.class);
	
	private static final String FILE_PATH = "D://demo.pdf";
   // private static final String APPLICATION_PDF = "application/pdf";

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public @ResponseBody void downloadA(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	
    	logger.info("<--DownloadPdfController-------------download--------------------started-->");
        String challanNo =  request.getParameter("id");
        generatePdfService.getPdfByChallanNo(challanNo,response);
        logger.info("<--DownloadPdfController-------------download--------------------Ended-->");
    
    }
    
    private File getFile() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + FILE_PATH + " was not found.");
        }
        return file;
    }

    public static void main(String[] args) throws FileNotFoundException {
		
    	DownloadPdfController downloadPdfController=new DownloadPdfController();
    	downloadPdfController.getFile();
    	System.out.println(downloadPdfController.getFile().getName());
    	
	}
    
}
