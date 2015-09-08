package com.baddream.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.baddream.game.BadDream;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Bad Dream";
        config.width = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
        config.height = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
		new LwjglApplication(new BadDream(), config);
	}
}
