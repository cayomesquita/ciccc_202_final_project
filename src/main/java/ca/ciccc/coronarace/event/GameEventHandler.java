package ca.ciccc.coronarace.event;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.event.Handles;
import javafx.event.EventHandler;

public class GameEventHandler implements EventHandler<GameEvent> {

    @Override
    @Handles(eventClass = GameEvent.class, eventType = "GAME_FAIL")
    public void handle(GameEvent event) {
        FXGL.getDisplay().showMessageBox("You loose!", () -> FXGL.exit());
    }
}
