package ca.ciccc.coronarace.collision;

import ca.ciccc.coronarace.component.PlayerHealthComponent;
import ca.ciccc.coronarace.entities.EntityType;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.extra.entity.components.HealthComponent;
import com.almasb.fxgl.ui.ProgressBar;

import java.util.List;

public class MedicineCollisionHandler extends CollisionHandler{
    public MedicineCollisionHandler() {
        super(EntityType.PLAYER, EntityType.MEDICINE);
    }

    @Override protected void onCollisionBegin(Entity player, Entity medicine) {
        medicine.removeFromWorld();
        PlayerHealthComponent playerHealthComponent = FXGL.getGameWorld().getEntitiesByType(EntityType.PLAYER).iterator().next().getComponent(PlayerHealthComponent.class);
        playerHealthComponent.increase();
        FXGL.getAudioPlayer().playSound("medicine.wav");
    }
    @Override protected void onCollision     (Entity player, Entity medicine) { super.onCollision   (player, medicine); }
    @Override protected void onCollisionEnd  (Entity player, Entity medicine) { super.onCollisionEnd(player, medicine); }
}
