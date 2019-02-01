package test;

import java.util.List;

import com.task.model.Projects;
import com.task.resources.Factory;

public class Test {
	public static void main(String[] args) {
		try {
			List<Projects> val = Factory.createProjectService().fetchAllProjects();
			for (Projects projects : val) {
				System.out.println(projects.getProjectId()+" "+projects.getProjectName());
			}
			
			/* List<Employee> val2 = Factory.createEmployeeService().fetchEmployeeByProject("Project1");
			for (Employee employee : val2) {
				System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName()+" "+employee.getProjectBelonged());
			}*/
			/*List<Tasks> val3 = Factory.createTaskService().fetchTaskByProjects("ALL PROJECTS");
			for (Tasks tasks : val3) {
				System.out.println(tasks.getTaskName()+""+tasks.getTaskStartDate()+""+tasks.getTaskEnddate());
			}*/
			/*List<Tasks> val3 = Factory.createTaskService().fetchTaskByProjects("Project1");
			for (Tasks tasks : val3) {
				System.out.println(tasks.getTaskName()+""+tasks.getTaskStartDate()+""+tasks.getTaskEnddate());
			}*/
		/*	Tasks task = new Tasks();
			task.setTaskName("Task1");
			task.setTaskStartDate(new Date());
			task.setTaskEnddate(new Date());
			task.setProjectBelonged("Project1");
			Set<Employee> employeesAssigned = new HashSet<>();
			Employee e = new Employee();
			e.setEmployeeId("Emp1");
			e.setEmployeeName("John");
			e.setProjectBelonged("Project1");
			employeesAssigned.add(e);
			task.setEmployeesAssigned(employeesAssigned);
			
			Factory.createTaskService().assignTasks(task);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
