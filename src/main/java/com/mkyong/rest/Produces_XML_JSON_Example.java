package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.Track;

@Path("produceboth")
public class Produces_XML_JSON_Example 
{
    @Path("both")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getBothResponse()
    {
    	
    	Track s = new Track();
    	s.setTitle("title");
    	s.setSinger("singer");
        
    	return Response.ok().entity(s).build();
    }
}