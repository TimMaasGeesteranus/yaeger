package com.github.timmaasgeesteranus.pacman.scenes;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import com.github.timmaasgeesteranus.pacman.PacMan;
import com.github.timmaasgeesteranus.pacman.entities.Player;
import com.github.timmaasgeesteranus.pacman.map.PlayGroundTileMap;
import com.github.timmaasgeesteranus.pacman.text.ScoreText;
import javafx.scene.paint.Color;

public class GameScene extends DynamicScene implements TileMapContainer {

    private PacMan pacMan;

    public GameScene(PacMan pacMan) {
        super();
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var scoreText = new ScoreText(new Coordinate2D(getWidth() * 0.56, getHeight() * 0.1));
        addEntity(scoreText);
        scoreText.setHighScoreText(0);

        var player = new Player(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.58), new Size(21, 21), scoreText);
        player.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(player);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new PlayGroundTileMap());
    }
}
