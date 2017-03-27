package comms.cool.manager.security;

import comms.cool.manager.pojo.CoolSampleUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        CoolSampleUser sampleUser = null;
        if(lowercaseLogin.equals("admin")) {
            sampleUser = CoolSampleUser.getAdminSampleUser();
        } else if(lowercaseLogin.equals("niney")) {
            sampleUser = CoolSampleUser.getSampleUser();
        }

        return new org.springframework.security.core.userdetails.User(lowercaseLogin,
                sampleUser.getPassword(),
                sampleUser.getAuthorities());
    }
}
