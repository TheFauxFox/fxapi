package paw.faux.fx.events;

import net.minecraft.text.Text;
import paw.faux.fx.abstracts.CancellableEvent;

public class EventChatLineAdd extends CancellableEvent {
    public Text message;

    public EventChatLineAdd(Text message) {
        this.message = message;
    }
}
