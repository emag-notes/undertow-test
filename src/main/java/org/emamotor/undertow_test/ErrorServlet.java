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
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    throw new RuntimeException(ErrorServlet.class.getName() + "#doGet");
  }

}
