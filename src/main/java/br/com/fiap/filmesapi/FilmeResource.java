package br.com.fiap.filmesapi;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.filmesapi.model.Filme;
import br.com.fiap.filmesapi.service.FilmeService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("filmes")
public class FilmeResource {
	
	FilmeService service = new FilmeService();
	
	// READ ALL
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Filme> index() throws SQLException {
		return service.findAll();
	}
	
	// READ BY ID
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) throws SQLException {
		var filme = service.findById(id);
		return filme == null ? 
				Response.status(Response.Status.NOT_FOUND).build() : 
					Response.ok(filme).build();
	}
	
	// CREATE FILME
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Filme filme) throws SQLException {
		return !service.create(filme) ? 
				Response.status(Response.Status.BAD_REQUEST).build() : 
					Response.ok(filme).build();
	}
	
	// UPDATE BY ID
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") Long id, Filme filme) throws SQLException {
		
		if (service.findById(id) == null) 
			return Response.status(Response.Status.NOT_FOUND).build();

		if (!service.update(id, filme)) {
			return Response.status(Response.Status.BAD_REQUEST).build();			
		}
		
		return Response.ok(filme).build();
	}
	
	// DELETE BY ID
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) throws SQLException {
		var filme = service.findById(id);
		
		if (filme == null)
			return Response.status(Response.Status.NOT_FOUND).build();
		
		service.delete(id);
		
		return Response.ok(filme).build();
	}
	
}
