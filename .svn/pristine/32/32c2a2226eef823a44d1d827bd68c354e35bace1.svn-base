package com.fa.inventory.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Principal;
import java.text.MessageFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.RequestDto;
import com.fa.inventory.dto.SmsResponseDto;
import com.fa.inventory.entity.Employee;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.User;
import com.fa.inventory.entity.WareHouse;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.WareHouseRepository;
import com.fa.inventory.service.SmsService;

@Service
@PropertySource({ "classpath:configuration/additional.properties" })
public class SmsServiceImpl implements SmsService {

	protected final Logger logger = Logger.getLogger(SmsServiceImpl.class);

	@Resource
	private Environment env;

	@Resource
	WareHouseRepository wareHouseRepository;

	@Resource
	ProjectRepository ProjectRepository;

	@Override
	public String sendSms(Principal principal, Authentication authentication) {
		try {
			// Construct data
			logger.info("<--SmsServiceImpl-------------sendSms--------------------started-->" + authentication);
			String apiKey = "apikey=" + env.getProperty("KEY");
			String message = "&message=" + env.getProperty("INBOUNDMESSAGESHEADER") + "\n"
					+ env.getProperty("INBOUNDMESSAGE");
			String sender = "&sender=" + URLEncoder.encode(env.getProperty("FACAPM"), "UTF-8");
			String numbers = "&numbers=" + "9940849755";
			String username = "username=" + env.getProperty("SMSUSERNAME");

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = username + apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
				System.out.println("sms response" + stringBuffer);
			}
			rd.close();
			logger.info("<--SmsServiceImpl-------------sendSms--------------------Ended-->" + authentication);
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	@Override
	public String sendSmsWithRestTemplate(Principal principal, Authentication authentication, String smsTemplate) {
		logger.info("<--SmsServiceImpl-------------sendSmsWithRestTemplate--------------------started-->" + authentication);

		logger.info("<--SmsServiceImpl-------------sendSmsWithRestTemplate--------------------Ended-->" + authentication);
		return null;
	}

	public String smsResponse(String mob, String name) {
		RequestDto urlReqDto = new RequestDto();
		String status = "";
		logger.info("<--SmsServiceImpl-------------smsResponse--------------------started-->");
		try {
			StringBuilder messages = new StringBuilder();
			messages.append(env.getProperty("INBOUNDMESSAGESHEADER"));
			messages.append("\n");
			messages.append("\n");
			messages.append(env.getProperty("INBOUNDMESSAGE"));
			String user = "username=" + env.getProperty("SMSUSERNAME");
			urlReqDto.setUser(user);
			String hash = "&hash=" + env.getProperty("KEY");
			urlReqDto.setHash(hash);
			String message = "&message=" + URLEncoder.encode(
					new MessageFormat(messages.toString()).format(new Object[] { name.toUpperCase() }), "UTF-8");
			urlReqDto.setMessage(message);
			String sender = "&sender=" + URLEncoder.encode(env.getProperty("FACAPM"), "UTF-8");
			urlReqDto.setSender(sender);
			String numbers = "&numbers=" + URLEncoder.encode(mob, "UTF-8");
			urlReqDto.setNumbers(numbers);
			String data = user + hash + numbers + message + sender;
			urlReqDto.setData(data);
			urlReqDto.setUrl(new URL(env.getProperty("SMSURL") + data).toString());
			logger.info("URL" + new URL(env.getProperty("SMSURL") + data));

			RestTemplate restTemplate = new RestTemplate();
			RequestEntity<RequestDto> requestEntity = new RequestEntity<>(urlReqDto, HttpMethod.POST,
					new URI(urlReqDto.getUrl()));
			ResponseEntity<SmsResponseDto> result = restTemplate.exchange(new URI(urlReqDto.getUrl()), HttpMethod.POST,
					requestEntity, SmsResponseDto.class);
			if (result.getStatusCode() == HttpStatus.OK && result.hasBody() && result.getBody() != null) {
				SmsResponseDto responseDto = result.getBody();
				status = responseDto.getStatus();
				// SmsDataProvider smsDataProvider=getSmsdataProvider(mob,new
				// MessageFormat(messages.toString()).format(new Object[] {
				// teleName.toUpperCase()}),status);
				// saveSmsDetails(responseDto,smsDataProvider);
			} else {
				throw new Exception("Error occured in smstrigger");
			}

		} catch (Exception e) {
			logger.error("", e);
			return "Error " + e;
		}
		logger.info("<--SmsServiceImpl-------------smsResponse--------------------Ended-->");
		return status;
	}

	@Override
	public String sendSmsToWareHouseOrProjectUsers(String To) {
		logger.info("<--SmsServiceImpl-------------sendSmsToWareHouseOrProjectUsers--------------------started-->");
		WareHouse warehouse = wareHouseRepository.findByWareHouseName(To);
		Project project = ProjectRepository.findByName(To);
		if (project != null) {
			List<User> usermanagementDtoList = project.getUser();
			if (usermanagementDtoList != null && !usermanagementDtoList.isEmpty()) {

				for (int k = 0; k < usermanagementDtoList.size(); k++) {
					User user = usermanagementDtoList.get(k);
					if (user != null) {
						Employee employee = user.getEmployee();
						if (employee != null) {
							smsResponse(String.valueOf(employee.getMobileNumber()), employee.getFirstName());
						}
					}
				}
			}
		} else if (warehouse != null) {
			WareHouse Warehouse = wareHouseRepository.findByWareHouseName(warehouse.getWareHouseName());
			if (Warehouse != null) {
				List<User> usermanagementDtoList = Warehouse.getUser();
				if (usermanagementDtoList != null && !usermanagementDtoList.isEmpty()) {

					for (int k = 0; k < usermanagementDtoList.size(); k++) {
						User user = usermanagementDtoList.get(k);
						if (user != null) {
							Employee employee = user.getEmployee();
							if (employee != null) {
								smsResponse(String.valueOf(employee.getMobileNumber()), employee.getFirstName());
							}
						}
					}
				}
			}
		}
		logger.info("<--SmsServiceImpl-------------sendSmsToWareHouseOrProjectUsers--------------------Ended-->");
		return InventoryConstant.SUCCESS;
	}

}
