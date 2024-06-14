package com.tka.OrganizationSystem.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	double salary;
	String department;
	String status;
	String phoneno;

	Date createddtm;
	String updatedby;

	Date updateddtm;
	String emailid;

	public Employee() {

	}

	public Employee(String name, double salary, String department, String status, String phoneno, Date createddtm,
			String updatedby, Date updateddtm, String emailid, Country country) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.status = status;
		this.phoneno = phoneno;
		this.createddtm = createddtm;
		this.updatedby = updatedby;
		this.updateddtm = updateddtm;
		this.emailid = emailid;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", status=" + status + ", phoneno=" + phoneno + ", createddtm=" + createddtm + ", updatedby="
				+ updatedby + ", updateddtm=" + updateddtm + ", emailid=" + emailid + ", country=" + country + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Date getCreateddtm() {
		return createddtm;
	}

	public void setCreateddtm(Date createddtm) {
		this.createddtm = createddtm;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdateddtm() {
		return updateddtm;
	}

	public void setUpdateddtm(Date updateddtm) {
		this.updateddtm = updateddtm;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@ManyToOne
	@JoinColumn(name = "c_id")
	Country country;

}
