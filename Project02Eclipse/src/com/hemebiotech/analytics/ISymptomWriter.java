package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	
	/*
	 * methode abstrate qui nous servira d ecrire dans un fichier
	 * @param symtoms
	 */
	
	public void writeSymptoms(Map<String, Integer> symptoms);

}
