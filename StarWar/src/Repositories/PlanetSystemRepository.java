package Repositories;

import Domain.Planet;
import Domain.PlanetSystem;

public class PlanetSystemRepository 
{
	private PlanetSystem _imperialRemnant;
	private PlanetSystem _vastEmpireSpace;
	private PlanetSystem _koornachtCluster;
	private PlanetSystem _tynnaSector;
	private PlanetSystem _syMyrthSector;
	private PlanetSystem _mawCluster;
	private PlanetSystem _pengalanIVSector;
	private PlanetSystem _wildSpace;
	private PlanetSystem _centrality;
		
	private PlanetRepository _planetRepository = new PlanetRepository();
	
	public PlanetSystemRepository()
	{
		InitializeImperialRemnant();
		InitializeVastEmpireSpace();
		InitializeKoornachtCluster();
		InitializeTynnaSector();
		InitializeSyMyrthSector();
		InitializeMawCluster();
		InitializePengalanIVSector();
		InitializeWildSpace();
		InitializeCentrality();		
	}	
	
	public PlanetSystem ImperialRemnant()
	{
		return _imperialRemnant;
	}
	
	public PlanetSystem VastEmpireSpace()
	{
		return _vastEmpireSpace;
	}
	
	public PlanetSystem KoornachtCluster()
	{
		return _koornachtCluster;
	}
	
	public PlanetSystem TynnaSector()
	{
		return _tynnaSector;
	}
	
	public PlanetSystem SyMyrthSector()
	{
		return _syMyrthSector;
	}
	
	public PlanetSystem MawCluster()
	{
		return _mawCluster;
	}
	
	public PlanetSystem PengalanIVSector()
	{
		return _pengalanIVSector;
	}
	
	public PlanetSystem WildSpace()
	{
		return _wildSpace;
	}
	
	public PlanetSystem Centrality()
	{
		return _centrality;
	}
	
	private void InitializeImperialRemnant() 
	{
		_imperialRemnant = new PlanetSystem();
		_imperialRemnant.Planets = new Planet[6];
		_imperialRemnant.Planets[0] = _planetRepository.Trandosha();
		_imperialRemnant.Planets[1] = _planetRepository.Naboo();
		_imperialRemnant.Planets[2] = _planetRepository.Bakura();
		_imperialRemnant.Planets[3] = _planetRepository.Calamari();
		_imperialRemnant.Planets[4] = _planetRepository.Muunilist();
		_imperialRemnant.Planets[5] = _planetRepository.Dantooine();		
	}
	
	private void InitializeVastEmpireSpace() 
	{
		_vastEmpireSpace = new PlanetSystem();
		_vastEmpireSpace.Planets = new Planet[4];
		_vastEmpireSpace.Planets[0] = _planetRepository.Ilum();
		_vastEmpireSpace.Planets[1] = _planetRepository.Sarapin();
		_vastEmpireSpace.Planets[2] = _planetRepository.EredennPrime();
		_vastEmpireSpace.Planets[3] = _planetRepository.Coruscant();
	}
	
	private void InitializeKoornachtCluster()
	{
		_koornachtCluster = new PlanetSystem();
		_koornachtCluster.Planets = new Planet[6];
		_koornachtCluster.Planets[0] = _planetRepository.YavinIV();
		_koornachtCluster.Planets[1] = _planetRepository.Kamino();
		_koornachtCluster.Planets[2] = _planetRepository.Corellia();
		_koornachtCluster.Planets[3] = _planetRepository.Nelvaan();
		_koornachtCluster.Planets[4] = _planetRepository.RhenVar();
		_koornachtCluster.Planets[5] = _planetRepository.Ando();		
	}
	
	private void InitializeTynnaSector()
	{
		_tynnaSector = new PlanetSystem();
		_tynnaSector.Planets = new Planet[1];
		_tynnaSector.Planets[0] = _planetRepository.Tynna();
	}
	
	private void InitializeSyMyrthSector()
	{
		_syMyrthSector = new PlanetSystem();
		_syMyrthSector.Planets = new Planet[1];
		_syMyrthSector.Planets[0] = _planetRepository.SyMyrth();
	}
	
	private void InitializeMawCluster()
	{
		_mawCluster = new PlanetSystem();
		_mawCluster.Planets = new Planet[6];
		_mawCluster.Planets[0] = _planetRepository.Geonosis();
		_mawCluster.Planets[1] = _planetRepository.Mustafar();
		_mawCluster.Planets[2] = _planetRepository.YagDhul();
		_mawCluster.Planets[3] = _planetRepository.Hypori();
		_mawCluster.Planets[4] = _planetRepository.Nivek();
		_mawCluster.Planets[5] = _planetRepository.Tatooine();
	}
	
	private void InitializePengalanIVSector()
	{
		_pengalanIVSector = new PlanetSystem();
		_pengalanIVSector.Planets = new Planet[1];
		_pengalanIVSector.Planets[0] = _planetRepository.PengalanIV();
	}
	
	private void InitializeWildSpace()
	{
		_wildSpace = new PlanetSystem();
		_wildSpace.Planets = new Planet[3];
		_wildSpace.Planets[0] = _planetRepository.Thule();
		_wildSpace.Planets[1] = _planetRepository.Queita();
		_wildSpace.Planets[2] = _planetRepository.Raxus();
	}
	
	private void InitializeCentrality()
	{
		_centrality = new PlanetSystem();
		_centrality.Planets = new Planet[6];
		_centrality.Planets[0] = _planetRepository.Elrood();
		_centrality.Planets[1] = _planetRepository.Danjar();
		_centrality.Planets[2] = _planetRepository.Tantra();
		_centrality.Planets[3] = _planetRepository.Sluis();
		_centrality.Planets[4] = _planetRepository.Kashyyyk();
		_centrality.Planets[5] = _planetRepository.AlarisPrime();
	}
}
