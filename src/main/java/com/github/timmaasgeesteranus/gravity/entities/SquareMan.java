package com.github.timmaasgeesteranus.gravity.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.DynamicRectangleEntity;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Optional;
import java.util.Set;

public class SquareMan extends DynamicRectangleEntity implements Newtonian, Collided, KeyListener {
    private int speed = 3;
    private boolean isInAir = false;
    private boolean isInAirAndHasDirection = false;
    private String directionInAir = "";

    public SquareMan(Coordinate2D initialPosition) {
        super(initialPosition);
        setFill(Color.BLACK);
        setHeight(20);
        setWidth(20);
    }


    @Override
    public void onCollision(Collider collidingObject) {
        if(collidingObject instanceof GroundTile) {

            this.setAnchorLocationY(this.getAnchorLocation().getY() - 1);

            setSpeed(0);

            isInAir = false;
            directionInAir = "";
            setGravitationalPull(false);
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            if (isInAir && !directionInAir.equals("LEFT")){
                setMotion(speed, Direction.LEFT.getValue());
                directionInAir = "LEFT";
            }
            else if(!isInAir){
                setMotion(speed, Direction.LEFT.getValue());
            }
        }
        else if (pressedKeys.contains(KeyCode.RIGHT)) {
            if (isInAir && !directionInAir.equals("RIGHT")){
                setMotion(speed, Direction.RIGHT.getValue());
                directionInAir = "RIGHT";
            }
            else if(!isInAir){
                setMotion(speed, Direction.RIGHT.getValue());
            }
        }
        else if (pressedKeys.contains(KeyCode.UP)) {
            if (!isInAir) {
                setGravitationalPull(true);
                setMotion(10, Direction.UP.getValue());
                isInAir = true;
            }
        }

    }
}
