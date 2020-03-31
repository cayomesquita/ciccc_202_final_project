package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.Config;
import com.almasb.fxgl.entity.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BackGroundEntityFactory implements EntityFactory {

    @Spawns("street")
    public Entity newStreet(SpawnData data) {

        Rectangle pavement = new Rectangle(Config.WIDTH, Config.HEIGHT, Color.DARKGRAY);

        return Entities.builder()
                .viewFromNode(pavement)
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

    @Spawns("sidewalk")
    public Entity newSidewalk(SpawnData data) {
        final double sideWalkWidthPercent = 0.16;
        Rectangle sideWalkLeft = new Rectangle(Config.WIDTH * sideWalkWidthPercent, Config.HEIGHT, Color.GRAY);
        Rectangle sideWalkRight = new Rectangle(Config.WIDTH * sideWalkWidthPercent, Config.HEIGHT, Color.GRAY);
        sideWalkRight.setX(Config.WIDTH * (1 - sideWalkWidthPercent));

        Group group = new Group();
        group.getChildren().add(sideWalkLeft);
        group.getChildren().add(sideWalkRight);

        return Entities.builder()
                .viewFromNode(group)
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

    @Spawns("streetline")
    public Entity newStreetlines(SpawnData data) {
        double widthPercent = 0.025;
        double xCenter = Config.WIDTH * (1 - widthPercent) / 2;
        double height = Config.HEIGHT * 0.2;
        double width = Config.WIDTH * widthPercent;
        Rectangle streetline = null;
        Group streetlines = new Group();
        int dy = 0;
        while (dy < Config.HEIGHT) {
            streetline = new Rectangle(width, height, Color.LIGHTGRAY);
            streetline.setX(xCenter);
            streetline.setY(dy);
            streetlines.getChildren().add(streetline);
            dy += height * 1.75;
        }
        return Entities.builder()
                .viewFromNode(streetlines)
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

}
