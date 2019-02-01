package com.task.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.model.Projects;
import com.task.persistence.dao.interfaces.ProjectDAO;
import com.task.persistence.entity.ProjectEntity;
@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO{
	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public List<Projects> fetchAllProjects() throws Exception {

		Session session=null;
		try{
			
			session=sessionFactory.openSession();
			Query query=session.createQuery("Select pe from ProjectEntity pe");
			List<ProjectEntity> projectList=query.list();
			List<Projects> pList = new ArrayList<Projects>();
			for (ProjectEntity project : projectList) {
				Projects project2 = new Projects();
				project2.setProjectId(project.getProjectId());
				project2.setProjectName(project.getProjectName());
				pList.add(project2);
			}
			return pList;
			
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
