package ca.ciccc.coronarace.component;

import com.almasb.fxgl.extra.entity.components.HealthComponent;

public class PlayerHealthComponent extends HealthComponent {

    private static final int DEFAULT_MAX_VALUE = 100;
    private static final int DEFAULT_VALUE = 50;

    private int maxValue;

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
        decrease(1);
//        FXGL.getGameState().setValue("health",valueProperty().getValue());
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
}
