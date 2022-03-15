package org.csc133.a2.commands;

import com.codename1.ui.Command;
import org.csc133.a2.GameWorld;
import java.awt.event.ActionEvent;

public class ExitCommand extends Command {
    private GameWorld gw;

    public ExitCommand(GameWorld gw) {
        super("Exit");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        gw.exitApplication();
    }
}
