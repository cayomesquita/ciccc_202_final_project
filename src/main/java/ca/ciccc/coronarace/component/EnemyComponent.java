package ca.ciccc.coronarace.component;

import ca.ciccc.coronarace.Config;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

public class EnemyComponent extends CoronaRaceComponentAbstract {

    private int speed = 1;
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalk;

    public EnemyComponent() {
        animIdle = new AnimationChannel("enemy.png",3, 85, 88, Duration.seconds(1), 1, 2);
        animWalk = new AnimationChannel("enemy.png",3, 85, 88, Duration.seconds(1), 1, 2);
        texture = new AnimatedTexture(animIdle);
    }
    @Override public void onAdded()             {
        super.onAdded();
        entity.setView(texture);
    }
    @Override public void onUpdate(double tpf)  {
        double speed = Config.STREET_SPEED * tpf;
        entity.setY(entity.getY()+speed);
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
    @Override public void onRemoved()           { super.onRemoved();   }
}