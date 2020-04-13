package ca.ciccc.coronarace;

import ca.ciccc.coronarace.entities.*;
import ca.ciccc.coronarace.entities.BackGroundEntityFactory;
import ca.ciccc.coronarace.entities.EntityType;
import ca.ciccc.coronarace.entities.GameEntityFactory;
import ca.ciccc.coronarace.entities.PlayerEntityFactory;
import ca.ciccc.coronarace.event.GameEventHandler;
import ca.ciccc.coronarace.collision.HomeCollisionHandler;
import ca.ciccc.coronarace.collision.EnemyCollisionHandler;
import ca.ciccc.coronarace.collision.MedicineCollisionHandler;
import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.event.EventBus;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.InputMapping;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

import java.util.Map;

public class CoronaRaceApp extends GameApplication {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(Config.getWIDTH());
        settings.setHeight(Config.getHEIGHT());
        settings.setTitle(Config.TITLE_CORONA_RACE);
        settings.setVersion(Config.VERSION);
        settings.setIntroEnabled(false);
        settings.setMenuEnabled(false);
        settings.setAppIcon(Config.APP_ICON);
        settings.setApplicationMode(ApplicationMode.DEVELOPER);
        //settings.setApplicationMode(ApplicationMode.RELEASE);
        //settings.setCredits();
    }
    @Override
    protected void initInput() {
        Input input = getInput();
        input.addInputMapping(new InputMapping("up", KeyCode.UP));
        input.addInputMapping(new InputMapping("down", KeyCode.DOWN));
        input.addInputMapping(new InputMapping("left", KeyCode.LEFT));
        input.addInputMapping(new InputMapping("right", KeyCode.RIGHT));
    }
    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("DxDy", "X:0000.00 Y:0000.00");
        vars.put("gameSpeed", Config.STREET_SPEED);

        vars.put("health", 0);
        Config.setLEVEL(1);
        vars.put("level", Config.getLevel());
    }
    @Override
    protected void preInit() {
        super.preInit();
        EventBus eventBus = getEventBus();
        eventBus.scanForHandlers(new GameEventHandler());
     }
    @Override
    protected void initPhysics() {
        super.initPhysics();
        getPhysicsWorld().addCollisionHandler(new HomeCollisionHandler());
        getPhysicsWorld().addCollisionHandler(new EnemyCollisionHandler());
        getPhysicsWorld().addCollisionHandler(new MedicineCollisionHandler());
    }
    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new BackGroundEntityFactory());
        getGameWorld().addEntityFactory(new ComplementEntityFactory());
        getGameWorld().addEntityFactory(new GameEntityFactory());
        getGameWorld().addEntityFactory(new EnemyEntityFactory());
        getGameWorld().addEntityFactory(new MedicineEntityFactory());
        getGameWorld().addEntityFactory(new PlayerEntityFactory());
        getGameWorld().addEntityFactory(new LevelsEntityFactory());

        FXGL.getAudioPlayer().loopBGM("bgm.wav");
    }
    @Override
    protected void initUI() {
        Text textHealth = new Text();
             textHealth.setTranslateX(110);
             textHealth.setTranslateY(575);
             textHealth.textProperty().bind(getGameState().intProperty("health").asString());
        getGameScene().addUINode(textHealth);
        //Text textLevel = new Text();
        //     textLevel.setTranslateX(510);
        //     textLevel.setTranslateY(50);
        //     textLevel.textProperty().bind(getGameState().intProperty("level").asString());
        //getGameScene().addUINode(textLevel);

        getGameWorld().spawn("sidewalk");
        getGameWorld().spawn("street");
        for (int i = 0; i < Config.getN_Trees(); i++) {
            switch (Config.getNRandom(3)) {
                case 0: Config.setDISTANCE_COMPLEMENT(100); break;
                case 1: Config.setDISTANCE_COMPLEMENT(200); break;
                case 2: Config.setDISTANCE_COMPLEMENT(300); break;
                case 3: Config.setDISTANCE_COMPLEMENT(350); break;
            }
            getGameWorld().spawn("tree");
        }
        getGameWorld().spawn("streetline");
        for (int i = 1; i <= Config.getMaxEnemies(); i++) {
            if (Config.getNRandom(3) != 4) getGameWorld().spawn("enemy");
            if (Config.getNRandom(3) == 0) getGameWorld().spawn("medicine");
        }
        getGameWorld().spawn("home");
        getGameWorld().spawn("player");
        getGameWorld().spawn("bar");

        getGameWorld().spawn("levelText");
        getGameWorld().spawn("levelOne");

        Input input = getInput();
        getGameWorld().getEntitiesByType(EntityType.PLAYER).forEach(entity -> entity.getComponents().forEach(component -> input.scanForUserActions(component)));
    }
}