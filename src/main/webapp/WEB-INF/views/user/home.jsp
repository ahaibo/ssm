<%--
  Created by IntelliJ IDEA.
  User: as
  Date: 2017/3/8
  Time: 02:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../common/common.jsp"/>
<html>
<head>
    <title>User Home</title>
    <style type="text/css">
        div.item {
            border: solid 1px #cccccc;
            margin: 20px 0;
            min-height: 50px;
        }
    </style>
</head>
<body>
<h1>User Home</h1>
<div class="item">
    <h2>User Add</h2>
    <div>
        <form action="/user/add" method="post">
            <table>
                <tbody>
                <tr>
                    <td>UserName:</td>
                    <td><input name="name" value="hai"></td>
                </tr>
                <tr>
                    <td>Sex:</td>
                    <td><input name="sex" value="男"></td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td><input name="age" value="28"></td>
                </tr>
                <tr>
                    <td>Birthday:</td>
                    <td><input name="birthday" value="1988-01-29"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input name="email" value="hai@hai.hai"></td>
                </tr>
                <tr>
                    <td colspan="2">Address Info:</td>
                </tr>
                <tr>
                    <td>Nation:</td>
                    <td><input name="address.nation" value="中国"></td>
                </tr>
                <tr>
                    <td>Province:</td>
                    <td><input name="address.province" value="四川"></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input name="address.city" value="成都"></td>
                </tr>
                <tr>
                    <td>Area:</td>
                    <td><input name="address.area" value="高新区"></td>
                </tr>
                <tr>
                    <td>County:</td>
                    <td><input name="address.county" value=""></td>
                </tr>
                <tr>
                    <td>Town:</td>
                    <td><input name="address.town" value=""></td>
                </tr>
                <tr>
                    <td>Village:</td>
                    <td><input name="address.village" value="五木"></td>
                </tr>
                <tr>
                    <td>Street:</td>
                    <td><input name="address.street" value="大源"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: right;"><input type="submit" value="Add"></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
<div class="item">
    <h2>File Upload</h2>
    <div>
        <form action="/user/upload" method="post" enctype="multipart/form-data">
            <div><input type="file" name="file" value="请选择文件"></div>
            <div><input type="submit" name="action" value="Upload"></div>
        </form>
    </div>
</div>
<div class="item">
    <div></div>
</div>
<div class="item">
    <div></div>
</div>
<div class="item">
    <div></div>
</div>
<div class="item">
    <div></div>
</div>
<script>
    /*$(function () {
     $(".item div").off().click(function () {
     $(this).slideToggle();
     })
     })*/
</script>
</body>
</html>
