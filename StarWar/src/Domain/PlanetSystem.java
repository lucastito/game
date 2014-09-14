package Domain;

public class PlanetSystem 
{
	public short Id;
	public Planet[] Planets;
	public Border[] InternalBorders;
	
	
	PlanetSystem(){
		
	}
	
	public Planet[] getPlanets(){
		return this.Planets;
	}
}
