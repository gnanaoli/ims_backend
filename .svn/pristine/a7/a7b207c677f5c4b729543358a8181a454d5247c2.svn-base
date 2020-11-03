package com.fa.inventory.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", length = 30, nullable = true)
	private String firstName;

	@Column(name = "emp_id", length = 30, nullable = true, unique = true)
	private String employeeId;

	@Column(name = "last_name", length = 30, nullable = true)
	private String lastName;

	@Column(name = "gender", length = 20, nullable = true)
	private String gender;

	@Column(name = "date_of_birth", length = 10, nullable = true)
	private Date dateOfBirth;

	@Column(name = "department", length = 30, nullable = true)
	private String department;

	@Column(name = "guardianname", length = 50, nullable = true)
	private String guardianName;

	@Column(name = "nationality", length = 30, nullable = true)
	private String nationality;

	@Column(name = "marital_status", length = 15, nullable = true)
	private String maritalStatus;

	@Column(name = "blood_group", length = 10, nullable = true)
	private String bloodGroup;

	@Column(name = "pancard_number", length = 10, nullable = true)
	private String panCardNumber;

	@Column(name = "proof", length = 15, nullable = true)
	private String proof;

	@Column(name = "proof_number", length = 20, nullable = true)
	private String proofNumber;

	@Column(name = "designation", length = 30, nullable = true)
	private String designation;

	@Column(name = "date_of_join", length = 10, nullable = true)
	private Date dateOfJoin;

	@Column(name = "confirmation_date", length = 10, nullable = true)
	private Date confirmationDate;

	@Column(name = "mobile_number", length = 12, nullable = true)
	private Long mobileNumber;

	@Column(name = "alternate_mobile_number", length = 20, nullable = true)
	private Long alternateMobileNumber;

	@Column(name = "phone_state_code", length = 5, nullable = true)
	private Long phoneStateCode;

	@Column(name = "telephone_number", length = 20, nullable = true)
	private Long telePhoneNumber;

	@Column(name = "mail_id", length = 100, nullable = true)
	private String mailId;

	@Column(name = "alternate_mail_id", length = 100, nullable = true)
	private String alternateMailId;

	@Column(name = "company_mail_id", length = 100, nullable = true)
	private String companyEmailId;

	@Column(name = "t_address_1", length = 30, nullable = true)
	private String taddress1;

	@Column(name = "t_address_2", length = 30, nullable = true)
	private String taddress2;

	@Column(name = "t_address_3", length = 30, nullable = true)
	private String taddress3;

	@Column(name = "t_address_4", length = 30, nullable = true)
	private String taddress4;

	@Column(name = "p_address_1", length = 30, nullable = true)
	private String paddress1;

	@Column(name = "p_address_2", length = 30, nullable = true)
	private String paddress2;

	@Column(name = "p_address_3", length = 30, nullable = true)
	private String paddress3;

	@Column(name = "p_address_4", length = 30, nullable = true)
	private String paddress4;

	@Column(name = "t_state", length = 30, nullable = true)
	private String tstate;

	@Column(name = "t_city", length = 30, nullable = true)
	private String tcity;

	@Column(name = "t_pincode", length = 8, nullable = true)
	private Long tpinCode;

	@Column(name = "status", length = 10, nullable = true)
	private String status;

	@Column(name = "substatus", length = 10, nullable = true)
	private String subStatus;

	@Column(name = "p_state", length = 30, nullable = true)
	private String pstate;

	@Column(name = "p_city", length = 30, nullable = true)
	private String pcity;

	@Column(name = "p_pincode", length = 8, nullable = true)
	private Long ppinCode;

	@Column(name = "religion", length = 50, nullable = true)
	private String religion;

	@Column(name = "father_name", length = 50, nullable = true)
	private String fatherName;

	@Column(name = "husband_name", length = 50, nullable = true)
	private String husbandName;

	@Column(name = "isAddressSame", length = 50, nullable = true)
	private String isAddressSame;

	@Column(name = "resigned_date", length = 10, nullable = true)
	private Date resignedDate;

	@Column(name = "aadhaar_number", length = 15, nullable = true)
	private String aadhaarNumber;

	@Column(name = "drivinglicense_number", length = 20, nullable = true)
	private String drivingLicenseNumber;

	@Column(name = "voterid_number", length = 20, nullable = true)
	private String voterIdNumber;

	@Column(name = "passport_number", length = 20, nullable = true)
	private String passportNumber;
	
	@Column(name = "employee_type", length = 30, nullable = true)
	private String employeeType;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.MERGE)
	@JoinColumn(name = "employee_id")
	private User user;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_proofmaster", joinColumns = {
			@JoinColumn(name = "employee_fk_id") }, inverseJoinColumns = { @JoinColumn(name = "proof_fk_id") })
	private List<IdProofMaster> proofMasterList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		return proofNumber;
	}

	public void setProofNumber(String proofNumber) {
		this.proofNumber = proofNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getAlternateMailId() {
		return alternateMailId;
	}

	public void setAlternateMailId(String alternateMailId) {
		this.alternateMailId = alternateMailId;
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

	public String getCompanyEmailId() {
		return companyEmailId;
	}

	public void setCompanyEmailId(String companyEmailId) {
		this.companyEmailId = companyEmailId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Date getResignedDate() {
		return resignedDate;
	}

	public void setResignedDate(Date resignedDate) {
		this.resignedDate = resignedDate;
	}

	public String getIsAddressSame() {
		return isAddressSame;
	}

	public void setIsAddressSame(String isAddressSame) {
		this.isAddressSame = isAddressSame;
	}

	public List<IdProofMaster> getProofMasterList() {
		return proofMasterList;
	}

	public void setProofMasterList(List<IdProofMaster> proofMasterList) {
		this.proofMasterList = proofMasterList;
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
	
	

}
