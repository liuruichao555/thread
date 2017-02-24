package eventBus.event;

import eventBus.model.DomainEvent;
import eventBus.model.EventType;

import java.util.Date;

/**
 * Created by song on 15/7/17.
 */
public class RegistrationCommitted extends DomainEvent {
    public RegistrationCommitted(){
        super();
    }
    public RegistrationCommitted(DomainEvent domainEvent){
        super(domainEvent);
    }
    @Override
    public Date occurredOn() {
        System.out.println("Registered");
        return new Date();
    }

    @Override
    public Object getData() {
        return "Registered";
    }

    @Override
    public EventType getEventType() {
        return EventType.RIGISTRATION_COMMITTED;
    }


}
