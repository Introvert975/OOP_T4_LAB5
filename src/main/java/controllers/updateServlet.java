package controllers;


import model.Flower;
import model.Flowers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/update"})
public class updateServlet extends HttpServlet
{
    private final Flowers flowers = new Flowers();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int carId = Integer.parseInt(req.getParameter("ID"));

        try
        {
            flowers.updateFlower(carId, new Flower(
                    "updated name",
                    "updated type",
                    "update color",
                    80,
                    200
            ));


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