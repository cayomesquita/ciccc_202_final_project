package ca.ciccc.coronarace.component;

import ca.ciccc.coronarace.Config;

public class StreetComponent extends CoronaRaceComponentAbstract {
    @Override
    public void onAdded() {
        super.onAdded();
    }
    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        double speed = Config.STREET_SPEED * tpf;
    }
    @Override
    public void onRemoved() {
        super.onRemoved();
    }
}
