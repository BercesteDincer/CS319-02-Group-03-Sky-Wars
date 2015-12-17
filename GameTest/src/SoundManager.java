import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * SoundManager class is responsible from managing sound operations
 */
public class SoundManager {
	
	//CONSTANTS FOR SOUNDS
	public static int USER_PLANE_SHOT_SOUND = 0;
	public static  int TARGET_HIT_SOUND = 1;
	public static  int EXPLOSION_SOUND = 2;
	public static  int GAME_OVER_SOUND = 3;
	public static  int PASSED_LEVEL_SOUND = 4;
	public static int PRESENT_BONUS_PACKAGE_SOUND = 5;
	public static int TRAP_BONUS_PACKAGE_SOUND = 6;
	
	//Constructor
	public SoundManager(){
		
	}
	//Plays the sound with specified id
	public Clip playSound(int soundId){
		Clip clip = null;
		try {
			URL url;
	         // Open an audio input stream.
			if( soundId ==  USER_PLANE_SHOT_SOUND){
				 url = this.getClass().getClassLoader().getResource("userHitSound.wav");
			}
			else if( soundId ==  TARGET_HIT_SOUND){
				 url = this.getClass().getClassLoader().getResource("targetHitSound.wav");
			}
			else if( soundId ==  EXPLOSION_SOUND){
				 url = this.getClass().getClassLoader().getResource("explosionSound.wav");
			}
			else if( soundId ==  GAME_OVER_SOUND){
				 url = this.getClass().getClassLoader().getResource("failSound.wav");
			}
			else if( soundId == PASSED_LEVEL_SOUND){
				 url = this.getClass().getClassLoader().getResource("levelPassedSound.wav");
			}
			else if( soundId == PRESENT_BONUS_PACKAGE_SOUND){
				 url = this.getClass().getClassLoader().getResource("bonusPackageSound.wav");
			}
			else{
				url = this.getClass().getClassLoader().getResource("trapPackageSound.wav");
			}
	        
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		return clip;
	}
}
