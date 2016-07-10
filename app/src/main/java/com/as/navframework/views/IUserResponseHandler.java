package com.as.navframework.views;

import com.as.navframework.entities.AuthenticationCredentials;

/**
 * Created by lxndr.soldatov on 06/07/16.
 */

public interface IUserResponseHandler {
    public void setAuthenticationCredentials(AuthenticationCredentials loginCredentials);
}
