package akka.demo3.actor;

import akka.actor.UntypedActor;
import akka.demo3.app.Command;
import akka.demo3.app.Event;
import akka.event.Logging;
import akka.event.LoggingAdapter;


public class Emitter extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) {

		if (msg instanceof Command) {

			log.info("Emitting Event: " + msg);

			String data = ((Command) msg).getData();

			// 发布Event类型的事件，会被Handler类型处理器处理
			getContext().system().eventStream().publish(new Event(data));
		}
	}
}
