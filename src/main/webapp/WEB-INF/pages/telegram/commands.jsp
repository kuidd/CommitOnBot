<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="utf-8">
<title>Список команд : Тестовое задание: ЦФТ</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Le styles -->

    <jsp:include page="/WEB-INF/pages/base.jsp"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/export/command/action.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/pages/header.jsp"/>
<div class="container">
    <div class="row">
    <div class="col-md-12">
        <br>
        <h1>Список команд</h1>
        <br>
        <div class="panel panel-default">
            <div class="panel-body">
                <table class="table table-striped table-bordered" id="data-table">
                    <thead>
                        <tr>
                            <th>Название</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${list}" var="item">
                            <tr>
                                <td>${item}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>

    </div>
</div>

</div>    <hr>
    <footer>
        <p>&copy; 2017</p>
    </footer>
</div> <!-- /container -->
</body>
</html>
