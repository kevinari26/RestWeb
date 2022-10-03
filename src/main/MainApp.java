package main;

import controller.MainController;
import model.Karyawan;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

// contoh cara POST pakai curl
// curl -v -X POST -H "Content-Type: application/json" -d "{\"id\":5,\"nama\":\"Ryan\",\"alamat\":\"Jakarta\"}" http://localhost:8080/RestWeb/karyawan/

	
@Path("")
public class MainApp {
	MainController mainController = new MainController();
	@GET
    @Path("/halo/{nama}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloMsg(@PathParam("nama") String nama) {
		String output = "Halo " + nama;
//    	mainController.readKaryawan("all",0);
    	return Response.status(200).entity(output).build();
    }
	
	@GET
	@Path("/karyawan")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllKaryawan() {
		List<Karyawan> hasilRead = mainController.readKaryawan("all");
		if (hasilRead != null) {
			return Response.ok(hasilRead, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@GET
    @Path("/karyawan/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllKaryawan(@PathParam("id") String id) {
		List<Karyawan> hasilRead = mainController.readKaryawan(id);
		if (hasilRead != null) {
			return Response.ok(hasilRead, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
    }
	
	@POST
	@Path("/karyawan")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postKaryawan(Karyawan karyawan) throws URISyntaxException {
		Integer stat = mainController.insertKaryawan (karyawan);
		if (stat == 1) {
			URI uri = new URI("/karyawan/" + karyawan.getId());
			return Response.created(uri).build();
		} else {
			return Response.notModified().build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/karyawan/{id}")
	public Response putKaryawan(@PathParam("id") int id, Karyawan karyawan) {
		Integer stat = mainController.updateKaryawan (karyawan, id);
		if (stat == 1) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
	
	@DELETE
	@Path("/karyawan/{id}")
	public Response deleteKaryawan(@PathParam("id") int id) {
		Integer stat = mainController.deleteKaryawan (id);
		if (stat == 1) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
}

//@GET
//@Produces(MediaType.APPLICATION_JSON)
//public String sayJsonHello() {
//    return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde!\"}";
//}
