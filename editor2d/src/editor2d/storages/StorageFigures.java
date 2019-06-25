package editor2d.storages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joml.Vector3d;

import editor2d.editparts.IEditPart;
import editor2d.figures.Circle;
import editor2d.figures.IFigure;
import editor2d.figures.Square;

public class StorageFigures {

	private static StorageFigures instance = new StorageFigures();

	public static StorageFigures getInstance() {
		return instance;
	}
	private StorageFigures() {
	}
	
	private List<Square> squares = new ArrayList<Square>();
	
	public void addFigure(IFigure figure) {
		if(figure == null) {
			throw new NullPointerException("Фигура в Editpart равна null");
		}else if(figure instanceof Circle) {
			Circle circle = (Circle)figure;
			Square square = findSquareForFigure(circle.getPosition());
			square.addCicrle(circle);
			circle.setSquare(square);
		}
	}
	
	public void removeFigure(IFigure figure) {
		if(figure == null) {
			throw new NullPointerException("Фигура в Editpart равна null");
		}else if(figure instanceof Circle) {
			Circle circle = (Circle)figure;
			Square square = circle.getSquare();
			square.removeCircle(circle);
			if(square.isEmpty()) {
				squares.remove(square);
			}
		}
	}
	
	private Square findSquareForFigure(Vector3d position) {
		Square square = null;;
		for(Square sq: squares) {
			if(sq.belongToPointOfSquare(position)) {
				square = sq;
				break;
			}
		}
		if(square == null) {
			square = createSquare(position);
			squares.add(square);
		}
		return square;
	}
	
	private Square createSquare(Vector3d position) {
		Square square = new Square();
		
		return square;
	}
	
	public List<Square> getSquares() {
		return Collections.unmodifiableList(squares);
	}
	
	public void cleanUp() {
		for(Square  square: squares) {
			square.cleanUp();
		}
	}
}
