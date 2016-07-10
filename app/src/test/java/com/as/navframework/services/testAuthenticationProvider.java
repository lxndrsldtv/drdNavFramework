package com.as.navframework.services;

import com.as.navframework.entities.AuthenticationCredentials;

/**
 * Created by lxndr.soldatov on 06/07/16.
 */

public class testAuthenticationProvider implements IAuthenticationProvider {

    public String authenticate (AuthenticationCredentials authenticationCredentials) {
        if ("login" == authenticationCredentials.login &&
            "password" == authenticationCredentials.password)
            return "token";
        else
            return "error";
    }
}
