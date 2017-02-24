package eventBus.handler;

import eventBus.event.RegistrationCommitted;

/**
 * Created by song on 15/7/19.
 */
public class RegistrationCommittedHandler extends Handler {
    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg instanceof RegistrationCommitted)
            log.info("RegistrationCommittedHandler ----- Handled Event: " + ((RegistrationCommitted)msg).getEventType());
        else
            log.info("unHandled");
    }
}