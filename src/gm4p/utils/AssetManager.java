package gm4p.utils;
import java.io.File;
import java.util.HashMap;

import gm4p.GM;
import processing.core.*;

public class AssetManager {

	HashMap<String, PImage> images;
	HashMap<String, PImage> sounds;
	HashMap<String, char[][]> pixelCache;
	PApplet p;

	// Constructor
	public AssetManager(PApplet applet) {
		p = applet;
		images = new HashMap<>();
        pixelCache = new HashMap<>();
		loadAllImages("");

		GM.debugMessage("AssetManager created:" + this.toString());
	}

	void addImage(String imageFileName, String subDir) {
        String imageLocation = "./" + (subDir.isEmpty() ? "" : (subDir + "/")),
                imageKey = subDir + (subDir.isEmpty() ? "" : "_") + imageFileName;

		PImage newImage = GM.p.loadImage(imageLocation + imageFileName);


		images.put(imageKey, newImage);

		newImage.loadPixels();
		char alphaCache[][] = new char[newImage.width][newImage.height];
		for (int iX=0; iX<newImage.width; iX++)
			for (int iY = 0; iY < newImage.height; iY++) {
                alphaCache[iX][iY] = (char) (newImage.pixels[iY * newImage.width + iX] >> 24);
            }

        pixelCache.put(imageKey, alphaCache);
	}

	public PImage get(String imageName) throws Exception {
		if (images.containsKey(imageName)) 
			return images.get(imageName);

		throw (new Exception("Image key not found: " + imageName));

	}

    public char[][] getPixelCache(String imageName){
        if (pixelCache.containsKey(imageName))
            return pixelCache.get(imageName);

        return null;
    }

	void loadAllImages( String subDir) {

		String imagePath = p.dataPath(subDir);
		GM.debugMessage("Importing assets from: " + imagePath);

		File dataFolder = new File(imagePath);
		File [] files = dataFolder.listFiles();

		for (File file : files) {
			if (file.isDirectory())
				loadAllImages(file.getName());

			if (file.getName().toLowerCase().endsWith(".png"))
				addImage(file.getName(), subDir);
		}
	}
}
