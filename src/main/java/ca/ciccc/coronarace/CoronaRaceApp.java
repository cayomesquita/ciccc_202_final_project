package ca.ciccc.coronarace;

import ca.ciccc.coronarace.entities.BackGroundEntityFactory;
import ca.ciccc.coronarace.entities.EntityType;
import ca.ciccc.coronarace.entities.PlayerEntityFactory;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.InputMapping;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Map;

public class CoronaRaceApp extends GameApplication {

    private Entity player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
<<<<<<< HEAD
        settings.setWidth(600);
        settings.setHeight(900);
        settings.setTitle("CoronaRace");
        settings.setVersion("0.1");
=======
        settings.setWidth(Config.WIDTH);
        settings.setHeight(Config.HEIGHT);
        settings.setTitle(Config.TITLE_CORONA_RACE);
        settings.setVersion(Config.VERSION);
>>>>>>> 8be242a893de6b593b13339b4d1dabce60d410d8
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("DxDy", "X:0000.00 Y:0000.00");
        vars.put("streetSpeed", Config.STREET_SPEED);
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new BackGroundEntityFactory());
        getGameWorld().addEntityFactory(new PlayerEntityFactory());
    }

    @Override
    protected void initUI() {
        Text textPixels = new Text();
        textPixels.setTranslateX(50); // x = 50
        textPixels.setTranslateY(100); // y = 100
        textPixels.textProperty().bind(getGameState().stringProperty("DxDy"));
        getGameScene().addUINode(textPixels); // add to the scene graph
        Text textSpeed = new Text();
        textSpeed.setTranslateX(50); // x = 50
        textSpeed.setTranslateY(120); // y = 100
        textSpeed.textProperty().bind(getGameState().doubleProperty("streetSpeed").asString());
        getGameScene().addUINode(textSpeed); // add to the scene graph

<<<<<<< HEAD
=======
        getGameWorld().spawn("street");
        getGameWorld().spawn("sidewalk");
        getGameWorld().spawn("streetline");
        getGameWorld().spawn("player");

        Input input = getInput();
        List<Entity> entities = getGameWorld().getEntitiesByType(EntityType.PLAYER);
        getGameWorld().getEntitiesByType(EntityType.PLAYER).forEach(entity -> entity.getComponents().forEach(component -> input.scanForUserActions(component)));
    }


>>>>>>> 8be242a893de6b593b13339b4d1dabce60d410d8
    @Override
    protected void initInput() {
        Input input = getInput();
        List<Entity> entities = getGameWorld().getEntitiesByType(EntityType.PLAYER);
        getGameWorld().getEntitiesByType(EntityType.PLAYER).forEach(entity -> entity.getComponents().forEach(component -> input.scanForUserActions(component)));

        input.addInputMapping(new InputMapping("up",KeyCode.UP));
        input.addInputMapping(new InputMapping("down",KeyCode.DOWN));
        input.addInputMapping(new InputMapping("left",KeyCode.LEFT));
        input.addInputMapping(new InputMapping("right",KeyCode.RIGHT));
    }
<<<<<<< HEAD
=======


>>>>>>> 8be242a893de6b593b13339b4d1dabce60d410d8
}
