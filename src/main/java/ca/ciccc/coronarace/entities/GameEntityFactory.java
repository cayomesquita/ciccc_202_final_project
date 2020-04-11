package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.component.BarHealthComponent;
import ca.ciccc.coronarace.component.HomeComponent;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.ui.ProgressBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameEntityFactory extends CoronaRaceEntityFactoryAbstract {

    @Spawns("bar")
    public Entity newBar(SpawnData data) {
        ProgressBar bar = new ProgressBar(false);
        bar.setHeight(20.0);
        bar.setWidth(200.0);
        bar.setLabelVisible(false);
        bar.setFill(Color.GREEN);
        bar.setBackgroundFill(Color.DARKGREY);
        bar.setTraceFill(Color.LIGHTGREEN);

        double initialHeight = getHeight() - 40;
        double initialWidth = 20;
        return Entities.builder()
                .type(EntityType.BAR)
                .renderLayer(RenderLayer.TOP)
                .viewFromNode(bar)
                .with(new BarHealthComponent())
                .at(initialWidth, initialHeight)
                .build();
    }

    @Spawns("home")
    public Entity newHome(SpawnData data) {
        double bannerWidth = getWidth() * 0.5;
        double bannerHeight = 80.0;

        Rectangle home = new Rectangle(bannerWidth, bannerHeight, Color.LIGHTSEAGREEN);

        double initialHeight = 40;
        double initialWidth = (getWidth() - bannerWidth) / 2;
        return Entities.builder()
                .type(EntityType.HOME)
                .renderLayer(RenderLayer.TOP)
                .viewFromNode(home)
                .bbox(new HitBox(BoundingShape.box(getWidth(), bannerHeight)))
                .with(new CollidableComponent(true), new HomeComponent())
                .at(initialWidth, initialHeight)
                .build();
    }

}
