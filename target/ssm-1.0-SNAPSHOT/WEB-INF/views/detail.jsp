<%--
  Created by IntelliJ IDEA.
  User: as
  Date: 2017/3/7
  Time: 04:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Detail</title>
</head>
<body>
<h1>Person Detail Info</h1>
<div>
    <form>
        <div>Name: <input type="hidden" name="name" value="${person.name}">${person.name}</div>
        <div>Sex: <input type="hidden" name="name" value="${person.sex}">${person.sex=='1'?'男':'女'}</div>
        <div>Age: <input type="hidden" name="name" value="${person.age}">${person.age}</div>
        <div>Mobile: <input type="hidden" name="name" value="${person.mobile}">${person.mobile}</div>
        <div>Hobby: <input type="hidden" name="name" value="${person.hobby}">${person.hobby}</div>
    </form>
</div>
</body>
</html>
