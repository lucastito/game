package Repositories;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import Domain.Planet;

public class PlanetRepository 
{
	private Map<String,Planet> planets;

	private Planet _trandosha;
	private Planet _naboo;
	private Planet _bakura;
	private Planet _calamari;
	private Planet _muunilist;
	private Planet _dantooine;
	private Planet _ilum;
	private Planet _sarapin;
	private Planet _eredennPrime;
	private Planet _coruscant;
	private Planet _yavinIV;
	private Planet _kamino;
	private Planet _corellia;
	private Planet _nelvaan;
	private Planet _rhenVar;
	private Planet _ando;
	private Planet _tynna;
	private Planet _syMyrth;
	private Planet _geonosis;
	private Planet _mustafar;
	private Planet _yagDhul;
	private Planet _hypori;
	private Planet _nivek;
	private Planet _tatooine;
	private Planet _pengalanIV;
	private Planet _thule;
	private Planet _queita;
	private Planet _raxus;
	private Planet _elrood;
	private Planet _danjar;
	private Planet _tantra;
	private Planet _sluis;
	private Planet _kashyyyk;
	private Planet _alarisPrime;
	
	public PlanetRepository()
	{
		planets = new HashMap<String, Planet>();
		try {
			_trandosha = new Planet((short) 1, "Trandosha", (short)20, (short)20, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_trandosha);
			
			_muunilist = new Planet((short) 2, "Muunilist", (short)90, (short)15, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_muunilist);
			
			_bakura = new Planet((short) 3, "Bakura", (short)160, (short)30, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_bakura);
			
			_calamari = new Planet((short) 4, "Calamari", (short)18, (short)90, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_calamari);
			
			_naboo = new Planet((short) 5, "Naboo", (short)100, (short)100, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_naboo);
			
			_dantooine = new Planet((short) 6, "Dantooine", (short)60, (short)170, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_dantooine);
			
			_ilum = new Planet((short) 7, "Ilum", (short)650, (short)25, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_ilum);
			
			_sarapin = new Planet((short) 8, "Sarapin", (short)580, (short)110, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_sarapin);
			
			_eredennPrime = new Planet((short) 9, "Eredeen Prime", (short)710, (short)100, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_eredennPrime);
			
			_coruscant = new Planet((short) 10, "Coruscant", (short)650, (short)290, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_coruscant);
			
			_yavinIV = new Planet((short) 11, "Yavin IV", (short)1115, (short)10, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_yavinIV);
			
			_kamino = new Planet((short) 12, "Kamino", (short)1270, (short)20, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_kamino);
			
			_corellia = new Planet((short) 13, "Corellia", (short)1200, (short)60, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_corellia);
			
			_nelvaan = new Planet((short) 14, "Nelvaan", (short)1125, (short)90, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_nelvaan);
			
			_rhenVar = new Planet((short) 15, "Rhen Var", (short)1265, (short)120, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_rhenVar);
			
			_ando = new Planet((short) 16, "Ando", (short)1195, (short)155, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_ando);
			
			_tynna = new Planet((short) 17, "Tynna", (short)130, (short)350, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_tynna);
			
			_syMyrth = new Planet((short) 18, "Sy Myrth", (short)1130, (short)300, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_syMyrth);
			
			_geonosis = new Planet((short) 19, "Geonosis", (short)30, (short)500, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_geonosis);
			
			_mustafar = new Planet((short) 20, "Mustafar", (short)5, (short)580, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_mustafar);
			
			_yagDhul = new Planet((short) 21, "Yag'Dhul", (short)85, (short)570, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_yagDhul);
			
			_hypori = new Planet((short) 22, "Hypori", (short)180, (short)575, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_hypori);
			
			_nivek = new Planet((short) 23, "Nivek", (short)50, (short) 650, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_nivek);
			
			_tatooine = new Planet((short) 24, "Tatooine", (short)140, (short)645, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_tatooine);
			
			_pengalanIV = new Planet((short) 25, "Pengalan IV", (short)700, (short)460, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_pengalanIV);
			
			_raxus = new Planet((short) 26, "Raxus", (short)560, (short)550, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_raxus);
			
			_queita = new Planet((short) 27, "Queita", (short)730, (short)580, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_queita);
			
			_thule = new Planet((short) 28, "Thule", (short)620, (short)630, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_thule);
			
			_elrood = new Planet((short) 29, "Elrood", (short)1105, (short)540, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_elrood);
			
			_danjar = new Planet((short) 30, "Danjar", (short)1175, (short)550, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_danjar);
			
			_tantra = new Planet((short) 31, "Tantra", (short)1235, (short)520, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_tantra);
			
			_sluis = new Planet((short) 32, "Sluis", (short)1085, (short)630, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_sluis);
			
			_kashyyyk = new Planet((short) 33, "Kashyyyk", (short)1180, (short)650, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_kashyyyk);
			
			_alarisPrime = new Planet((short) 34, "Alaris Prime", (short)1270, (short)590, ImageIO.read(new File("image/imgicon.png")));
			addPlanet(_alarisPrime);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void addPlanet(Planet pl){
		planets.put(pl.getName(), pl);
	}
	
	public Map<String, Planet> getPlanets() {
		return planets;
	}
	
	public Planet Trandosha()
	{
		return _trandosha;
	}
	
	public Planet Naboo()
	{
		return _naboo;
	}
	
	public Planet Bakura()
	{
		return _bakura;
	}
	
	public Planet Calamari()
	{
		return _calamari;
	}
	
	public Planet Muunilist()
	{
		return _muunilist;
	}
	
	public Planet Dantooine()
	{
		return _dantooine;
	}
	
	public Planet Ilum()
	{
		return _ilum;
	}
	
	public Planet Sarapin()
	{
		return _sarapin;
	}
	
	public Planet EredennPrime()
	{
		return _eredennPrime;
	}
	
	public Planet Coruscant()
	{
		return _coruscant;
	}
	
	public Planet YavinIV()
	{
		return _yavinIV;
	}
	
	public Planet Kamino()
	{
		return _kamino;
	}
	
	public Planet Corellia()
	{
		return _corellia;
	}
	
	public Planet Nelvaan()
	{
		return _nelvaan;
	}
	
	public Planet RhenVar()
	{
		return _rhenVar;
	}
	
	public Planet Ando()
	{
		return _ando;
	}
	
	public Planet Tynna()
	{
		return _tynna;
	}
	
	public Planet SyMyrth()
	{
		return _syMyrth;
	}
	
	public Planet Geonosis()
	{
		return _geonosis;
	}
	
	public Planet Mustafar()
	{
		return _mustafar;
	}
	
	public Planet YagDhul()
	{
		return _yagDhul;
	}
	
	public Planet Hypori()
	{
		return _hypori;
	}
	
	public Planet Nivek()
	{
		return _nivek;
	}
	
	public Planet Tatooine()
	{
		return _tatooine;
	}
	
	public Planet PengalanIV()
	{
		return _pengalanIV;
	}
	
	public Planet Thule()
	{
		return _thule;
	}
	
	public Planet Queita()
	{
		return _queita;
	}
	
	public Planet Raxus()
	{
		return _raxus;
	}
	
	public Planet Elrood()
	{
		return _elrood;
	}
	
	public Planet Danjar()
	{
		return _danjar;
	}
	
	public Planet Tantra()
	{
		return _tantra;
	}
	
	public Planet Sluis()
	{
		return _sluis;
	}
	
	public Planet Kashyyyk()
	{
		return _kashyyyk;
	}
	
	public Planet AlarisPrime()
	{
		return _alarisPrime;
	}
}
