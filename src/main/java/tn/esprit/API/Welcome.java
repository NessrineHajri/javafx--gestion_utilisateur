package tn.esprit.API;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException; // Import ServletException
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/welcome")
public class Welcome extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Welcome to skillseekr</title></head>");
        out.println("<body>");
        out.println("<h1>Welcome to skillseekr!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}