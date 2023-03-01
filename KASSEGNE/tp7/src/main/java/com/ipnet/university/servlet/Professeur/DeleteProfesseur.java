package com.ipnet.university.servlet.Professeur;

import com.ipnet.university.dto.Professeur;
import com.ipnet.university.service.ProfesseurService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete/professeur")
public class DeleteProfesseur extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        ProfesseurService professeurService = new ProfesseurService();
        Professeur p = professeurService.deleteProfesseur(id);

        HttpSession session = req.getSession();

        if (p != null) {
            session.setAttribute("success", "Professeur deleted successfully");
            resp.sendRedirect("professeur.jsp");
        } else {
            session.setAttribute("error", "Professeur failed to get delete");
            resp.sendRedirect("professeur.jsp");
        }
    }
}
