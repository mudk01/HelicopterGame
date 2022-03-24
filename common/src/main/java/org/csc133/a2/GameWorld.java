package org.csc133.a2;

import com.codename1.ui.Display;
import org.csc133.a2.gameobjects.*;

import java.util.ArrayList;
import java.util.Random;

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
    private Fire fire;
    private Fires fires;
    private Buildings buildings;
    private final int FUEL = 25000;


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
        fires = new Fires();
        buildings = new Buildings();
        buildings.add(buildingLeft);
        buildings.add(buildingRight);
        buildings.add(buildingTop);
        gameObjects.add(river);
        gameObjects.add(helipad);
        gameObjects.add(buildings);
        for(GameObject go : gameObjects) {
            if(go instanceof Buildings) {
                for(Building building : buildings) {
                    for(int i =0;i<3;i++) {
                        fire = new Fire(worldSize, building);
                        fires.add(fire);
                    }
                }
            }
        }
        gameObjects.add(fires);
        gameObjects.add(helicopter);
        helicopter.setFuel(FUEL);

        int count = 1;
        for(GameObject go : gameObjects) {
            if(go instanceof Buildings) {
                for(Fire fire : fires) {
                    System.err.println(count);
                    count++;
                }
            }
        }
    }

    public void tick() {
        helicopter.move();
        for(GameObject go: gameObjects) {
            if(go instanceof Fires) {
                for(Fire fire: fires) {
                    fire.growFire();
                }
            }
        }
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
                helicopter.slowDown();
                break;
            case -91:
                helicopter.speedUp();
                break;
            case -93:
                helicopter.steerLeft();
                break;
            case -94:
                helicopter.steerRight();
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

    public void exitApplication() {
        Display.getInstance().exitApplication();
    }

    public void decelerateHeli() {
        helicopter.slowDown();
    }

    public void accelerateHeli() {
        helicopter.speedUp();
    }

    public void steerLeft() {
        helicopter.steerLeft();
    }

    public void steerRight() {
        helicopter.steerRight();
    }

    public void drinkWater() {
        helicopter.drinkWater();
    }

    public void fightFire() {
        ArrayList<Fire> fires = new ArrayList<>();
        for (GameObject go: getGameObjectCollection()) {
            if(go instanceof Fire) {
                fires.add((Fire)go);
            }
        }
        helicopter.fightFire(fires);
    }
}
