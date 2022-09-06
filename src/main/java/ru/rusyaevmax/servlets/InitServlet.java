package ru.rusyaevmax.servlets;

import ru.rusyaevmax.entity.Game;
import ru.rusyaevmax.utils.GetIP;
import ru.rusyaevmax.utils.ReadCookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession currentSession = req.getSession(true);

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Game game = Game.getInstance();

        resp.addCookie(new Cookie("ip", GetIP.getClientIpAddress(req)));

        String countGameString = ReadCookies.getValue(req, "countGame");
        int countGame = countGameString.equals("") ? 0 : Integer.parseInt(countGameString);
        resp.addCookie(new Cookie("countGame", ++countGame + ""));

        String playerName = req.getParameter("playerName");
        resp.addCookie(new Cookie("playerName", playerName));

        String currentParagraph = ReadCookies.getValue(req, "currentParagraph");
        resp.addCookie(new Cookie("currentParagraph", currentParagraph.equals("") ? "start" : currentParagraph));

        // Если пользователь перешёл на главную страницу будучи в игровом процессе (имя героя есть в куках)
        if (!ReadCookies.getValue(req, playerName).equals(""))
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        else
            resp.sendRedirect("/logic");
    }
}
