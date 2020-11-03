package com.fa.inventory.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

public interface GeneratePdfService {

	OutputStream getPdfByChallanNo(String challanNo,HttpServletResponse response) throws MalformedURLException, IOException;
	
}
