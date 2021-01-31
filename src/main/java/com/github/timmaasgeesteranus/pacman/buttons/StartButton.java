package com.github.timmaasgeesteranus.pacman.buttons;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import com.github.timmaasgeesteranus.pacman.PacMan;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class StartButton extends TextEntity implements MouseButtonPressedListener {

    private PacMan pacMan;

    public StartButton(Coordinate2D initialLocation, PacMan pacMan) {
        super(initialLocation, "Start!");
        setFill(Color.WHITE);
        setFont(HanFont.createDefaultCondensedFont(HanFontStyle.BOLD, 30));
        this.pacMan = pacMan;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        pacMan.setActiveScene(1);
    }
}
