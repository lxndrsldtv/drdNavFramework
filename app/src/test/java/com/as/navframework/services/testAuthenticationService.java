package com.as.navframework.services;

/**
 * Created by lxndr.soldatov on 06/07/16.
 */

public class testAuthenticationService implements IAuthenticationService {

    private String token;

    @Override
    public boolean has_valid_token () {
        if ("token" == token)
            return true;
        else
            return false;
    }

    @Override
    public boolean has_invalid_token () {
        return !has_valid_token ();
    }

    public void setToken (String token) {
        this.token = token;
    }
}
