package KubePrueba.pr.services;
import KubePrueba.pr.business.UniversidadesDao;
import KubePrueba.pr.modelo.Universidades;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("uni")
public class UniversidadServices {

    @Inject
    private UniversidadesDao dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    @Path("list")
	public Response Listar(Universidades uni) {
		try {
			List<Universidades> listado = dao.Listar();
			return Response.ok(listado).build();
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(500,"Error al listar clientes: "+ ex.getMessage());
			
			
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
	}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    @Path("crear")
	public Response Guardar(Universidades uni) {
		try {
			dao.Guardar(uni);
			return Response.ok(uni).build();
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(500,"Error al guardar cliente: "+ ex.getMessage());
			
			
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
	}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    @Path("update")
	public Response actualizar(Universidades uni) {
		try {
			dao.actualizar(uni);
			return Response.ok(uni).build();
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(500,"Error al actualizar cliente: "+ ex.getMessage());
			
			
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
	}

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminar")
	public Response Eliminar(int uni) {
		try {
			dao.Eliminar(uni);
			return Response.ok("Eliminado: "+uni).build();
		}catch(Exception ex) {
			ErrorMessage error = new ErrorMessage(500,"Error al guardar cliente: "+ ex.getMessage());
			
			
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
	}
}
