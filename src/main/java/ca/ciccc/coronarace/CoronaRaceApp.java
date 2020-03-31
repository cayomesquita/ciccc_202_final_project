package ca.ciccc.coronarace;

import ca.ciccc.coronarace.entities.BackGroundEntityFactory;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.RenderLayer;
import com.almasb.fxgl.entity.view.EntityView;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Map;

public class CoronaRaceApp extends GameApplication {

    private Entity player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(Config.WIDTH);
        settings.setHeight(Config.HEIGHT - 5);
        settings.setTitle(Config.TITLE_CORONA_RACE);
        settings.setVersion(Config.VERSION);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("DxDy", "X:0000.00 Y:0000.00");
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new BackGroundEntityFactory());

        player = Entities.builder()
                .at(300, 300)
                .viewFromNode(new Rectangle(25, 25, Color.BLUE))
                .buildAndAttach(getGameWorld());
    }

    @Override
    protected void initUI() {
        Text textPixels = new Text();
        textPixels.setTranslateX(50); // x = 50
        textPixels.setTranslateY(100); // y = 100
        textPixels.textProperty().bind(getGameState().stringProperty("DxDy"));
        getGameScene().addUINode(textPixels); // add to the scene graph

        getGameWorld().spawn("street");
        getGameWorld().spawn("sidewalk");
        getGameWorld().spawn("streetline");
    }


    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", player.getX(), player.getY()));
                if (player.getX() < getWidth() - 20) {
                    player.translateX(5); // move right 5 pixels
                }
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", player.getX(), player.getY()));
                if (player.getX() > 0) {
                    player.translateX(-5); // move left 5 pixels
                }
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", player.getX(), player.getY()));
                if (player.getY() > 0) {
                    player.translateY(-5); // move up 5 pixels
                }
            }
        }, KeyCode.UP);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", player.getX(), player.getY()));
                if (player.getY() < getHeight() - 20) {
                    player.translateY(5); // move down 5 pixels
                }
            }
        }, KeyCode.DOWN);
    }


}
