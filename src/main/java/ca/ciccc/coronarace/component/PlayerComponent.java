package ca.ciccc.coronarace.component;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.input.ActionType;
import com.almasb.fxgl.input.OnUserAction;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

public class PlayerComponent extends CoronaRaceComponentAbstract {

    private int speed = 1;
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalk;

    public PlayerComponent() {
        animIdle = new AnimationChannel("player.png", 3, 85, 88, Duration.seconds(1), 1, 2);
        animWalk = new AnimationChannel("player.png", 3, 85, 88, Duration.seconds(1), 1, 2);
        texture = new AnimatedTexture(animIdle);
    }
    @Override
    public void onAdded() {
        super.onAdded();
        entity.setView(texture);
    }
    @Override
    public void onUpdate(double tpf) {
        if (speed != 0) {
            if (texture.getAnimationChannel() == animIdle) {
                texture.loopAnimationChannel(animWalk);
            }
            speed = (int) (speed * 0.9);
            if (FXGLMath.abs(speed) < 1) {
                speed = 0;
                texture.loopAnimationChannel(animIdle);
            }
        }
    }
    @Override
    public void onRemoved() {
        super.onRemoved();
    }
    @OnUserAction(name = "up", type = ActionType.ON_ACTION)
    public void moveUp() {
        if (entity.getY() > 0) {
            entity.translateY(-1); // move up 5 pixels
            getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", entity.getX(), entity.getY()));
        }
    }
    @OnUserAction(name = "down", type = ActionType.ON_ACTION)
    public void moveDown() {
        if (entity.getY() < getHeight() - entity.getBoundingBoxComponent().getHeight()) {
            entity.translateY(1); // move down 5 pixels
            getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", entity.getX(), entity.getY()));
        }
    }
    @OnUserAction(name = "left", type = ActionType.ON_ACTION)
    public void moveLeft() {
        if (entity.getX() > 80) {
            entity.translateX(-1); // move left 5 pixels
            getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", entity.getX(), entity.getY()));
        }
    }
    @OnUserAction(name = "right", type = ActionType.ON_ACTION)
    public void moveRight() {
        if (entity.getX() < getWidth() - entity.getBoundingBoxComponent().getWidth() - 130) {
            entity.translateX(1); // move right 5 pixels
            getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", entity.getX(), entity.getY()));
        }
    }
}
