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
	

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		Set<String> cles_symp = symptoms.keySet(); // recuperation des cles de la collection Map
		//construction de la chaine de texte
		StringBuilder builder = new StringBuilder();
		builder.append("Symptomes et les nombre d occurence :\n\t");
		for (String cles : cles_symp) {
			Integer quantite = symptoms.get(cles); //on recupere la quantite du symptome
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
