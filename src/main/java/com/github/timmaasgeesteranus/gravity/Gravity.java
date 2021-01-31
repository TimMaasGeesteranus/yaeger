package com.github.timmaasgeesteranus.gravity;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.YaegerGame;
import com.github.timmaasgeesteranus.gravity.scenes.GameScene;

public class Gravity extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    protected void setupGame() {
        setGameTitle("Gravity");
        setSize((new Size(700,825)));
    }

    @Override
    protected void setupScenes() {
        addScene(0, new GameScene(this));
    }
}