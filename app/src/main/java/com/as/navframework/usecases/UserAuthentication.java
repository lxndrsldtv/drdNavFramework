package com.as.navframework.usecases;

/**
 * Created by al.so on 04.07.2016.
 */

public class UserAuthentication {
    /**
     * check if user already authenticated
     * if user already authenticated - finish procedure
     * check if user has token
     * check if token is valid
     * ask user for pin code
     * check if user oin code is right
     * check if user authenticating first time - what is the sign of first time authentication?
     */
//    public void execute() {
//        if ( authenticationService.has_valid_token() ) {
//            //if ( AuthenticationService.getAuthenticationProvider().is_pin_code_correct(UserInterface.ask_user_for_pin_code()) )
//            reset_number_of_failed_tries();
//            while (NUMBER_OF_FAILED_TRIES < MAX_ALLOWED_NUMBER_OF_TRIES_TO_ENTER_CORRECT_PIN_CODE) {
//                if (authenticationProvider.is_pin_code_correct(userInterface.ask_user_for_pin_code()))
//                    return;
//            }
//
//            authenticationService.reset_token();
//        }
//
//        authenticationProvider.authenticate(userInterface.ask_user_for_authentication_credentials());
//
//        if ( authenticationProvider.has_pin_code_for_token(authenticationService.getToken()) )
//            authenticationProvider.is_pin_code_correct(userInterface.ask_user_for_pin_code())
//
//    }

}
