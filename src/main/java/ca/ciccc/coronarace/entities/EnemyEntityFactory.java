package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.component.EnemyComponent;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;

public class EnemyEntityFactory implements EntityFactory {
    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        switch (Config.getNRandom((int) Config.getnPositionsX()-1)){
            case 0: Config.setPOSITION_X_OBJECT(Config.getXLeft());     break;
            case 1: Config.setPOSITION_X_OBJECT(Config.getXCenterL());  break;
            case 2: Config.setPOSITION_X_OBJECT(Config.getXCenterR());  break;
            case 3: Config.setPOSITION_X_OBJECT(Config.getXRight());    break;
        }
        Config.setPOSITION_Y_OBJECT(Config.getPositionYObject() - Config.getDistanceObject());
        return Entities.builder()
                .type(EntityType.ENEMY)
                .viewFromTexture("enemy.png")
                .bbox(new HitBox(BoundingShape.box(Config.getEnemyWidth(), Config.getEnemyHeight())))
                .with(new EnemyComponent(), new CollidableComponent(true))
                .at(Config.getPositionXObject(), Config.getPositionYObject())
                .build();
    }
}