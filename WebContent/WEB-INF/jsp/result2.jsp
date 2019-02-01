<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Submitted Student Information</h2>
      <table>
         <tr>
            <td>Name</td>
            <td>${taskName}</td>
         </tr>
         <tr>
            <td>Project</td>
            <td>${projectBelonged}</td>
         </tr>
         <tr>
            <td>employeesAssigned</td>
            <td>${employeesAssigned}</td>
         </tr>
         <tr>
            <td>taskStartDate</td>
            <td>${taskStartDate}</td>
         </tr>
         <tr>
            <td>taskEnddate</td>
            <td>${taskEnddate}</td>
         </tr>
      </table>  
      
      
	<a href="index.jsp">Go Back</a>
   </body>
   
</html>