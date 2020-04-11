package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.component.PlayerComponent;
import ca.ciccc.coronarace.component.PlayerHealthComponent;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayerEntityFactory extends CoronaRaceEntityFactoryAbstract {

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        Node node = new Rectangle(50, 100, Color.BLUE);
        double initialHeight = (getHeight() - 100) * 0.9;
        double initialWidth = (getWidth() - 50) / 2;
        return Entities.builder()
                .type(EntityType.PLAYER)
                .viewFromNodeWithBBox(node)
                .bbox(new HitBox(BoundingShape.box(50, 100)))
                .with(new PlayerComponent(), new PlayerHealthComponent(), new CollidableComponent(true))
                .at(initialWidth, initialHeight)
                .build();
    }

}
