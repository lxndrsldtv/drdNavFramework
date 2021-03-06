package com.as.navframework;

import android.content.Intent;
import android.util.Log;

import com.as.navframework.views.HomeActivity;
import com.as.navframework.views.LoginActivity;
import com.as.navframework.views.PinCodeActivity;
import com.as.navframework.views.TermsAndConditionsActivity;

/**
 * Created by alex.soldatov on 24/06/16.
 */
public class NavFlow3 implements NavigationFlow {
    /**
     * simulate login flow
     *
     * login successful flow (first time)
     * home (activity 1) <-> login (activity 2) -> pin (activity 3a) -> terms&conditions (activity 3b) -> home (activity 1)
     *                   <---------------------------------|                    |
     *                   <------------------------------------------------------|
     *
     * login successful flow (sequential times)
     * home (activity 1) <-> login (activity 2) -> pin (activity 3a) -> home (activity 1)
     *                   <---------------------------------|
     *
     * login error flow
     * home (activity 1) <-> login (activity 2)

     */

    private enum Nodes {
        Home,
        Login,
        PinCode,
        TermAndConditions
    }

    private Transition transitionProvider;
    private Nodes currentNode;

    public NavFlow3() {
        currentNode = Nodes.Home;
    }

    @Override
    public void setTransitionProvider(Transition transition) {

        Log.v("NF", "Change Transition Provider");

        if (null == transitionProvider)
            Log.v("NF", "from null");
        else
            Log.v("NF", "from " + transitionProvider.getClass().toString());

        transitionProvider = transition;

        Log.v("NF", "to " + transitionProvider.getClass().toString());
    }

    public void navigateToHome() { /* should be command with method execute */
        //transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        transitionProvider.setDestination(HomeActivity.class);
        transitionProvider.perform();
    }

    public void navigateToLogin() {
        //transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        transitionProvider.setDestination(LoginActivity.class);
        transitionProvider.perform();
    }

    public void navigateToPinCode() {
        //transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), PinCodeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        transitionProvider.setDestination(PinCodeActivity.class);
        transitionProvider.perform();
    }

    public void navigateToTermAndConditions() {
        //transitionProvider.startActivity(new Intent(transitionProvider.getApplicationContext(), TermsAndConditionsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        transitionProvider.setDestination(TermsAndConditionsActivity.class);
        transitionProvider.perform();
    }

    @Override
    public void startFlow() {
        navigateToLogin();
        currentNode = Nodes.Login;
    }

    @Override
    public void navigateNext() {

        switch ( currentNode ) {

            case Home:
                navigateToLogin();
                currentNode = Nodes.Login;

                Log.v("NF", "Home -> Login");

                break;

            case Login:
                if /* login successful - go to pin */ ( Math.random() > 0.5f ) {
                    navigateToPinCode();
                    currentNode = Nodes.PinCode;
                    Log.v("NF", "Login -> PinCode");
                }
                else /* login unsuccessful - stay on login */ {
                    //navigateToLogin();
                    //currentNode = Nodes.Login;
                    Log.v("NF", "Login -> Login");
                }
                break;

            case PinCode:
                double _case = Math.random();
                if /* case = first login -> set pin code -> done correctly */ ( _case <= 0.2f ) {
                    navigateToTermAndConditions();
                    currentNode = Nodes.TermAndConditions;
                    Log.v("NF", "PinCode -> TermAndCond");
                    break;
                }
                if /* case = first login -> set pin code -> done incorrectly */ ( 0.2f <  _case && _case <= 0.4f ) {
                    //navigateToPinCode();
                    //currentNode = Nodes.PinCode;
                    Log.v("NF", "PinCode -> PinCode");
                    break;
                }
                if /* case = sequential login -> check pin code -> pin correct */ ( 0.4f <  _case && _case <= 0.6f ) {
                    navigateToHome();
                    currentNode = Nodes.Home;
                    Log.v("NF", "PinCode -> Home");
                    break;
                }
                if /* case = sequential login -> check pin code -> pin incorrect */ ( 0.6f <  _case && _case <= 0.8f ) {
                    //navigateToPinCode();
                    //currentNode = Nodes.PinCode;
                    Log.v("NF", "PinCode -> PinCode");
                    break;
                }
                if /* case = sequential login -> check pin code -> pin incorrect 3 times*/ ( 0.8f <  _case && _case <= 1.0f ) {
                    navigateToLogin();
                    currentNode = Nodes.Login;
                    Log.v("NF", "PinCode -> Login");
                    break;
                }
                Log.v("NF", "-- -> --");
                break;

            case TermAndConditions:
                /* agreed/disagreed does not matter - go to home */
                navigateToHome();
                currentNode = Nodes.Home;
                Log.v("NF", "TermAndCond -> Home");
                break;

            default:
                Log.v("NF", "--- -> ---");
                break;
        }

    }

    @Override
    public void navigatePrev() {

        switch ( currentNode ) {
            case Home:
                currentNode = Nodes.Home;
                Log.v("NF", "Home <- Home");
                break;

            case Login:
                navigateToHome();
                currentNode = Nodes.Home;
                Log.v("NF", "Home <- Login");
                break;

            case PinCode:
                navigateToHome();
                currentNode = Nodes.Home;
                Log.v("NF", "Home <- PinCode");
                break;

            case TermAndConditions:
                navigateToHome();
                currentNode = Nodes.Home;
                Log.v("NF", "Home <- TermAndCond");
                break;

            default:
                Log.v("NF", "-/- <- -/-");
                break;
        }

    }
}
