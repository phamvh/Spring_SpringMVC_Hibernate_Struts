package org.koushik.javabrains;

import java.util.List;

public class Triangle {

public List<Point> getPoints() {
		return points;
	}




	public void setPoints(List<Point> points) {
		this.points = points;
	}




private List<Point> points;

	


	public void draw(){
		
		for(Point point: points){
			System.out.println("Point = ("+point.getX()+", "+point.getY() + ")");
		}
		///System.out.println("Point A = ("+getPointA().getX()+", "+getPointA().getY() + ")");
		///System.out.println("Point B = ("+getPointB().getX()+", "+getPointB().getY() + ")");
		///System.out.println("Point C = ("+getPointC().getX()+", "+getPointC().getY() + ")");
	}
}
