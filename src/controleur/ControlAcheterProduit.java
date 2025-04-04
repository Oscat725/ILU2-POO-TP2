package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	@SuppressWarnings("null")
	public String[] chercherVendeurs(String produit) {
		String[] vendeurs = null;
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
		if (gaulois != null) {
			vendeurs = new String[gaulois.length];
			for (int i = 0; i < gaulois.length; i++) {
				Gaulois gaulois2 = gaulois[i];
				vendeurs[i]=gaulois2.getNom();
			}
		}
		return vendeurs;
	}

	public Boolean acheteurApartient(String nomAcheteur) {
		Boolean appartient = controlVerifierIdentite.verifierIdentite(nomAcheteur);
		return appartient;
	}

	public Boolean produitMarche(String produit) {
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
		return gaulois!=null;
	}

	public int quantiteProduit(String vendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		return etal.getQuantite();
	}

	public int acheterProduit(String vendeur, int quantite) {
		Gaulois gaulois = village.trouverHabitant(vendeur);
		if (gaulois != null) {
			Etal etal= village.rechercherEtal(gaulois);
			return etal.acheterProduit(quantite);
		}
		return 0;
	}

}
