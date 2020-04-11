package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.component.EnemyComponent;
import com.almasb.fxgl.entity.*;

import java.util.Random;

public class MedicineEntityFactory implements EntityFactory {
    @Spawns("medicine")
    public Entity newMedicine(SpawnData data) {
        Random nRandom = new Random();
        String imagePath = "";
        switch (nRandom.nextInt(4)){
            case 0: Config.setPOSITION_X_OBJECT(Config.getXLeft());     imagePath = "enemyLeft";    break;
            case 1: Config.setPOSITION_X_OBJECT(Config.getXCenterL());  imagePath = "enemyCenterL"; break;
            case 2: Config.setPOSITION_X_OBJECT(Config.getXCenterR());  imagePath = "enemyCenterR"; break;
            case 3: Config.setPOSITION_X_OBJECT(Config.getXRight());    imagePath = "enemyRight";   break;
        }
        switch (nRandom.nextInt(1)){
            case 0: imagePath = "gloves"; break;
            case 1: imagePath = "mouthCover"; break;
        }
        Config.setPOSITION_Y_OBJECT(Config.getPositionYObject() - Config.getDistanceObject());
        return Entities.builder()
                .type(EntityType.MEDICINE)
                //.viewFromNode(new Rectangle(70, 70))
                .viewFromTexture(imagePath+".png")
                //.bbox(new HitBox(BoundingShape.box(50, 100)))             // I dont know what it is
                .with(new EnemyComponent())                               // ERROR
                .at(Config.getPositionXObject(), Config.getPositionYObject())
                .build();
    }
}
