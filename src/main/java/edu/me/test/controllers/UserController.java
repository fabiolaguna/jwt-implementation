package edu.me.test.controllers;

import edu.me.test.models.dtos.requests.PostUserDto;
import edu.me.test.models.dtos.responses.UserResponse;
import edu.me.test.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid PostUserDto user){

        return ResponseEntity.created(getLocation(UserResponse.fromUser(userService.save(user)))).build();
    }

    private URI getLocation(UserResponse userResponse) {

        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id-user")
                .buildAndExpand(userResponse.getId())
                .toUri();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){

        List<UserResponse> userResponses = userService.getAll()
                .stream()
                .map(UserResponse::fromUser)
                .collect(Collectors.toList());

        return userResponses.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(userResponses);
    }
}
