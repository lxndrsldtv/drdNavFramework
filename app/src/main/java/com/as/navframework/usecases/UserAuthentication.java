package com.as.navframework.usecases;

import com.as.navframework.Entities.AuthenticationCredentials;
import com.as.navframework.Services.AuthenticationProvider;
import com.as.navframework.Services.AuthenticationService;
import com.as.navframework.views.IUserResponseHandler;
import com.as.navframework.views.UserInterface;

/**
 * Created by al.so on 04.07.2016.
 */

public class UserAuthentication implements IUserResponseHandler {

    private UserInterface _UserInterface;
    private AuthenticationService _AuthenticationService;
    private AuthenticationProvider _AuthenticationProvider;
    private AuthenticationCredentials _AuthenticationCredentials;

    public UserAuthentication (UserInterface userInterface,
                               AuthenticationService authenticationService,
                               AuthenticationProvider authenticationProvider) {

        _UserInterface = userInterface;
        _AuthenticationService = authenticationService;
        _AuthenticationProvider = authenticationProvider;
    }


    /**
     * check if user already authenticated
     * if user already authenticated - finish procedure
     * check if user has token
     * check if token is valid
     * ask user for pin code
     * check if user oin code is right
     * check if user authenticating first time - what is the sign of first time authentication?
     */
    public void execute() {
//        if ( _AuthenticationService.has_valid_token() ) {
        while (_AuthenticationService.has_invalid_token()) {
//            //if ( AuthenticationService.getAuthenticationProvider().is_pin_code_correct(UserInterface.ask_user_for_pin_code()) )
//            reset_number_of_failed_tries();
//            while (NUMBER_OF_FAILED_TRIES < MAX_ALLOWED_NUMBER_OF_TRIES_TO_ENTER_CORRECT_PIN_CODE) {
//                if (authenticationProvider.is_pin_code_correct(userInterface.ask_user_for_pin_code()))
//                    return;
//            }
//
//            authenticationService.reset_token();
//        }
        if (null == _AuthenticationCredentials)
            _UserInterface.ask_user_for_authentication_credentials(this);

        String token = _AuthenticationProvider.authenticate(_AuthenticationCredentials);
        _AuthenticationService.setToken(token);
    }

//
//        authenticationProvider.authenticate(userInterface.ask_user_for_authentication_credentials());
//
//        if ( authenticationProvider.has_pin_code_for_token(authenticationService.getToken()) )
//            authenticationProvider.is_pin_code_correct(userInterface.ask_user_for_pin_code())
//
    }

    /**
     * ask user for auth credentials
     * try to authenticate user with given credentials
     */
    public void execute1() {
        _UserInterface.ask_user_for_authentication_credentials(this);
    }

    public void setAuthenticationCredentials(AuthenticationCredentials authenticationCredentials) {
        _AuthenticationCredentials = authenticationCredentials;
//        String token = _AuthenticationProvider.authenticate(_AuthenticationCredentials);
//        _AuthenticationService.setToken(token);
        execute();
    }

    public void setSecurityCode(String security_code) {
        _AuthenticationCredentials.security_code = security_code;
    }

}
