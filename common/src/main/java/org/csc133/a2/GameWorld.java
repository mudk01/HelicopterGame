package org.csc133.a2;

import com.codename1.ui.Dialog;
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
    private Fires fires, deadFires;
    private Buildings buildings;
    private final int FUEL = 25000;
    private int fireArea, area, initArea;
    private int tickCount;
    private ArrayList<Integer> initialAreas;

    private static GameWorld gameWorld;

    private GameWorld() {}

    public static GameWorld getInstance() {
        gameWorld = new GameWorld();
        gameWorld.worldSize = new Dimension();
        return gameWorld;
    }

    public void init() {
        tickCount = 0;
        initialAreas = new ArrayList<>();
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
        deadFires = new Fires();
        buildings = new Buildings();
        buildings.add(buildingLeft);
        buildings.add(buildingRight);
        buildings.add(buildingTop);
        gameObjects.add(river);
        gameObjects.add(helipad);
        gameObjects.add(buildings);
        fireArea = 1000;
        area = 0;
        createFiresInBuilding();
        checkFireBudget();
        gameObjects.add(fires);
        gameObjects.add(helicopter);
        helicopter.setFuel(FUEL);
    }

    public void tick() {
        int counti = 0;
        for(GameObject go : gameObjects) {
            if(go instanceof Buildings) {
                for(Building b : buildings) {
                    int damage = 0;
                    for(Fire fire : b.getFires()) {
                        damage += fire.getArea();
                    }
                    System.err.println("damage at building " + counti + "is: " + (damage-initialAreas.get(counti))/b.getValue());
                    b.setDamage(((damage-initialAreas.get(counti))/b.getValue()));
                    counti++;
                }
            }
        }
        helicopter.move();
        int fireCount = 0;
        int chosenFire = new Random().nextInt(getFireCount());
        for(GameObject go: gameObjects) {
            if(go instanceof Fires) {
                for (Fire fire : fires) {
                    if (chosenFire == fireCount) {
                        fire.growFire();
                    }
                    fireCount++;
                    if (helicopter.checkFireCollision(fire)) {
                        fire.setTrue();
                    } else {
                        fire.setFalse();
                    }
                    if (fire.getSize() <= 0) {
                        fire.extinguishFire();
                        deadFires.add(fire);
                    }
                }
            }
        }
        fires.getGameObjects().removeAll(deadFires.getGameObjects());
        if(getFireCount() == 0 && helicopter.isOnPad()) {
            gameWon();
        }
        helicopter.checkRiverCollision(river.getLocation(), river.getWidth(),
                river.getHeight());
        if(helicopter.checkFuel()) {
            endGame();
        }
        tickCount++;
    }

    private void createFiresInBuilding(){
        for(GameObject go : gameObjects) {
            if(go instanceof Buildings) {
                for(Building building : buildings) {
                    int randomFiresInBuilding = new Random().nextInt(2) + 2;
                    for(int i =0;i<randomFiresInBuilding;i++) {
                        int size =
                                new Random().nextInt(4) + 10;
                        fire = new Fire(worldSize, size);
                        area += fire.getArea();
                        fires.add(fire);
                        building.setFires(fire);
                        fire.setFire(building);
                    }
                    getInitialArea(area);
                }
            }
        }
    }

    private void getInitialArea(int area) {
        initialAreas.add(area);
    }

    private void checkFireBudget() {
        for(GameObject go : gameObjects) {
            if(go instanceof Buildings) {
                for(Building building: buildings) {
                    if(area != fireArea) {
                        int remSize =
                                (int)Math.sqrt(Math.ceil((fireArea - area)/Math.PI)) * 2;
                        fire = new Fire(worldSize, remSize);
                        fires.add(fire);
                        building.setFires(fire);
                        fire.setFire(building);
                        area+=fire.getArea();
                    }
                }
            }
        }
    }

    private void gameWon() {
        if(Dialog.show("Congratulations!",
                "You put out all the fires!\n Score: "+helicopter.getFuel(),
                "Replay", "Exit")) {
            init();
        }
        else {
            Display.getInstance().exitApplication();
        }
    }

    private void endGame() {
        if(Dialog.show("Game Over", "You ran out of fuel",
                "Replay", "Exit")) {
            init();
        }
        else {
            Display.getInstance().exitApplication();
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
        helicopter.fightFire(fires);
        helicopter.dropWater();
    }

    public int getFireCount() {
        return fires.getSize();
    }
}
