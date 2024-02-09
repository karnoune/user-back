package fr.karnoune.user.api;

import fr.karnoune.user.domain.UserDto;
import fr.karnoune.user.service.IuserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(value = "http://localhost:4200")
public class UserResource {

    private final IuserService userService;

    @Autowired
    public UserResource(IuserService userService) {
        this.userService = userService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le service a bien traité la requête avec succès"),
            @ApiResponse(responseCode = "500", description = "Une erreur s'est produite")
    })

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        userService.createUSer(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getListUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto update(@PathVariable("id") Long id, @RequestBody UserDto UserDto) {
        return userService.updateUser(UserDto);
    }

    //@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteUseryId(id);
    }

    @PostMapping(value = "/check-email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkEmail(@RequestBody String inputEmail) {
        return ResponseEntity.ok(userService.checkEmailUser(inputEmail));
    }
}
