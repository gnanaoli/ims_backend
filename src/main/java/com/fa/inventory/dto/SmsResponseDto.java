package com.fa.inventory.dto;

/**
 * @author Yvaraj.p
 */
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("balance")
	private String balance;

	@JsonProperty("batch_id")
	private String batchId;

	@JsonProperty("cost")
	private String cost;

	@JsonProperty("num_messages")
	private String numMessages;

	@JsonProperty("messages")
	private List<Messages> message;

	@JsonProperty("receipt_url")
	private String receiptURL;

	@JsonProperty("custom")
	private String custom;

	@JsonProperty("message")
	private Message messages;

	@JsonProperty("status")
	private String status;

	@JsonProperty("errors")
	private List<ErrorDescription> errors;

	@JsonProperty("warnings")
	private List<ErrorDescription> warnings;

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getNumMessages() {
		return numMessages;
	}

	public void setNumMessages(String numMessages) {
		this.numMessages = numMessages;
	}


	public String getReceiptURL() {
		return receiptURL;
	}

	public void setReceiptURL(String receiptURL) {
		this.receiptURL = receiptURL;
	}

	public List<Messages> getMessage() {
		return message;
	}

	public void setMessage(List<Messages> message) {
		this.message = message;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	
	public String getStatus() {
		return status;
	}

	public Message getMessages() {
		return messages;
	}

	public void setMessages(Message messages) {
		this.messages = messages;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ErrorDescription> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDescription> errors) {
		this.errors = errors;
	}

	public List<ErrorDescription> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<ErrorDescription> warnings) {
		this.warnings = warnings;
	}

}
