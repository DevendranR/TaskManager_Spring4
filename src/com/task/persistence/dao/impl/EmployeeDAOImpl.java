package com.task.persistence.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.model.Employee;
import com.task.model.Tasks;
import com.task.persistence.dao.interfaces.EmployeeDAO;
import com.task.persistence.entity.EmployeeEntity;
import com.task.persistence.entity.TaskEntity;
@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO{
	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public List<Employee> fetchEmployeeByProject(String projectId) throws Exception {
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Query query=session.createQuery("Select e from EmployeeEntity e where e.projectBelonged=?");
			query.setParameter(0, projectId);
			List<EmployeeEntity> empList=(List<EmployeeEntity>) query.list();
			List<Employee> eList = new ArrayList<>();
			
			for (EmployeeEntity employee : empList) {
				Employee emp = new Employee();
				emp.setEmployeeId(employee.getEmployeeId());
				emp.setEmployeeName(employee.getEmployeeName());
				emp.setProjectBelonged(employee.getProjectBelonged());
				Set<Tasks> set = new HashSet<>();
				for (TaskEntity taskEt : employee.getTasks()) {
					Tasks task = new Tasks();
					task.setTaskId(taskEt.getTaskId());
					task.setTaskName(taskEt.getTaskName());
					set.add(task);
				}
				emp.setTaskAssigned(set);
				eList.add(emp);
			}
				
			
			return eList;
			
		}catch (HibernateException e) {
			DOMConfigurator.configure("src/com/task/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(e.getMessage(),e);
			throw new Exception("DAO.TECHINAL_ERROR");
		} catch (Exception exception) {
			throw exception;
		}
		
			
		}

}
