package com.github.timmaasgeesteranus.pacman.map;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.DynamicCompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class FoodIntersectionUp extends DynamicCompositeEntity
{
    public FoodIntersectionUp(Coordinate2D initialLocation, Size size) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var food = new Food(new Coordinate2D(0, 0), new Size(25));
        addEntity(food);

        var foodHitBox = new FoodHitBox(new Coordinate2D(0, 0), "up");
        addEntity(foodHitBox);
    }
}
