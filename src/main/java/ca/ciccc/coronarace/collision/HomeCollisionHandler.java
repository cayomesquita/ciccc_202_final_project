package ca.ciccc.coronarace.collision;

import ca.ciccc.coronarace.Config;
import ca.ciccc.coronarace.LevelsComponents.*;
import ca.ciccc.coronarace.component.LevelsComponent;
import ca.ciccc.coronarace.component.PlayerHealthComponent;
import ca.ciccc.coronarace.entities.EntityType;
import ca.ciccc.coronarace.event.GameEvent;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;

public class HomeCollisionHandler extends CollisionHandler {
    public HomeCollisionHandler() {
        super(EntityType.PLAYER, EntityType.HOME);
    }
    @Override protected void onCollisionBegin(Entity a, Entity b) {
        FXGL.getEventBus().fireEvent(new GameEvent(GameEvent.GAME_SUCCESS));
        /**
        switch (Config.getLevel()){
            case 1 : LevelOneComponent   levelOne   = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_ONE    ).iterator().next().getComponent(LevelOneComponent.class    ); levelOne.onRemoved();   break;
            case 2 : LevelTwoComponent   levelTwo   = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_TWO    ).iterator().next().getComponent(LevelTwoComponent.class    ); levelTwo.onRemoved();   break;
            case 3 : LevelThreeComponent levelThree = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_THREE  ).iterator().next().getComponent(LevelThreeComponent.class  ); levelThree.onRemoved(); break;
            case 4 : LevelFourComponent  levelFour  = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_FOUR   ).iterator().next().getComponent(LevelFourComponent.class   ); levelFour.onRemoved();  break;
            case 5 : LevelFiveComponent  levelFive  = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_FIVE   ).iterator().next().getComponent(LevelFiveComponent.class   ); levelFive.onRemoved();  break;
            case 6 : LevelSixComponent   levelSix   = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_SIX    ).iterator().next().getComponent(LevelSixComponent.class    ); levelSix.onRemoved();   break;
            case 7 : LevelSevenComponent levelSeven = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_SEVEN  ).iterator().next().getComponent(LevelSevenComponent.class  ); levelSeven.onRemoved(); break;
            case 8 : LevelEightComponent levelEight = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_EIGHT  ).iterator().next().getComponent(LevelEightComponent.class  ); levelEight.onRemoved(); break;
            case 9 : LevelNineComponent  levelNine  = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_NINE   ).iterator().next().getComponent(LevelNineComponent.class   ); levelNine.onRemoved();  break;
            case 10: LevelTenComponent   levelTen   = FXGL.getGameWorld().getEntitiesByType(EntityType.LEVEL_TEN    ).iterator().next().getComponent(LevelTenComponent.class    ); levelTen.onRemoved();   break;
        }
        Config.setLEVEL(Config.getLevel()+1);
         */
    }
    @Override protected void onCollision(Entity a, Entity b) {
        super.onCollision(a, b);
    }
    @Override protected void onCollisionEnd(Entity a, Entity b) {
        super.onCollisionEnd(a, b);
    }
}
