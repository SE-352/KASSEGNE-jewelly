package com.ipnet.university.servlet.Departement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update/departementbyid")
public class UpdateDepartementById extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateDepartement.jsp");
        requestDispatcher.forward(req, resp);
    }
}
