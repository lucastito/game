package Repositories;

import Domain.Planet;
import Domain.PlanetSystem;

public class PlanetSystemRepository {
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

	public PlanetSystemRepository() {
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

	public PlanetSystem ImperialRemnant() {
		return _imperialRemnant;
	}

	public PlanetSystem VastEmpireSpace() {
		return _vastEmpireSpace;
	}

	public PlanetSystem KoornachtCluster() {
		return _koornachtCluster;
	}

	public PlanetSystem TynnaSector() {
		return _tynnaSector;
	}

	public PlanetSystem SyMyrthSector() {
		return _syMyrthSector;
	}

	public PlanetSystem MawCluster() {
		return _mawCluster;
	}

	public PlanetSystem PengalanIVSector() {
		return _pengalanIVSector;
	}

	public PlanetSystem WildSpace() {
		return _wildSpace;
	}

	public PlanetSystem Centrality() {
		return _centrality;
	}

	private void InitializeImperialRemnant() {
		_imperialRemnant = new PlanetSystem();
		Planet[] planets = new Planet[6];
		planets[0] = _planetRepository.Trandosha();
		planets[1] = _planetRepository.Naboo();
		planets[2] = _planetRepository.Bakura();
		planets[3] = _planetRepository.Calamari();
		planets[4] = _planetRepository.Muunilist();
		planets[5] = _planetRepository.Dantooine();
		_imperialRemnant.setPlanets(planets);
	}

	private void InitializeVastEmpireSpace() {
		_vastEmpireSpace = new PlanetSystem();
		Planet[] planets = new Planet[4];
		planets[0] = _planetRepository.Ilum();
		planets[1] = _planetRepository.Sarapin();
		planets[2] = _planetRepository.EredennPrime();
		planets[3] = _planetRepository.Coruscant();
		_vastEmpireSpace.setPlanets(planets);
	}

	private void InitializeKoornachtCluster() {
		_koornachtCluster = new PlanetSystem();
		Planet[] planets = new Planet[6];
		planets[0] = _planetRepository.YavinIV();
		planets[1] = _planetRepository.Kamino();
		planets[2] = _planetRepository.Corellia();
		planets[3] = _planetRepository.Nelvaan();
		planets[4] = _planetRepository.RhenVar();
		planets[5] = _planetRepository.Ando();
		_koornachtCluster.setPlanets(planets);
	}

	private void InitializeTynnaSector() {
		_tynnaSector = new PlanetSystem();
		Planet[] planets = new Planet[1];
		planets[0] = _planetRepository.Tynna();
		_tynnaSector.setPlanets(planets);
	}

	private void InitializeSyMyrthSector() {
		_syMyrthSector = new PlanetSystem();
		Planet[] planets = new Planet[1];
		planets[0] = _planetRepository.SyMyrth();
		_syMyrthSector.setPlanets(planets);
	}

	private void InitializeMawCluster() {
		_mawCluster = new PlanetSystem();
		Planet[] planets = new Planet[6];
		planets[0] = _planetRepository.Geonosis();
		planets[1] = _planetRepository.Mustafar();
		planets[2] = _planetRepository.YagDhul();
		planets[3] = _planetRepository.Hypori();
		planets[4] = _planetRepository.Nivek();
		planets[5] = _planetRepository.Tatooine();
		_mawCluster.setPlanets(planets);
	}

	private void InitializePengalanIVSector() {
		_pengalanIVSector = new PlanetSystem();
		Planet[] planets = new Planet[1];
		planets[0] = _planetRepository.PengalanIV();
		_pengalanIVSector.setPlanets(planets);
	}

	private void InitializeWildSpace() {
		_wildSpace = new PlanetSystem();
		Planet[] planets = new Planet[3];
		planets[0] = _planetRepository.Thule();
		planets[1] = _planetRepository.Queita();
		planets[2] = _planetRepository.Raxus();
		_wildSpace.setPlanets(planets);
	}

	private void InitializeCentrality() {
		_centrality = new PlanetSystem();
		Planet[] planets = new Planet[6];
		planets[0] = _planetRepository.Elrood();
		planets[1] = _planetRepository.Danjar();
		planets[2] = _planetRepository.Tantra();
		planets[3] = _planetRepository.Sluis();
		planets[4] = _planetRepository.Kashyyyk();
		planets[5] = _planetRepository.AlarisPrime();
		_centrality.setPlanets(planets);
	}
}
