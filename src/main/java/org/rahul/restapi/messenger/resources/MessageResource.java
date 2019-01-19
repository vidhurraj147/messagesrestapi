package org.rahul.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.rahul.restapi.messenger.model.Message;
import org.rahul.restapi.messenger.resources.beans.MessageFilterBean;
import org.rahul.restapi.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messsageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
//	public List<Message> getAllMessages(@QueryParam("year") int year,
//										@QueryParam("start") int start,
//										@QueryParam("size") int size
//			){
	public List<Message> getAllMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear() > 0) {
			return messsageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() >= 0) {
			return messsageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messsageService.getMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messsageService.addMessage(message);
		// return "Post Works";
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messsageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		return messsageService.removeMessage(messageId);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String test() {
		return "test";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Path("/1")
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId){
		return messsageService.getMessage(messageId);
		// return "@PathParam for /{messageId} added";
	}
	
	
	@GET
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
//	@GET
//	@Path("/{messageId}/comments")
//	public String commentsTest() {
//		return "comments test";
//	}
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessage() {
//		return "JAX-WS Web Services REST API CALL";
//	}

}
