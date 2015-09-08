package com.baddream.game.desktop;

import com.baddream.game.BadDream;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Bad Dream";
        config.width = 800;
        config.height = 600;
        config.resizable = false;
		new LwjglApplication(new BadDream(), config);
	}
}
