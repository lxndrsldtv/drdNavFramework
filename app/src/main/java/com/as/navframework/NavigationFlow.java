package com.as.navframework;

/**
 * Created by alex.soldatov on 24/06/16.
 */
public interface NavigationFlow {
    void setTransitionProvider(Transition transitionProvider);
    void startFlow();
    void navigateNext();
    void navigatePrev();
}
