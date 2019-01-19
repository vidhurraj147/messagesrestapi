package org.rahul.restapi.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rahul.restapi.messenger.database.DatabaseClass;
import org.rahul.restapi.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		Profile p1 = new Profile(1L, "Rahul","firstName", "lastName");
		Profile p2 = new Profile(2L, "Avaina","firstName", "lastName");
		Profile p3 = new Profile(3L, "Podisha","firstName", "lastName");
		profiles.put("Rahul", p1);
		profiles.put("Avaina", p2);
		profiles.put("Podisha", p3);
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1 );
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		System.out.println(profiles);
		System.out.println("profileName requested to delete "+profileName);
		return profiles.remove(profileName);
	}

}
