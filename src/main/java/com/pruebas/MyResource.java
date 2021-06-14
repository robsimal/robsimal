package com.pruebas;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/saludo")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Bienvenido.....";
    }
    
    @POST
    @Path("{nombre}")
    public Response leerParametro(@PathParam("nombre") String nombre) {
    	//http://localhost:8080/proyecto/jersey/saludo/nombre/Luis
    	return Response.status(200).entity("El nombre recibido: " + nombre).build();
    }

    	//Trabajar con query string
    //http://localhost:8080/proyecto/rest/saludo?referencia=1234&clave=valor&clave=valor
    @PUT
    @Path("/query")
    public Response leerQueryString(@QueryParam("referencia")  int ref) {
    	return Response.status(200).entity("Sumamos 100 a la ref. " + (ref + 100)).build();
    }
    
    


}







