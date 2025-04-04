package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abrarcourcix;

	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abrarcourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abrarcourcix);
	}
	
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] chef =controlAfficherVillage.donnerNomsVillageois();
		assertSame(abrarcourcix, village.trouverHabitant(chef[0]));
		
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		
		controlEmmenager.ajouterGaulois("Asterix", 10);
		String[] gauloishabitans =controlAfficherVillage.donnerNomsVillageois();
		assertEquals("Asterix", gauloishabitans[1]);
		
		controlEmmenager.ajouterDruide("g", 10,10, 10);
		String[] gdruidehabitants =controlAfficherVillage.donnerNomsVillageois();
		System.out.println(gdruidehabitants[2]);
		assertEquals("le druide g", gdruidehabitants[2]);
		assertNotEquals("faux", gdruidehabitants[2]);
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String nomVillage = controlAfficherVillage.donnerNomVillage();
		assertEquals("le village des irréductibles", nomVillage);
		assertNotEquals("Faux", nomVillage);
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		int nbEtal = controlAfficherVillage.donnerNbEtals();
		assertEquals(5, nbEtal);
	}

}
