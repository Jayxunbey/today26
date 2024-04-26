package uz.pdp.online.jayxun.todaytest22s.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import uz.pdp.online.jayxun.todaytest22s.advice.EmailOrUserNameAlreadyExistsExceptions;
import uz.pdp.online.jayxun.todaytest22s.dto.req.auth.SignUpReqDto;
import uz.pdp.online.jayxun.todaytest22s.entity.User;
import uz.pdp.online.jayxun.todaytest22s.repo.UserRepository;

import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;


class UserServiceTest {

    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void registerUserThrowException() {

        User user = new User();
        user.setUsername("Jayxunbey");

//        new SignUpReqDto()
        SignUpReqDto sign = new SignUpReqDto("Jayxunbey@gmail.com", "Jayxunbey","Jayxunbey2003");

        when(userRepository.findByEmailIgnoreCase(sign.getEmail())).thenReturn(Optional.of(new User()));
        when(userRepository.findByUsernameIgnoreCase(sign.getUsername())).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(user)).thenReturn(new User());



        Assertions.assertThrows(EmailOrUserNameAlreadyExistsExceptions.class, () -> {userService.save(sign);});

        Mockito.verify(userRepository, Mockito.times(1)).findByEmailIgnoreCase(sign.getEmail());
        Mockito.verify(userRepository, Mockito.times(0)).save(user);
        Mockito.verify(userRepository, Mockito.times(0)).findByUsernameIgnoreCase(sign.getUsername());




    }


}