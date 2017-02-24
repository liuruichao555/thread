package akka.demo3.app;

import akka.demo3.actor.Emitter;
import akka.demo3.actor.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


/**
 * 事件总线 ；死信 如 终止 actors所述, 当actor终止后其邮箱队列中的剩余消息及后续发送的消息都将被发送到死信邮箱， 它缺省情况下会发布打包在
 * DeadLetter 中的消息. 这种打包动作会保留原始的发送者、接收者以及消息内容。
 * 
 * @author lcq
 * 
 */
public class System {

	public static final Logger log = LoggerFactory.getLogger(System.class);

	public static void main(String[] args) throws Exception {

		final ActorSystem actorSystem = ActorSystem.create("event-system");

		Thread.sleep(5000);

		// 发射器
		final ActorRef emitter = actorSystem.actorOf(Props
				.create(Emitter.class));
		final ActorRef handler = actorSystem.actorOf(Props
				.create(Handler.class));
		// 为handler订阅Event类型的事件
		actorSystem.eventStream().subscribe(handler, Event.class);

		for (int i = 0; i < 10; i++) {
			emitter.tell(new Command("CMD " + i), null);
		}

		Thread.sleep(5000);

		log.debug("Actor System Shutdown Starting...");

		actorSystem.shutdown();
	}
}
