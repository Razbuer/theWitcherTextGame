package ru.rusyaevmax.servlets;

import ru.rusyaevmax.entity.Game;
import ru.rusyaevmax.utils.GetIP;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession(true);

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Game game = Game.getInstance();

        Cookie ip = new Cookie("ip", GetIP.getClientIpAddress(req));
        resp.addCookie(ip);

        int countGame = 1;
        if (req.getCookies() != null && req.getCookies().length > 0) {
            Optional<Cookie> countGameOptional = Arrays.stream(req.getCookies()).filter(x -> x.getName().equals("countGame")).findFirst();
            countGame = countGameOptional.map(cookie -> Integer.parseInt(cookie.getValue())).orElse(0);
        }
        Cookie countGameCookie = new Cookie("countGame", ++countGame + "");
        resp.addCookie(countGameCookie);

        String playerName = req.getParameter("playerName");
        Cookie playerNameCookie = new Cookie("playerName", playerName);
        resp.addCookie(playerNameCookie);

        resp.sendRedirect("/logic?choice=start");
    }
}
