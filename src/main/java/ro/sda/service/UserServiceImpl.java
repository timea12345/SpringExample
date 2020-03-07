package ro.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.sda.dto.UserRegistrationDTO;
import ro.sda.model.LocalUser;
import ro.sda.model.Role;
import ro.sda.repository.LocalUserRepository;
import ro.sda.repository.RoleRepository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final LocalUserRepository localUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(LocalUserRepository localUserRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.localUserRepository = localUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {
        Optional<LocalUser> localUserOptional = localUserRepository.findByEmailIgnoreCase("timea@yahoo.ro");
        if (localUserOptional.isPresent()) {
            return;
        }
        LocalUser localUser = new LocalUser();
        localUser.setEmail("timea@yahoo.ro");
        localUser.setPassword(passwordEncoder.encode("abcd1234"));
//        localUser.setRoles();
        localUserRepository.save(localUser);
    }

    @Override
    public LocalUser findByEmail(String email) {
        return localUserRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("the user could not be found"));
    }

    @Override
    public LocalUser save(UserRegistrationDTO userDTO) {
        LocalUser localUser = new LocalUser();

        Optional<Role> role = roleRepository.findByName("ROLE_USER");
        role.ifPresent(localUser::addRole);
        localUser.setEmail(userDTO.getEmail());
        localUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        localUserRepository.save(localUser);
        return localUser;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LocalUser localUser = findByEmail(s);

        return new User(localUser.getEmail(),
                localUser.getPassword(),
                localUser.getRoles()
                        .stream()
                        .map(r -> new SimpleGrantedAuthority(r.getName()))
                        .collect(Collectors.toSet()));
    }
}
