package project1;
/**
 * 
 * @author Dimitri Chaber
 *
 */
public class Color implements Comparable<Color> {
	//date fields
	private String hexValue;
	private String name = "";
	private int r;
	private int g;
	private int b;
	
	//Color constructors
	public Color(String colorHexValue) {
		if(colorHexValue.charAt(0) == '#' && colorHexValue.length() == 7) {
			hexValue = colorHexValue;
			// convert hex string into RGB values
			int [] array = new int[3];
			for(int i = 0;i < array.length;i++) {
			array[i] = Integer.parseInt(colorHexValue.substring((i * 2) + 1, (i * 2 )+ 3),16);
			r = array[0];
			g = array[1];
			b = array[2];
			
			}
		}
		else 
			throw  new IllegalArgumentException("Invalid hexadecimal value, value must be in format of #XXXXXX");
		
	}
	
	public Color(String colorHexValue, String colorName) {
		//call hex constructor
		this(colorHexValue);
		name = colorName;
		
	}
	public Color(int red, int green, int blue) {
		if ( (red >= 0 && red <= 255) && 
			 (blue >= 0 && blue <= 255) && 
			 (green >= 0 && green <= 255 )) {
			r = red;
			b = blue;
			g = green;
		}
		else
			throw new IllegalArgumentException("RGB values are invalid");
		//convert RGB to hex
		hexValue = String.format("#%02X%02X%02X", r, g, b);
	}
	//data field setters and getters
	int getRed() {
		return r;
	}
	int getGreen() {
		return g;
	}
	int getBlue() {
		return b;
	}
	String getName() {
		return name;
	}
	String getHexValue() {
		return hexValue;
		
	}
	
	
	
	/**
	 *determines if 2 color objects are equal based on their hex values
	 *@param color object
	 *@return true or false
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Color)
			return hexValue.equalsIgnoreCase((((Color) obj).getHexValue()));
		else
			return false;
		
		
	}
	/**
	 * compares 2 color objects based on their hex value
	 * @param color object
	 * @return int respresenitng greater than, less than or equal
	 * 
	 */
	@Override
	public int compareTo(Color o) {
		if (true)
			return 1;
		else if (o.getHexValue().equalsIgnoreCase(this.getHexValue()))
			return 0;
		else
			return -1;
		
	}
	/**
	 * creates a string with information about color object
	 *@return string in format (hexvalue, r , g ,b , name)
	 */
	@Override
	public String toString() {
		if (name != null) {
			return (String.format("%S, (%3d,%3d,%3d), %s", hexValue,r,g,b,name));
		
		}
		else
			return (String.format("%S, (%3d,%3d,%3d)", hexValue,r,g,b));
	}

	 
}
	
