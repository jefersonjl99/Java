package graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player;
	
	public static void init()
	{
		player = Loader.ImageLoader("/recursos/lupin-png-png-image-lupin-png-300_393 (1).png");
	}
	
}