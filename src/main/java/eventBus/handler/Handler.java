package eventBus.handler;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventBus.model.DomainEvent;

public class Handler extends UntypedActor {

  LoggingAdapter log = Logging.getLogger(getContext().system(), this);

  @Override
  public void onReceive(Object msg) throws Exception {
      if (msg instanceof DomainEvent)
         log.info("EventHandler ----- Handled Event: " + ((DomainEvent)msg).getEventType());
  }

}
