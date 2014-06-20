package org.emamotor.undertow_test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tanabe
 */
@WebServlet("/expensive")
public class ExpensiveServlet extends HttpServlet {

  private static final int NUM = 100_000_000;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    expensiveOperation(NUM);
    response.getWriter().println("This is Expensive Servlet: NUM: " + NUM + " sec.");
  }

  private void expensiveOperation(int delay) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < NUM; i++) {
      Collections.shuffle(list);
    }
  }

}
