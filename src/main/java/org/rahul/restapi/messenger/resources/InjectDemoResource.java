package org.rahul.restapi.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderValue") String header,
											@CookieParam("name") String name) {
		return "MatrixParam "+matrixParam+""
				+ ", headeris "+header+" "
				+ ", cookieName is "+name; 
		// return "Test";
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		return "Context-Test, "
			   + ",uriInfo-- "+uriInfo+" "
			   + ",uriInfo-- "+uriInfo.getAbsolutePath().toString()+" "
			   + ",uriInfo-- "+uriInfo.toString()+" "
			   + ",headers-- "+headers.toString()+" "
			   + ",headersCookies-- "+headers.getCookies().toString();
	}
}
