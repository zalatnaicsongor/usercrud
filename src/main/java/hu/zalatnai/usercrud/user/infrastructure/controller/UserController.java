package hu.zalatnai.usercrud.user.infrastructure.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import hu.zalatnai.usercrud.user.application.UserChangeSet;
import hu.zalatnai.usercrud.user.application.UserService;
import hu.zalatnai.usercrud.user.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * adapts between HTTP and the User domain
 */
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserOutput create(@RequestBody UserInput userInput) {
        User createdUser = userService.createUser(userInput.getName(), userInput.getDateOfBirth());
        return UserOutput.fromUser(createdUser);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    public UserOutput get(@PathVariable("id") UUID id) {
        return UserOutput.fromUser(userService.getUser(id));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH, consumes = "application/json", produces = "application/json")
    public void update(@PathVariable("id") UUID id, @RequestBody UserInput userInput) {
        userService.modifyUser(
            id,
            new UserChangeSet(userInput.getName(), userInput.getDateOfBirth())
        );
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
    }

    static class UserInput {
        @JsonProperty
        private String name;
        @JsonProperty
        private LocalDate dateOfBirth;

        UserInput() {
        }

        public String getName() {
            return name;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }
    }

    static class UserOutput {
        @JsonProperty
        private UUID id;
        @JsonProperty
        private String name;
        @JsonProperty
        private LocalDate dateOfBirth;
        @JsonProperty
        private Instant created;
        @JsonProperty
        private Instant modified;

        UserOutput(UUID id, String name, LocalDate dateOfBirth, Instant created, Instant modified) {
            this.id = id;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.created = created;
            this.modified = modified;
        }

        static UserOutput fromUser(User user) {
            return new UserOutput(
                user.getId(),
                user.getName(),
                user.getDateOfBirth(),
                user.getCreated(),
                user.getModified()
            );
        }
    }
}
