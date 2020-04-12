package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.component.EnemyComponent;
import ca.ciccc.coronarace.component.MedicineComponent;
import ca.ciccc.coronarace.component.PlayerComponent;
import ca.ciccc.coronarace.component.PlayerHealthComponent;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;

import java.util.Random;

public class MedicineEntityFactory implements EntityFactory {
    @Spawns("medicine")
    public Entity newMedicine(SpawnData data) {
        Random nRandom = new Random();
        String imagePath = "";
        double currentPosition = Config.getPositionXObject();
        do {
            switch (nRandom.nextInt((int) Config.getnPositionsX())){
                case 0: Config.setPOSITION_X_OBJECT(Config.getXLeft());    break;
                case 1: Config.setPOSITION_X_OBJECT(Config.getXCenterL()); break;
                case 2: Config.setPOSITION_X_OBJECT(Config.getXCenterR()); break;
                case 3: Config.setPOSITION_X_OBJECT(Config.getXRight());   break;
            }
        }while(currentPosition==Config.getPositionXObject());

        switch (nRandom.nextInt(1)){
            case 0: imagePath = "gloves"; break;
            case 1: imagePath = "mouthCover"; break;
        }
        Config.setPOSITION_Y_OBJECT(Config.getPositionYObject());
        return Entities.builder()
                .type(EntityType.MEDICINE)
                .viewFromTexture(imagePath+".png")
                .bbox(new HitBox(BoundingShape.box(70, 70)))
                .with(new MedicineComponent(), new CollidableComponent(true))
                .at(Config.getPositionXObject(), Config.getPositionYObject())
                .build();
    }
}
