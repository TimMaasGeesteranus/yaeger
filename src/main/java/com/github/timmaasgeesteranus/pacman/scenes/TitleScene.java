package com.github.timmaasgeesteranus.pacman.scenes;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.scenes.StaticScene;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import com.github.timmaasgeesteranus.pacman.PacMan;
import com.github.timmaasgeesteranus.pacman.buttons.StartButton;
import javafx.scene.paint.Color;

public class TitleScene extends StaticScene {
    private PacMan pacMan;

    public TitleScene(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
        setBackgroundAudio("audio/pacman.mp3");
    }

    @Override
    public void setupEntities() {
        var pacManText = new TextEntity(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.3), "Pac-man");
        pacManText.setFill(Color.WHITE);
        pacManText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        pacManText.setFont(HanFont.createDefaultCondensedFont(HanFontStyle.DEMI_BOLD, 80));
        addEntity(pacManText);

        var playText = new StartButton(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.6), pacMan);
        pacManText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(playText);
    }
}