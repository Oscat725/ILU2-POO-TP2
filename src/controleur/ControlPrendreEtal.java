package controleur;

import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		boolean etalDisponible = village.rechercherEtalVide()
;		return etalDisponible;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		int numeroEtal = -1;
		numeroEtal =village.installerVendeur(village.trouverHabitant(nomVendeur), produit, nbProduit);
		return numeroEtal+1;
	}

	public boolean verifierIdentite(String nomVendeur) {
		boolean nomVendeurConnu= controlVerifierIdentite.verifierIdentite(nomVendeur);
		return nomVendeurConnu;
	}
}
