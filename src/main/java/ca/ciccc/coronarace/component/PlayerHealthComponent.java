package ca.ciccc.coronarace.component;

import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.event.GameEvent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.extra.entity.components.HealthComponent;

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
            Number newValue = valueProperty().getValue() - 1;
            valueProperty().setValue(newValue.intValue() > 0 ? newValue : 0);
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

    private int getV(){
        int value = 0;
        switch (Config.getLevel()){
            case 1: value = 10; break;
            case 2: value = 15; break;
            case 3: value = 20; break;
            case 4: value = 25; break;
            case 5: value = 30; break;
        }
        return value;
    }
    public void decrease() {
        Number newValue = valueProperty().getValue() - getV();
        valueProperty().setValue(newValue.intValue() > 0 ? newValue : 0);
    }
    public void increase() {
        Number newValue = valueProperty().getValue() + getV();
        valueProperty().setValue(newValue.intValue() < this.maxValue ? newValue : this.maxValue);
    }

    public int getMaxValue() {
        return maxValue;
    }
}
