<%--
  Created by IntelliJ IDEA.
  User: as
  Date: 2017/3/7
  Time: 06:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String ctx = request.getContextPath();
//    ctx = null == ctx || ctx.equals("") ? "/" : ctx;
    request.setAttribute("ctx", ctx);
%>
