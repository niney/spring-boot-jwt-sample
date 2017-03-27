package comms.cool.manager.web;

import comms.cool.manager.pojo.CoolSampleUser;
import comms.cool.manager.security.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api")
public class AccountResource {

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    public AccountResource() { }

    /**
     * GET current user
     * @return user
     */
    @GetMapping("/account")
    public ResponseEntity<CoolSampleUser.PublicSampleUser> getAccount() {
        CoolSampleUser.PublicSampleUser publicSampleUser = null;
        if(SecurityUtils.getCurrentUserLogin().equals("admin")) {
            publicSampleUser = CoolSampleUser.getAdminPublicUser();
        }
        if(SecurityUtils.getCurrentUserLogin().equals("niney")) {
            publicSampleUser = CoolSampleUser.getPublicUser();
        }
        return new ResponseEntity<>(publicSampleUser, HttpStatus.OK);
    }
}
