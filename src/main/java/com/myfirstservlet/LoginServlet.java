package com.myfirstservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "password", value = "Bridgelabz")
        }
)

public class LoginServlet extends HttpServlet {

    static final String REGEX_NAME = "^[A-Z]{1}[a-zA-Z]{2,}$";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdInput = req.getParameter("userInput");
        String passwordInput = req.getParameter("pwdInput");
        String password = getServletConfig().getInitParameter("password");

        if (userIdInput.matches(REGEX_NAME) && password.equals(passwordInput)) {
            req.setAttribute("user", userIdInput);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color = red> Either username or password is wrong</font>");
            rd.include(req, resp);
        }
    }
}