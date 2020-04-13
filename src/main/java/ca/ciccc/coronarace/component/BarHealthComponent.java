package ca.ciccc.coronarace.component;

import com.almasb.fxgl.ui.ProgressBar;

public class BarHealthComponent extends CoronaRaceComponentAbstract {
    @Override public void onAdded() {
        super.onAdded();
        PlayerHealthComponent playerHealthComponent = getPlayerEntity().getComponent(PlayerHealthComponent.class);
        ProgressBar bar = (ProgressBar) entity.getView().getNodes().iterator().next();
        bar.setMaxValue(playerHealthComponent.getMaxValue());
        bar.currentValueProperty().setValue(50);
        bar.currentValueProperty().bind(playerHealthComponent.valueProperty());
    }
    @Override public void onUpdate(double tpf) {
        super.onUpdate(tpf);
    }
    @Override public void onRemoved() {
        super.onRemoved();
    }
}
