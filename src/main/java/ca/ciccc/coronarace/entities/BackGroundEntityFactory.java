package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.component.StreetlineComponent;
import com.almasb.fxgl.entity.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BackGroundEntityFactory implements EntityFactory {

    public static final double WIDTH_PERCENT = 0.025;
    public static final double HEIGHT_PERCENT = 0.2;

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
        double xCenter = Config.WIDTH * (1 - WIDTH_PERCENT) / 2;
        double height = Config.HEIGHT * HEIGHT_PERCENT;
        double distance = height * Config.STREETLINE_DISTANCE_PERCENT;
        double width = Config.WIDTH * WIDTH_PERCENT;
        Rectangle streetline = null;
        Group streetlines = new Group();
        int dy = 0;
        while (dy < Config.HEIGHT + distance) {
            streetline = new Rectangle(width, height, Color.LIGHTGRAY);
            streetline.setTranslateX(xCenter);
            streetline.setTranslateY(dy);
            streetlines.getChildren().add(streetline);
            dy += height + distance;
        }
        return Entities.builder()
                .viewFromNode(streetlines)
                .with(new StreetlineComponent())
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

}
