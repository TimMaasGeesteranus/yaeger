package com.github.timmaasgeesteranus.pacman.map;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;
import javafx.scene.paint.Color;

public class Wall extends SpriteEntity implements Collider {

    public Wall(Coordinate2D initialPosition, Size size) {
        super("images/wall.jpg", initialPosition, size);
        setAnchorPoint(AnchorPoint.TOP_LEFT);
    }
}
