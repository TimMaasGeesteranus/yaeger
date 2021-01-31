package com.github.timmaasgeesteranus.gravity.scenes;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import com.github.timmaasgeesteranus.gravity.Gravity;
import com.github.timmaasgeesteranus.gravity.entities.SquareMan;
import com.github.timmaasgeesteranus.gravity.map.PlayGroundTileMap;
import com.github.timmaasgeesteranus.pacman.PacMan;
import com.github.timmaasgeesteranus.pacman.entities.Player;
import com.github.timmaasgeesteranus.pacman.text.ScoreText;
import javafx.scene.paint.Color;

public class GameScene extends DynamicScene implements TileMapContainer {

    private Gravity gravity;

    public GameScene(Gravity gravity) {
        super();
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.RED);
    }

    @Override
    public void setupEntities() {
        var squareMan = new SquareMan(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(squareMan);

    }

    @Override
    public void setupTileMaps() {
        addTileMap(new PlayGroundTileMap());
    }
}