package chapter_11;

public class Rectangle implements Cloneable{
	int width, height;
	Rectangle (int width, int height){
		this.width = width;
		this.height = height;
	}
	
	int getArea() {
		return width * height;
	}
	
	public Object clone() {
		try {
			return super.clone();
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}
}
