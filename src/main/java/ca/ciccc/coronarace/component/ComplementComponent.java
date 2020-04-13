package ca.ciccc.coronarace.component;

import ca.ciccc.coronarace.Config;

public class ComplementComponent extends CoronaRaceComponentAbstract {
    @Override public void onAdded() {
        super.onAdded();
    }
    @Override public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        double speed = Config.STREET_SPEED * tpf;
        entity.setY(entity.getY()+speed);
    }
    @Override public void onRemoved() {
        super.onRemoved();
    }
}
