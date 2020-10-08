package digital.paisley.springmvcthymeleaf.model;

import javax.validation.constraints.NotBlank;

public class User {


    private Integer Id;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

    public User(Integer id, String userName, String password, String email) {
        Id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
