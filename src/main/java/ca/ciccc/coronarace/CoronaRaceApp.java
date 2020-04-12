package ca.ciccc.coronarace;

import ca.ciccc.coronarace.collision.HomeCollisionHandler;
import ca.ciccc.coronarace.entities.BackGroundEntityFactory;
import ca.ciccc.coronarace.entities.EntityType;
import ca.ciccc.coronarace.entities.GameEntityFactory;
import ca.ciccc.coronarace.entities.PlayerEntityFactory;
import ca.ciccc.coronarace.event.GameEventHandler;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.event.EventBus;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.InputMapping;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.input.KeyCode;
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
        settings.setWidth(Config.WIDTH);
        settings.setHeight(Config.HEIGHT);
        settings.setTitle(Config.TITLE_CORONA_RACE);
        settings.setVersion(Config.VERSION);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("DxDy", "X:0000.00 Y:0000.00");
        vars.put("gameSpeed", Config.STREET_SPEED);
        vars.put("health", 0);
    }

    @Override
    protected void preInit() {
        super.preInit();
        EventBus eventBus = getEventBus();
        eventBus.scanForHandlers(new GameEventHandler());
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new BackGroundEntityFactory());
        getGameWorld().addEntityFactory(new PlayerEntityFactory());
        getGameWorld().addEntityFactory(new GameEntityFactory());
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
        textSpeed.textProperty().bind(getGameState().doubleProperty("gameSpeed").asString());
        getGameScene().addUINode(textSpeed); // add to the scene graph
        Text textHealth = new Text();
        textHealth.setTranslateX(50); // x = 50
        textHealth.setTranslateY(140); // y = 100
        textHealth.textProperty().bind(getGameState().intProperty("health").asString());
        getGameScene().addUINode(textHealth); // add to the scene graph

        getGameWorld().spawn("street");
        getGameWorld().spawn("sidewalk");
        getGameWorld().spawn("streetline");
        getGameWorld().spawn("player");
        getGameWorld().spawn("bar");
        getGameWorld().spawn("home");

        Input input = getInput();
        List<Entity> entities = getGameWorld().getEntitiesByType(EntityType.PLAYER);
        getGameWorld().getEntitiesByType(EntityType.PLAYER).forEach(entity -> entity.getComponents().forEach(component -> input.scanForUserActions(component)));
    }


    @Override
    protected void initInput() {
        Input input = getInput();

        input.addInputMapping(new InputMapping("up", KeyCode.UP));
        input.addInputMapping(new InputMapping("down", KeyCode.DOWN));
        input.addInputMapping(new InputMapping("left", KeyCode.LEFT));
        input.addInputMapping(new InputMapping("right", KeyCode.RIGHT));
        input.addInputMapping(new InputMapping("test", KeyCode.T));

    }

    @Override
    protected void initPhysics() {
        super.initPhysics();
        getPhysicsWorld().addCollisionHandler(new HomeCollisionHandler());
    }
}
