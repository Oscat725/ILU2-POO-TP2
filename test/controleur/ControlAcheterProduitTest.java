package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abrarcourcix;
	
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abrarcourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abrarcourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit, "Le constructeur ne renvoie pas null");
	}

	@Test
	void testChercherVendeurs() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Bonemine", 10, 10, 10);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Bonemine", "Fleurs", 2);
		
		String[] vendeurs = controlAcheterProduit.chercherVendeurs("Rien");
		assertNull(vendeurs);
		
		String[] vendeurBon = controlAcheterProduit.chercherVendeurs("Fleurs");
		assertEquals("Bonemine", vendeurBon[0]);
	}

	@Test
	void testAcheteurApartient() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Bonemine", 10, 10, 10);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Bonemine", "Fleurs", 2);
		
		Boolean apartenir = controlAcheterProduit.acheteurApartient("Bonemine");
		assertTrue(apartenir);
		assertFalse(controlAcheterProduit.acheteurApartient("Asterix"));
		
	}

	@Test
	void testProduitMarche() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Bonemine", 10, 10, 10);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Bonemine", "Fleurs", 2);
		
		Boolean produit = controlAcheterProduit.produitMarche("Fleurs");
		assertTrue(produit);
		assertFalse(controlAcheterProduit.produitMarche("Rien"));
	}

	@Test
	void testQuantiteProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Bonemine", 10, 10, 10);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Bonemine", "Fleurs", 3);
		
		int quantite = controlAcheterProduit.quantiteProduit("Bonemine");
		assertEquals(3, quantite);
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Bonemine", 10, 10, 10);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Bonemine", "Fleurs", 3);
		
		int quantitevendu = controlAcheterProduit.acheterProduit("Bonemine", 1);
		assertEquals(1, quantitevendu);
		
		quantitevendu = controlAcheterProduit.acheterProduit("Bonemine", 3);
		assertEquals(2, quantitevendu);
		
		quantitevendu = controlAcheterProduit.acheterProduit("Bonemine", 2);
		assertEquals(0, quantitevendu);
		
		quantitevendu = controlAcheterProduit.acheterProduit("Personne", 2);
		assertEquals(0, quantitevendu);
	}

}
