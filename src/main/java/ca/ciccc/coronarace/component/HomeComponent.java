package ca.ciccc.coronarace.component;

public class HomeComponent extends CoronaRaceComponentAbstract {
    @Override
    public void onAdded() {
        super.onAdded();
    }
    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        double speed = getGameSpeed() * tpf;
        entity.translateY(speed);
    }
    @Override
    public void onRemoved() {
        super.onRemoved();
    }

}
