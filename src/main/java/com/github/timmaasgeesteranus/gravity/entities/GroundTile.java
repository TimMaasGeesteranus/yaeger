package com.github.timmaasgeesteranus.gravity.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.DynamicRectangleEntity;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

public class GroundTile extends RectangleEntity implements Collider {
    public GroundTile(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        setFill(Color.DARKBLUE);
    }
}
