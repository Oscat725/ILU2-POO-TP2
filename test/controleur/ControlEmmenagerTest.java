package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
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
	void testControlEmmenager() {
		ControlEmmenager controlEmenager = new ControlEmmenager(village);
		assertNotNull(controlEmenager, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertTrue(controlEmmenager.isHabitant("Abraracourcix"));
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertNotNull(village.trouverHabitant("Panoramix"));
		assertTrue(controlEmmenager.isHabitant("Panoramix"));

	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertNotNull(village.trouverHabitant("Bonemine"));
	}
	
	@Test
	void testTrophabitants() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		for (int j = 0; j < 10; j++) {
			controlEmmenager.ajouterGaulois(""+j, 10);
		}
		controlEmmenager.ajouterGaulois("11", 10);
		assertFalse(controlEmmenager.isHabitant("11"));
	}

}
