package home.spring_ecommerce.webapi.controllers;

import home.spring_ecommerce.application.dtos.user.CreateUserDto;
import home.spring_ecommerce.application.dtos.user.UpdateUserDto;
import home.spring_ecommerce.application.dtos.user.UserListViewDto;
import home.spring_ecommerce.application.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody CreateUserDto createUserDto) {
        try {
            userService.addUser(createUserDto);

            return new ResponseEntity<>("User Created Successfuly", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUsersList")
    public ResponseEntity<List<UserListViewDto>> getUsersList() {
        List<UserListViewDto> users = userService.getUsersList();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserListViewDto> getUserById(@PathVariable("id") Long id) {

        return userService.getUserViewById(id)
                .map(ResponseEntity::ok) // If user is found, return 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // If not found, return 404 Not Found
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserDto updateUserDto) {
        try {
            userService.updateUser(id, updateUserDto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}