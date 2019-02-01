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

import com.task.model.Tasks;
import com.task.persistence.dao.interfaces.TaskDAO;
import com.task.persistence.entity.EmployeeEntity;
import com.task.persistence.entity.TaskEntity;
import com.task.utils.DateConverter;
@Repository("taskDAO")
public class TaskDAOImpl implements TaskDAO{
	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public void assignTasks(Tasks task) throws Exception {
		Session session=null;
		try{
			session=sessionFactory.openSession();
			
			TaskEntity taskEntity= new TaskEntity();
			taskEntity.setTaskName(task.getTaskName());
			taskEntity.setTaskStartDate(DateConverter.convertStringToDate(task.getTaskStartDate()));
			taskEntity.setTaskEnddate(DateConverter.convertStringToDate(task.getTaskEnddate()));
			taskEntity.setProjectBelonged(task.getProjectBelonged());
			Set<EmployeeEntity> empSet = new HashSet<>();
			for (String empid : task.getEmployeesAssigned()) {
				Query query=session.createQuery("Select e from EmployeeEntity e where e.employeeId = ?");
				query.setParameter(0, empid);
				EmployeeEntity emp=(EmployeeEntity) query.list().get(0);
				
				empSet.add(emp);
			}
			taskEntity.setEmployees(empSet);
			session.beginTransaction();
			session.save(taskEntity);
			session.getTransaction().commit();
			
			
		}catch (HibernateException e) {
			DOMConfigurator.configure("src/com/task/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(e.getMessage(),e);
			throw new Exception("DAO.TECHINAL_ERROR");
		} catch (Exception exception) {
			throw exception;
}
		

		
	}

	@Override
	public List<Tasks> fetchTaskByProjects(String projectId) throws Exception {
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Query query=session.createQuery("Select e from TaskEntity e where e.ProjectBelonged = ?");
			query.setParameter(0, projectId);
			List<TaskEntity> taskList=query.list();
			List<Tasks> tList = new ArrayList<Tasks>();
			for (TaskEntity task : taskList) {
				Tasks task2 = new Tasks();
				task2.setTaskId(task.getTaskId());
				task2.setTaskName(task.getTaskName());
				task2.setTaskStartDate(DateConverter.convertDateToString(task.getTaskStartDate()));
				task2.setTaskEnddate(DateConverter.convertDateToString(task.getTaskEnddate()));
				task2.setProjectBelonged(task.getProjectBelonged());
				Set<String> empSet = new HashSet<>();
				for (EmployeeEntity emps : task.getEmployees()) {
					
					empSet.add(emps.getEmployeeId());
				}
				task2.setEmployeesAssigned(empSet);
				tList.add(task2);
			}
			return tList;
			
		}catch (HibernateException e) {
			DOMConfigurator.configure("src/com/task/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(e.getMessage(),e);
			throw new Exception("DAO.TECHINAL_ERROR");
		} catch (Exception exception) {
			throw exception;
}
		

	}

	@Override
	public List<Tasks> fetchAllTasks() throws Exception {
		
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Query query=session.createQuery("Select e from TaskEntity e");
			List<TaskEntity> taskList=query.list();
			List<Tasks> tList = new ArrayList<Tasks>();
			for (TaskEntity task : taskList) {
				Tasks task2 = new Tasks();
				task2.setTaskId(task.getTaskId());
				task2.setTaskName(task.getTaskName());
				task2.setTaskStartDate(DateConverter.convertDateToString(task.getTaskStartDate()));
				task2.setTaskEnddate(DateConverter.convertDateToString(task.getTaskEnddate()));
				Set<String> empSet = new HashSet<>();
				Set<EmployeeEntity> val = task.getEmployees();
				for (EmployeeEntity emps : val) {
					
					empSet.add(emps.getEmployeeId());
				}
				task2.setEmployeesAssigned(empSet);
				tList.add(task2);
			}
			return tList;
			
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
