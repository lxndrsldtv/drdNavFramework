package com.as.navframework.coordinators;

import com.as.navframework.coordinators.front_coordinator.IFrontCoordinator;
import com.as.navframework.coordinators.login_coordinator.ILoginCoordinator;
import com.as.navframework.coordinators.login_flow_coordinator.ILoginCoordinatorCallbackHandler;
import com.as.navframework.coordinators.start_flow_coordinator.IFrontCoordinatorCallbackHandler;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public class testLoginCoordinator implements ILoginCoordinator   {
    private ILoginCoordinatorCallbackHandler callbackHandler;

    @Override
    public void start() {
        System.out.println("testLoginCoordinator started");

        boolean user_is_not_authenticated = true;
        boolean user_do_not_pressed_back_button = true;

        while (user_is_not_authenticated || user_do_not_pressed_back_button) {

            System.out.println(
                    "testLoginCoordinator starts presenter to take user login and password");
            //will user press back button?
            if (Math.random() > 0.5f) {
                System.out.println("user has pressed back button");
                user_do_not_pressed_back_button = false;
                continue;
            }

            System.out.println(
                    "testLoginCoordinator starts interactor to authenticate user in the system");
            //will user be successfully authenticated?
            if (Math.random() > 0.5f) {
                System.out.println("user has been successfully authenticated");
                user_is_not_authenticated = false;
            }
        }

        System.out.println("testLoginCoordinator start finishing");
        callbackHandler.onFinish(this);
    }

    @Override
    public void onFinish(ILoginCoordinatorCallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }
}
