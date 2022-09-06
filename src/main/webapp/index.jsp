<%@ page import="ru.rusyaevmax.utils.ReadCookies" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
        <div class="main">
            <%
                // Если пользователь перешёл на главную страницу будучи в игровом процессе (имя героя есть в куках)
                String playerName = ReadCookies.getValue(request, "playerName");
                if (!playerName.equals(""))
                    response.sendRedirect("/start");
            %>
            <form action="start" method="post">
                <p> - Слава богам, к нам, в Новиград, пожаловал ведьмак, мы уже совсем отчаялись, в городе происходит что-то неладное, если ты нас выручишь, век будем помнить.<br> - Ох, прости мои манеры, меня зовут Сильвестр Амелло, а как я могу тебя величать?</p>

                <input type="text" name="playerName" />

                <input type="submit" value="представиться" />
            </form>
        </div>
<%@ include file="footer.jsp" %>