package ca.ciccc.coronarace.event;

import javafx.event.Event;
import javafx.event.EventType;

public class GameEvent extends Event {

    public static final EventType<GameEvent> GAME_FAIL = new EventType<>(Event.ANY, "GAME_FAIL");
    public static final EventType<GameEvent> GAME_SUCCESS = new EventType<>(Event.ANY, "GAME_SUCCESS");

    public GameEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
