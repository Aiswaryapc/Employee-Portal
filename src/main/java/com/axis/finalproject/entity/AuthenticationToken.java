//package com.axis.finalproject.entity;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import java.util.Date;
//import java.util.UUID;
//
//@Entity
//@Table(name = "tokens")
//public class AuthenticationToken {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    private String token;
//
//    @Column(name = "created_date")
//    private Date createdDate;
//
//    @OneToOne(targetEntity = Admin.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "admin_id")
//    private Admin admin;
//    
//    @OneToOne(targetEntity = Admin.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "emp_id")
//    private Employee employee;
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//  
//    public Admin getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public AuthenticationToken( Employee employee) {
//		super();
//        this.createdDate = new Date();
//        this.token = UUID.randomUUID().toString();
//		this.employee = employee;
//	}
//	public AuthenticationToken( Admin admin) {
//		super();
//        this.createdDate = new Date();
//        this.token = UUID.randomUUID().toString();
//		this.admin = admin;
//	}
//	public AuthenticationToken() {
//    }
//
//	@Override
//	public String toString() {
//		return "AuthenticationToken [id=" + id + ", token=" + token + ", createdDate=" + createdDate + ", admin="
//				+ admin + ", employee=" + employee + "]";
//	}
//	
//}