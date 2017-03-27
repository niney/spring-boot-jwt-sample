package comms.cool.manager.pojo;

import comms.cool.manager.security.AuthoritiesConstants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class CoolSampleUser extends User {

    private String langKey;

    public CoolSampleUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public static CoolSampleUser getAdminSampleUser() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));
        grantedAuthorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.ADMIN));
        CoolSampleUser sampleUser = new CoolSampleUser("admin", "1", grantedAuthorities);
        sampleUser.setLangKey("ko");
        return sampleUser;
    }

    public static PublicSampleUser getAdminPublicUser() {
        CoolSampleUser sampleUser = getAdminSampleUser();
        Collection<GrantedAuthority> grantedAuthorities = sampleUser.getAuthorities();
        return new PublicSampleUser(sampleUser.getUsername(),
                grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()),
                sampleUser.getLangKey());
    }

    public static CoolSampleUser getSampleUser() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));
        CoolSampleUser sampleUser = new CoolSampleUser("niney", "1", grantedAuthorities);
        sampleUser.setLangKey("ko");
        return sampleUser;
    }

    public static PublicSampleUser getPublicUser() {
        CoolSampleUser sampleUser = getSampleUser();
        Collection<GrantedAuthority> grantedAuthorities = sampleUser.getAuthorities();
        return new PublicSampleUser(sampleUser.getUsername(),
                grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()),
                sampleUser.getLangKey());
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public static class PublicSampleUser {

        private String login;
        private Set<String> authorities;
        @Size(min = 2, max = 5)
        private String langKey;

        public PublicSampleUser(String login, Set<String> authorities, String langKey) {
            this.login = login;
            this.authorities = authorities;
            this.langKey = langKey;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Set<String> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(Set<String> authorities) {
            this.authorities = authorities;
        }

        public String getLangKey() {
            return langKey;
        }

        public void setLangKey(String langKey) {
            this.langKey = langKey;
        }
    }

    public static class Authority implements Serializable {

        private static final long serialVersionUID = 1L;

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Authority authority = (Authority) o;

            if (name != null ? !name.equals(authority.name) : authority.name != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Authority{" +
                    "name='" + name + '\'' +
                    "}";
        }
    }
}
