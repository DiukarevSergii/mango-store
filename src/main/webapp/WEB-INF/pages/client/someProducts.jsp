<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>MANGO STORE</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <!-- TOP MENU -->
    <jsp:include page="/WEB-INF/pages/template/top-menu.jsp"/>
    <!-- MIDDLE MENU -->
    <jsp:include page="/WEB-INF/pages/template/middle-menu.jsp"/>
    <!-- BOTTOM MENU -->
    <jsp:include page="/WEB-INF/pages/template/bottom-menu.jsp"/>
    <!-- RIGHT BLOCK -->
    <%--<jsp:include page="/WEB-INF/pages/template/right-block.jsp"/>--%>
    <!-- MAIN BLOCK -->
    <jsp:include page="/WEB-INF/pages/template/mainBlock.jsp"/>
    <!-- BASEMENT -->
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>

</div>
</body>
</html>