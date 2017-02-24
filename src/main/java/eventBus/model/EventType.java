package eventBus.model;

/**
 * Created by song on 15/7/20.
 */
public enum EventType {
    ORDER_COMMITTED, RIGISTRATION_COMMITTED;

    @Override
    public String toString() {
        return this.name();
    }
}
