import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectiveCard {
	private short id;
	private String name;
	private Planet[] planetsToConquer;
	private Planet[] planetsToDefend;
	private short planetsToChoose;
	private BufferedImage frontImage;
	private BufferedImage backImage;

	public ObjectiveCard(short id, String name, Planet[] planetsToConquer,
			Planet[] planetsToDefend, short planetsToChoose,
			String pathOfTheBackgroundImage, String versePathOfImage) {
		this.id = id;
		this.name = name;
		this.planetsToConquer = planetsToConquer;
		this.planetsToDefend = planetsToDefend;
		this.planetsToChoose = planetsToChoose;
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

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Planet[] getPlanetsToConquer() {
		return planetsToConquer;
	}

	public Planet[] getPlanetsToDefend() {
		return planetsToConquer;
	}

	public short getPlanetsToChoose() {
		return planetsToChoose;
	}

	public BufferedImage getFrontImage() {
		return frontImage;
	}

	public BufferedImage getBackImage() {
		return backImage;
	}
}