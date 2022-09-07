import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.rusyaevmax.servlets.InitServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitServletTest {
    @Mock
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    @Mock
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    @Mock
    RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);


    @Test
    public void redirectOnIndexPageIfCookieContainsPlayerName() throws IOException, ServletException {
        Cookie[] cookies = {new Cookie("playerName", "playerName")};

        Mockito.when(request.getCookies()).thenReturn(cookies);
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        new InitServlet().service(request, response);

        Mockito.verify(request.getRequestDispatcher("/index.jsp")).forward(request, response);
    }

    @Test
    public void redirectOnLogicPageIfCookieDontContainsPlayerName() throws IOException, ServletException {
        Cookie[] cookies = {};

        Mockito.when(request.getCookies()).thenReturn(cookies);

        new InitServlet().service(request, response);

        Mockito.verify(response).sendRedirect("/logic");
    }
}
