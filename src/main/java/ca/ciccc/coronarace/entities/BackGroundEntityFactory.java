package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.component.ComplementComponent;
import ca.ciccc.coronarace.component.StreetComponent;
import ca.ciccc.coronarace.component.StreetlineComponent;
import com.almasb.fxgl.entity.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BackGroundEntityFactory extends CoronaRaceEntityFactoryAbstract {
    @Spawns("street")
    public Entity newStreet(SpawnData data) {
        return Entities.builder()
                .viewFromTexture("road.png")
                .renderLayer(RenderLayer.BACKGROUND)
                .at(100, 0)
                .with(new StreetComponent())
                .build();
    }

    @Spawns("sidewalk")
    public Entity newSidewalk(SpawnData data) {
        //final double sideWalkWidthPercent = 0.16;
        //Rectangle sideWalkLeft = new Rectangle(Config.WIDTH * sideWalkWidthPercent, Config.HEIGHT, Color.GRAY);
        //Rectangle sideWalkRight = new Rectangle(Config.WIDTH * sideWalkWidthPercent, Config.HEIGHT, Color.GRAY);
        //sideWalkRight.setX(Config.WIDTH * (1 - sideWalkWidthPercent));

        //Group group = new Group();
        //group.getChildren().add(sideWalkLeft);
        //group.getChildren().add(sideWalkRight);
        return Entities.builder()
                //.viewFromNode(group)
                .viewFromTexture("sideWalk.png")
                .renderLayer(RenderLayer.BACKGROUND)
                .with(new StreetComponent())
                .build();
    }

    @Spawns("streetline")
    public Entity newStreetlines(SpawnData data) {
        double height = Config.getHEIGHT() * Config.getHEIGHT_PERCENT();
        double distance = height * Config.STREETLINE_DISTANCE_PERCENT;
        Rectangle streetline = null;
        Group streetlines = new Group();
        int dy = 0;
        while (dy < Config.getHEIGHT() + distance) {
            streetline = new Rectangle(Config.getWIDTH() * Config.getWIDTH_PERCENT(), height, Color.LIGHTGRAY);
            streetline.setTranslateX(Config.getWIDTH() * (1 - Config.getWIDTH_PERCENT()) / 2);
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
