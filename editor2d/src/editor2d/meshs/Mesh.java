package editor2d.meshs;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL31.*;

import java.io.Serializable;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;


public  class Mesh implements Serializable {

	private final static int SIZE_FLOAT_IN_BYTE = 4;
	private static final int restartIndex = 0xFFFFFFFF;
	
	private int vao;
	private int vbo;
	private int nbo;
	private int cbo;
	private int ibo;
	private int visbo;
	private int countIndex;
	private int primitive;
	private int kindRender = 0;

	
//	public Mesh(StorageOfReferencesToFiguresInTheVideoCard.DataFor3DModel data, int primitive) {
//			this.primitive = primitive;
//			countIndex = data.getCountIndex();
//
//			vao = glGenVertexArrays();
//			glBindVertexArray(vao);
//			
//			glBindBuffer(GL_ARRAY_BUFFER, data.getVbo());
//			glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
//			glEnableVertexAttribArray(0);
//
//			glBindBuffer(GL_ARRAY_BUFFER, data.getNbo());
//			glVertexAttribPointer(2, 3, GL_FLOAT, false, 0, 0);
//			glEnableVertexAttribArray(2);
//
//			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, data.getIbo());
//
//			glBindVertexArray(0);
//		}
//	
	
	public Mesh(FloatBuffer vertex, int primitive, int additionalMemory) {	
		
		this.primitive = primitive;
		countIndex = vertex.capacity() / 3;
		kindRender = 1;

		vao = glGenVertexArrays();
		glBindVertexArray(vao);
		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, vertex.capacity() * SIZE_FLOAT_IN_BYTE + additionalMemory, GL_DYNAMIC_DRAW);
		glBufferSubData(GL_ARRAY_BUFFER, 0, vertex);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glBindVertexArray(0);
	}

	public Mesh(FloatBuffer vertex, FloatBuffer normal, IntBuffer index, int primitive) {
		this.primitive = primitive;
		countIndex = index.capacity();

		vao = glGenVertexArrays();
		glBindVertexArray(vao);

		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, vertex, GL_STATIC_DRAW);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);

		nbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, nbo);
		glBufferData(GL_ARRAY_BUFFER, normal, GL_STATIC_DRAW);
		glVertexAttribPointer(2, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(2);

		ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, index, GL_STATIC_DRAW);

		glBindVertexArray(0);
	}
	
	public Mesh(FloatBuffer vertex, IntBuffer index, IntBuffer color, IntBuffer visible, int primitive) {
		this.primitive = primitive;
		countIndex = index.capacity();

		vao = glGenVertexArrays();
		glBindVertexArray(vao);

		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, vertex, GL_STATIC_DRAW);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);
		
		cbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, cbo);
		glBufferData(GL_ARRAY_BUFFER, color, GL_STATIC_DRAW);
		glVertexAttribPointer(5, 1, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(5);
		
		visbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, visbo);
		glBufferData(GL_ARRAY_BUFFER, visible, GL_STATIC_DRAW);
		glVertexAttribPointer(6, 1, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(6);

		ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, index, GL_STATIC_DRAW);

		glBindVertexArray(0);
	}
	

	public Mesh(FloatBuffer vertex, IntBuffer index, IntBuffer color,  int primitive) {
		this.primitive = primitive;
		countIndex = index.capacity();

		vao = glGenVertexArrays();
		glBindVertexArray(vao);

		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, vertex, GL_STATIC_DRAW);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);
		
		cbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, cbo);
		glBufferData(GL_ARRAY_BUFFER, color, GL_STATIC_DRAW);
		glVertexAttribPointer(5, 1, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(5);

		ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, index, GL_STATIC_DRAW);

		glBindVertexArray(0);
	}
	
	public Mesh( FloatBuffer vertex, IntBuffer index, int countInstance, int primitive){
		
		glEnable (GL_PRIMITIVE_RESTART);
		this.countIndex = countInstance;
		this.primitive = primitive;
		vao = glGenVertexArrays();
	    glBindVertexArray(vao);
	    
	    glPrimitiveRestartIndex(restartIndex);
				
		vbo = glGenBuffers();
	    glBindBuffer(GL_ARRAY_BUFFER, vbo);
	    glBufferData(GL_ARRAY_BUFFER, vertex, GL_STATIC_DRAW);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(0);     
             
 
        ibo = glGenBuffers();
	    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
	    glBufferData(GL_ELEMENT_ARRAY_BUFFER, index, GL_STATIC_DRAW);

	    glBindVertexArray(0);	
	 }
	
	
	public Mesh(int vertex, IntBuffer index, int primitive) {
		this.primitive = primitive;
		countIndex = index.capacity();

		vao = glGenVertexArrays();
		glBindVertexArray(vao);

		glBindBuffer(GL_ARRAY_BUFFER, vertex);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);

		ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, index, GL_STATIC_DRAW);

		glBindVertexArray(0);
	}


	public void render() {
		if (kindRender == 0) {
			glBindVertexArray(vao);
			glDrawElements(primitive, countIndex, GL_UNSIGNED_INT, 0);
			glBindVertexArray(0);
		} else {
			glBindVertexArray(vao);		
			glEnableVertexAttribArray(0);
			glEnableVertexAttribArray(1);
			glDrawArrays(primitive, 0, countIndex);
			glDisableVertexAttribArray(1);
			glDisableVertexAttribArray(0);			
			glBindVertexArray(0);
		}
	}
	
	
	public void replaceData(int offset, FloatBuffer data, int buffer){
		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, buffer);
		glBufferSubData(GL_ARRAY_BUFFER, offset, data);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}
	
	public void replaceData(int offset, IntBuffer data, int buffer){
		glBindVertexArray(vao);
		glBindBuffer(GL_ARRAY_BUFFER, buffer);
		glBufferSubData(GL_ARRAY_BUFFER, offset, data);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}
	
	public int getVBO(){
		return vbo;
	}
	
	public int getCBO(){
		return cbo;
	}
	
	public int getVISBO(){
		return visbo;
	}

	public	 void cleanUp() {
		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(2);
		glDisableVertexAttribArray(5);
		glDisableVertexAttribArray(6);
		
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(vbo);
		glDeleteBuffers(nbo);
		glDeleteBuffers(ibo);
		glDeleteBuffers(cbo);
		glDeleteBuffers(visbo);
		
		glBindVertexArray(0);
		glDeleteVertexArrays(vao);
	}


	public void deleteBuffers() {
		glDeleteBuffers(vbo);
		glDeleteBuffers(nbo);
		glDeleteBuffers(ibo);
		glDeleteBuffers(cbo);
		glDeleteBuffers(visbo);
		
		
	}
	
}
