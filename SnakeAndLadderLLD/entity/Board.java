package SnakeAndLadderLLD.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, Integer> snakeLadder = new HashMap<>();

    public Board(int size, List<BoardEntity> entites) {
        this.size = size;

        for (BoardEntity entity : entites) {
            snakeLadder.put(entity.getStart(), entity.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public int getFinalPosition(int pos) {
        return snakeLadder.getOrDefault(pos, pos);
    }

}
