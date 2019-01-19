package org.rahul.restapi.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {
	
	@GET
	public String getCommentResource() {
		return "sub-resource";
	}
	
	@GET
	@Path("/{commentId}")
	// @Consumes(MediaType.TEXT_PLAIN)
	public String someOtherText() {
		return "someOtherText-->";
	}
//	public String someOtherText(@PathParam("commentId") String commentId) {
//		return "someOtherText--> "+commentId;
//	}

}
