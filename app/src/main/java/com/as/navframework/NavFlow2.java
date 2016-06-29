package com.as.navframework;

import android.content.Intent;

import com.as.navframework.views.HomeActivity;
import com.as.navframework.views.LoginActivity;
import com.as.navframework.views.PinCodeActivity;
import com.as.navframework.views.TermsAndConditionsActivity;

/**
 * Created by alex.soldatov on 24/06/16.
 */
public class NavFlow2 implements NavigationFlow {
    private enum Nodes {
        LoginActivityStep1,
        LoginActivityStep2,
        LoginActivityStep3a,
        LoginActivityStep3b
    }

    private Navigator transitionProvider;
    private Nodes currentNode;

    public NavFlow2(Navigator transitionProvider) {
        this.transitionProvider = transitionProvider;
        currentNode = Nodes.LoginActivityStep1;
    }

    @Override
    public void setTransitionProvider(Transition transition) {

    }

    public void navigateToLoginActivityStep1() {
        transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public void navigateToLoginActivityStep2() {
        transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public void navigateToLoginActivityStep3a() {
        transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), PinCodeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public void navigateToLoginActivityStep3b() {
        transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), TermsAndConditionsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    public void startFlow() {
        navigateToLoginActivityStep1();
        currentNode = Nodes.LoginActivityStep1;
    }

    @Override
    public void navigateNext() {

        switch ( currentNode ) {
            case LoginActivityStep1: {
                navigateToLoginActivityStep2();
                currentNode = Nodes.LoginActivityStep2;
                break;
            }
            case LoginActivityStep2: {
                navigateToLoginActivityStep3a();
                currentNode = Nodes.LoginActivityStep3a;
                break;
            }
            case LoginActivityStep3a:
                navigateToLoginActivityStep3b();
                currentNode = Nodes.LoginActivityStep3b;
                break;
            case LoginActivityStep3b:
                navigateToLoginActivityStep1();
                currentNode = Nodes.LoginActivityStep1;
                break;
            default:
                break;
        }

    }

    @Override
    public void navigatePrev() {

        switch ( currentNode ) {
            case LoginActivityStep1: {
                currentNode = Nodes.LoginActivityStep1;
                break;
            }
            case LoginActivityStep2: {
                navigateToLoginActivityStep1();
                currentNode = Nodes.LoginActivityStep1;
                break;
            }
            case LoginActivityStep3a: {
                navigateToLoginActivityStep2();
                currentNode = Nodes.LoginActivityStep2;
                break;
            }
            case LoginActivityStep3b: {
                navigateToLoginActivityStep3a();
                currentNode = Nodes.LoginActivityStep3a;
                break;
            }
            default:
                break;
        }

    }
}
