package com.mkyong.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.mkyong.FileName;
import com.mkyong.Track;


@Path("/json/metallica")
@Stateless
public class JSONService {
	
	private String URI ;  
	private String mode ; 
	
    @Context
    private ServletContext context;
	
	
	@PostConstruct
	public void init() {
	 
        String realPath = context.getRealPath("/WEB-INF/config.properties");
        
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(new File(realPath)));
            mode = props.getProperty("aws.deploy");
            realPath = context.getRealPath("/WEB-INF/" + mode );
            props = new Properties();
            props.load(new FileInputStream(new File(realPath)));
            URI = props.getProperty("aws.uri");
            System.err.println(context.getServletContextName());
            
        } catch (IOException ex) {
           
        }
        
	}



	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
		
 
		return Response.status(200).entity(output).build();
 
	}
	    @POST
	    @Path("/post2")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces({MediaType.APPLICATION_JSON}) 
	    
	    public List<FileName> createTrackInJSON2(files t) throws IOException {
	    	FileName fileName  = new FileName() ;
	    	List<FileName> all  = new LinkedList<FileName>() ; 
	    	List<String> listFichiers = t.getList() ; 
	    	for (String string : listFichiers) {
				System.err.println("Traitement fichiers :" + string);
				
				FileInputStream fstream = new FileInputStream(URI + string );
		    	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		    	String strLine; int count  = 0  ;  FileName fileResult = new FileName() ; 

		    	while ((strLine = br.readLine()) != null)   {
		    	  System.err.println (strLine);	count ++  ; 
		    	}

		    	br.close();
		    	
				if ( count % 2 == 0 ) {
		    		fileResult.setFileName(string );
		    		fileResult.setValidate(false);
		    		fileResult.setFileName("" + Math.random());
		    		fileResult.setValidate(Boolean.TRUE);
		        	fileResult.setDate(new Date().toString());
		    	}else{
		    		fileResult.setFileName(string );
		    		fileResult.setValidate(false);
		    		fileResult.setFileName("" + Math.random());
		    		fileResult.setValidate(Boolean.FALSE);
		        	fileResult.setDate(new Date().toString());
		    	}
		    		
		    	
				all.add(fileResult) ; 
			}

	    	
			return all ; 
	    }
	 

    @Path("get")
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track ; 

	}
    
    @POST
	@Path("/test")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.TEXT_HTML}) 
	public String post( files files ) throws IOException {
		
    	return "ok" ; 

	}
    

    @POST
	@Path("/upload")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON}) 
	public Response uploadFile( FileName fileName ) throws IOException {

    	FileInputStream fstream = new FileInputStream(URI + fileName.getFileName() );
    	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    	String strLine; int count  = 0  ;  FileName fileResult = new FileName() ; 

    	while ((strLine = br.readLine()) != null)   {
    	  System.err.println (strLine);	count ++  ; 
    	}

    	br.close();
    	if ( count % 2 == 0 ) {
    		fileResult.setFileName(fileName.getFileName());
    		fileResult.setValidate(true);
    	  	fileName.setFileName("" + Math.random());
        	fileName.setValidate(Boolean.TRUE);
        	fileName.setDate(new Date().toString());
        	Track track = new Track();
        	track.setSinger("" + Math.random()); track.setTitle("" + Math.random());
			fileName.setTrack(track );
    	}else{
    		fileResult.setFileName(fileName.getFileName());
    		fileResult.setValidate(false);
    	  	fileName.setFileName("" + Math.random());
        	fileName.setValidate(Boolean.FALSE);
        	fileName.setDate(new Date().toString());
        	Track track = new Track();
        	track.setSinger("" + Math.random()); track.setTitle("" + Math.random());
			fileName.setTrack(track );
    	}
    		

        return Response.status(200).entity(fileName).build();

	}
    
    @Path("get")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public String getCurrency() {
 
        String returnValue = "" ;
        String realPath = context.getRealPath("/WEB-INF/regional.properties");
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(new File(realPath)));
            returnValue = props.getProperty("spring.datasource.url");
            System.out.println(returnValue);
        } catch (IOException ex) {
           
        }
        
        return returnValue;
    }
	
}