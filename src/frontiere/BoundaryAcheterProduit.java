package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteruApartient = controlAcheterProduit.acheteurApartient(nomAcheteur);
		if (!acheteruApartient) {
			System.out.println("Je suis d�sol�e Panoramix mais il"
					+ " faut �tre un habitant de notre "
					+ "village pour commercer ici.");
			return;
		}
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		boolean produitMarche = controlAcheterProduit.produitMarche(produit);
		if (!produitMarche) {
			
		}
		StringBuilder question = new StringBuilder();
		question.append("Chez quel commer�ant voulez-vous acheter des ");
		question.append(produit);
		question.append(" ?\n");
		String[] vendeurs = controlAcheterProduit.chercherVendeurs(produit);
		if (vendeurs.length<1) {
			System.out.println("D�sol�, personne ne vend ce produit au march�.\n");
			return;
		}
		for (int i = 0; i < vendeurs.length; i++) {
			String string = vendeurs[i];
			question.append(i);
			question.append(" - "+string);
			question.append("\n");
		}
		int numeroVendeur = Clavier.entrerEntier(question.toString());
		
		if((numeroVendeur<-1) ||(numeroVendeur>vendeurs.length)) {
			
		}
		
		System.out.println(nomAcheteur+" se d�place jusqu'� l'etal du vendeur "+vendeurs[numeroVendeur]);
		System.out.println("Bonjour "+nomAcheteur);
		
		int nbAcheter = Clavier.entrerEntier("Combien de "+produit+ "voulez-vous acheter ?");
		
		
		int quantiteProduit = controlAcheterProduit.quantiteProduit(vendeurs[numeroVendeur]);
		
		if (quantiteProduit==0) {
			System.out.println("Panoramix veut acheter "+nbAcheter+", malheureusement il n�y en a plus !");
			return;
		}
		if(nbAcheter<quantiteProduit) {
			System.out.print(nomAcheteur+" veut acheter "+nbAcheter+" "+produit+", malheureusement "+vendeurs[numeroVendeur]+"il n�en a plus que ");
			System.out.println(quantiteProduit+". "+nomAcheteur+" ach�te tout le stock de "+vendeurs[numeroVendeur]+".");
			return;
		}
		
		System.out.println(nomAcheteur+" ach�te "+nbAcheter+" "+produit+ " � "+vendeurs[numeroVendeur]+"." );
		return;
	}
}
