package org.emamotor.undertow_test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author tanabe
 */
@WebServlet("/slow")
public class SlowServlet extends HttpServlet {

  private static final int DELAY = 1;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    sleep(DELAY);
    response.getWriter().println("This is Slow Servlet: DELAY: " + DELAY + " sec.");
  }

  private void sleep(int delay) {
    try {
      TimeUnit.SECONDS.sleep(DELAY);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
