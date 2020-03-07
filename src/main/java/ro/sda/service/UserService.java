package ro.sda.service;

import org.springframework.security.core.userdetails.UserDetailsService;;
import ro.sda.dto.UserRegistrationDTO;
import ro.sda.model.LocalUser;

public interface UserService extends UserDetailsService {

    LocalUser findByEmail(String email);
    LocalUser save(UserRegistrationDTO userDTO);


}
