package org.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Save")

public class SaveServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            String email = req.getParameter("email");
            String pass = req.getParameter("pass");
            User user = new User();
            user.setEmail(email);
            user.setPass(pass);
            UserDAO dbase = new UserDAO();
            boolean s = dbase.insert(user);
            if (s) {
                RequestDispatcher rd = req.getRequestDispatcher("/success.html");
                rd.forward(req, res);
            } else {

                PrintWriter out = res.getWriter();
                out.println("<p>failed</p>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    }

