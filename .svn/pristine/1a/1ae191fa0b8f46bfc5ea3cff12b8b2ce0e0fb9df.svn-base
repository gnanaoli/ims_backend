package com.fa.inventory.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fa.inventory.entity.DispatcherLog;
import com.fa.inventory.repository.DispatchLogRepository;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 

@Controller
public class PdfServlet extends HttpServlet {
 
	public static final String LOGO = "C:/Users/Gnanaoli.s/Desktop/INVENTRY-NEW-CHANGE/img/logo.png";
	
	@Resource
	DispatchLogRepository dispatchLogRepository;
	
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
	
	 @RequestMapping(value = "/samplepdf",method=RequestMethod.POST)
	 public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            // Get the text that will be added to the PDF
            String text = request.getParameter("text");
//            if (text == null || text.trim().length() == 0) {
//                 text = "You didn't enter any text.";
//            }
            // step 1
            Document document = new Document();
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            // step 3
            Font titlefont = new Font(FontFamily.TIMES_ROMAN, 25, Font.BOLD,BaseColor.BLACK);
			Font companynamefont = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD,BaseColor.BLACK);
			Font addressfont = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL,BaseColor.BLACK);
			Font headingfont = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL,BaseColor.BLACK);
			Font detailsfont = new Font(FontFamily.TIMES_ROMAN, 9, Font.NORMAL,BaseColor.BLACK);
			document.open();
			Paragraph title1 = new Paragraph("DELIVERY CHALLAN");
			title1.setAlignment(Element.ALIGN_CENTER);

			
			Paragraph paragraph = new Paragraph("");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			Chunk underline = new Chunk("DELIVERY CHALLAN",titlefont);
			underline.setUnderline(0.1f, -2f); // 0.1 thick, -2 y-location
			paragraph.add(underline);
			document.add(paragraph);

			PdfPTable address = new PdfPTable(new float[] { 75, 25 });

			address.setWidthPercentage(100);

			Paragraph p = new Paragraph("SPAN ENGINEERS \n",companynamefont);
			
			
			p.add(new Paragraph("Flat No. 1, Ground Floor, Sundar Enclave,30 / 1,Valmiki Street, \n",addressfont));
			p.add(new Paragraph("Thiruvanmiyur, Chennai -  41. Phone : 24410478 / 7200056491. \n",addressfont));
			p.add(new Paragraph("Email : spanengineers@yahoo.co.in \n",addressfont));
			
		
			
			PdfPCell address1 = new PdfPCell(p);
			
			
			address1.setHorizontalAlignment(Element.ALIGN_CENTER);
			address1.setPaddingBottom(5);
			address1.setLeading(2, 1);
			
			Image logoimg = Image.getInstance(LOGO);
			logoimg.setWidthPercentage(100);
			logoimg.scaleAbsoluteWidth(130);
			logoimg.scaleAbsoluteHeight(70);
			
			PdfPCell logo = new PdfPCell(logoimg);
			logo.setPadding(3);

			address.addCell(address1);
			address.addCell(logo);

			PdfPTable cust_details = new PdfPTable(new float[] {18,32,18,32});
			cust_details.setWidthPercentage(100);	
			

			PdfPCell cname = new PdfPCell(new Paragraph("C'nee Name", headingfont));
			PdfPCell cnamevalue = new PdfPCell(new Paragraph("", headingfont));
			PdfPCell gstin = new PdfPCell(new Paragraph("GSTIN", headingfont));
			PdfPCell gstinvalue = new PdfPCell(new Paragraph("3Afdsf", headingfont));
			PdfPCell caddress = new PdfPCell(new Paragraph("C'nee Add", headingfont));
			caddress.setRowspan(3);
			PdfPCell caddressvalue = new PdfPCell(new Paragraph("", headingfont));
			caddressvalue.setRowspan(3);
			PdfPCell delychallan = new PdfPCell(new Paragraph("Dely Challan", headingfont));
			PdfPCell delychallanvalue = new PdfPCell(new Paragraph("", headingfont));
			PdfPCell dcdate = new PdfPCell(new Paragraph("DC Date :", headingfont));
			PdfPCell dcdatevalue = new PdfPCell(new Paragraph("", headingfont));
			PdfPCell placeofsuppy = new PdfPCell(new Paragraph("Place of Supply :", headingfont));
			PdfPCell placeofsuppyvalue = new PdfPCell(new Paragraph("", headingfont));
			PdfPCell transmode = new PdfPCell(new Paragraph("Trans Mode", headingfont));
			PdfPCell transmodevalue = new PdfPCell(new Paragraph("", headingfont));
			PdfPCell transcompany = new PdfPCell(new Paragraph("Trans Company", headingfont));
			PdfPCell transcompanyvalue = new PdfPCell(new Paragraph("", headingfont));
			PdfPCell vehicleno = new PdfPCell(new Paragraph("Vehicle No :", headingfont));
			PdfPCell vehiclenovalue = new PdfPCell(new Paragraph("", headingfont));
			PdfPCell dispacthdate = new PdfPCell(new Paragraph("Dispatch Date :", headingfont));
			PdfPCell dispacthdatevalue = new PdfPCell(new Paragraph("", headingfont));

			cust_details.addCell(cname);
			cust_details.addCell(cnamevalue);
			cust_details.addCell(gstin);
			cust_details.addCell(gstinvalue);
			cust_details.addCell(caddress);
			cust_details.addCell(caddressvalue);
			cust_details.addCell(delychallan);
			cust_details.addCell(delychallanvalue);
			cust_details.addCell(dcdate);
			cust_details.addCell(dcdatevalue);
			cust_details.addCell(placeofsuppy);
			cust_details.addCell(placeofsuppyvalue);
			cust_details.addCell(transmode);
			cust_details.addCell(transmodevalue);
			cust_details.addCell(vehicleno);
			cust_details.addCell(vehiclenovalue);
			cust_details.addCell(transcompany);
			cust_details.addCell(transcompanyvalue);
			cust_details.addCell(dispacthdate);
			cust_details.addCell(dispacthdatevalue);

			PdfPTable product_details_heading1 = new PdfPTable(new float[] {1});
			product_details_heading1.setWidthPercentage(100);
			
			PdfPTable product_details_heading = new PdfPTable(new float[] {7,40,13,10,10,10,10});
			product_details_heading.setWidthPercentage(100);
			
						
			PdfPCell sno = new PdfPCell(new Paragraph("S.No", headingfont));
			PdfPCell productdesc = new PdfPCell(new Paragraph("Product Description", headingfont));
			PdfPCell code = new PdfPCell(new Paragraph("Code", headingfont));
			PdfPCell qty = new PdfPCell(new Paragraph("Qty", headingfont));
			PdfPCell unit = new PdfPCell(new Paragraph("Unit", headingfont));
			PdfPCell rate = new PdfPCell(new Paragraph("Rate", headingfont));
			PdfPCell total = new PdfPCell(new Paragraph("Total", headingfont));
			
			
			product_details_heading.addCell(sno);
			product_details_heading.addCell(productdesc);
			product_details_heading.addCell(code);
			product_details_heading.addCell(qty);
			product_details_heading.addCell(unit);
			product_details_heading.addCell(rate);
			product_details_heading.addCell(total);
			
			product_details_heading1.addCell(product_details_heading);
			
			PdfPTable product_details = new PdfPTable(new float[] {7,40,13,10,10,10,10});
			product_details.setWidthPercentage(100);
			
			List<DispatcherLog> dispatcherLogEntityList=dispatchLogRepository.getDispatcherLogByChallanNo("1015");
			
			for(int i=0;i<dispatcherLogEntityList.size();i++)
			{
				PdfPCell snovalue = new PdfPCell(new Paragraph(String.valueOf(i), headingfont));
				PdfPCell productdescvalue = new PdfPCell(new Paragraph(dispatcherLogEntityList.get(i).getCategory().getCategoryType(), headingfont));
				PdfPCell codevalue = new PdfPCell(new Paragraph(dispatcherLogEntityList.get(i).getModelCode(), headingfont));
				PdfPCell qtyvalue = new PdfPCell(new Paragraph(String.valueOf(dispatcherLogEntityList.get(i).getAvailableQuantity()), headingfont));
				PdfPCell unitvalue = new PdfPCell(new Paragraph("", headingfont));
				PdfPCell ratevalue = new PdfPCell(new Paragraph("", headingfont));
				PdfPCell totalvalue = new PdfPCell(new Paragraph("", headingfont));
				product_details.addCell(snovalue);
				product_details.addCell(productdescvalue);
				product_details.addCell(codevalue);
				product_details.addCell(qtyvalue);
				product_details.addCell(unitvalue);
				product_details.addCell(ratevalue);
				product_details.addCell(totalvalue);
			}
			
			
			
			
			
			
			Paragraph terms = new Paragraph("The above mentioned goods are transported for internal purpose and NOT FOR SALE",detailsfont);
			
			Paragraph seal = new Paragraph("For SPAN ENGINEERS",headingfont);
			
			seal.setAlignment(Element.ALIGN_RIGHT);
			
			document.add(new Paragraph("\n"));
			document.add(address);
			document.add(cust_details);
			document.add(product_details_heading1);
			document.add(product_details);
			document.add(new Paragraph("\n"));
			document.add(terms);
			document.add(new Paragraph("\n"));
			document.add(seal);
            // step 5
            document.close();
 
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        }
        catch(DocumentException e) {
            throw new IOException(e.getMessage());
        }
    }
 
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 6067021675155015602L;
 
}
