package com.fa.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "password_rules")
public class PasswordRules {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "min_length_for_regular_password",length=2)
	private Integer minLengthForRegularPassword;

	@Column(name = "maximum_wrong_attempts",length=2)
	private Integer maximumWrongAttempts;

	@Column(name = "warn_n_days_before_expiry",length=2)
	private Integer warn_N_Days_Before_Expiry;

	@Column(name = "expires_after_n_days",length=2)
	private Integer expiresAfterNDays;

	@Column(name = "prevent_last_n_passwords",length=2)
	private Integer preventLastNPasswords;

	@Column(name = "lock_after_n_inactive_days",length=2)
	private Integer lockAfterNInactiveDays;

	@Column(name = "upper_case_alphabets",length=2)
	private Integer upperCaseAlphabets;

	@Column(name = "lower_case_alphabets",length=2)
	private Integer lowerCaseAlphabets;

	@Column(name = "numerals",length=2)
	private Integer numerals;

	@Column(name = "speical_characters",length=2)
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
