package org.emamotor.undertow_test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yoshimasa Tanabe
 */
@WebServlet("/server-info")
public class ServerInfoServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    request.getSession();
    response.getWriter().println("SCHEME://IP ADDRESS:PORT=" + request.getScheme() + "://" + request.getLocalAddr() + ":" + request.getLocalPort());
  }

}
