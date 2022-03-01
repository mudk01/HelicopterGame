package org.csc133.a2;

import org.csc133.a2.gameobjects.GameObject;
import org.csc133.a2.gameobjects.River;

import java.util.ArrayList;

public class GameWorld {
    private River river;
    private ArrayList<GameObject> gameObjects;

    public GameWorld() {
        init();
    }

    private void init() {
        river = new River();
        gameObjects = new ArrayList<>();
        gameObjects.add(river);
    }

    public void tick() {

    }

    public ArrayList<GameObject> getGameObjectCollection() {
        return gameObjects;
    }
}
