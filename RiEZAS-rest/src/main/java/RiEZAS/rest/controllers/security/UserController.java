package RiEZAS.rest.controllers.security;

import RiEZAS.business.api.dto.security.UserDto;
import RiEZAS.business.impl.services.UserService;
import RiEZAS.rest.respons.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static RiEZAS.business.impl.utils.JwtTokenUtils.generateToken;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AuthenticationManager manager;
    private final PasswordEncoder encoder;
    private final UserService service;

    public UserController(UserService service, AuthenticationManager manager, PasswordEncoder encoder) {
        this.service = service;
        this.manager = manager;
        this.encoder = encoder;
    }

    @PostMapping("/create")
    public void create(@RequestBody UserDto userDto) {
        service.create(userDto);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        UserDto userDto = service.read(id);
        if (userDto == null) {
            return new ResponseEntity<>(new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Event with id " + id + " nor found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/registration")
    public void registration(@RequestParam String name, @RequestParam String password) {
        service.registration(name, encoder.encode(password));
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> authentication(@RequestParam String name, @RequestParam String password) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(name,password));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new ErrorResponse(
                    HttpStatus.UNAUTHORIZED.value(),
                    "Неправильный логин или пароль"),
                    HttpStatus.UNAUTHORIZED
            );
        }
        UserDto user = service.findByName(name);
        return ResponseEntity.ok(generateToken(user));
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkToken() {
        return ResponseEntity.ok(null);
    }
}
