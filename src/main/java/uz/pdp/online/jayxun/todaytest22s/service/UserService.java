package uz.pdp.online.jayxun.todaytest22s.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.online.jayxun.todaytest22s.advice.EmailOrUserNameAlreadyExistsExceptions;
import uz.pdp.online.jayxun.todaytest22s.dto.req.auth.SignUpReqDto;
import uz.pdp.online.jayxun.todaytest22s.dto.req.auth.UserDto;
import uz.pdp.online.jayxun.todaytest22s.entity.User;
import uz.pdp.online.jayxun.todaytest22s.repo.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;




    public void save(SignUpReqDto signUpReqDto) {
        User user = new User();

        Optional<User> username = userRepository.findByUsernameIgnoreCase(signUpReqDto.getUsername());

        Optional<User> email = userRepository.findByEmailIgnoreCase(signUpReqDto.getEmail());



        user.setEmail(signUpReqDto.getEmail());
        user.setPassword(signUpReqDto.getPassword());
        user.setUsername(signUpReqDto.getUsername());
        userRepository.save(user);
        if (username.isEmpty() && email.isEmpty()) {
            throw new EmailOrUserNameAlreadyExistsExceptions();
        }
    }

    private Optional<User> findByUserName(SignUpReqDto signUpReqDto) {
        return userRepository.findByUsernameIgnoreCase(signUpReqDto.getUsername());
    }

    private Optional<User> getUserById(SignUpReqDto signUpReqDto) {
        return userRepository.findByEmailIgnoreCase(signUpReqDto.getEmail());
    }


    public void save(UserDto userDto) {

        Optional<User> byEmailIgnoreCase = userRepository.findByEmailIgnoreCase(userDto.getEmail());
        if (byEmailIgnoreCase.isPresent()) {
            throw new EmailOrUserNameAlreadyExistsExceptions();
        }

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);
    }
}
