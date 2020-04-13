package ca.ciccc.coronarace.entities;

import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.LevelsComponents.*;
import ca.ciccc.coronarace.component.LevelsComponent;
import com.almasb.fxgl.entity.*;

public class LevelsEntityFactory implements EntityFactory {
    @Spawns("levelText")
    public Entity newLevel(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight());
        Config.setPOSITION_Y_COMPLEMENT(530);
        return Entities.builder()
                .viewFromTexture("level.png")
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelOne")
    public Entity levelOne(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("1-1.png")
                .with(new LevelOneComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelTwo")
    public Entity levelTwo(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("2-1.png")
                .with(new LevelTwoComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelThree")
    public Entity levelThree(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("3-1.png")
                .with(new LevelThreeComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelFour")
    public Entity levelFour(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("4-1.png")
                .with(new LevelFourComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelFive")
    public Entity levelFive(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight());
        Config.setPOSITION_Y_COMPLEMENT(570);
        return Entities.builder()
                .viewFromTexture("5-1.png")
                .with(new LevelFiveComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelSix")
    public Entity levelSix(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("6-1.png")
                .with(new LevelSixComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelSeven")
    public Entity levelSeven(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("7-1.png")
                .with(new LevelSevenComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelEight")
    public Entity levelEight(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("8-1.png")
                .with(new LevelEightComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelNine")
    public Entity levelNine(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("9-1.png")
                .with(new LevelNineComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
    @Spawns("levelTen")
    public Entity levelTen(SpawnData data) {
        Config.setPOSITION_X_COMPLEMENT(Config.getComplementRight()+13);
        Config.setPOSITION_Y_COMPLEMENT(550);
        return Entities.builder()
                .viewFromTexture("10-1.png")
                .with(new LevelTenComponent())
                .at(Config.getPositionXComplement(), Config.getPositionYComplement())
                .build();
    }
}