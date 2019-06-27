package editor2d.meshs;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL31.*;
import static org.lwjgl.opengl.GL33.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import editor2d.storages.StorageDataForFigures;
import editor2d.storages.StorageDataForFigures.TypeFigure;
import editor2d.utils.LoaderResources.LinkOnBuffersInVideocard;

import static org.lwjgl.opengl.GL30.*;

public class ListInstanceMeshs {
	
	private final static int SIZE_FLOAT_IN_BYTE = 4;
	private final static int COUNT_DIGITS_IN_COLOR = 1;
	private final static int COUNT_DIGITS_IN_RADIUS = 1;
	private final static int COUNT_DIGITS_IN_POSITION = 3;
	
	private int countInstance = 0;
	private int countIndex = 0;
	private int vao;
	private int position;
	private int color;
	private int radius;
	private int colorBorder;
	private int widthBorder;
	private int hover;
	private int colorHover;
	private int widthHover;
	
	private int capacity = 20;
	private int currentIndex = 0;	
	
	public int getCurrentIndex() {
		return currentIndex;
	}

	public ListInstanceMeshs() {
		LinkOnBuffersInVideocard link = StorageDataForFigures.getInstance().getData(TypeFigure.CIRCLE);
		countIndex = link.getIndex().capacity();
		vao = glGenVertexArrays();
		glBindVertexArray(vao);
		
		glBindBuffer(GL_ARRAY_BUFFER, link.getVbo());
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);
		
