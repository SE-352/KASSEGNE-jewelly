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

@WebServlet("/save/cours")
public class SaveCours extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String intitule = req.getParameter("intitule");
        String dateCreation = req.getParameter("dateCreation");

        Cours cours = new Cours();
        cours.setIntitule(intitule);
        cours.setDateCreation(new Date(dateCreation));

        CoursService coursService = new CoursService();
        Cours c = coursService.saveCours(cours);

        HttpSession session = req.getSession();

        if (c != null) {
            session.setAttribute("success", "Cours saved successfully");
            resp.sendRedirect("saveCours.jsp");
        } else {
            session.setAttribute("error", "Cours failed to get saved");
            resp.sendRedirect("saveCours.jsp");
        }
    }
}
