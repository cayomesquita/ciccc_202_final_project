package ca.ciccc.coronarace.entities;
import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.component.EnemyComponent;
import ca.ciccc.coronarace.component.PlayerComponent;
import ca.ciccc.coronarace.component.StreetlineComponent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.asset.AssetLoader;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.view.EntityView;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;
public class EnemyEntityFactory implements EntityFactory {

    /**
    private static AssetLoader assetLoader;
    static{
        assetLoader = GameApplication.getService(ServiceType.ASSET_LOADER)
    }
    public static Entity newEnem(double x, double y){
        Entity enemy = new Entity();
        enemy.getPositionComponent().setValue(x,y);
        enemy.getMainViewComponent().setView(new EntityView(assetLoader.loadTexture("enemy1.png")));
        return enemy;
    }
     */

    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        Rectangle enemy   = null;
        Group     enemies = new Group();
        enemy = new Rectangle(Config.ENEMY_WIDTH, Config.ENEMY_HEIGHT, Color.GREEN);
        enemy.setTranslateY(0);

        Random nRandom = new Random(3);
        switch (nRandom.nextInt()){
            case 1:  enemy.setTranslateX(Config.xLeft);   break;
            case 3:  enemy.setTranslateX(Config.xCenter); break;
            default: enemy.setTranslateX(Config.xRight);  break;
        }

        enemies.getChildren().add(enemy);

        /***
        int dy = 0;                                                         // 0 , 150, 300, 450, 600
        while (dy <= Config.HEIGHT + Config.ENEMY_DISTANCE) {               // dy < 600 + 100 (700) ,
            enemy = new Rectangle(Config.ENEMY_WIDTH, Config.ENEMY_HEIGHT, Color.GREEN);
            enemy.setTranslateY(dy);

            Random nRandom = new Random(3);
            switch (nRandom.nextInt()){
                case 1:  enemy.setTranslateX(Config.xLeft);   break;
                case 3:  enemy.setTranslateX(Config.xCenter); break;
                default: enemy.setTranslateX(Config.xRight);  break;
            }

            enemies.getChildren().add(enemy);
            dy += Config.ENEMY_HEIGHT + Config.ENEMY_DISTANCE;
        }*/

        return Entities.builder()
                .viewFromNode(enemies)
                .with(new EnemyComponent())
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }
}