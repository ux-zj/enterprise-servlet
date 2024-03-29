package com.enterpriseproject.enterpriseservlet;

import Models.Film;
import com.enterpriseproject.enterpriseservlet.controllers.CommandsBridge;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "InsertServlet", value = "/InsertServlet")
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String stars = request.getParameter("stars");
        String review = request.getParameter("review");
        int year = Integer.parseInt(request.getParameter("year"));

        Film f = new Film(title, year, director, stars, review);

        new CommandsBridge().insertFilm(f);
        System.out.println("Insert: " + f);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
