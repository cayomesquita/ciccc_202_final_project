package ca.ciccc.coronarace.collision;

import ca.ciccc.coronarace.entities.EntityType;
import ca.ciccc.coronarace.event.GameEvent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;

public class HomeCollisionHandler extends CollisionHandler {

    public HomeCollisionHandler() {
        super(EntityType.PLAYER, EntityType.HOME);
    }

    @Override
    protected void onCollisionBegin(Entity a, Entity b) {
        FXGL.getEventBus().fireEvent(new GameEvent(GameEvent.GAME_SUCCESS));
    }

    @Override
    protected void onCollision(Entity a, Entity b) {
        super.onCollision(a, b);
    }

    @Override
    protected void onCollisionEnd(Entity a, Entity b) {
        super.onCollisionEnd(a, b);
    }
}
