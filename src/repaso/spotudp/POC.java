package repaso.spotudp;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class POC {

	public static void main(String[] args){
		MakeSound speaker = new MakeSound();
		// Debe ser ruta absoluta
		String file = "D:\\JorgeDL\\MP3\\africa-toto.wav";
		speaker.playSound(file);
	}
}
