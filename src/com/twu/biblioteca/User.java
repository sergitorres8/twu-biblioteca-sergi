package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private String loginNumber;
    private String password;
    private String userName;
    private String email;
    private String phoneNumber;
    private List checkedOutItemsToReturn;

    public User(String loginNumber, String password, String userName, String email, String phoneNumber) {
        this.loginNumber = loginNumber;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.checkedOutItemsToReturn = new ArrayList();
    }
    public List getUserInformation(){
        return Arrays.asList(userName,email,phoneNumber);
    }
    public String getLoginNumber() {
        return loginNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List getCheckedOutItemsToReturn() {
        return checkedOutItemsToReturn;
    }

    public void setCheckedOutItemsToReturn(LibraryItem item) {
        this.checkedOutItemsToReturn.add(item);
    }

    public void removeBookAfterReturn(LibraryItem item){
        this.checkedOutItemsToReturn.remove(item);
    }

    public boolean login(String loginNumber, String password){
        if (this.loginNumber.equals(loginNumber) && this.password.equals(password))
            return true;
        return false;
    }
}
