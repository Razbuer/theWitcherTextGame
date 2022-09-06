<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="header.jsp"/>--%>
<%@ include file="header.jsp" %>
<div class="main">
            <form action="start" method="post">
                <p>Приветствую тебя ведьмак</p>

                <input type="text" name="playerName" />

                <input type="submit" value="представиться" />
            </form>
        </div>
<%@ include file="footer.jsp" %>
<%--<jsp:include page="footer.jsp"/>--%>