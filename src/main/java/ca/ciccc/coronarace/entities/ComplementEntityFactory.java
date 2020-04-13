package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.component.ComplementComponent;
import com.almasb.fxgl.entity.*;
import ca.ciccc.coronarace.Config;

public class ComplementEntityFactory implements EntityFactory {
    @Spawns("tree")
    public Entity newComplement(SpawnData data) {
        switch (Config.getNRandom((int) Config.getComplementsX())){
            case 0: Config.setPOSITION_X_COMPLEMENT(Config.getComplementLeft());  break;
            case 1: Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()); break;
        }
        Config.setPOSITION_Y_COMPLEMENT(Config.getPositionYComplement() - Config.getDistanceComplement());
        return Entities.builder()
                .type(EntityType.TREE)
                .viewFromTexture("tree.png")
                .with(new ComplementComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
}
