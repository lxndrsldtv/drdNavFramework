package com.as.navframework.services;

import com.as.navframework.entities.AuthenticationCredentials;

/**
 * Created by lxndr.soldatov on 10/07/16.
 */

public interface IAuthenticationProvider {
    public String authenticate (AuthenticationCredentials authenticationCredentials);
}
