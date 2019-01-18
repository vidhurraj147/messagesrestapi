package org.rahul.restapi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.rahul.restapi.messenger.model.Message;
import org.rahul.restapi.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<Long, Profile>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles(){
		return profiles;
	}

}
