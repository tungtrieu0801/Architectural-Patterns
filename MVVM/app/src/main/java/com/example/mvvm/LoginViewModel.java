package com.example.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

public class LoginViewModel extends BaseObservable {
    private  String email;
    private String passsword;
    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isShow = new ObservableField<>();
    public ObservableField<Boolean> isSuccess = new ObservableField<>();
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
        notifyPropertyChanged(BR.passsword);
    }
    public void onClickLogin() {
        isShow.set(true);
        User user = new User(getEmail(), getPasssword());
        if(user.isValidEmail() && user.isPassValid()) {
            messageLogin.set("Login success");
            isSuccess.set(true);
        }else{
            messageLogin.set("Login fail");
            isSuccess.set(false);
        }
    }
}
