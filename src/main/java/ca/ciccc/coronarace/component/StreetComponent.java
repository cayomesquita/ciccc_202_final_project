package ca.ciccc.coronarace.component;

import ca.ciccc.coronarace.Config;
import com.almasb.fxgl.texture.Texture;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreetComponent extends CoronaRaceComponentAbstract {

    @Override
    public void onAdded() {
        super.onAdded();
    }

    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        double speed = Config.STREET_SPEED * tpf;
        //entity.setY(entity.getY()+speed);

    }

    @Override
    public void onRemoved() {
        super.onRemoved();
    }
}
