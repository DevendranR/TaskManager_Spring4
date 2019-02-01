DROP TABLE Projects CASCADE CONSTRAINTS;
DROP TABLE Tasks CASCADE CONSTRAINTS;
DROP TABLE Employee CASCADE CONSTRAINTS;
DROP TABLE employee_task CASCADE CONSTRAINTS;


CREATE TABLE Projects(
    projectId varchar2(15)NOT NULL PRIMARY KEY,
    projectName varchar2(100) NOT NULL
);

insert into Projects values('Project1','IOS');
insert into Projects values('Project2','Windows');
insert into Projects values('Project3','OpenSource');

CREATE TABLE Tasks(
    taskId varchar2(15)NOT NULL PRIMARY KEY,
    taskName varchar2(100) NOT NULL,
    taskStartDate DATE NOT NULL,
    taskEnddate DATE NOT NULL,
    projectBelonged varchar2(15) NOT NULL,
    FOREIGN KEY (projectBelonged) REFERENCES Projects(projectId)
);

CREATE TABLE Employee(
    employeeId varchar2(15) NOT NULL PRIMARY KEY,
    employeeName varchar2(50) NOT NULL,
    projectBelonged varchar2(15),
    FOREIGN KEY (projectBelonged) REFERENCES Projects(projectId)
);


insert into Employee values('Emp1','John','Project1');
insert into Employee values('Emp2','Jack','Project2');
insert into Employee values('Emp3','Jenny','Project3');
insert into Employee values('Emp4','Johny','Project1');
insert into Employee values('Emp5','Jacky','Project2');
insert into Employee values('Emp6','Jen','Project3');
insert into Employee values('Emp7','Jacob','Project1');
insert into Employee values('Emp8','Jill','Project2');
insert into Employee values('Emp9','Jolly','Project3');

CREATE TABLE employee_task (
  employeeId varchar2(15) NOT NULL,
  taskId varchar2(15) NOT NULL,
  PRIMARY KEY (employeeId,taskId),
  CONSTRAINT employee_task_ibfk_1 
   FOREIGN KEY (employeeId) REFERENCES Employee (employeeId),
  CONSTRAINT employee_task_ibfk_2
   FOREIGN KEY (taskId) REFERENCES Tasks (taskId)
);

COMMIT;