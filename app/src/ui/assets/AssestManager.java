package ui.assets;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class AssetManager {
    public static Image loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (Exception e) {
            System.err.println("Missing image: " + path);
            return null;
        }
    }
}
