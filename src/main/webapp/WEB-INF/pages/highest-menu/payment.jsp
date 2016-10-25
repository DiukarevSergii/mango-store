<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
    <title>MANGO STORE | Payment</title>
    <!-- HEAD -->
    <jsp:include page="/WEB-INF/pages/template/head.jsp"/>
</head>

<body>
<div class="container">
    <jsp:include page="/WEB-INF/pages/template/top-menu.jsp"/>

    <jsp:include page="/WEB-INF/pages/template/middle-menu.jsp"/>

    <jsp:include page="/WEB-INF/pages/template/bottom-menu.jsp"/>

    <jsp:include page="/WEB-INF/pages/template/right-block.jsp"/>

    <div class="main-block" style="height: 700px">
        <h3>Оплата</h3>
        <p>Для Вашего удобства, оплатить любые товары компании «МАНГО» Вы можете несколькими способами:</p>
        <div class="text">
            <table>
                <tbody>
                <tr>
                    <td style="width: 20px;">
                        <pre><img src="/resources/img/payer.png" alt="" width="45"
                                  height="31"></pre>
                    </td>
                    <td>
                        <p><strong><span
                                style="font-size: 12px;">Наличный расчет</span></strong></p>
                        <p><span style="font-size: 12px; ">В магазине или при доставке курьером</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td style="width: 20px;">
                    <pre style="margin-top: -18px"><br><img src="/resources/img/credit-card.png" alt="" width="40"
                                  height="28"></pre>
                    </td>
                    <td>
                        <p><strong><span
                                style="font-size: 12px;">Безналичный расчет</span></strong>
                        </p>
                        <p><span style="font-size: 12px;">
                        В магазине компании «МАНГО» банковской платежной картой Visa или MasterCard. </span>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
    <jsp:include page="/WEB-INF/pages/template/basement.jsp"/>
</div>

</body>
</html>