package es.npatarino.android.gotchallenge.chat.message.ui;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import es.npatarino.android.gotchallenge.chat.message.domain.model.Message;
import es.npatarino.android.gotchallenge.chat.message.view.viewmodel.StickerPayLoad;

import java.util.LinkedList;
import java.util.List;

public class MessageRenderBuilder extends RendererBuilder<Message> {

    public MessageRenderBuilder() {
        List<Renderer<Message>> prototypes = getMessageRendererPrototypes();
        setPrototypes(prototypes);
    }

    public List<Renderer<Message>> getMessageRendererPrototypes() {
        LinkedList<Renderer<Message>> prototypes = new LinkedList<>();

        prototypes.add(new MessageRenderer());
        prototypes.add(new StickerRenderer());

        return prototypes;
    }

    @Override
    protected Class getPrototypeClass(Message content) {
        Class prototypeClass;

        if (content.getPayload() instanceof StickerPayLoad) {
            prototypeClass = StickerRenderer.class;
        } else {
            prototypeClass = MessageRenderer.class;
        }

        return prototypeClass;
    }
}
