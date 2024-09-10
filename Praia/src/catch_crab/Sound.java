package catch_crab;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

	private AudioClip clip; 
	
	public static final Sound music = new Sound("/hwi.wav");
	public static final Sound musi = new Sound("/mar.wav");
	public static final Sound apert = new Sound("/apert.wav");
	public static final Sound explo = new Sound("/explo.wav");
	
	private Sound(String name) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(name));
		}catch(Throwable e) {}
	}
	
	public void play() {
		try {
			new Thread() {
				public void run() {
					clip.play();
				}
			}.start();
		}catch(Throwable e) {}
	}
	public void loop() {
		try {
			new Thread() {
				public void run() {
					clip.loop();
				}
			}.start();
		}catch(Throwable e) {}
	}
}
