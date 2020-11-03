package com.fa.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "page_name", length = 100, nullable = false)
	private String pageName;
	
	@Column(name = "menu_icon", length = 100, nullable = false)
	private String menuIcon;

	@Column(name = "menu_category", length = 50, nullable = true)
	private String menuCategory;

	@Column(name = "menu_name", length = 50, nullable = true)
	private String menuName;

	@Column(name = "order_no", length = 50, nullable = true)
	private String orderName;

	@Column(name = "status", length = 100, nullable = false)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	
	

}
