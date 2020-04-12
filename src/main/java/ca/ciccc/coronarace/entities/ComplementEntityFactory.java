package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.component.ComplementComponent;
import ca.ciccc.coronarace.component.MedicineComponent;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.component.EnemyComponent;
import java.util.Random;

public class ComplementEntityFactory implements EntityFactory {
    @Spawns("tree")
    public Entity newComplement(SpawnData data) {
        Random nRandom = new Random();
        switch (nRandom.nextInt((int) Config.getComplementsX())){
            case 0: Config.setPOSITION_X_COMPLEMENT(Config.getComplementLeft());  break;
            case 1: Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()); break;
        }
        Config.setPOSITION_Y_COMPLEMENT(Config.getPositionYComplement() - Config.getDistanceComplement());
        return Entities.builder()
                .type(EntityType.TREE)
                .viewFromTexture("tree.png")
                .with(new ComplementComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }

}
