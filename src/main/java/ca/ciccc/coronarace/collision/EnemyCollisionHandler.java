package ca.ciccc.coronarace.collision;

import ca.ciccc.coronarace.entities.EntityType;
import ca.ciccc.coronarace.event.GameEvent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;

public class EnemyCollisionHandler extends CollisionHandler {
    public EnemyCollisionHandler() {
        super(EntityType.PLAYER, EntityType.ENEMY);
    }

    @Override protected void onCollisionBegin(Entity player, Entity enemy) {
        //FXGL.getEventBus().fireEvent(new GameEvent(GameEvent.GAME_SUCCESS));

    }
    @Override protected void onCollision     (Entity player, Entity enemy) {
        super.onCollision   (player, enemy);
    }
    @Override protected void onCollisionEnd  (Entity player, Entity enemy) {
        super.onCollisionEnd(player, enemy);
    }
}
