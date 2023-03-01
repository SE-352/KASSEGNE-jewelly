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

@WebServlet("/delete/cours")
public class DeleteCours extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        CoursService coursService = new CoursService();
        Cours c = coursService.deleteCours(id);

        HttpSession session = req.getSession();

        if (c != null) {
            session.setAttribute("success", "Cours deleted successfully");
            resp.sendRedirect("cours.jsp");
        } else {
            session.setAttribute("error", "Cours failed to get delete");
            resp.sendRedirect("cours.jsp");
        }
    }
}
