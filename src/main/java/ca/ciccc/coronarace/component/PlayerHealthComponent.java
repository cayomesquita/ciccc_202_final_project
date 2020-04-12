package ca.ciccc.coronarace.component;

import ca.ciccc.coronarace.event.GameEvent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.extra.entity.components.HealthComponent;
import com.almasb.fxgl.input.ActionType;
import com.almasb.fxgl.input.OnUserAction;

public class PlayerHealthComponent extends HealthComponent {

    private static final int DEFAULT_MAX_VALUE = 100;
    private static final int DEFAULT_VALUE = DEFAULT_MAX_VALUE;

    private int maxValue;
    private double timeCount = 0.0;
    private double timeLoop = 1.0;

    public PlayerHealthComponent() {
        super(DEFAULT_VALUE);
        this.maxValue = DEFAULT_MAX_VALUE;
    }

    @Override
    public void onAdded() {
        super.onAdded();
    }

    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        timeCount += tpf;
        if (timeCount > timeLoop) {
            timeCount = 0;
            decrease(1);
            FXGL.getGameState().setValue("health", valueProperty().getValue());
        }
        if (valueProperty().get() <= 0) {
            FXGL.getEventBus().fireEvent(new GameEvent(GameEvent.GAME_FAIL));
        }
    }

    @Override
    public void onRemoved() {
        super.onRemoved();
    }

    public void decrease(int value) {
        Number newValue = valueProperty().getValue() - value;
        valueProperty().setValue(newValue.intValue() > 0 ? newValue : 0);
    }
    public void increase(int value) {
        Number newValue = valueProperty().getValue() + value;
        valueProperty().setValue(newValue.intValue() < this.maxValue ? newValue : this.maxValue);
    }

    public int getMaxValue() {
        return maxValue;
    }

    /**
    @OnUserAction(name = "increaseBar", type = ActionType.ON_ACTION_BEGIN) public void increaseBar() {
        increase(10);
    }
    @OnUserAction(name = "decreaseBar", type = ActionType.ON_ACTION_BEGIN) public void decreaseBar() {
        increase(-10);
    }
    */
}
