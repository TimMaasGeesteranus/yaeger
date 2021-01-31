package com.github.timmaasgeesteranus.pacman.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.timmaasgeesteranus.pacman.map.FoodHitBox;
import com.github.timmaasgeesteranus.pacman.map.FoodIntersectionUp;
import com.github.timmaasgeesteranus.pacman.map.Wall;
import com.github.timmaasgeesteranus.pacman.text.ScoreText;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Collided {
    private final ScoreText scoreText;
    private int score = 0;
    private String wantedDirection = "left";

    public Player(Coordinate2D coordinate2D, Size size, ScoreText scoreText) {
        super("images/player.jpg", coordinate2D, size);
        this.scoreText = scoreText;
        setMotion(1, Direction.LEFT.getValue());
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            wantedDirection = "left";
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            wantedDirection = "right";
        } else if (pressedKeys.contains(KeyCode.UP)) {
            wantedDirection = "up";
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            wantedDirection = "down";
        }
        if(this.getSpeed() == 0){
            if (pressedKeys.contains(KeyCode.LEFT)) {
                setMotion(1, Direction.LEFT.getValue());
            } else if (pressedKeys.contains(KeyCode.RIGHT)) {
                setMotion(1, Direction.RIGHT.getValue());
            } else if (pressedKeys.contains(KeyCode.UP)) {
                setMotion(1, Direction.UP.getValue());
            } else if (pressedKeys.contains(KeyCode.DOWN)) {
                setMotion(1, Direction.DOWN.getValue());
            }
        }

        System.out.println("i want to go " + wantedDirection);
    }

    @Override
    public void onCollision(Collider collidingObject) {
       if(collidingObject instanceof FoodIntersectionUp){
           System.out.println("collided with food!");
//           if(wantedDirection.equals("left")){
//               setMotion(1, Direction.LEFT.getValue());
//           }
//           if(wantedDirection.equals("right")){
//               setMotion(1, Direction.RIGHT.getValue());
//           }
//           if(wantedDirection.equals("up")){
//               setMotion(1, Direction.UP.getValue());
//           }
//           if(wantedDirection.equals("down")){
//               setMotion(1, Direction.DOWN.getValue());
//           }
       }
        /** Colliding with a FootHitBox **/
       if(collidingObject instanceof FoodHitBox){
           System.out.println(((FoodHitBox) collidingObject).angleTo(this) + " - " + ((FoodHitBox) collidingObject).position);
           System.out.println(((FoodHitBox) collidingObject).getAnchorLocation());
           if(((FoodHitBox) collidingObject).angleTo(this) > 41 && ((FoodHitBox) collidingObject).angleTo(this) < 44 && ( ((FoodHitBox) collidingObject).position).equals("left")){ //Wall is on the right side
               System.out.println("Hit an intersection on the right side of me");
               switch (wantedDirection){
                   case "up":
                       this.setAnchorLocationX(this.getAnchorLocation().getX() - 1);
                       setMotion(1, Direction.UP.getValue());
                       break;
                   case "down":
                       this.setAnchorLocationX(this.getAnchorLocation().getX() - 1);
                       setMotion(1, Direction.DOWN.getValue());
                       break;
                   case "right":
                       setMotion(1, Direction.RIGHT.getValue());
                       break;
                   case "left":
                       setMotion(1, Direction.LEFT.getValue());
                       break;
                   default:
                       this.setAnchorLocationX(this.getAnchorLocation().getX() - 1);
                       setSpeed(0);
               }
           }
           if(((FoodHitBox) collidingObject).angleTo(this) > 29 && ((FoodHitBox) collidingObject).angleTo(this) < 31 && ( ((FoodHitBox) collidingObject).position).equals("down")){ //Wall is on the upper side
               System.out.println("Hit an intersection on the upper side of me");
               switch (wantedDirection){
                   case "left":
                       this.setAnchorLocationY(this.getAnchorLocation().getY() + 1);
                       setMotion(1, Direction.LEFT.getValue());
                       break;
                   case "right":
                       this.setAnchorLocationY(this.getAnchorLocation().getY() + 1);
                       setMotion(1, Direction.RIGHT.getValue());
                       break;
                   case "up":
                       setMotion(1, Direction.UP.getValue());
                       break;
                   case "down":
                       setMotion(1, Direction.DOWN.getValue());
                       break;
                   default:
                       setSpeed(0);
                       this.setAnchorLocationY(this.getAnchorLocation().getY() + 1);
               }
           }
           if(((FoodHitBox) collidingObject).angleTo(this) < 28 && ((FoodHitBox) collidingObject).angleTo(this) > 25 && ( ((FoodHitBox) collidingObject).position).equals("right")){ //Wall is on the left side
               System.out.println("Hit an intersection on the left side of me");
               switch (wantedDirection){
                   case "up":
                       this.setAnchorLocationX(this.getAnchorLocation().getX() + 1);
                       setMotion(1, Direction.UP.getValue());
                       break;
                   case "down":
                       this.setAnchorLocationX(this.getAnchorLocation().getX() + 1);
                       setMotion(1, Direction.DOWN.getValue());
                       break;
                   case "left":
                       setMotion(1, Direction.LEFT.getValue());
                       break;
                   case "right":
                       setMotion(1, Direction.RIGHT.getValue());
                       break;
                   default:
                       setSpeed(0);
                       this.setAnchorLocationX(this.getAnchorLocation().getX() + 1);
               }
           }
           if(((FoodHitBox) collidingObject).angleTo(this) < 26 && ((FoodHitBox) collidingObject).angleTo(this) > 24 && ( ((FoodHitBox) collidingObject).position).equals("up")){ //Wall is on the down side
               System.out.println("Hit an intersection on the down side of me");
               switch (wantedDirection){
                   case "left":
                       setMotion(1, Direction.LEFT.getValue());
                       this.setAnchorLocationY(this.getAnchorLocation().getY() - 1);
                       break;
                   case "right":
                       setMotion(1, Direction.RIGHT.getValue());
                       this.setAnchorLocationY(this.getAnchorLocation().getY() - 1);
                       break;
                   case "down":
                       setMotion(1, Direction.DOWN.getValue());
                       break;
                   case "up":
                       setMotion(1, Direction.UP.getValue());
                       break;
                   default:
                       setSpeed(0);
                       this.setAnchorLocationY(this.getAnchorLocation().getY() - 1);
               }
           }
       }

       /** Colliding with a Wall **/
        if(collidingObject instanceof Wall){
            //System.out.println(collidingObject.getWidth());
            if(((Wall) collidingObject).angleTo(this) > 318){ //Wall is on the right side
                this.setAnchorLocationX(this.getAnchorLocation().getX() - 1);
                switch (wantedDirection){
                    case "up":
                        setMotion(1, Direction.UP.getValue());
                        break;
                    case "down":
                        setMotion(1, Direction.DOWN.getValue());
                        break;
                    default:
                        setSpeed(0);
                }
            }
            if(((Wall) collidingObject).angleTo(this) < 45){ //Wall is on the upper side
                this.setAnchorLocationY(this.getAnchorLocation().getY() + 1);
                switch (wantedDirection){
                    case "left":
                        setMotion(1, Direction.LEFT.getValue());
                        break;
                    case "right":
                        setMotion(1, Direction.RIGHT.getValue());
                        break;
                    default:
                        setSpeed(0);
                }
            }
            if(((Wall) collidingObject).angleTo(this) < 73 && ((Wall) collidingObject).angleTo(this) > 44){ //Wall is on the left side
                this.setAnchorLocationX(this.getAnchorLocation().getX() + 1);
                switch (wantedDirection){
                    case "up":
                        setMotion(1, Direction.UP.getValue());
                        break;
                    case "down":
                        setMotion(1, Direction.DOWN.getValue());
                        break;
                    default:
                        setSpeed(0);
                }
            }
            if(((Wall) collidingObject).angleTo(this) < 133 && ((Wall) collidingObject).angleTo(this) > 105){ //Wall is on the down side
                this.setAnchorLocationY(this.getAnchorLocation().getY() - 1);
                switch (wantedDirection){
                    case "left":
                        setMotion(1, Direction.LEFT.getValue());
                        break;
                    case "right":
                        setMotion(1, Direction.RIGHT.getValue());
                        break;
                    default:
                        setSpeed(0);
                }
            }
        }
    }
}
