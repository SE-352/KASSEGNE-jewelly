package com.ipnet.university.servlet.Cours;

import com.ipnet.university.dto.Cours;
import com.ipnet.university.service.CoursService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/update/cours")
public class UpdateCours extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String intitule = req.getParameter("intitule");
        String dateCreation = req.getParameter("dateCreation");


        Cours cours = new Cours();
        cours.setIntitule(intitule);
        cours.setDateCreation(new Date(dateCreation));

        CoursService coursService = new CoursService();
        Cours c = coursService.saveCours(cours);


        HttpSession session = req.getSession();

        if (c != null) {
            session.setAttribute("success", "Cours updated successfully");
            resp.sendRedirect("cours.jsp");
        } else {
            session.setAttribute("error", "Batch failed to get update");
            resp.sendRedirect("cours.jsp");
        }
    }
}
