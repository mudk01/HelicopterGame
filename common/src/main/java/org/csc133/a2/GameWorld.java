package org.csc133.a2;

import org.csc133.a2.gameobjects.GameObject;
import org.csc133.a2.gameobjects.Helicopter;
import org.csc133.a2.gameobjects.Helipad;
import org.csc133.a2.gameobjects.River;

import java.awt.*;
import java.util.ArrayList;
import com.codename1.ui.geom.Dimension;

public class GameWorld {
    private River river;
    private Helipad helipad;
    private Helicopter helicopter;
    private ArrayList<GameObject> gameObjects;
    private Dimension worldSize;

    public GameWorld() {
        worldSize = new Dimension();
        init();
    }

    public void init() {
        System.err.println(worldSize);
        river = new River(worldSize);
        helipad = new Helipad(worldSize);
        helicopter = new Helicopter(helipad.getHelipadCenter(),
                helipad.getHelipadSize());
        gameObjects = new ArrayList<>();
        gameObjects.add(river);
        gameObjects.add(helipad);
        gameObjects.add(helicopter);
    }

    public void tick() {

    }

    public ArrayList<GameObject> getGameObjectCollection() {
        return gameObjects;
    }

    public String getHeading() {
        return String.valueOf(helicopter.getHeading());
    }

    public String getFuel() {
        return String.valueOf(helicopter.getFuel());

    }

    public String getSpeed() {
        return String.valueOf(helicopter.getSpeed());
    }

    public void setDimension(Dimension worldSize) {
        this.worldSize = worldSize;
    }
}
