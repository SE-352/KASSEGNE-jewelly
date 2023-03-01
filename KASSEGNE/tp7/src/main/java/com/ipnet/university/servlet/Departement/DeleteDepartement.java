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

@WebServlet("/delete/departement")
public class DeleteDepartement extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        DepartementService departementService = new DepartementService();
        Departement d = departementService.deleteDepartement(id);

        HttpSession session = req.getSession();

        if (d != null) {
            session.setAttribute("success", "Departement deleted successfully");
            resp.sendRedirect("departement.jsp");
        } else {
            session.setAttribute("error", "Departement failed to get delete");
            resp.sendRedirect("departement.jsp");
        }
    }
}
