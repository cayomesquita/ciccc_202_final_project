package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.component.BarHealthComponent;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.ui.ProgressBar;
import javafx.scene.paint.Color;

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

}
