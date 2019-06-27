package editor2d.storages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joml.Vector3d;

import editor2d.base.IEditPart;
import editor2d.figures.Circle;
import editor2d.figures.IFigure;
import editor2d.figures.Square;

public class StorageFigures {

	private static StorageFigures instance = new StorageFigures();
	private int widthSquare = 100, heightSquare = 100; 
	public static StorageFigures getInstance() {
		return instance;
	}

	private StorageFigures() {
	}

	private List<Square> squares = new ArrayList<Square>();

	public void addFigure(IFigure figure) {
		if (figure == null) {
			throw new NullPointerException("Фигура в Editpart равна null");
		} else if (figure instanceof Circle) {
			Circle circle = (Circle) figure;
			Square square = findSquareForFigure(circle.getPosition());
			square.addCicrle(circle);
			circle.setSquare(square);
		}
	}

	public void removeFigure(IFigure figure) {
		if (figure == null) {
			throw new NullPointerException("Фигура в Editpart равна null");
		} else if (figure instanceof Circle) {
			Circle circle = (Circle) figure;
			Square square = circle.getSquare();
			square.removeCircle(circle);
			if (square.isEmpty()) {
				squares.remove(square);
			}
		}
	}

	private Square findSquareForFigure(Vector3d p) {
		Square square = null;
		for (Square sq : squares) {
			if (sq.belongToPointOfSquare(p)) {
				square = sq;
				break;
			}
		}
		if (square == null) {
			square = createSquare(p);
			squares.add(square);
		}
		return square;
	}

	private Square createSquare(Vector3d p) {
		int startX = 0, startY = 0;
		if (p.x >= 0) {
			if (p.y >= 0) {
				//x >=0  y >=0
				double t = p.y % heightSquare;
				startX = (int)(p.x / widthSquare) * widthSquare;
				if(t > 0) {
					startY = ((int)(p.y / heightSquare) + 1) * heightSquare;
				}else {
					startY = ((int)(p.y / heightSquare)) * heightSquare;
				}	
				
			} else {
				//x >=0  y < 0
				startX = ((int)(p.x / widthSquare) )* widthSquare;
				startY = ((int)(p.y / heightSquare) )* heightSquare;							
			}
		} else {
			if (p.y >= 0) {
				//x < 0  y >=0
				double t = p.y % heightSquare;
				if(t > 0) {
					startY = ((int)(p.y / heightSquare) + 1) * heightSquare;
				}else {
					startY = ((int)(p.y / heightSquare)) * heightSquare;
				}				
				t = p.x % widthSquare;
				if(t > 0) {
					startX = ((int)(p.x / widthSquare) + 1) * widthSquare;
				}else {
					startX = ((int)(p.x / widthSquare)) * widthSquare;
				}			
			} else {
				//x < 0  y < 0
				double t = p.x % widthSquare;
				startY = ((int)(p.y / heightSquare)) * heightSquare;
				if(t > 0) {
					startX = ((int)(p.x / widthSquare) + 1) * widthSquare;
				}else {
					startX = ((int)(p.x / widthSquare)) * widthSquare;
				}				
			}
		}
		return new Square(startX, startY, widthSquare, heightSquare);
	}

	public List<Square> getSquares() {
		return Collections.unmodifiableList(squares);
	}

	public void cleanUp() {
		for (Square square : squares) {
			square.cleanUp();
		}
	}
}
