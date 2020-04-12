package ca.ciccc.coronarace.entities;
import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.component.EnemyComponent;
import ca.ciccc.coronarace.component.PlayerComponent;
import ca.ciccc.coronarace.component.StreetlineComponent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.asset.AssetLoader;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.view.EntityView;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;
public class EnemyEntityFactory implements EntityFactory {
    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        Random nRandom = new Random();
        String imagePath = "";
        switch (nRandom.nextInt((int) Config.getnPositionsX()-1)){
            case 0: Config.setPOSITION_X_OBJECT(Config.getXLeft());     imagePath = "enemyLeft";    break;
            case 1: Config.setPOSITION_X_OBJECT(Config.getXCenterL());  imagePath = "enemyCenterL"; break;
            case 2: Config.setPOSITION_X_OBJECT(Config.getXCenterR());  imagePath = "enemyCenterR"; break;
            case 3: Config.setPOSITION_X_OBJECT(Config.getXRight());    imagePath = "enemyRight";   break;
        }
        Config.setPOSITION_Y_OBJECT(Config.getPositionYObject() - Config.getDistanceObject());
        return Entities.builder()
                .type(EntityType.ENEMY)
                .viewFromTexture(imagePath+".png")
                .bbox(new HitBox(BoundingShape.box(Config.getEnemyWidth(), Config.getEnemyHeight())))
                .with(new EnemyComponent(), new CollidableComponent(true))
                .at(Config.getPositionXObject(), Config.getPositionYObject())
                .build();
    }
}