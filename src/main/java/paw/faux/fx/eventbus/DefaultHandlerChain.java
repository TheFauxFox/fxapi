package paw.faux.fx.eventbus;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class DefaultHandlerChain extends CopyOnWriteArrayList<ListenerMethod> implements HandlerChain {
    volatile boolean interrupt;

    DefaultHandlerChain(List<ListenerMethod> subscribers) {
        super(subscribers);
    }

    @Override
    public void interrupt() {
        interrupt = true;
    }
}
