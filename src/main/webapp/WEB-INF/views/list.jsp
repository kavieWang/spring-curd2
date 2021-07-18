<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%--SpringMVC处理静态资源;1。为什么会有这样的间题;--%>
<%--优雅的 REST风格的资源URL不希望带· html或.do 等后缀若将DispatcherServlet请求映射配置为/,--%>
<%--则Spring MVC将捕获WEB容器的所有请求，包括静态资源的请求，SpringMVC 会将他们当成一个普通请求处理,因找不到对应处理器将导致错误。--%>
<%--2。解决:在SpringMVC的配置文件中配置<mvc:default-servlet-handler/>--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var href=$(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            })
        })
    </script>
</head>
<body>


    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>

     <c:if test="${empty requestScope.employees}">
         没有获得该集合的数据
     </c:if>
     <c:if test="${!empty requestScope.employees}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>ID</td>
                <td>LastName</td>
                <td>Email</td>
                <td>Gender</td>
                <td>Department</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>

        </table>
     </c:if>
      <c:forEach items="${requestScope.employees}" var="emps">
           <table border="1" cellpadding="10">
               <tr>
                   <td>${emps.id}</td>
                   <td>${emps.lastName}</td>
                   <td>${emps.gender==0?"Famel":"Male"}</td>
                   <td>${emps.email}</td>
                   <td>${emps.department.departmentName}</td>
                   <td><a href="input/${emps.id}">Edit</a> </td>
                   <td><a class="delete" href="input/${emps.id}" >Delete</a> </td>
               </tr>
           </table>
      </c:forEach>


     <a href="input">Add new Employee</a>


<%--    为什么要在这里用form表单
        因为这样更加快捷和方便

--%>






</body>
</html>
