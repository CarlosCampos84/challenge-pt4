package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/usuario")
public class UsuarioResource {
    private UsuarioBO usuarioBO = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findaAll() {
        ArrayList<UsuarioTO> resultado = usuarioBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 OK
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id") Long idCliente) {
        UsuarioTO resultado = usuarioBO.findByCodigo(idCliente);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 OK
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid UsuarioTO usuario) {
        UsuarioTO resultado = usuarioBO.save(usuario);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400); // bad request
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idCliente) {
        Response.ResponseBuilder response = null;
        if (usuarioBO.delete(idCliente)) {
            response = Response.status(204); //204 NO CONTENT
        } else {
            response = Response.status(404); //404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid UsuarioTO usuario,@PathParam("id") Long codigo){
        usuario.setIdCliente(codigo);
        UsuarioTO resultado = usuarioBO.update(usuario);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); //201
        } else {
            response = Response.status(400); // 400 BAD
        }
        response.entity(resultado);
        return response.build();
    }
}