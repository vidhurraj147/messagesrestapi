package org.rahul.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rahul.restapi.messenger.model.Message;
import org.rahul.restapi.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messsageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessages(){
		return messsageService.getMessages();
	}
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessage() {
//		return "JAX-WS Web Services REST API CALL";
//	}

}
