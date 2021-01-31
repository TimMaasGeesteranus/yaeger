package com.github.timmaasgeesteranus.pacman;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.YaegerGame;
import com.github.timmaasgeesteranus.pacman.scenes.GameScene;
import com.github.timmaasgeesteranus.pacman.scenes.TitleScene;

public class PacMan extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    protected void setupGame() {
        setGameTitle("PacMan");
        setSize((new Size(700,825)));
    }

    @Override
    protected void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this));
    }
}