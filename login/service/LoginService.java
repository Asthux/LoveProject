package loveproject.login.service;

import javafx.scene.Parent;
import loveproject.login.dto.LoginDTO;

public interface LoginService {
    public LoginDTO loginProc(Parent loginForm);
    public void cancelProc(Parent loginForm);

}
