package eventBus.event;

import eventBus.model.DomainEvent;
import eventBus.model.EventType;

import java.util.Date;

/**
 * Created by song on 15/7/19.
 */
public class OrderCommitted extends DomainEvent {
    public OrderCommitted(){
        super();
    }
    public OrderCommitted(DomainEvent domainEvent){
        super(domainEvent);
    }
    @Override
    public Date occurredOn() {
        System.out.println("OrderCommitted");
        return occurredOn == null ?new Date():occurredOn;
    }

    @Override
    public Object getData() {
        return "OrderCommitted";
    }
    public void setData(Object object){
        this.data = object;
    }

    @Override
    public EventType getEventType() {
        return EventType.ORDER_COMMITTED;
    }

}
