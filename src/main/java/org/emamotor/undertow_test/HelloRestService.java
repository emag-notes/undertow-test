package org.emamotor.undertow_test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Yoshimasa Tanabe
 */
@Path("/hello")
public class HelloRestService {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello REST World";
  }

}
