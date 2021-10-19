package loveproject.login.service;

import javafx.scene.Parent;
import loveproject.register.dto.MemberDTO;

public interface LoginService {
    public MemberDTO loginProc(Parent loginForm);
    public void cancelProc(Parent loginForm);

}
