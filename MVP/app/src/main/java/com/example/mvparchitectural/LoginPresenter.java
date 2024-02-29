package com.example.mvparchitectural;

public class LoginPresenter {
    private LoginInterface mloginInterface;

    public LoginPresenter(LoginInterface mloginInterface) {
        this.mloginInterface = mloginInterface;
    }
    public void login(UserModel userModel) {
        if(userModel.isValidEmail() && userModel.isPassValid()){
            mloginInterface.loginSuccess();
        }else{
            mloginInterface.loginFail();
        }
    }
}
