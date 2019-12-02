<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/20
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图片上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="filename">
    <input type="submit" value="上传">
</form>
    <p>${msg}</p>
</body>
</html>
