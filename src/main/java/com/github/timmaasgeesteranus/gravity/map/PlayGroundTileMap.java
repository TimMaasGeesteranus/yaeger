package com.github.timmaasgeesteranus.gravity.map;

import com.github.hanyaeger.api.engine.entities.tilemap.TileMap;
import com.github.timmaasgeesteranus.gravity.entities.GroundTile;

public class PlayGroundTileMap extends TileMap {
    @Override
    public void setupEntities() {
        addEntity(1, GroundTile.class);
    }

    @Override
    public int[][] defineMap() {
        int[][] map = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
        };
        return map;
    }
}
