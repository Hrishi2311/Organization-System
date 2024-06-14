package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;

	public String addCountry(Country c) {

		String msg = dao.addCountry(c);

		if (Objects.isNull(msg)) {
			msg = "msg is not added";
		}

		return msg;

	}

	public String updateCountry(int id, Country c) {
		// TODO Auto-generated method stub
		String msg = dao.updateCountry(id, c);

		if (Objects.isNull(msg)) {
			msg = "county is not updated";
		}
		return msg;

	}

	public String deleteCountry(int id) {

		String msg = dao.deleteCountry(id);

		if (Objects.isNull(msg)) {
			msg = "Country is not delete";
		}

		return msg;

	}

	public List<Country> getAllCountry() {

		List<Country> list = dao.getAllCountry();
		return list;

	}

	public String addEmployee(Employee emp) {

		String msg = dao.addEmployee(emp);

		if (Objects.isNull(msg)) {
			msg = "Record not added";
		}

		return msg;

	}

	public String updateEmployee(Employee emp) {

		String msg = dao.updateEmployee(emp);

		if (Objects.isNull(msg)) {
			msg = "record is not updated..";
		}

		return msg;
	}

	public String deleteEmployee(int id) {

		String msg = dao.deleteEmployee(id);

		if (Objects.isNull(msg)) {
			msg = "record is not deleted..";
		}

		return msg;
	}

	public List<Employee> getAllEmployee() {

		List<Employee> list = dao.getAllEmployee();

		if (Objects.isNull(list)) {
			list = null;

		}

		return list;
	}

	public Employee getParticularEmployee(int id) {

		Employee emp = dao.getParticularEmployee(id);

		if (Objects.isNull(emp)) {
			emp = null;
		}

		return emp;
	}

	public List<Employee> getParticularStatus(String status) {

		List<Employee> list = dao.getParticularStatus(status);

		return list;
	}

	public List<Employee> getParticularDepartment(String department) {

		List<Employee> list = dao.getParticularDepartment(department);

//	if(Objects.isNull(list)) {
//		list=null;
//	}

		return list;
	}

	public HashMap loginCheck(Employee emp) {

		Employee e = dao.loginCheck(emp);

		HashMap map = new HashMap();

		if (Objects.isNull(e)) {
			map.put("msg", "Invalid user");
			map.put("user", e);

		} else {
			map.put("msg", "Valid user");
			map.put("user", e);

		}
		return map;

	}

	public List<Employee> getSalary(double salary) {

		List<Employee> list = dao.getSalary(salary);
		if(Objects.isNull(list)) {
			list=null;
		}

		return list;

	}

}
