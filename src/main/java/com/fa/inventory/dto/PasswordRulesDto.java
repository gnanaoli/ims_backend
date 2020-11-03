package com.fa.inventory.dto;

public class PasswordRulesDto {
	private Long id;

	
	private Integer minLengthForRegularPassword;

	
	private Integer maximumWrongAttempts;

	
	private Integer warn_N_Days_Before_Expiry;

	
	private Integer expiresAfterNDays;

	
	private Integer preventLastNPasswords;

	
	private Integer lockAfterNInactiveDays;

	
	private Integer upperCaseAlphabets;

	
	private Integer lowerCaseAlphabets;

	
	private Integer numerals;

	
	private Integer speicalcharacters;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getMinLengthForRegularPassword() {
		return minLengthForRegularPassword;
	}


	public void setMinLengthForRegularPassword(Integer minLengthForRegularPassword) {
		this.minLengthForRegularPassword = minLengthForRegularPassword;
	}


	public Integer getMaximumWrongAttempts() {
		return maximumWrongAttempts;
	}


	public void setMaximumWrongAttempts(Integer maximumWrongAttempts) {
		this.maximumWrongAttempts = maximumWrongAttempts;
	}


	public Integer getWarn_N_Days_Before_Expiry() {
		return warn_N_Days_Before_Expiry;
	}


	public void setWarn_N_Days_Before_Expiry(Integer warn_N_Days_Before_Expiry) {
		this.warn_N_Days_Before_Expiry = warn_N_Days_Before_Expiry;
	}


	public Integer getExpiresAfterNDays() {
		return expiresAfterNDays;
	}


	public void setExpiresAfterNDays(Integer expiresAfterNDays) {
		this.expiresAfterNDays = expiresAfterNDays;
	}


	public Integer getPreventLastNPasswords() {
		return preventLastNPasswords;
	}


	public void setPreventLastNPasswords(Integer preventLastNPasswords) {
		this.preventLastNPasswords = preventLastNPasswords;
	}


	public Integer getLockAfterNInactiveDays() {
		return lockAfterNInactiveDays;
	}


	public void setLockAfterNInactiveDays(Integer lockAfterNInactiveDays) {
		this.lockAfterNInactiveDays = lockAfterNInactiveDays;
	}


	public Integer getUpperCaseAlphabets() {
		return upperCaseAlphabets;
	}


	public void setUpperCaseAlphabets(Integer upperCaseAlphabets) {
		this.upperCaseAlphabets = upperCaseAlphabets;
	}


	public Integer getLowerCaseAlphabets() {
		return lowerCaseAlphabets;
	}


	public void setLowerCaseAlphabets(Integer lowerCaseAlphabets) {
		this.lowerCaseAlphabets = lowerCaseAlphabets;
	}


	public Integer getNumerals() {
		return numerals;
	}


	public void setNumerals(Integer numerals) {
		this.numerals = numerals;
	}


	public Integer getSpeicalcharacters() {
		return speicalcharacters;
	}


	public void setSpeicalcharacters(Integer speicalcharacters) {
		this.speicalcharacters = speicalcharacters;
	}
	
}
