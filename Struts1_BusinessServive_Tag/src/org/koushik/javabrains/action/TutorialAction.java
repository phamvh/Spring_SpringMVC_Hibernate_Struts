package org.koushik.javabrains.action;

import org.koushik.javabrains.service.TutorialFinderService;

public class TutorialAction {
	/**
	 * Struts2 will pack this property (using its getting method) into the value stack
	 * so that one can access it using the struts tag library <s:property value="bestTutorialSite"/>.
	 *  See the JSP file - success.jsp.
	 */
	private String bestTutorialSite;
	public String getBestTutorialSite() {
		return bestTutorialSite;
	}
	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}
	public String execute(){
		TutorialFinderService tutorialFinderService = new TutorialFinderService();
		String bestTutorialSite = tutorialFinderService.getBestTutorialSite();
		setBestTutorialSite(bestTutorialSite);
		System.out.println(bestTutorialSite);
		return "success";
	}
}
