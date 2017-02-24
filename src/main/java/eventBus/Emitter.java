package eventBus;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventBus.model.DomainEvent;
import eventBus.model.EventType;
import eventBus.event.OrderCommitted;
import eventBus.event.RegistrationCommitted;

public class Emitter extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof DomainEvent) {
            EventType et = ((DomainEvent) msg).getEventType();
            log.info("Emitting Event: " + et);
            switch (et){
                case ORDER_COMMITTED:
                    getContext().system().eventStream().publish((OrderCommitted) msg);
                    break;
                case RIGISTRATION_COMMITTED:
                    getContext().system().eventStream().publish((RegistrationCommitted) msg);
                    break;
                default:break;
            }
        }
    }
}
