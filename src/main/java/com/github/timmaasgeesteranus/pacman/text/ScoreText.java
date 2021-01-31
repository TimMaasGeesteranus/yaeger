package com.github.timmaasgeesteranus.pacman.text;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.styles.HanFont;
import javafx.scene.paint.Color;

public class ScoreText extends TextEntity {
    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(HanFont.createDefaultFont(40));
        setFill(Color.WHITE);
    }

    public void setHighScoreText(int highScore){
        setText("High Score: " + highScore);
    }
}
