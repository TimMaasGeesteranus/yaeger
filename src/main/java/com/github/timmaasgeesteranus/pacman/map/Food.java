package com.github.timmaasgeesteranus.pacman.map;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.MotionApplier;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class Food extends SpriteEntity {

    public Food(Coordinate2D initialPosition, Size size) {
        super("images/food.jpg", initialPosition, size);
    }

}