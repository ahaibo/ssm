<%--
  Created by IntelliJ IDEA.
  User: as
  Date: 2017/3/7
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common.jsp"/>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1 style="color: darkred; text-align: center; font-size: large;">
    ${message==null||message==""?"Error!":message}
</h1>
</body>
</html>
