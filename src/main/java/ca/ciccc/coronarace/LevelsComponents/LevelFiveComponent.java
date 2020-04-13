package ca.ciccc.coronarace.LevelsComponents;

import ca.ciccc.coronarace.component.CoronaRaceComponentAbstract;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

public class LevelFiveComponent extends CoronaRaceComponentAbstract {

    private int speed = 0;
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalk;

    public LevelFiveComponent() {
        animIdle = new AnimationChannel("1.png",1, 85, 88, Duration.seconds(1), 1, 2);
        animWalk = new AnimationChannel("1.png",3, 85, 88, Duration.seconds(1), 1, 2);
        texture = new AnimatedTexture(animIdle);
    }
    @Override public void onAdded() {
        super.onAdded();
        entity.setView(texture);
    }
    @Override public void onUpdate(double tpf) {
        super.onUpdate(tpf);
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
    @Override public void onRemoved() {
        super.onRemoved();
    }
}
