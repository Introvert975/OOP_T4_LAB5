

package controllers;

import model.Flowers;
import model.Flower;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/addition"})
public class addServlet extends HttpServlet
{
    private final Flowers flowers = new Flowers();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String color = req.getParameter("color");
        int length = Integer.parseInt(req.getParameter("length"));
        int price = Integer.parseInt(req.getParameter("price"));

        Flower flower = new Flower(name, type, color, length,price);

        try
        {
            flowers.addFlower(flower);

            updatePage(req, resp);
        }
        catch (SQLException e)
        {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка базы данных: " + e.getMessage());
        }
    }
    private void updatePage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException
    {
        List<Flower> flowerList = flowers.getFlowers();
        req.setAttribute("flowerList", flowerList);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}