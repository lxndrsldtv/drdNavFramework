package com.as.navframework.services;

/**
 * Created by lxndr.soldatov on 10/07/16.
 */

public interface IAuthenticationService {
    public boolean has_valid_token();
    public boolean has_invalid_token();
}
