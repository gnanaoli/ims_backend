package com.fa.inventory.dto;

import java.util.List;

public class EmployeeDto {

	private Long id;

	private String fullName;

	private String firstName;

	private String employeeId;

	private String lastName;

	private String gender;

	private String guardianName;

	private String nationality;

	private String maritalStatus;

	private String bloodGroup;

	private String panCardNumber;

	private String proof;

	private String ProofNumber;

	private String department;

	private String designation;

	private String dateOfJoin;

	private Long mobileNumber;

	private Long alternateMobileNumber;

	private Long phoneStateCode;

	private Long telePhoneNumber;

	private String companyEmailId;

	private String emailId;

	private String alternateEmailId;

	private String taddress1;

	private String taddress2;

	private String taddress3;

	private String taddress4;

	private String paddress1;

	private String paddress2;

	private String paddress3;

	private String paddress4;

	private String tstate;

	private String tcity;

	private Long tpinCode;

	private String pstate;

	private String pcity;

	private Long ppinCode;

	private String status;

	private String subStatus;

	private Boolean isAddressSame;

	private String dateOfBirth;

	private String confirmationDate;

	private String religion;

	private String fatherName;

	private String husbandName;

	private String resignedDate;

	private String aadhaarNumber;

	private String drivingLicenseNumber;

	private String voterIdNumber;

	private String passportNumber;
	
	private String employeeType;
	
	private List<IdProofMasterDto> idProofMasterDtoList;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public String getProofNumber() {
		return ProofNumber;
	}

	public void setProofNumber(String proofNumber) {
		ProofNumber = proofNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(String confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getAlternateMobileNumber() {
		return alternateMobileNumber;
	}

	public void setAlternateMobileNumber(Long alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}

	public Long getPhoneStateCode() {
		return phoneStateCode;
	}

	public void setPhoneStateCode(Long phoneStateCode) {
		this.phoneStateCode = phoneStateCode;
	}

	public Long getTelePhoneNumber() {
		return telePhoneNumber;
	}

	public void setTelePhoneNumber(Long telePhoneNumber) {
		this.telePhoneNumber = telePhoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAlternateEmailId() {
		return alternateEmailId;
	}

	public void setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}

	public String getTstate() {
		return tstate;
	}

	public void setTstate(String tstate) {
		this.tstate = tstate;
	}

	public String getTcity() {
		return tcity;
	}

	public void setTcity(String tcity) {
		this.tcity = tcity;
	}

	public Long getTpinCode() {
		return tpinCode;
	}

	public void setTpinCode(Long tpinCode) {
		this.tpinCode = tpinCode;
	}

	public String getPstate() {
		return pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	public String getPcity() {
		return pcity;
	}

	public void setPcity(String pcity) {
		this.pcity = pcity;
	}

	public Long getPpinCode() {
		return ppinCode;
	}

	public void setPpinCode(Long ppinCode) {
		this.ppinCode = ppinCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Boolean getIsAddressSame() {
		return isAddressSame;
	}

	public void setIsAddressSame(Boolean isAddressSame) {
		this.isAddressSame = isAddressSame;
	}

	public String getTaddress1() {
		return taddress1;
	}

	public void setTaddress1(String taddress1) {
		this.taddress1 = taddress1;
	}

	public String getTaddress2() {
		return taddress2;
	}

	public void setTaddress2(String taddress2) {
		this.taddress2 = taddress2;
	}

	public String getTaddress3() {
		return taddress3;
	}

	public void setTaddress3(String taddress3) {
		this.taddress3 = taddress3;
	}

	public String getTaddress4() {
		return taddress4;
	}

	public void setTaddress4(String taddress4) {
		this.taddress4 = taddress4;
	}

	public String getPaddress1() {
		return paddress1;
	}

	public void setPaddress1(String paddress1) {
		this.paddress1 = paddress1;
	}

	public String getPaddress2() {
		return paddress2;
	}

	public void setPaddress2(String paddress2) {
		this.paddress2 = paddress2;
	}

	public String getPaddress3() {
		return paddress3;
	}

	public void setPaddress3(String paddress3) {
		this.paddress3 = paddress3;
	}

	public String getPaddress4() {
		return paddress4;
	}

	public void setPaddress4(String paddress4) {
		this.paddress4 = paddress4;
	}

	public String getCompanyEmailId() {
		return companyEmailId;
	}

	public void setCompanyEmailId(String companyEmailId) {
		this.companyEmailId = companyEmailId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getHusbandName() {
		return husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public String getResignedDate() {
		return resignedDate;
	}

	public void setResignedDate(String resignedDate) {
		this.resignedDate = resignedDate;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	public String getVoterIdNumber() {
		return voterIdNumber;
	}

	public void setVoterIdNumber(String voterIdNumber) {
		this.voterIdNumber = voterIdNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public List<IdProofMasterDto> getIdProofMasterDtoList() {
		return idProofMasterDtoList;
	}

	public void setIdProofMasterDtoList(List<IdProofMasterDto> idProofMasterDtoList) {
		this.idProofMasterDtoList = idProofMasterDtoList;
	}

}
