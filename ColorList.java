package project1;
/**
 * class that contains list of color objects
 *@author Dimitri Chaber
 *@version 9/11/2017
 * 
 */

import java.util.ArrayList;

public class ColorList extends ArrayList<Color> {
	public ColorList() {
		
	}
	/**
	 * Finds color object with name matching argument
	 * @param colorName
	 * @return color object with matching name if it exists
	 */
	public Color getColorByName(String colorName) {
		//search loop
		for(int i = 0; i < super.size(); i++) {
			if(super.get(i).getName().equalsIgnoreCase(colorName) ) {
				return super.get(i);
				
			}
			
		}
		//if no match is found returns null
		return null;
	}
	/**
	 * Find color object with hex matching argument
	 * @param colorHexValue
	 * @return color object with matching hex if it exists
	 */
	public Color getColorByHexValue(String colorHexValue) {
		//search loop
		Color tempColor = new Color(colorHexValue);
		for(int i = 0; i < super.size(); i++) {
			if(super.get(i).equals(tempColor)) {
				return super.get(i);
				
			}
		}
		//if no match is found returns null
		return tempColor;
		
	}

}
