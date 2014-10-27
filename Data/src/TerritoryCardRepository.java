import java.util.HashSet;
import java.util.Set;

public class TerritoryCardRepository implements ITerritoryCardRepository {
	private Set<TerritoryCard> territoryCards;

	public TerritoryCardRepository() {
	TerritoryCard alarisPrime = new TerritoryCard((short)34, "Alaris Prime", "image/Alaris Prime.png", "image/Verse.png");
territoryCards.add(alarisPrime);
	TerritoryCard ando = new TerritoryCard((short)16, "Ando", "image/Ando.png", "image/Verse.png");
territoryCards.add(ando);
	TerritoryCard bakura = new TerritoryCard((short)3, "Bakura", "image/Bakura.png", "image/Verse.png");
territoryCards.add(bakura);
	TerritoryCard calamari = new TerritoryCard((short)4, "Calamari", "image/Calamari.png", "image/Verse.png");
territoryCards.add(calamari);
	TerritoryCard corellia = new TerritoryCard((short)13, "Corellia", "image/Corellia.png", "image/Verse.png");
territoryCards.add(corellia);
	TerritoryCard coruscant = new TerritoryCard((short)10, "Coruscant", "image/Coruscant.png", "image/Verse.png");
territoryCards.add(coruscant);
	TerritoryCard danjar = new TerritoryCard((short)30, "Danjar", "image/Danjar.png", "image/Verse.png");
territoryCards.add(danjar);
	TerritoryCard dantooine = new TerritoryCard((short)6, "Dantooine", "image/Dantooine.png", "image/Verse.png");
territoryCards.add(dantooine);
	TerritoryCard elrood = new TerritoryCard((short)29, "ElRood", "image/ElRood.png", "image/Verse.png");
territoryCards.add(elrood);
	TerritoryCard eredennPrime = new TerritoryCard((short)9, "Eredenn Prime", "image/Eredenn Prime.png", "image/Verse.png");
territoryCards.add(eredennPrime);
	TerritoryCard geonosis = new TerritoryCard((short)19, "Geonosis", "image/Geonosis.png", "image/Verse.png");
territoryCards.add(geonosis);
	TerritoryCard hypori = new TerritoryCard((short)22, "Hypori", "image/Hypori.png", "image/Verse.png");
territoryCards.add(hypori);
	TerritoryCard ilum = new TerritoryCard((short)7, "Ilum", "image/Ilum.png", "image/Verse.png");
territoryCards.add(ilum);
	TerritoryCard kamino = new TerritoryCard((short)12, "Kamino", "image/Kamino.png", "image/Verse.png");
territoryCards.add(kamino);
	TerritoryCard kashyyyk = new TerritoryCard((short)33, "Kashyyyk", "image/Kashyyyk.png", "image/Verse.png");
territoryCards.add(kashyyyk);
	TerritoryCard mustafar = new TerritoryCard((short)20, "Mustafar", "image/Mustafar.png", "image/Verse.png");
territoryCards.add(mustafar);
	TerritoryCard muunlist = new TerritoryCard((short)2, "Muunlist", "image/Muunlist.png", "image/Verse.png");
territoryCards.add(muunlist);
	TerritoryCard naboo = new TerritoryCard((short)5, "Naboo", "image/Naboo.png", "image/Verse.png");
territoryCards.add(naboo);
	TerritoryCard nelvaan = new TerritoryCard((short)14, "Nelvaan", "image/Nelvaan.png", "image/Verse.png");
territoryCards.add(nelvaan);
	TerritoryCard nivek = new TerritoryCard((short)23, "Nivek", "image/Nivek.png", "image/Verse.png");
territoryCards.add(nivek);
	TerritoryCard pengalanIV = new TerritoryCard((short)25, "Pengalan IV", "image/Pengalan IV.png", "image/Verse.png");
territoryCards.add(pengalanIV);
	TerritoryCard queita = new TerritoryCard((short)27, "Queita", "image/Queita.png", "image/Verse.png");
territoryCards.add(queita);
	TerritoryCard raxus = new TerritoryCard((short)26, "Raxus", "image/Raxus.png", "image/Verse.png");
territoryCards.add(raxus);
	TerritoryCard rhenVar = new TerritoryCard((short)15, "Rhen Var", "image/Rhen Var.png", "image/Verse.png");
territoryCards.add(rhenVar);
	TerritoryCard sarapin = new TerritoryCard((short)8, "Sarapin", "image/Sarapin.png", "image/Verse.png");
territoryCards.add(sarapin);
	TerritoryCard sluis = new TerritoryCard((short)32, "Sluis", "image/Sluis.png", "image/Verse.png");
territoryCards.add(sluis);
	TerritoryCard syMyrth = new TerritoryCard((short)18, "Sy Myrth", "image/Sy Myrth.png", "image/Verse.png");
territoryCards.add(syMyrth);
	TerritoryCard tantra = new TerritoryCard((short)31, "Tantra", "image/Tantra.png", "image/Verse.png");
territoryCards.add(tantra);
	TerritoryCard tatooine = new TerritoryCard((short)24, "Tatooine", "image/Tatooine.png", "image/Verse.png");
territoryCards.add(tatooine);
	TerritoryCard thule = new TerritoryCard((short)28, "Thule", "image/Thule.png", "image/Verse.png");
territoryCards.add(thule);
	TerritoryCard trandosha = new TerritoryCard((short)1, "Trandosha", "image/Trandosha.png", "image/Verse.png");
territoryCards.add(trandosha);
	TerritoryCard tynna = new TerritoryCard((short)17, "Tynna", "image/Tynna.png", "image/Verse.png");
territoryCards.add(tynna);
	TerritoryCard yagDhul = new TerritoryCard((short)21, "Yag'Dhul", "image/Yag'Dhul.png", "image/Verse.png");
territoryCards.add(yagDhul);
	TerritoryCard yavinIV = new TerritoryCard((short)11, "Yavin IV", "image/Yavin IV.png", "image/Verse.png");
territoryCards.add(yavinIV);
	this.territoryCards = new HashSet<TerritoryCard>();
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

}
