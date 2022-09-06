<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</div>
<div class="clr"></div>
<footer id="footer">
    <c:if test="${ cookie.playerName.value.length() > 0 }" >
        <button onclick="restart()">Начать игру заново</button>
        <div>
            <span>IP address: ${cookie.ip.value}</span>
            <span>Количество игр: ${cookie.countGame.value}</span>
            <c:if test="${cookie.playerName.value.length() != 0 && cookie.playerName.value != null }">
                <span>Имя ведьмака: ${cookie.playerName.value}</span>

            </c:if>
        </div>
    </c:if>
</footer>
</body>
</html>
