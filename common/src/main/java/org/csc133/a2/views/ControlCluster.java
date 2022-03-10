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
    Button left, right, fight, exit, drink, brake, accelerate;
    Container leftCont, rightCont, fightCont, exitCont, drinkCont, brakeCont,
            accelCont;
    public ControlCluster(GameWorld gw) {
        this.gw = gw;

        this.getStyle().setBgColor(ColorUtil.rgb(255,255,255));
        this.getStyle().setBgTransparency(255);


        this.setLayout(new BorderLayout());
//        Form cluster = new Form(new BorderLayout());

//        ((BorderLayout)this.getLayout()).setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER)CENTER_BEHAVIOR_CENTER;
        leftCont = new Container(new BorderLayout());
        rightCont = new Container(new BorderLayout());
        fightCont = new Container(new BorderLayout());
        exitCont = new Container(new BorderLayout());
        drinkCont = new Container(new BorderLayout());
        brakeCont = new Container(new BorderLayout());
        accelCont = new Container(new BorderLayout());

        left = new Button("Left");
        right = new Button("Right");
        fight = new Button("Fight");
        exit = new Button("Exit");
        drink = new Button("Drink");
        brake = new Button("Brake");
        accelerate = new Button("Accel");
//        this.add(BorderLayout.WEST, left)
//                .add(BorderLayout.WEST, right)
//                .add(BorderLayout.WEST, fight)
//                .add(BorderLayout.CENTER, exit)
//                .add(BorderLayout.EAST, accelerate);
        leftCont.add(BorderLayout.WEST, left);
        leftCont.add(BorderLayout.CENTER, right);
        leftCont.add(BorderLayout.EAST, fight);
        exitCont.add(BorderLayout.CENTER, exit);
        rightCont.add(BorderLayout.WEST, drink);
        rightCont.add(BorderLayout.CENTER, brake);
        rightCont.add(BorderLayout.EAST, accelerate);
        this.add(BorderLayout.WEST, leftCont);
        this.add(BorderLayout.CENTER, exitCont);
        this.add(BorderLayout.EAST, rightCont);

    }

}
