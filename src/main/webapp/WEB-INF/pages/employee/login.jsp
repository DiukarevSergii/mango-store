<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Prog.kiev.ua</title>
</head>
<body>
<div align="center">
    <form action="/j_spring_security_check" method="POST">
        Login:<br/><input type="text" name="j_login"><br/>
        Password:<br/><input type="password" name="j_password"><br/>
        <input type="submit" />

        <c:if test="${param.error ne null}">
            <p>Wrong login or password!</p>
        </c:if>

        <c:if test="${param.logout ne null}">
            <p>Chao!</p>
        </c:if>
    </form>
</div>
</body>
</html>
