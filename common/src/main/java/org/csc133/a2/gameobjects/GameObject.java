package org.csc133.a2.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.interfaces.Drawable;

public abstract class GameObject implements Drawable {
    int color;
    Dimension dimension;
    Dimension worldSize;

    public String toString() {
        return this.getClass().getSimpleName();
    }
}

