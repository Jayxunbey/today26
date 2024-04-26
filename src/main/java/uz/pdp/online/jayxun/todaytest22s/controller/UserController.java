package uz.pdp.online.jayxun.todaytest22s.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.jayxun.todaytest22s.dto.req.auth.UserDto;
import uz.pdp.online.jayxun.todaytest22s.entity.User;
import uz.pdp.online.jayxun.todaytest22s.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public User getUser() {

        return new User();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody @Valid UserDto userDto) {

        userService.save(userDto);

        return ResponseEntity.ok("success");

    }



}
