package com.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.task.model.Projects;
import com.task.persistence.dao.interfaces.ProjectDAO;
import com.task.service.interfaces.ProjectService;
@Service("projectService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	ProjectDAO projectDAO;
	@Override
	public List<Projects> fetchAllProjects() throws Exception {
		List<Projects> projectDetails = projectDAO.fetchAllProjects();
		return projectDetails;
	}

}
