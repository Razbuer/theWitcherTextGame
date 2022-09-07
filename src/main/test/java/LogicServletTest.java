import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.rusyaevmax.servlets.LogicServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogicServletTest {
    @Mock
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    @Mock
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    @Mock
    RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

    @Test
    public void redirectOnOtherPage() throws IOException, ServletException {
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        new LogicServlet().service(request, response);

        Mockito.verify(request.getRequestDispatcher("/other.jsp")).forward(request, response);
    }
}
