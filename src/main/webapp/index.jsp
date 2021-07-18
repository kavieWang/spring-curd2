<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<a href="testResponsestatusExceptionReslove?i=10">testResponsestatusExceptionReslove</a>

<a href="emp">list.jsp</a>

<a href="testExceptionHandleExceptionReslove?i=2">testExceptionHandleExceptionReslove</a>

<form action="testFileupload" method="post" enctype="multipart/form-data">
    File<input type="file" name="file"/>
    Desc<input type="text" name="desc">
    <input type="submit" value="Submit">
</form>

<form action="testhttpmessageconvert" method="post" enctype="multipart/form-data">
    File<input type="file" name="file"/>
    Desc<input type="text" name="desc">
    <input type="submit" value="Submit">
</form>

<br><br>
<a href="ResponseEntity">download</a>

</body>
</html>