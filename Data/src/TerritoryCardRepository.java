import java.util.HashSet;
import java.util.Set;

public class TerritoryCardRepository implements ITerritoryCardRepository {
	private Set<TerritoryCard> territoryCards;

	public TerritoryCardRepository() {
		territoryCards = new HashSet<TerritoryCard>();

		TerritoryCard alarisPrime = new TerritoryCard((short) 34,
				"Alaris Prime", "image/territorios/AlarisPrime.png",
				"image/territorios/Verse.png");
		territoryCards.add(alarisPrime);
		TerritoryCard ando = new TerritoryCard((short) 16, "Ando",
				"image/territorios/Ando.png", "image/territorios/Verse.png");
		territoryCards.add(ando);
		TerritoryCard bakura = new TerritoryCard((short) 3, "Bakura",
				"image/territorios/Bakura.png", "image/territorios/Verse.png");
		territoryCards.add(bakura);
		TerritoryCard calamari = new TerritoryCard((short) 4, "Calamari",
				"image/territorios/Calamari.png", "image/territorios/Verse.png");
		territoryCards.add(calamari);
		TerritoryCard corellia = new TerritoryCard((short) 13, "Corellia",
				"image/territorios/Corellia.png", "image/territorios/Verse.png");
		territoryCards.add(corellia);
		TerritoryCard coruscant = new TerritoryCard((short) 10, "Coruscant",
				"image/territorios/Coruscant.png",
				"image/territorios/Verse.png");
		territoryCards.add(coruscant);
		TerritoryCard danjar = new TerritoryCard((short) 30, "Danjar",
				"image/territorios/Danjar.png", "image/territorios/Verse.png");
		territoryCards.add(danjar);
		TerritoryCard dantooine = new TerritoryCard((short) 6, "Dantooine",
				"image/territorios/Dantooine.png",
				"image/territorios/Verse.png");
		territoryCards.add(dantooine);
		TerritoryCard elrood = new TerritoryCard((short) 29, "ElRood",
				"image/territorios/ElRood.png", "image/territorios/Verse.png");
		territoryCards.add(elrood);
		TerritoryCard eredennPrime = new TerritoryCard((short) 9,
				"Eredenn Prime", "image/territorios/EredeenPrime.png",
				"image/territorios/Verse.png");
		territoryCards.add(eredennPrime);
		TerritoryCard geonosis = new TerritoryCard((short) 19, "Geonosis",
				"image/territorios/Geonosis.png", "image/territorios/Verse.png");
		territoryCards.add(geonosis);
		TerritoryCard hypori = new TerritoryCard((short) 22, "Hypori",
				"image/territorios/Hypori.png", "image/territorios/Verse.png");
		territoryCards.add(hypori);
		TerritoryCard ilum = new TerritoryCard((short) 7, "Ilum",
				"image/territorios/Ilum.png", "image/territorios/Verse.png");
		territoryCards.add(ilum);
		TerritoryCard kamino = new TerritoryCard((short) 12, "Kamino",
				"image/territorios/Kamino.png", "image/territorios/Verse.png");
		territoryCards.add(kamino);
		TerritoryCard kashyyyk = new TerritoryCard((short) 33, "Kashyyyk",
				"image/territorios/Kashyyyk.png", "image/territorios/Verse.png");
		territoryCards.add(kashyyyk);
		TerritoryCard mustafar = new TerritoryCard((short) 20, "Mustafar",
				"image/territorios/Mustafar.png", "image/territorios/Verse.png");
		territoryCards.add(mustafar);
		TerritoryCard muunlist = new TerritoryCard((short) 2, "Muunlist",
				"image/territorios/muunilist.png",
				"image/territorios/Verse.png");
		territoryCards.add(muunlist);
		TerritoryCard naboo = new TerritoryCard((short) 5, "Naboo",
				"image/territorios/Naboo.png", "image/territorios/Verse.png");
		territoryCards.add(naboo);
		TerritoryCard nelvaan = new TerritoryCard((short) 14, "Nelvaan",
				"image/territorios/Nelvaan.png", "image/territorios/Verse.png");
		territoryCards.add(nelvaan);
		TerritoryCard nivek = new TerritoryCard((short) 23, "Nivek",
				"image/territorios/Nivek.png", "image/territorios/Verse.png");
		territoryCards.add(nivek);
		TerritoryCard pengalanIV = new TerritoryCard((short) 25, "Pengalan IV",
				"image/territorios/PengalanIV.png",
				"image/territorios/Verse.png");
		territoryCards.add(pengalanIV);
		TerritoryCard queita = new TerritoryCard((short) 27, "Queita",
				"image/territorios/Queita.png", "image/territorios/Verse.png");
		territoryCards.add(queita);
		TerritoryCard raxus = new TerritoryCard((short) 26, "Raxus",
				"image/territorios/Raxus.png", "image/territorios/Verse.png");
		territoryCards.add(raxus);
		TerritoryCard rhenVar = new TerritoryCard((short) 15, "Rhen Var",
				"image/territorios/rhenvar.png", "image/territorios/Verse.png");
		territoryCards.add(rhenVar);
		TerritoryCard sarapin = new TerritoryCard((short) 8, "Sarapin",
				"image/territorios/Sarapin.png", "image/territorios/Verse.png");
		territoryCards.add(sarapin);
		TerritoryCard sluis = new TerritoryCard((short) 32, "Sluis",
				"image/territorios/Sluis.png", "image/territorios/Verse.png");
		territoryCards.add(sluis);
		TerritoryCard syMyrth = new TerritoryCard((short) 18, "Sy Myrth",
				"image/territorios/symyrth.png", "image/territorios/Verse.png");
		territoryCards.add(syMyrth);
		TerritoryCard tantra = new TerritoryCard((short) 31, "Tantra",
				"image/territorios/Tantra.png", "image/territorios/Verse.png");
		territoryCards.add(tantra);
		TerritoryCard tatooine = new TerritoryCard((short) 24, "Tatooine",
				"image/territorios/Tatooine.png", "image/territorios/Verse.png");
		territoryCards.add(tatooine);
		TerritoryCard thule = new TerritoryCard((short) 28, "Thule",
				"image/territorios/Thule.png", "image/territorios/Verse.png");
		territoryCards.add(thule);
		TerritoryCard trandosha = new TerritoryCard((short) 1, "Trandosha",
				"image/territorios/Trandosha.png",
				"image/territorios/Verse.png");
		territoryCards.add(trandosha);
		TerritoryCard tynna = new TerritoryCard((short) 17, "Tynna",
				"image/territorios/Tynna.png", "image/territorios/Verse.png");
		territoryCards.add(tynna);
		TerritoryCard yagDhul = new TerritoryCard((short) 21, "Yag'Dhul",
				"image/territorios/Yag'Dhul.png", "image/territorios/Verse.png");
		territoryCards.add(yagDhul);
		TerritoryCard yavinIV = new TerritoryCard((short) 11, "Yavin IV",
				"image/territorios/Yavin.png", "image/territorios/Verse.png");
		territoryCards.add(yavinIV);

		War.getInstance().setTerritoryCards(territoryCards);
	}

	@Override
	public TerritoryCard getTerritoryCardByName(String name) {
		for (TerritoryCard card : territoryCards) {
			if (card.getName().equals(name)) {
				return card;
			}
		}
		return null;
	}

	public int getTerritoryCardAmount() {
		return territoryCards.size();
	}

}
