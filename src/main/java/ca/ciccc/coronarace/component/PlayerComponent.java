package ca.ciccc.coronarace.component;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.gameplay.GameState;
import com.almasb.fxgl.input.ActionType;
import com.almasb.fxgl.input.OnUserAction;

public class PlayerComponent extends Component {

    @Override
    public void onAdded() {
        super.onAdded();
    }

    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
    }

    @Override
    public void onRemoved() {
        super.onRemoved();
    }

    @OnUserAction(name = "up", type = ActionType.ON_ACTION)
    public void moveUp() {
        if (entity.getY() > 0) {
            entity.translateY(-5); // move up 5 pixels
            getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", entity.getX(), entity.getY()));
        }
    }

    @OnUserAction(name = "down", type = ActionType.ON_ACTION)
    public void moveDown() {
        if (entity.getY() < getHeight() - entity.getBoundingBoxComponent().getHeight()) {
            entity.translateY(5); // move down 5 pixels
            getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", entity.getX(), entity.getY()));
        }
    }

    @OnUserAction(name = "left", type = ActionType.ON_ACTION)
    public void moveLeft() {
        if (entity.getX() > 0) {
            entity.translateX(-5); // move left 5 pixels
            getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", entity.getX(), entity.getY()));
        }
    }

    @OnUserAction(name = "right", type = ActionType.ON_ACTION)
    public void moveRight() {
        if (entity.getX() < getWidth() - entity.getBoundingBoxComponent().getWidth()) {
            entity.translateX(5); // move right 5 pixels
            getGameState().setValue("DxDy", String.format("X:%4.2f Y:%4.2f", entity.getX(), entity.getY()));
        }
    }

    private GameState getGameState() {
        return FXGL.getGameState();
    }

    private double getHeight() {
        return FXGL.getAppHeight();
    }

    private double getWidth() {
        return FXGL.getAppWidth();
    }
}
