package net.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class ProductResource {
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String sayPlainTextHello() {
//		return "Hello Jersey";
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}
}
