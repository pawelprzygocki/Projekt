package domain;

public class User {

    private String login;
    private String pwd;

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }
    
    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
