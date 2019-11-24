package bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String userName;
    private String password;
    private String errorMsg;


    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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

    public String validate()
    {
        if ("admin".equals(userName) && "admin".equals(password)) {
            errorMsg = null;
            return "welcome";
        } else {
            errorMsg = "Invalid user id or password. Please try  again";
            return null;
        }
    }
}
