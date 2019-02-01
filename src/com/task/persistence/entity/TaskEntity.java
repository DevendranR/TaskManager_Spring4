package com.task.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Tasks")
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer taskId;
	private String taskName;
	@Temporal(TemporalType.DATE)
	private Date taskStartDate;
	@Temporal(TemporalType.DATE)
	private Date taskEnddate;
	private String ProjectBelonged;
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Employee_Task", 
        joinColumns = { @JoinColumn(name = "taskId") }, 
        inverseJoinColumns = { @JoinColumn(name = "employeeId") }
    )
    
    private Set<EmployeeEntity> employees = new HashSet<>();
	
	public Set<EmployeeEntity> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<EmployeeEntity> employees) {
		this.employees = employees;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getTaskStartDate() {
		return taskStartDate;
	}
	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	public Date getTaskEnddate() {
		return taskEnddate;
	}
	public void setTaskEnddate(Date taskEnddate) {
		this.taskEnddate = taskEnddate;
	}
	public String getProjectBelonged() {
		return ProjectBelonged;
	}
	public void setProjectBelonged(String projectBelonged) {
		ProjectBelonged = projectBelonged;
	}

	
}
