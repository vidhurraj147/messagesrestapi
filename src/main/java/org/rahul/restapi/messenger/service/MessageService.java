package org.rahul.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rahul.restapi.messenger.database.DatabaseClass;
import org.rahul.restapi.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		Message m4 = new Message(1L, " Podisha Hello world", "Podisha");
		Message m5 = new Message(2L, " Avaina Hello world", "Avaina");
		messages.put(1L, m4);
		messages.put(2L, m5);
	}
	
	public List<Message> getMessages(){
		return new ArrayList<Message>(messages.values());
//		Message m1 = new Message(1L, " Eclipse Hello world", "Kadgekar");
//		Message m2 = new Message(1L, " Jersey Hello world", "Kadgekar");
//		Message m3 = new Message(1L, " Apache Hello world", "Kadgekar");
//		Message m4 = new Message(1L, " Podisha Hello world", "Podisha");
//		Message m5 = new Message(1L, " Avaina Hello world", "Avaina");
//		List<Message> list = new ArrayList<Message>();
//		list.add(m1);
//		list.add(m2);
//		list.add(m3);
//		list.add(m4);
//		list.add(m5);
//		
//		return list;
	}
	

	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1 );
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}
