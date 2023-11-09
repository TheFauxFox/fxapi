package paw.faux.fx.eventbus;

public interface HandlerChainAware {
    void setHandlerChain(HandlerChain handlerChain);
    HandlerChain getHandlerChain();
}
