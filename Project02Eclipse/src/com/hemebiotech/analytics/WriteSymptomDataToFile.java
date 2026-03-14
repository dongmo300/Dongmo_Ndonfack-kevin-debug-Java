package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/*
 * classe implementant l'interface ISymptomWriter
 */

public class WriteSymptomDataToFile implements ISymptomWriter{
	/*
	 * on recupere d'abord les clés de la collection Map
	 * en suit on construit la chaine du texte a afficher
	 * @param symptoms 
	 */

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		Set<String> cles_symp = symptoms.keySet(); 
		//
		StringBuilder builder = new StringBuilder();
		builder.append("Symptomes et les nombre d occurence :\n\t");
		/*
		 * on recupere la valeur qui sera associé à la clé
		 * c'est à dire la quantité du symtôme qui va être associé au symptôme
		 */
		for (String cles : cles_symp) {
			Integer quantite = symptoms.get(cles); 
			builder.append(cles + " : " + quantite + "\n\t");
		}
		
		try {
			BufferedWriter ecriture = new BufferedWriter(new FileWriter("result.out"));
			ecriture.write(builder.toString());
			ecriture.close();
		} catch (IOException e) {
			System.out.println("impossible d ecrire dans le fiche");
		}
		
	}

}
