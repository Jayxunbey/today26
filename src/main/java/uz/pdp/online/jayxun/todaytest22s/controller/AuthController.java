package uz.pdp.online.jayxun.todaytest22s.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.jayxun.todaytest22s.dto.req.auth.SignUpReqDto;
import uz.pdp.online.jayxun.todaytest22s.repo.UserRepository;
import uz.pdp.online.jayxun.todaytest22s.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final UserService userService;
//    private final UserRepository userRepository;

    @PostMapping(path = "/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpReqDto signUpReqDto){

        userService.save(signUpReqDto);


        

        return ResponseEntity.ok("Sign up successful");
    }


}
