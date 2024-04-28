/*
 *	===============================================================================
 *	PolygonShape.java : A shape that is a polygon.
 *  YOUR UPI: LEVE092
 *	=============================================================================== */
import java.awt.*;
import java.util.Arrays;
class PolygonShape extends SquareShape {
	private Point centre = new Point(DEFAULT_HEIGHT/2, DEFAULT_HEIGHT/2);
	private int radius = DEFAULT_HEIGHT/2;
	private int numberOfSides = 6;
    public PolygonShape() {}
	public PolygonShape(int x, int y, int s, int pw, int ph, Color c, Color bc, PathType pt, ShapeType st) {
		super(x ,y ,s, pw ,ph, c, bc, pt);
		this.numberOfSides = st.getNumberOfSides();
		radius = s/2;
		centre  = new Point(x + width/2, y + height/2);
	}
	public void draw(Graphics g) { //complete the draw method
	
		this.centre = new Point(this.getX() + this.radius, this.getY() + this.radius);
        int[] xCoords = new int[numberOfSides];
        int[] yCoords = new int[numberOfSides];

        for(int i = 0; i < numberOfSides; i++){
            double angle = (i*2*Math.PI)/numberOfSides;
            xCoords[i] = (int) (centre.getX() + radius * Math.cos(angle));
            yCoords[i] = (int) (centre.getY() + radius * Math.sin(angle));
        }
		g.setColor(color);
		g.fillPolygon(xCoords, yCoords, xCoords.length);
		g.setColor(borderColor);
		g.drawPolygon(xCoords, yCoords, xCoords.length);
	}
}