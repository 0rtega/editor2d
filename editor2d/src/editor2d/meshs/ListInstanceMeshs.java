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
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, link.getIbo());

		glBindVertexArray(0);
	}
	
	public void addData(FloatBuffer position, int offsetPosition, IntBuffer color, int offsetColor, FloatBuffer radius, int offsetRadius) {
		if (currentIndex == capacity - 1) {
			changeBuffersToNew();
		}
		
		currentIndex++;
		countInstance++;
		
		addData(this.position, position, offsetPosition);
		addData(this.color, color, offsetColor);
		addData(this.radius, radius, offsetRadius);
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
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(position);
		glDeleteBuffers(color);
		glDeleteBuffers(radius);
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
		glEnableVertexAttribArray(5);
		glVertexAttribPointer(5, COUNT_DIGITS_IN_RADIUS, GL_FLOAT, false,  0, 0);
		glVertexAttribDivisor(5, 1);
		glBindVertexArray(0);

		capacity = newCapacity;
	}
	
}
