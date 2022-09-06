package ru.rusyaevmax.servlets;

import ru.rusyaevmax.entity.Game;
import ru.rusyaevmax.entity.Paragraph;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = Game.getInstance();

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Paragraph currentParagraph = game.getGameWay().get(req.getParameter("choice"));
        req.setAttribute("currentParagraph", currentParagraph);

        getServletContext().getRequestDispatcher("/other.jsp").forward(req, resp);
    }
}
