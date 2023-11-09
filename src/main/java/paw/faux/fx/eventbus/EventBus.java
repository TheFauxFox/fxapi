package paw.faux.fx.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EventBus {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ListenersRegistry listenersRegistry;
    private final EventDispatcher eventDispatcher;
    public static boolean DEBUG = false;

    public EventBus() {
        listenersRegistry = new ListenersRegistry();
        eventDispatcher = new EventDispatcher(listenersRegistry);
    }

    public void register(Object listener) {
        if (listener == null) {
            throw new NullPointerException("Null object can not be registered.");
        }
        if (DEBUG) logger.info("Registering listener " + listener);
        listenersRegistry.register(listener);
    }

    public void deregister(Object listener) {
        if (listener == null) {
            throw new NullPointerException("Null object can not be de-registered.");
        }
        if (DEBUG) logger.info("Un-Registering listener " + listener);
        listenersRegistry.deregister(listener);
    }

    public <T> T post(T event) {
        if (event == null) throw new NullPointerException("Null event can not be posted.");

        List<ListenerMethod> subscribers = listenersRegistry.getSubscribers(event);
        if (subscribers != null && !subscribers.isEmpty()) {
            DefaultHandlerChain handlerChain = new DefaultHandlerChain(subscribers);
            eventDispatcher.dispatch(event, handlerChain);
        }
        return event;
    }
}
