package org.koushik.javabrains.action;

import org.koushik.javabrains.service.TutorialFinderService;

public class TutorialAction {
	private String bestTutorialSite;
	
	private static String SUCCESS = "success";
	
	/**
	 * If the input parameter has the same name as this property, struts2 will automatically
	 * pass the value of the input parameter to this property (using the setter method).
	 * This work and it does not matter, which method (GET or POST) is used.
	 */
	private String language;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getBestTutorialSite() {
		return bestTutorialSite;
	}
	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}
	public String execute(){
		TutorialFinderService tutorialFinderService = new TutorialFinderService();
		String bestTutorialSite = tutorialFinderService.getBestTutorialSite(getLanguage());
		setBestTutorialSite(bestTutorialSite);
		System.out.println(bestTutorialSite);
		System.out.println("Input parameter languge = "+getLanguage());
		return SUCCESS;
	}
}
