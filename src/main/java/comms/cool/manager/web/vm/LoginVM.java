package comms.cool.manager.web.vm;

import javax.validation.constraints.NotNull;

/**
 * View Model object for storing a user's credentials.
 */
public class LoginVM {

    private String username;

    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVM{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
