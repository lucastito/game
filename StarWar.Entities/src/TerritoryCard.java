import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TerritoryCard {
	private String name;
	private short id;
	private BufferedImage frontImage;
	private BufferedImage backImage;

	public TerritoryCard(short id, String name,
			String pathOfTheBackgroundImage, String versePathOfImage) {
		this.id = id;
		this.name = name;
		try {
			this.frontImage = ImageIO
					.read(new File(getClass()
							.getResource(pathOfTheBackgroundImage).getPath()
							.toString()));
			this.backImage = ImageIO.read(new File(getClass()
					.getResource(versePathOfImage).getPath().toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public short getId() {
		return id;
	}

	public BufferedImage getFrontImage() {
		return frontImage;
	}

	public BufferedImage getBackImage() {
		return backImage;
	}
}
