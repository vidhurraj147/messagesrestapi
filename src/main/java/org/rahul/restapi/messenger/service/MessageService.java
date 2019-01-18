package org.rahul.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.rahul.restapi.messenger.model.Message;

public class MessageService {
	
	public List<Message> getMessages(){
		Message m1 = new Message(1L, " Eclipse Hello world", "Kadgekar");
		Message m2 = new Message(1L, " Jersey Hello world", "Kadgekar");
		Message m3 = new Message(1L, " Apache Hello world", "Kadgekar");
		Message m4 = new Message(1L, " Podisha Hello world", "Podisha");
		Message m5 = new Message(1L, " Avaina Hello world", "Avaina");
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		
		return list;
	}

}
