package com.as.navframework.Services;

import com.as.navframework.Entities.AuthenticationCredentials;

/**
 * Created by lxndr.soldatov on 06/07/16.
 */

public class AuthenticationProvider {

    public String authenticate (AuthenticationCredentials authenticationCredentials) {
        if ("login" == authenticationCredentials.login &&
            "password" == authenticationCredentials.password)
            return "token";
        else
            return "error";
    }
}
