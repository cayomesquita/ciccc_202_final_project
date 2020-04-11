package ca.ciccc.coronarace.entities;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.EntityFactory;

public class CoronaRaceEntityFactoryAbstract implements EntityFactory {

    protected double getWidth() {
        return FXGL.getAppWidth();
    }

    protected double getHeight() {
        return FXGL.getAppHeight();
    }

}
