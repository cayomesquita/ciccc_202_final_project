package ca.ciccc.coronarace.component;

import ca.ciccc.coronarace.entities.EntityType;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.gameplay.GameState;
import org.jetbrains.annotations.NotNull;

public abstract class CoronaRaceComponentAbstract extends Component {

    protected GameState getGameState() {
        return FXGL.getGameState();
    }

    protected double getHeight() {
        return FXGL.getAppHeight();
    }

    protected double getWidth() {
        return FXGL.getAppWidth();
    }

    protected Entity getPlayerEntity() {
        return getGameWorld().getEntitiesByType(EntityType.PLAYER).iterator().next();
    }

    @NotNull
    protected GameWorld getGameWorld() {
        return FXGL.getGameWorld();
    }

    protected Double getGameSpeed() {
        return FXGL.getGameState().getDouble("gameSpeed");
    }
}
