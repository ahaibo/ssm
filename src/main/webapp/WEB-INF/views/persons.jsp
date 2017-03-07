<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/common.jsp" flush="true"/>
<html>
<head>
    <title>Persons</title>
    <style type="text/css">
        table {
            border: solid 1px #cccccc;
        }

        table th, table td {
            border: solid 1px #cccccc;
            padding: 8px;
        }
    </style>
    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.person-delete').off().click(function (el) {
                if (!confirm('Do you really want to delete this person?')) {
                    return false;
                }
                var $this = $(this), pid = $this.attr('pid');
                if (pid) {
                    $.get("/person/delete/" + pid, function () {
                        console.log('delete person' + pid + ' success');
                    })
                }
            });
        });
    </script>
</head>
<body>
<h1>Welcome Persons Page.</h1>
<c:choose>
    <c:when test="persons.size==0">
        <h1>暂无人员信息</h1>
    </c:when>
    <c:otherwise>
        <h1>人员信息（总<span style="color: darkred;">${persons.size()}</span>员）</h1>
        <div>
            <table>
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>手机</th>
                    <th>兴趣</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${persons}" var="person" varStatus="curr">
                    <tr>
                        <td>${person.name}</td>
                        <td>${person.sex == '1' ? '男' : '女'}</td>
                        <td>${person.age}</td>
                        <td>${person.mobile}</td>
                        <td>${person.hobby}</td>
                        <td>
                            <a href="/person/detail/${person.id}" target="_blank">详情</a>
                            <a href="/person/delete/${person.id}" class="person-delete" pid="${person.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>