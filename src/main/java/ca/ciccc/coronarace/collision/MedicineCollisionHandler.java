package ca.ciccc.coronarace.collision;

import ca.ciccc.coronarace.entities.EntityType;
import ca.ciccc.coronarace.event.GameEvent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import ca.ciccc.coronarace.component.PlayerHealthComponent;

public class MedicineCollisionHandler extends CollisionHandler {
    public MedicineCollisionHandler() {
        super(EntityType.PLAYER, EntityType.MEDICINE);
    }

    @Override protected void onCollisionBegin(Entity player, Entity medicine) {
        //FXGL.getEventBus().fireEvent(new GameEvent(GameEvent.GAME_SUCCESS));
        medicine.removeFromWorld();
        PlayerHealthComponent ph = new PlayerHealthComponent();
        ph.increase(10);
    }
    @Override protected void onCollision     (Entity player, Entity medicine) { super.onCollision   (player, medicine); }
    @Override protected void onCollisionEnd  (Entity player, Entity medicine) { super.onCollisionEnd(player, medicine); }
}
