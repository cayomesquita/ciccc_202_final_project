package ca.ciccc.coronarace.level;

import ca.ciccc.coronarace.entities.EntityType;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.app.FXGL.Companion;
import com.almasb.fxgl.util.Optional;

public class Level {
    private int currentWave = 0;
    public Level() {

    }
    public boolean isDone() {
        return currentWave == 1;
    }
    public void nextWave() {
        currentWave++;
    }
    public void spawnNewWave() {

        currentWave++;
        int numEnemies = 10;
        String[] enemyTypes = { "Enemy1" };
        Optional<Entity> player = FXGL.getGameWorld().getSingleton(EntityType.PLAYER);
        for (int i = 0; i < numEnemies; i++) {
            String type = FXGLMath.random(enemyTypes).get();
            //Entity e = FXGL.getGameWorld().spawn(type, new SpawnData(player.getX() + 700, FXGLMath.random(0, 400)));
        }
    }
}
