package org.csc133.a2.views;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;

import javax.swing.border.Border;

public class ControlCluster extends Container {
    GameWorld gw;
    Button left, right, fight, exit, drink, brake, accelerate ;
    public ControlCluster(GameWorld gw) {
        this.gw = gw;

        this.getStyle().setBgColor(ColorUtil.rgb(255,255,255));
        this.getStyle().setBgTransparency(255);


        this.setLayout(new BorderLayout());
        Form cluster = new Form(new BorderLayout());

        ((BorderLayout)this.getLayout()).setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER);
        left = new Button("Left");
        right = new Button("Right");
        fight = new Button("Fight");
        exit = new Button("Exit");
        drink = new Button("Drink");
        brake = new Button("Brake");
        accelerate = new Button("Accel");
        this.add(BorderLayout.WEST, left)
                .add(BorderLayout.WEST, right)
                .add(BorderLayout.WEST, fight)
                .add(BorderLayout.CENTER, exit)
                .add(BorderLayout.EAST, accelerate);
//        this.add(BorderLayout.SOUTH, cluster);


    }

}
