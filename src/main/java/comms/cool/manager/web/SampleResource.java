package comms.cool.manager.web;

import comms.cool.manager.pojo.CoolSampleUser;
import comms.cool.manager.pojo.Sample;
import comms.cool.manager.security.AuthoritiesConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleResource {

    @GetMapping("/sample")
    @Secured(AuthoritiesConstants.USER)
    public ResponseEntity<Sample> getSample() {
        return new ResponseEntity<>(new Sample("테슷 제목", "테스트 내용"), HttpStatus.OK);
    }

    @GetMapping("/adminSample")
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<Sample> getAdminSample() {
        return new ResponseEntity<>(new Sample("관리자 제목", "관리자 테스트 내용"), HttpStatus.OK);
    }
}
