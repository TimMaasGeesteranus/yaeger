package com.github.timmaasgeesteranus.pacman.map;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;

public class FoodHitBox extends RectangleEntity implements Collider {
    public String position;

    public FoodHitBox(Coordinate2D initialPosition, String position) {
        super(initialPosition);
        this.position = position;

        switch (position) {
            case "down":
                setWidth(25);
                setAnchorLocationY(25);
                break;
            case "up":
                setWidth(25);
                break;
            case "left":
                setHeight(25);
                break;
            case "right":
                setHeight(25);
                setAnchorLocationX(23);
                break;
        }
    }
}

