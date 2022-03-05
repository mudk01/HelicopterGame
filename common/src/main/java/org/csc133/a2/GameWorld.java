package org.csc133.a2;

import org.csc133.a2.gameobjects.*;

import java.awt.*;
import java.util.ArrayList;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;

public class GameWorld {
    private River river;
    private Helipad helipad;
    private Helicopter helicopter;
    private ArrayList<GameObject> gameObjects;
    private Dimension worldSize;
    private Building buildingTop, buildingRight, buildingLeft;
    private Point topBuildingLocation, rightBuildingLocation,
            leftBuildingLocation;
    private Dimension topBuildingSize, rightBuildingSize, leftBuildingSize;

    public GameWorld() {
        worldSize = new Dimension();
        init();
    }

    public void init() {
        System.err.println(worldSize);
        river = new River(worldSize);
        helipad = new Helipad(worldSize);
        helicopter = new Helicopter(helipad.getHelipadCenter(),
                helipad.getHelipadSize(), worldSize);
        topBuildingLocation = new Point(worldSize.getWidth()/6, 5);
        rightBuildingSize = new Dimension(worldSize.getHeight()/6,
                worldSize.getHeight()/2);
        rightBuildingLocation =
                new Point(worldSize.getWidth()/10 ,
                        worldSize.getHeight()/3 + worldSize.getHeight()/18);
        leftBuildingSize = new Dimension(worldSize.getHeight()/5,
                worldSize.getHeight()/3);
        leftBuildingLocation =
                new Point(worldSize.getWidth() - worldSize.getWidth()/10 - leftBuildingSize.getWidth(),
                        worldSize.getHeight()/2);
        topBuildingSize = new Dimension((worldSize.getWidth()*2)/3,
                worldSize.getHeight()/10);
        buildingTop = new Building(worldSize, topBuildingLocation,
                topBuildingSize);
        buildingRight = new Building(worldSize, rightBuildingLocation,
                rightBuildingSize);
        buildingLeft = new Building(worldSize, leftBuildingLocation,
                leftBuildingSize);
        gameObjects = new ArrayList<>();
        gameObjects.add(river);
        gameObjects.add(helipad);
        gameObjects.add(helicopter);
        gameObjects.add(buildingTop);
        gameObjects.add(buildingRight);
        gameObjects.add(buildingLeft);
    }

    public void tick() {
        helicopter.move();

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

    public void input(int input) {
        switch (input) {
            case -92:
                helicopter.moveBackwards();
                break;
            case -91:
                helicopter.moveForwards();
                break;
            case -93:
                helicopter.moveLeft();
                break;
            case -94:
                helicopter.moveRight();
                break;
            case 'd':
                helicopter.drinkWater();
                break;
            case 'f':
//                helicopter.fightFire(fires);
                helicopter.dropWater();
                break;
        }
    }
}
