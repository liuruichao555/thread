package eventBus.model;

import java.util.Date;

/**
 * Created by song on 15/7/20.
 */
public abstract class DomainEvent {
    protected Object data;
    protected Date occurredOn;
    public DomainEvent(){
        super();
    }
    public DomainEvent(DomainEvent domainEvent){
        this.data = domainEvent.getData();
    }
    public Date occurredOn() {
        System.out.println("OrderCommitted");
        return occurredOn == null ?new Date():occurredOn;
    }
    public String getClassName(){
        return this.getClass().getName();
    }
    public String getShortClassName(){
        String className = getClassName();
        return className.substring(className.lastIndexOf(".")+1, className.length());
    }
    public Object getData() {
        return this.data;
    }
    public void setData(Object object){
        this.data = object;
    }

    public String[] getHandlerName(){
        return new String[]{this.getClassName()+"Handler"};
    }

    public abstract EventType getEventType();
}