		position = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, position);
		glBufferData(GL_ARRAY_BUFFER, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_POSITION, GL_DYNAMIC_DRAW);
		glEnableVertexAttribArray(2);
		glVertexAttribPointer(2, COUNT_DIGITS_IN_POSITION, GL_FLOAT, false, 0, 0);
		glVertexAttribDivisor(2, 1);

		color = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, color);
		glBufferData(GL_ARRAY_BUFFER, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR, GL_DYNAMIC_DRAW);
		glEnableVertexAttribArray(3);
		glVertexAttribIPointer(3, COUNT_DIGITS_IN_COLOR, GL_INT, 0, 0);
		glVertexAttribDivisor(3, 1);
		
		radius = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, radius);
		glBufferData(GL_ARRAY_BUFFER, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS, GL_DYNAMIC_DRAW);
		glEnableVertexAttribArray(4);
		glVertexAttribIPointer(4, COUNT_DIGITS_IN_RADIUS, GL_INT, 0, 0);
		glVertexAttribDivisor(4, 1);
		
		colorBorder = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, colorBorder);
		glBufferData(GL_ARRAY_BUFFER, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR, GL_DYNAMIC_DRAW);
		glEnableVertexAttribArray(5);
		glVertexAttribIPointer(5, COUNT_DIGITS_IN_COLOR, GL_INT, 0, 0);
		glVertexAttribDivisor(5, 1);
		
		widthBorder = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, widthBorder);
		glBufferData(GL_ARRAY_BUFFER, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS, GL_DYNAMIC_DRAW);
		glEnableVertexAttribArray(6);
		glVertexAttribIPointer(6, COUNT_DIGITS_IN_RADIUS, GL_INT, 0, 0);
		glVertexAttribDivisor(6, 1);
		
		hover = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, hover);
		glBufferData(GL_ARRAY_BUFFER, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR, GL_DYNAMIC_DRAW);
		glEnableVertexAttribArray(7);
		glVertexAttribIPointer(7, COUNT_DIGITS_IN_COLOR, GL_INT, 0, 0);
		glVertexAttribDivisor(7, 1);
		
		colorHover = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, colorHover);
		glBufferData(GL_ARRAY_BUFFER, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR, GL_DYNAMIC_DRAW);
		glEnableVertexAttribArray(8);
		glVertexAttribIPointer(8, COUNT_DIGITS_IN_COLOR, GL_INT, 0, 0);
		glVertexAttribDivisor(8, 1);
		
		widthHover = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, widthHover);
		glBufferData(GL_ARRAY_BUFFER, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS, GL_DYNAMIC_DRAW);
		glEnableVertexAttribArray(9);
		glVertexAttribIPointer(9, COUNT_DIGITS_IN_RADIUS, GL_INT, 0, 0);
		glVertexAttribDivisor(9, 1);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, link.getIbo());

		glBindVertexArray(0);
	}
	
	public void addData(FloatBuffer position, int offsetPosition, IntBuffer color, int offsetColor,
						FloatBuffer radius, int offsetRadius, IntBuffer colorBorder, int offsetColorBorder,
						FloatBuffer widthBorder, int offsetWidthBorder,
						IntBuffer hover, int offsetHover, IntBuffer colorHover, int offsetColorHover,
						FloatBuffer widthHover, int offsetWidthHover) {
		if (currentIndex == capacity - 1) {
			changeBuffersToNew();
		}
		
		currentIndex++;
		countInstance++;
		
		addData(this.position, position, offsetPosition);
		addData(this.color, color, offsetColor);
		addData(this.radius, radius, offsetRadius);
		addData(this.colorBorder, colorBorder, offsetColor);
		addData(this.widthBorder, widthBorder, offsetWidthBorder);
		addData(this.hover, hover, offsetHover);
		addData(this.colorHover, colorHover, offsetColorHover);
		addData(this.widthHover, widthHover, offsetWidthHover);
	}
	
	private void addData(int buffer, FloatBuffer data, int offset) {
		
		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, buffer);
		glBufferSubData(GL_ARRAY_BUFFER, offset, data);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
		
	}

	private void addData(int buffer, IntBuffer data, int offset) {
		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, buffer);
		glBufferSubData(GL_ARRAY_BUFFER, offset, data);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}
	
	public void removeData() {
		
	}
	
	public void updateData() {
		
	}
	
	public void render() {
		glBindVertexArray(vao);
		glDrawElementsInstanced(GL_TRIANGLES, countIndex, GL_UNSIGNED_INT, 0, countInstance);
		glBindVertexArray(0);
	}
	
	public void cleanUp() {
		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(2);
		glDisableVertexAttribArray(3);
		glDisableVertexAttribArray(4);
		glDisableVertexAttribArray(5);
		glDisableVertexAttribArray(6);
		glDisableVertexAttribArray(7);
		glDisableVertexAttribArray(8);
		glDisableVertexAttribArray(9);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(position);
		glDeleteBuffers(color);
		glDeleteBuffers(radius);
		glDeleteBuffers(colorBorder);
		glDeleteBuffers(widthBorder);
		glDeleteBuffers(hover);
		glDeleteBuffers(colorHover);
		glDeleteBuffers(widthHover);
		glBindVertexArray(0);
		glDeleteVertexArrays(vao);
	}
	
	private void copyBuffer(int oldBuffer, int newBuffer, int startRead, int startWrite, int sizedata) {
		
		glBindVertexArray(vao);
		glBindBuffer(GL_COPY_WRITE_BUFFER, newBuffer);
		glBindBuffer(GL_ARRAY_BUFFER, oldBuffer);
		
		glCopyBufferSubData(GL_ARRAY_BUFFER, GL_COPY_WRITE_BUFFER, startRead, startWrite, sizedata);

		glDeleteBuffers(oldBuffer);
		glBindBuffer(GL_COPY_WRITE_BUFFER, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}
	
	private void changeBuffersToNew(){
		int newCapacity = capacity + capacity / 2;

		int newPositionBuffer = glGenBuffers();
		glBindBuffer(GL_COPY_WRITE_BUFFER, newPositionBuffer);
		glBufferData(GL_COPY_WRITE_BUFFER, newCapacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_POSITION, GL_DYNAMIC_DRAW);
		copyBuffer(this.position, newPositionBuffer, 0, 0,
				capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_POSITION);

		//glDeleteBuffers(this.position);
		this.position = newPositionBuffer;

		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, this.position);
		glEnableVertexAttribArray(2);
		glVertexAttribPointer(2, COUNT_DIGITS_IN_POSITION, GL_FLOAT, false, 0, 0);
		glVertexAttribDivisor(2, 1);
		glBindVertexArray(0);
		
		int newPositionColor = glGenBuffers();
		glBindBuffer(GL_COPY_WRITE_BUFFER, newPositionColor);
		glBufferData(GL_COPY_WRITE_BUFFER, newCapacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR, GL_DYNAMIC_DRAW);
		 copyBuffer(this.color, newPositionColor, 0, 0,
				capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR);

		//glDeleteBuffers(this.color);
		this.color = newPositionColor;

		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, this.color);
		glEnableVertexAttribArray(3);
		glVertexAttribIPointer(3, COUNT_DIGITS_IN_COLOR, GL_INT,  0, 0);
		glVertexAttribDivisor(3, 1);
		glBindVertexArray(0);
		
		
		int newPositionRadius = glGenBuffers();
		glBindBuffer(GL_COPY_WRITE_BUFFER, newPositionRadius);
		glBufferData(GL_COPY_WRITE_BUFFER, newCapacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS, GL_DYNAMIC_DRAW);
		copyBuffer(this.radius, newPositionRadius, 0, 0, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS);

		//glDeleteBuffers(this.colorId);
		this.radius = newPositionRadius;

		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, this.radius);
		glEnableVertexAttribArray(4);
		glVertexAttribPointer(4, COUNT_DIGITS_IN_RADIUS, GL_FLOAT, false,  0, 0);
		glVertexAttribDivisor(4, 1);
		glBindVertexArray(0);
		
		
		
		int newPositionColorBorder = glGenBuffers();
		glBindBuffer(GL_COPY_WRITE_BUFFER, newPositionColorBorder);
		glBufferData(GL_COPY_WRITE_BUFFER, newCapacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR, GL_DYNAMIC_DRAW);
		 copyBuffer(this.colorBorder, newPositionColorBorder, 0, 0,
				capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR);

		//glDeleteBuffers(this.color);
		this.colorBorder = newPositionColorBorder;

		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, this.colorBorder);
		glEnableVertexAttribArray(5);
		glVertexAttribIPointer(5, COUNT_DIGITS_IN_COLOR, GL_INT,  0, 0);
		glVertexAttribDivisor(5, 1);
		glBindVertexArray(0);
		
		
		int newPositionWidthBorder = glGenBuffers();
		glBindBuffer(GL_COPY_WRITE_BUFFER, newPositionWidthBorder);
		glBufferData(GL_COPY_WRITE_BUFFER, newCapacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS, GL_DYNAMIC_DRAW);
		copyBuffer(this.widthBorder, newPositionWidthBorder, 0, 0, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS);

		//glDeleteBuffers(this.colorId);
		this.widthBorder = newPositionWidthBorder;

		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, this.widthBorder);
		glEnableVertexAttribArray(6);
		glVertexAttribPointer(6, COUNT_DIGITS_IN_RADIUS, GL_FLOAT, false,  0, 0);
		glVertexAttribDivisor(6, 1);
		glBindVertexArray(0);
		
		
		int newPositionHover = glGenBuffers();
		glBindBuffer(GL_COPY_WRITE_BUFFER, newPositionHover);
		glBufferData(GL_COPY_WRITE_BUFFER, newCapacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR, GL_DYNAMIC_DRAW);
		 copyBuffer(this.hover, newPositionHover, 0, 0,
				capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR);

		//glDeleteBuffers(this.color);
		this.hover = newPositionHover;

		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, this.hover);
		glEnableVertexAttribArray(7);
		glVertexAttribIPointer(7, COUNT_DIGITS_IN_COLOR, GL_INT,  0, 0);
		glVertexAttribDivisor(7, 1);
		glBindVertexArray(0);
		
		int newPositionColorHover = glGenBuffers();
		glBindBuffer(GL_COPY_WRITE_BUFFER, newPositionColorHover);
		glBufferData(GL_COPY_WRITE_BUFFER, newCapacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR, GL_DYNAMIC_DRAW);
		 copyBuffer(this.colorHover, newPositionColorHover, 0, 0,
				capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_COLOR);

		//glDeleteBuffers(this.color);
		this.colorHover = newPositionColorHover;

		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, this.colorHover);
		glEnableVertexAttribArray(8);
		glVertexAttribIPointer(8, COUNT_DIGITS_IN_COLOR, GL_INT,  0, 0);
		glVertexAttribDivisor(8, 1);
		glBindVertexArray(0);
		
		int newPositionWidthHover = glGenBuffers();
		glBindBuffer(GL_COPY_WRITE_BUFFER, newPositionWidthHover);
		glBufferData(GL_COPY_WRITE_BUFFER, newCapacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS, GL_DYNAMIC_DRAW);
		copyBuffer(this.widthHover, newPositionWidthHover, 0, 0, capacity * SIZE_FLOAT_IN_BYTE * COUNT_DIGITS_IN_RADIUS);

		//glDeleteBuffers(this.colorId);
		this.widthHover = newPositionWidthHover;

		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, this.widthHover);
		glEnableVertexAttribArray(9);
		glVertexAttribPointer(9, COUNT_DIGITS_IN_RADIUS, GL_FLOAT, false,  0, 0);
		glVertexAttribDivisor(9, 1);
		glBindVertexArray(0);

		capacity = newCapacity;
	}
	
}
