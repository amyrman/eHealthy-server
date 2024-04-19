package com.ehealth.server.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path; // Defines the path to the base URL of the API
import jakarta.ws.rs.POST; // Annotation to handle POST request types
import jakarta.ws.rs.Consumes; // Specifies the MIME media types a resource method can accept.
import jakarta.ws.rs.core.MediaType; // Defines media types for consuming and producing
import jakarta.ws.rs.core.Response; // Used for building HTTP responses
import jakarta.inject.Inject; // Used for dependency injection of the UserRepository

import com.ehealth.server.resources.UserCredentials; // Imports the DTO
import com.ehealth.server.model.User; // Imports the User entity
import com.ehealth.server.repository.UserRepository; // Imports the UserRepository for database interactions

@Path("/users")
@RequestScoped
public class UserResource {
    @Inject
    private UserRepository userRepository;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response registerUser(User user) {
        userRepository.save(user);
        return Response.status(Response.Status.CREATED).entity("User registered successfully").build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(UserCredentials credentials) {
        if (credentials == null || credentials.getUsername() == null || credentials.getPassword() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Missing credentials").build();
        }
        User user = userRepository.findUserByCredentials(credentials);
        if (user != null) {
            return Response.ok().entity("User logged in successfully").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }
}
