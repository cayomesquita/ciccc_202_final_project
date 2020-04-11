package ca.ciccc.coronarace.event;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.event.Handles;

public class GameEventHandler{

    @Handles(eventClass = GameEvent.class, eventType = "GAME_FAIL")
    public void handleGameFail(GameEvent event) {
        FXGL.getDisplay().showMessageBox("You loose!", () -> FXGL.exit());
    }

    @Handles(eventClass = GameEvent.class, eventType = "GAME_SUCCESS")
    public void handleGameSuccess(GameEvent event) {
        FXGL.getDisplay().showMessageBox("You won!", () -> FXGL.exit());
    }

}
