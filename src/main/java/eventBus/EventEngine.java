package eventBus;

import eventBus.model.DomainEvent;
import eventBus.model.EventType;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import eventBus.event.RegistrationCommitted;
import org.apache.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by song on 15/7/17.
 */
public class EventEngine {
    private static Logger logger = Logger.getLogger(EventEngine.class);
    static final ActorSystem actorSystem = ActorSystem.create("event-system");
    static final ActorRef emitter = actorSystem.actorOf(Props.create(Emitter.class));
    static ConcurrentHashMap<String, ActorRef> actorRefMap = new ConcurrentHashMap();
    static {

    }
    public static void fireRegistrationCommitted(RegistrationCommitted registrationCommitted){
        emitter.tell(registrationCommitted, null);
    }
    public static void fireOrderCommitted(RegistrationCommitted registrationCommitted){
        emitter.tell(registrationCommitted, null);
    }

    public static void fireEventByDefaultHandler(DomainEvent event){
        EventType eventType = event.getEventType();
        ActorRef actorRef;
        try {
            if(!actorRefMap.containsKey(event.getShortClassName())){
                actorRef = actorSystem.actorOf(Props.create(Class.forName("eventBus.handler." + event.getShortClassName() + "Handler")));
                actorRefMap.put(event.getShortClassName(), actorRef);
                System.out.println(actorRef.path().toString());
            }
            actorSystem.eventStream().subscribe(actorRefMap.get(event.getShortClassName()), Class.forName(event.getClassName()));
            emitter.tell(event, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
