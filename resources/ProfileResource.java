package com.rama.rmkcet.Messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rama.rmkcet.Messenger.model.Profile;
import com.rama.rmkcet.Messenger.service.ProfileService;


	@Path("/profiles")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public class ProfileResource {

		private ProfileService profileService = new ProfileService();
		
		
		
		@GET
		public List<Profile> getProfile() {
			return profileService.getAllProfiles();
		}
		
		@POST
		public Profile addProfile(Profile profile) {
			return profileService.addProfile(profile);
		}
		
		@GET
		@Path("/{profileName}")
		public Profile getProfile(@PathParam("profileName") String profileName) {
			return profileService.getProfile(profileName);
		}
		
		@PUT
		@Path("/{profileName}")
		public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
			profile.setProfileName(profileName);
			return profileService.updateProfile(profile);
		}
		
		@DELETE
		@Path("/{profileName}")
		public void deleteProfile(@PathParam("profileName") String profileName) {
			profileService.removeProfile(profileName);
		}
		
		
		
	}



