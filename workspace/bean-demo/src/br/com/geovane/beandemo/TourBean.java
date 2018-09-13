package br.com.geovane.beandemo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TourBean {

	private String kindOfTour;
	
	// No-args constructor
	public TourBean() {
		
	}
	
	public String startTheTour() {
		if (kindOfTour != null && kindOfTour.equals("city"))
			return "city_tour";
		else
			return "country_tour";
	}

	// Getters and setters
	public String getKindOfTour() {
		return kindOfTour;
	}

	public void setKindOfTour(String kindOfTour) {
		this.kindOfTour = kindOfTour;
	}
	
}
