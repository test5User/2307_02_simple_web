package by.itclass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/oneParam")
public class OneParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var param1 = req.getParameter("param1");
        var param2 = req.getParameter("param2");
        var writer = resp.getWriter();
        writer.write("<h1>" + param1 + "</h1>");
        writer.write("<h1>" + param2 + "</h1>");
    }
}
