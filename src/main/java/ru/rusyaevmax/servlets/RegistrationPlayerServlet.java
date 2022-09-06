package ru.rusyaevmax.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/registrationPlayer")
public class RegistrationPlayerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String playerName = req.getParameter("playerName");
        Cookie playerNameCookie = new Cookie("playerName", playerName);
        resp.addCookie(playerNameCookie);

        resp.sendRedirect("/logic?choice=start");
    }
}
