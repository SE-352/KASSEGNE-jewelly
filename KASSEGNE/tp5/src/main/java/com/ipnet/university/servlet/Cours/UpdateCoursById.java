package com.ipnet.university.servlet.Cours;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update/coursbyid")
public class UpdateCoursById extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateCours.jsp");
        requestDispatcher.forward(req, resp);
    }
}
