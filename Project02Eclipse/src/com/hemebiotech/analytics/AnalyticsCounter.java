package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomWriter ecriture_symptoms;
	private ISymptomReader lecture_symptoms ;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.ecriture_symptoms = writer;
		this.lecture_symptoms = reader;
	}
	/*
	 * methode recuperant la liste des entree (symptomes) dans le fichier
	 */
	public List<String> getSymptoms(){
		
		return this.lecture_symptoms.GetSymptoms();
		
	}
	/*
	 * methode qui compte chaque symptome existant
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		
		Map<String, Integer> total_chaque_symtom =new HashMap<String, Integer>();
		/*
		 * total_chaque_symptom.getOrDefault returne la valeur associee a la cle ou une valeur par
		 * defaut si la cle n'existe pas dans le map. zero est la valeur par defaut ici
		 */
		for (String symp : symptoms) {
		    total_chaque_symtom.put(symp, total_chaque_symtom.getOrDefault(symp, 0) + 1);
		}
		return total_chaque_symtom;
		
	}
	/*
	 * methode qui trie la liste de symptomes et d'occurences par ordre alphabetique
	 */
	public Map<String, Integer> sortSymptoms(Map<String,Integer> symptoms){
		//trie par ordre alphabetique des cles
		TreeMap<String, Integer> sortSymp = new TreeMap<String, Integer>(symptoms);
		return sortSymp;
		
	}
	/*
	 * methode qui ecrire le resultat dans le fichier de sortie
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.ecriture_symptoms.writeSymptoms(symptoms);
		
	}
	
	
}
