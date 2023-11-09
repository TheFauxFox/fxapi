package paw.faux.fx.eventbus;

public class ExceptionEvent implements HandlerChainAware {
    private final Throwable exception;
    private final ExceptionContext exceptionContext;
    private HandlerChain handlerChain;

    public ExceptionEvent(Throwable exception, ExceptionContext exceptionContext) {
        this.exception = exception;
        this.exceptionContext = exceptionContext;
    }

    public ExceptionContext getExceptionContext() {
        return exceptionContext;
    }

    public Throwable getException() {
        return exception;
    }

    @Override
    public void setHandlerChain(HandlerChain handlerChain) {
        this.handlerChain = handlerChain;
    }

    @Override
    public HandlerChain getHandlerChain() {
        return handlerChain;
    }

    @Override
    public String toString() {
        return "[exception = " + getException().toString() + ", context = " + getExceptionContext() + "]";
    }
}
