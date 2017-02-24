package eventBus.handler;

import eventBus.event.OrderCommitted;

import java.util.Date;

/**
 * Created by song on 15/7/19.
 */
public class OrderCommittedHandler extends Handler {
    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg instanceof OrderCommitted)
            log.info("OrderCommittedHandler ----- Handled Event: " + ((OrderCommitted)msg).getEventType());
        else
            log.info("unHandled");
    }
}