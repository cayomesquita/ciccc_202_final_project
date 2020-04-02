package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.component.PlayerComponent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.*;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayerEntityFactory implements EntityFactory {

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        Node node = new Rectangle(50, 100, Color.BLUE);
        double initialHeight = (getHeight() - 100) * 0.9;
        double initialWidth = (getWidth() - 50) / 2;
        return Entities.builder()
                .type(EntityType.PLAYER)
                .viewFromNode(node)
                .with(new PlayerComponent())
                .at(initialWidth, initialHeight)
                .build();
    }

    private double getWidth() {
        return FXGL.getAppWidth();
    }

    private double getHeight() {
        return FXGL.getAppHeight();
    }

}
