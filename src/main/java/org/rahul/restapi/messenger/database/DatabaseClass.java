package org.rahul.restapi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.rahul.restapi.messenger.model.Message;
import org.rahul.restapi.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}

}
