<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.rusyaevmax.entity.Paragraph" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="main">
    <%
        String mainText = "";
        String playerName = "ведьмак";
        List<Paragraph> choices = List.of();

        if (request.getCookies() != null) {
            Optional<Cookie> playerNameCookie = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("playerName")).findFirst();
            if (playerNameCookie.isPresent())
                playerName = playerNameCookie.get().getValue();
        }

        if (request.getAttribute("currentParagraph") != null) {
            Paragraph currentParagraph = (Paragraph) request.getAttribute("currentParagraph");
            mainText = currentParagraph.getContent();
            choices = currentParagraph.getChoices();
        }
    %>

    <div>
        <%= mainText.replace("{playerName}", playerName) %>
    </div>

    <br>

    <form action="logic" method="get">
        <c:forEach var="choice" items="<%= choices %>">
            <input type="submit" name="choice" value="${choice.getTextLink()}">
        </c:forEach>
    </form>
</div>
<jsp:include page="footer.jsp"/>