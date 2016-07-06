package com.as.navframework.Services;

/**
 * Created by lxndr.soldatov on 06/07/16.
 */

public class AuthenticationService {

    private String token;

    public boolean has_valid_token () {
        if ("token" == token)
            return true;
        else
            return false;
    }

    public boolean has_invalid_token () {
        return !has_valid_token ();
    }

    public void setToken (String token) {
        this.token = token;
    }
}
