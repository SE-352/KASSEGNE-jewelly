package com.ipnet.university.servlet.Etudiant;

import com.ipnet.university.dto.Etudiant;
import com.ipnet.university.service.EtudiantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete/etudiant")
public class DeleteEtudiant extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        EtudiantService etudiantService = new EtudiantService();
        Etudiant e = etudiantService.deleteEtudiant(id);

        HttpSession session = req.getSession();

        if (e != null) {
            session.setAttribute("success", "Etudiant deleted successfully");
            resp.sendRedirect("etudiant.jsp");
        } else {
            session.setAttribute("error", "Etudiant failed to get delete");
            resp.sendRedirect("etudiant.jsp");
        }
    }
}
