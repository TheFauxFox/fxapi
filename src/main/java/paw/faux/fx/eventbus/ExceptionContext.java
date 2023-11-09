package paw.faux.fx.eventbus;

import java.lang.reflect.Method;

public record ExceptionContext(Object listener, Object event, Method subscribedMethod) {

    @Override
    public String toString() {
        return "[method = " + subscribedMethod().getName() + ", listener = " + listener() + ", event = " + event() + "]";
    }
}
