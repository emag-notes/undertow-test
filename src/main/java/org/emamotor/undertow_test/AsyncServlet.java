package org.emamotor.undertow_test;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author tanabe
 */
@WebServlet(
  urlPatterns="/async",
  asyncSupported=true)
public class AsyncServlet extends HttpServlet {

  private static final int DELAY = 1;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    AsyncContext asyncC = req.startAsync();
    asyncC.addListener(new AsyncServiceListener());
    asyncC.start(new AsyncService(asyncC));
    // do something.
  }

  private static class AsyncService implements Runnable {
    AsyncContext ctx;

    public AsyncService(AsyncContext ctx) {
      this.ctx = ctx;
    }

    public void run() {
      try {
        // do something
        sleep(DELAY);
        PrintWriter writer = ctx.getResponse().getWriter();
        writer.write("Asynchronous processing complete");
        writer.close();
        ctx.complete();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    private void sleep(int delay) {
      try {
        TimeUnit.SECONDS.sleep(DELAY);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  private static class AsyncServiceListener implements AsyncListener {

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
      // do something.
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
      // do something.
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
      // do something.
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
      // do something.
    }
  }

}
