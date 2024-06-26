package by.itclass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/formParam")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var writer = resp.getWriter()){
            var userName = req.getParameter("userName");
            var userAge = req.getParameter("userAge");
            var gender = req.getParameter("gender");
            var country = req.getParameter("country");
            var courses = req.getParameterValues("courses");
            writer.write("<p>Name: " + userName + "</p>");
            writer.write("<p>Age: " + userAge + "</p>");
            writer.write("<p>Gender: " + gender + "</p>");
            writer.write("<p>Country: " + country + "</p>");
            writer.write("<p>Courses: </p><ol>");
            Arrays.stream(courses)
                    .forEach(it -> writer.write("<li>" + it + "</li>"));
            writer.write("</ol>");
        }
    }
}
