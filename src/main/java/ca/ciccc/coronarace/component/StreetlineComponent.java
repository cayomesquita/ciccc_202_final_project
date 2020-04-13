package ca.ciccc.coronarace.component;

import ca.ciccc.coronarace.Config;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreetlineComponent extends CoronaRaceComponentAbstract {
    private final SortedSet<Rectangle> collection;
    public StreetlineComponent() {
        super();
        this.collection = new TreeSet<Rectangle>(
                (rec1, rec2) -> Double.compare(rec1.getTranslateY(), rec2.getTranslateY()));
    }
    @Override public void onAdded() {
        super.onAdded();
        ObservableList<Node> nodes = entity.getView().getNodes();
        if (!nodes.isEmpty()) {
            Group group = (Group) nodes.iterator().next();
            group.getChildren().stream()
                    .map(node -> (Rectangle) node)
                    .collect(Collectors.toCollection(() -> collection));
        }
    }
    @Override public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        double speed = getGameSpeed() * tpf;
        collection.forEach(rectangle -> rectangle.setTranslateY(rectangle.getTranslateY() + speed));
        double distance = collection.first().getHeight() * Config.STREETLINE_DISTANCE_PERCENT;
        if (collection.first().getTranslateY() >= distance) {
            Rectangle rect = collection.last();
            collection.remove(rect);
            respawn(rect);
            collection.add(rect);
        }
    }
    private void respawn(Rectangle streetline) {
        streetline.setTranslateY(-streetline.getHeight());
    }
}
