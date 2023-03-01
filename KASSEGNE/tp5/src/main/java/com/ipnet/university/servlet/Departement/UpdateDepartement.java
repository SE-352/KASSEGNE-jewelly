package com.ipnet.university.servlet.Departement;

import com.ipnet.university.dto.Departement;
import com.ipnet.university.service.DepartementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/update/departement")
public class UpdateDepartement extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String adresseWeb = req.getParameter("adresseWeb");

        Departement departement = new Departement();
        departement.setNom(nom);
        departement.setAdresseWeb(adresseWeb);

        DepartementService departementService = new DepartementService();
        Departement d = departementService.saveDepartement(departement);

        HttpSession session = req.getSession();

        if (d != null) {
            session.setAttribute("success", "Departement updated successfully");
            resp.sendRedirect("departement.jsp");
        } else {
            session.setAttribute("error", "Departement failed to get saved");
            resp.sendRedirect("departement.jsp");
        }
    }
}
