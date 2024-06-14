package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factroy;

	public String addCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factroy.openSession();
			tx = session.beginTransaction();

			session.persist(c);

			session.getTransaction();
			tx.commit();
			msg = "country is added..";
		} catch (Exception e) {
			if (msg != null) {
				tx.rollback();

			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String updateCountry(int id, Country c) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factroy.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);
			country.setCname(c.getCname());

			session.merge(country);

			session.getTransaction();
			tx.commit();
			msg = "country is updated..";
		} catch (Exception e) {
			if (msg != null) {
				tx.rollback();

			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;

	}

	public String deleteCountry(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factroy.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);

			session.remove(country);

			session.getTransaction();
			tx.commit();
			msg = "country is deleted..";

		} catch (Exception e) {

			if (msg != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;

		// List<Country> list = null;

		try {

			String hqlQuery = "from Country";

			session = factroy.openSession();
			tx = session.beginTransaction();

			Query<Country> query = session.createQuery(hqlQuery, Country.class);

			list = query.list();

			session.getTransaction();
			tx.commit();
			System.out.println("Here is all country..");

		} catch (Exception e) {

			if (list != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public String addEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factroy.openSession();
			tx = session.beginTransaction();

			session.persist(emp);

			tx.commit();
			msg = "Employee added successfully..";

		} catch (Exception e) {
			if (msg != null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factroy.openSession();
			tx = session.beginTransaction();

			Employee e = session.get(Employee.class, emp.getId());

			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			e.setDepartment(emp.getDepartment());
			e.setStatus(emp.getStatus());
			e.setPhoneno(emp.getPhoneno());
			e.setCreateddtm(emp.getCreateddtm());
			e.setUpdatedby(emp.getUpdatedby());
			e.setUpdateddtm(emp.getUpdateddtm());
			e.setEmailid(emp.getEmailid());
			e.setCountry(emp.getCountry());

			session.merge(e);
			tx.commit();
			msg = "Employee Updated Successfully..";

		} catch (Exception e) {
			if (msg != null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmployee(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factroy.openSession();
			tx = session.beginTransaction();

			Employee emp = session.get(Employee.class, id);

			session.remove(emp);

			tx.commit();
			msg = "Employee deleted Successfully..";

		} catch (Exception e) {
			if (msg != null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Employee> getAllEmployee() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee";

		try {
			session = factroy.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Employee getParticularEmployee(int id) {
		Session session = null;
		Transaction tx = null;
		Employee emp = null;
		// String hqlQuery = "from Employee";

		try {

			session = factroy.openSession();
			tx = session.beginTransaction();

			emp = session.get(Employee.class, id);
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return emp;
	}

	public List<Employee> getParticularStatus(String status) {
		// TODO Auto-generated method stub

		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where status=:mystatus";

		try {

			session = factroy.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mystatus", status);

			list = query.list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public List<Employee> getParticularDepartment(String department) {

		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where department=:mydepartment";

		try {

			session = factroy.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mydepartment", department);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Employee loginCheck(Employee emp) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;
		String hqlQuery = "from Employee where emailid=:myemailid and phoneno=:myphone";

		try {

			session = factroy.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("myphone", emp.getPhoneno());

			employee = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

	public List<Employee> getSalary(double salary) {
		// TODO Auto-generated method stub

		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;

		String hqlQuery = "from Employee where salary >: mysalary";

		try {

			session = factroy.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			query.setParameter("mysalary", salary);

			list = query.list();
			
			tx=session.getTransaction();
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		

	}

}
