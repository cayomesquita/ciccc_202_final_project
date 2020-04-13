package ca.ciccc.coronarace.event;

import ca.ciccc.coronarace.Config;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Level;
import com.almasb.fxgl.event.Handles;

public class GameEventHandler{

    @Handles(eventClass = GameEvent.class, eventType = "GAME_FAIL")
    public void handleGameFail(GameEvent event) {
        FXGL.getAudioPlayer().playSound("lose.wav");
        //FXGL.getDisplay().showMessageBox("You are infected! :(", () -> FXGL.exit());
        FXGL.getDisplay().showMessageBox("You are infected! :(", () -> FXGL.exit());
    }

    @Handles(eventClass = GameEvent.class, eventType = "GAME_SUCCESS")
    public void handleGameSuccess(GameEvent event) {
        FXGL.getAudioPlayer().playSound("win.wav");
        FXGL.getDisplay().showMessageBox("YOU ARE SAFE!! Congratulation! :D", () -> FXGL.exit());
//        FXGL.getDisplay().showMessageBox("YOU ARE SAFE!! Congratulation! :D");
        //Level level = new Level(Config.getWIDTH()+400, Config.getHEIGHT()+400, FXGL.getGameWorld().getEntities());
//        FXGL.getGameWorld().setLevel(level);
    }
}
