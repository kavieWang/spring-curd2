<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 14036
  Date: 2021/7/11
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<%--
        数据校验
        数据转换
        数据验证
--%>
<head>
    <title>Title</title>
</head>
<body>

    <form action="" method="post">
      Employee<input type="text" name="employee" />
        <input type="submit" value="submit">
    </form>


<form:form action="input" method="post" modelAttribute="employee">
    <%--    这里的path相当于form当中的name属性--%>

    LastName<form:input path="lastName"/>
    <br>
    Email:<form:input path="email"/>
    <br>
    <%
        Map<Integer,String> genders=new HashMap();
        genders.put(1,"Male");
        genders.put(0,"Female");
        request.setAttribute("genders",genders);
    %>
    Genders:<form:radiobuttons path="gender" items="${genders}"/>
    <br>
    Department:<form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id">
</form:select>
    <br>
   <input type="submit" value="submit">
</form:form>

</body>
</html>
