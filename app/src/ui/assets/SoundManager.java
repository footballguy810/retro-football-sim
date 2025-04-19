package ui.assets;

import javax.sound.sampled.*;
import java.io.File;
import java.util.HashMap;

public class SoundManager {
    private static final HashMap<String, Clip> soundClips = new HashMap<>();

    public static void play(String name) {
        try {
            Clip clip = getClip(name);
            clip.setFramePosition(0);
            clip.start();
        } catch (Exception e) {
            System.err.println("Sound failed: " + name);
        }
    }

    public static void loop(String name) {
        try {
            Clip clip = getClip(name);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println("Loop sound failed: " + name);
        }
    }

    public static void stop(String name) {
        Clip clip = soundClips.get(name);
        if (clip != null) clip.stop();
    }

    private static Clip getClip(String name) throws Exception {
        if (!soundClips.containsKey(name)) {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("res/sounds/" + name));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            soundClips.put(name, clip);
        }
        return soundClips.get(name);
    }
}
