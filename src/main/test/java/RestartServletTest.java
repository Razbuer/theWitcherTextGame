import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.rusyaevmax.servlets.RestartServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RestartServletTest {
    @Mock
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    @Mock
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    @Mock
    HttpSession httpSession = Mockito.mock(HttpSession.class);

    @Test
    public void restartShouldInvokeInvalidateSession() throws ServletException, IOException {
        Mockito.when(request.getSession()).thenReturn(httpSession);

        new RestartServlet().doPost(request, response);

        Mockito.verify(request.getSession()).invalidate();
    }
}
