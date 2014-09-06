package Repositories;

import Domain.Planet;

public class PlanetRepository 
{
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
		_trandosha = new Planet();
		_trandosha.Id = 1;
		_trandosha.Name = "Trandosha";
		
		_naboo = new Planet();
		_naboo.Id = 2;
		_naboo.Name = "Naboo";
		
		_bakura = new Planet();
		_bakura.Id = 3;
		_bakura.Name = "Bakura";
		
		_calamari = new Planet();
		_calamari.Id = 4;
		_calamari.Name = "Calamari";
		
		_muunilist = new Planet();
		_muunilist.Id = 5;
		_muunilist.Name = "Muunilist";
		
		_dantooine = new Planet();
		_dantooine.Id = 6;
		_dantooine.Name = "Dantooine";
		
		_ilum = new Planet();
		_ilum.Id = 7;
		_ilum.Name = "Ilum";	
		
		_sarapin = new Planet();
		_sarapin.Id = 8;
		_sarapin.Name = "Sarapin";
		
		_eredennPrime = new Planet();
		_eredennPrime.Id = 9;
		_eredennPrime.Name = "Eredeen Prime";
		
		_coruscant = new Planet();
		_coruscant.Id = 10;
		_coruscant.Name = "Coruscant";
		
		_yavinIV = new Planet();
		_yavinIV.Id = 11;
		_yavinIV.Name = "Yavin IV";
		
		_kamino = new Planet();
		_kamino.Id = 12;
		_kamino.Name = "Kamino";
		
		_corellia = new Planet();
		_corellia.Id = 13;
		_corellia.Name = "Corellia";
		
		_nelvaan = new Planet();
		_nelvaan.Id = 14;
		_nelvaan.Name = "Nelvaan";
		
		_rhenVar = new Planet();
		_rhenVar.Id = 15;
		_rhenVar.Name = "Rhen Var";
		
		_ando = new Planet();
		_ando.Id = 16;
		_ando.Name = "Ando";
		
		_tynna = new Planet();
		_tynna.Id = 17;
		_tynna.Name = "Tynna";
		
		_syMyrth = new Planet();
		_syMyrth.Id = 18;
		_syMyrth.Name = "Sy Myrth";
		
		_geonosis = new Planet();
		_geonosis.Id = 19;
		_geonosis.Name = "Geonosis";
		
		_mustafar = new Planet();
		_mustafar.Id = 20;
		_mustafar.Name = "Mustafar";
		
		_yagDhul = new Planet();
		_yagDhul.Id = 21;
		_yagDhul.Name = "Yag'Dhul";
		
		_hypori = new Planet();
		_hypori.Id = 22;
		_hypori.Name = "Hypori";
		
		_nivek = new Planet();
		_nivek.Id = 23;
		_nivek.Name = "Nivek";
		
		_tatooine = new Planet();
		_tatooine.Id = 24;
		_tatooine.Name = "Tatooine";
		
		_pengalanIV = new Planet();
		_pengalanIV.Id = 25;
		_pengalanIV.Name = "Pengalan IV";
		
		_thule = new Planet();
		_thule.Id = 26;
		_thule.Name = "Thule";
		
		_queita = new Planet();
		_queita.Id = 27;
		_queita.Name = "Queita";
		
		_raxus = new Planet();
		_raxus.Id = 28;
		_raxus.Name = "Raxus";
		
		_elrood = new Planet();
		_elrood.Id = 29;
		_elrood.Name = "Elrood";
		
		_danjar = new Planet();
		_danjar.Id = 30;
		_danjar.Name = "Danjar";
		
		_tantra = new Planet();
		_tantra.Id = 31;
		_tantra.Name = "Tantra";
		
		_sluis = new Planet();
		_sluis.Id = 32;
		_sluis.Name = "Sluis";
		
		_kashyyyk = new Planet();
		_kashyyyk.Id = 33;
		_kashyyyk.Name = "Kashyyyk";
		
		_alarisPrime = new Planet();
		_alarisPrime.Id = 34;
		_alarisPrime.Name = "Alaris Prime";
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
