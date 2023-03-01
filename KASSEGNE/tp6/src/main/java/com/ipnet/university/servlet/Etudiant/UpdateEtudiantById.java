package com.ipnet.university.servlet.Etudiant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update/etudiantbyid")
public class UpdateEtudiantById extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateEtudiant.jsp");
        requestDispatcher.forward(req, resp);
    }
}
