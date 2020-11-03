package com.fa.inventory.entity;

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
import javax.persistence.Table;

@Entity
@Table(name = "id_proof_master")
public class IdProofMaster {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 30, nullable = false)
	private String name;

	@Column(name = "status", length = 30, nullable = false)
	private String status;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, })
	@JoinTable(name = "employee_proofmaster", joinColumns = {
			@JoinColumn(name = "employee_fk_id") }, inverseJoinColumns = { @JoinColumn(name = "proof_fk_id") })
	private List<Employee> employeeList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

}
