package org.csc133.a2.gameobjects;

public class GameObject {
}
// use Dimension to encapsulate width and heights of objects

abstract class Fixed extends GameObject {

}

abstract class Moveable extends GameObject {
    void move(){

    }
}