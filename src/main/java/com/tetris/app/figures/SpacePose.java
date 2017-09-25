package com.tetris.app.figures;

import java.util.HashMap;
import java.util.Map;

public enum SpacePose {
    FIRST,
    SECOND,
    THIRD,
    FOURTH;

    static Map<Integer, SpacePose> positions = new HashMap<>();

    static {
        positions.put(FIRST.ordinal(), FIRST);
        positions.put(SECOND.ordinal(), SECOND);
        positions.put(THIRD.ordinal(), THIRD);
        positions.put(FOURTH.ordinal(), FOURTH);
    }

    public static SpacePose getNext(SpacePose sp) {
        int index = sp.ordinal();
        if (index < 3) {
            return positions.get(++index);
        }
        return positions.get(0);
    }
}
