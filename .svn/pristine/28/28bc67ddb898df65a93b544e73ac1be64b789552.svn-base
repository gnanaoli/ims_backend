package com.fa.inventory.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.entity.DeliveryChallanEntity;
import com.fa.inventory.entity.DispatcherLog;
import com.fa.inventory.repository.DeliveryChallanEntityRepository;
import com.fa.inventory.repository.DispatchLogRepository;
import com.fa.inventory.service.GeneratePdfService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@PropertySource({ "classpath:configuration/additional.properties" })
public class GeneratePdfImpl implements GeneratePdfService {

	public String LOGO = null;

	@Resource
	private Environment env;

	@Resource
	ServletContext servletContext;

	@PostConstruct
	public void setLogoPath() {
		this.LOGO = servletContext.getRealPath(env.getProperty("imagepath"));
	}

	@Resource
	DispatchLogRepository dispatchLogRepository;

	@Resource
	DeliveryChallanEntityRepository deliveryChallanEntityRepository;

	protected final Logger logger = Logger.getLogger(GeneratePdfImpl.class);

	@Override
	public OutputStream getPdfByChallanNo(String challanNo, HttpServletResponse response)
			throws MalformedURLException, IOException {

		logger.info("<--inventoryController3-------------getPdfByChallanNo--------------------started-->");
		Document document = new Document(PageSize.A4, 20f, 20f, 15f, 5f);
		OutputStream os = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfPCell vehiclenovalue = null;
		PdfPCell dispacthdatevalue = null;
		PdfPCell dcdatevalue = null;
		PdfPCell placeofsuppyvalue = null;
		PdfPCell transmodevalue = null;
		PdfPCell transcompanyvalue = null;
		PdfPCell cnamevalue = null;
		PdfPCell gstinvalue = null;
		PdfPCell caddressvalue = null;
		try {
			PdfWriter.getInstance(document, baos);
			Font titlefont = new Font(FontFamily.TIMES_ROMAN, 25, Font.BOLD, BaseColor.BLACK);
			Font companynamefont = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK);
			Font addressfont = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
			Font headingfont = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
			Font detailsfont = new Font(FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
			document.open();
			Paragraph title1 = new Paragraph("DELIVERY CHALLAN");
			title1.setAlignment(Element.ALIGN_CENTER);
			Paragraph paragraph = new Paragraph("");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			Chunk underline = new Chunk("DELIVERY CHALLAN", titlefont);
			underline.setUnderline(0.1f, -2f); // 0.1 thick, -2 y-location
			paragraph.add(underline);
			document.add(paragraph);
			PdfPTable address = new PdfPTable(new float[] { 75, 25 });
			address.setWidthPercentage(100);
			Paragraph p = new Paragraph("SPAN ENGINEERS \n", companynamefont);
			p.add(new Paragraph("Flat No. 1, Ground Floor, Sundar Enclave,30 / 1,Valmiki Street, \n", addressfont));
			p.add(new Paragraph("Thiruvanmiyur, Chennai -  41. Phone : 24410478 / 7200056491. \n", addressfont));
			p.add(new Paragraph("Email : spanengineers@yahoo.co.in \n", addressfont));
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

			PdfPTable cust_details = new PdfPTable(new float[] { 18, 32, 18, 32 });
			cust_details.setWidthPercentage(100);

			List<DeliveryChallanEntity> deliveryChallanEntities = deliveryChallanEntityRepository
					.findByChallanNo(challanNo);

			if (deliveryChallanEntities != null && !deliveryChallanEntities.isEmpty()) {
				PdfPCell cname = new PdfPCell(new Paragraph("Consignee Name", headingfont));
				if (deliveryChallanEntities.get(0).getConsigneeName() != null) {
					cnamevalue = new PdfPCell(
							new Paragraph(deliveryChallanEntities.get(0).getConsigneeName(), headingfont));
				} else {
					cnamevalue = new PdfPCell();
				}
				PdfPCell gstin = new PdfPCell(new Paragraph("GSTIN", headingfont));
				if (deliveryChallanEntities.get(0).getGstIn() != null) {
					gstinvalue = new PdfPCell(new Paragraph(deliveryChallanEntities.get(0).getGstIn(), headingfont));
				} else {
					gstinvalue = new PdfPCell();
				}
				PdfPCell caddress = new PdfPCell(new Paragraph("Consignee Add", headingfont));
				caddress.setRowspan(3);
				if (deliveryChallanEntities.get(0).getConsigneeAddress() != null) {
					caddressvalue = new PdfPCell(
							new Paragraph(deliveryChallanEntities.get(0).getConsigneeAddress(), headingfont));
					caddressvalue.setRowspan(3);
				} else {
					caddressvalue = new PdfPCell();
				}
				PdfPCell delychallan = new PdfPCell(new Paragraph("Dely Challan", headingfont));
				PdfPCell delychallanvalue = new PdfPCell(new Paragraph(challanNo, headingfont));
				PdfPCell dcdate = new PdfPCell(new Paragraph("Delivery Challan Date :", headingfont));
				if (deliveryChallanEntities.get(0).getDcDate() != null) {
					dcdatevalue = new PdfPCell(new Paragraph(deliveryChallanEntities.get(0).getDcDate(), headingfont));
				} else {
					dcdatevalue = new PdfPCell();
				}
				dcdatevalue.setHorizontalAlignment(Element.ALIGN_LEFT);
				dcdatevalue.setVerticalAlignment(Element.ALIGN_LEFT);
				PdfPCell placeofsuppy = new PdfPCell(new Paragraph("Place of Supply :", headingfont));
				if (deliveryChallanEntities.get(0).getPlaceOfSupply() != null) {
					placeofsuppyvalue = new PdfPCell(
							new Paragraph(deliveryChallanEntities.get(0).getPlaceOfSupply(), headingfont));
				} else {
					placeofsuppyvalue = new PdfPCell();
				}
				PdfPCell transmode = new PdfPCell(new Paragraph("Trans Mode", headingfont));
				if (deliveryChallanEntities.get(0).getTransMode() != null) {
					transmodevalue = new PdfPCell(
							new Paragraph(deliveryChallanEntities.get(0).getTransMode(), headingfont));
				} else {
					transmodevalue = new PdfPCell();
				}
				PdfPCell transcompany = new PdfPCell(new Paragraph("Trans Company", headingfont));
				if (deliveryChallanEntities.get(0).getTransCompany() != null) {
					transcompanyvalue = new PdfPCell(
							new Paragraph(deliveryChallanEntities.get(0).getTransCompany(), headingfont));
				} else {
					transcompanyvalue = new PdfPCell();
				}
				PdfPCell vehicleno = new PdfPCell(new Paragraph("Vehicle No :", headingfont));
				if (deliveryChallanEntities.get(0).getVehicleNo() != null) {
					vehiclenovalue = new PdfPCell(
							new Paragraph(deliveryChallanEntities.get(0).getVehicleNo(), headingfont));
				} else {
					vehiclenovalue = new PdfPCell();
				}
				PdfPCell dispacthdate = new PdfPCell(new Paragraph("Dispatch Date :", headingfont));
				if (deliveryChallanEntities.get(0).getDispatchDate() != null) {
					dispacthdatevalue = new PdfPCell(new Paragraph(
							MasterDateUtil.convertDateToString(deliveryChallanEntities.get(0).getDispatchDate()),
							headingfont));
				} else {
					dispacthdatevalue = new PdfPCell();
				}
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
			}

			PdfPTable product_details_heading1 = new PdfPTable(new float[] { 1 });
			product_details_heading1.setWidthPercentage(100);

			PdfPTable product_details_heading = new PdfPTable(new float[] { 7, 40, 13, 10, 10, 10, 10 });
			product_details_heading.setWidthPercentage(100);

			PdfPCell sno = new PdfPCell(new Paragraph("S.No", headingfont));
			sno.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell productdesc = new PdfPCell(new Paragraph("Product Description", headingfont));
			productdesc.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell code = new PdfPCell(new Paragraph("Code", headingfont));
			code.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell qty = new PdfPCell(new Paragraph("Qty", headingfont));
			qty.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell unit = new PdfPCell(new Paragraph("Unit", headingfont));
			unit.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell rate = new PdfPCell(new Paragraph("Rate", headingfont));
			rate.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell total = new PdfPCell(new Paragraph("Total", headingfont));
			total.setHorizontalAlignment(Element.ALIGN_CENTER);

			product_details_heading.addCell(sno);
			product_details_heading.addCell(productdesc);
			product_details_heading.addCell(code);
			product_details_heading.addCell(qty);
			product_details_heading.addCell(unit);
			product_details_heading.addCell(rate);
			product_details_heading.addCell(total);

			product_details_heading1.addCell(product_details_heading);

			PdfPTable product_details = new PdfPTable(new float[] { 7, 40, 13, 10, 10, 10, 10 });
			product_details.setWidthPercentage(100);

			List<DispatcherLog> dispatcherLogEntityList = dispatchLogRepository.getDispatcherLogByChallanNo(challanNo);

			for (int i = 0; i < dispatcherLogEntityList.size(); i++) {
				PdfPCell snovalue = new PdfPCell(new Paragraph(String.valueOf(i + 1), headingfont));
				snovalue.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell productdescvalue = new PdfPCell(
						new Paragraph(
								dispatcherLogEntityList.get(i).getCategory().getCategoryType() + "-"
										+ dispatcherLogEntityList.get(i).getSubCategory().getSubCategory(),
								headingfont));
				PdfPCell codevalue = new PdfPCell(
						new Paragraph(dispatcherLogEntityList.get(i).getModelCode(), headingfont));
				codevalue.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell qtyvalue = new PdfPCell(new Paragraph(
						String.valueOf(dispatcherLogEntityList.get(i).getDispatchedQuantity()), headingfont));
				qtyvalue.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell unitvalue = new PdfPCell(new Paragraph("", headingfont));
				unitvalue.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell ratevalue = new PdfPCell(new Paragraph("", headingfont));
				ratevalue.setHorizontalAlignment(Element.ALIGN_RIGHT);
				float Amount = 0;
				if (dispatcherLogEntityList.get(i).getPrice() != null) {
					Amount = (dispatcherLogEntityList.get(i).getDispatchedQuantity()
							* (dispatcherLogEntityList.get(i).getPrice()));

				}
				PdfPCell totalvalue = new PdfPCell(new Paragraph(String.valueOf(dispatcherLogEntityList.get(i).getPrice()), headingfont));
				totalvalue.setHorizontalAlignment(Element.ALIGN_CENTER);
				product_details.addCell(snovalue);
				product_details.addCell(productdescvalue);
				product_details.addCell(codevalue);
				product_details.addCell(qtyvalue);
				product_details.addCell(unitvalue);
				product_details.addCell(ratevalue);
				product_details.addCell(totalvalue);
			}
			Paragraph terms = new Paragraph(
					"* The above mentioned goods are transported for internal purpose only and NOT FOR SALE", detailsfont);
			Paragraph seal = new Paragraph("FOR SPAN ENGINEERS", headingfont);
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
			document.close();
			System.out.println("Pdf created successfully.");
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getPdfByChallanNo--------------------Ended-->");
		return os;
	}

}
