package edu.galileo.android.photofeed.libs;

import edu.galileo.android.photofeed.libs.base.EventBus;

/**
 * Created by Roberto Hdez. on 27/06/16.
 * <roberto.htamayo@gmail.com>
 */

public class GreenRobotEventBus implements EventBus {
    org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus(org.greenrobot.eventbus.EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void register(Object suscribe) {

    }

    @Override
    public void unregister(Object suscribe) {

    }

    @Override
    public void post(Object event) {

    }
}
