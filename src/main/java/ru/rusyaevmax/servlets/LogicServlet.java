package ru.rusyaevmax.servlets;

import ru.rusyaevmax.entity.Game;
import ru.rusyaevmax.entity.Paragraph;
import ru.rusyaevmax.utils.ReadCookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(value = "/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = Game.getInstance();

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Paragraph currentParagraph;
        if (req.getParameter("choice") != null) {
            currentParagraph = game.getGameWay().get(req.getParameter("choice"));
            req.setAttribute("currentParagraph", currentParagraph);
        } else {
            String currentParagraphString = URLDecoder.decode(ReadCookies.getValue(req, "currentParagraph"), StandardCharsets.UTF_8);
            currentParagraph = game.getGameWay().get(!currentParagraphString.equals("") ? currentParagraphString : "start");
            req.setAttribute("currentParagraph", currentParagraph);
        }

        resp.addCookie(new Cookie("currentParagraph", URLEncoder.encode(currentParagraph.getTextLink(), StandardCharsets.UTF_8)));

        req.getRequestDispatcher("/other.jsp").forward(req, resp);
    }
}
