package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		ISymptomReader lecteurFichier = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ISymptomWriter ecriveurFichier = new WriteSymptomDataToFile();
		AnalyticsCounter analyseurFichier = new AnalyticsCounter(lecteurFichier, ecriveurFichier);
		
		List<String> listeSymptoms = analyseurFichier.getSymptoms();
		
		Map<String, Integer> quantiteSymptoms = analyseurFichier.countSymptoms(listeSymptoms);
		
		Map<String, Integer> trieSymptoms = analyseurFichier.sortSymptoms(quantiteSymptoms);
		
		analyseurFichier.writeSymptoms(trieSymptoms);

	}

}
