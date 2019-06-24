package editor2d.meshs;


import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import editor2d.graphics.text.AtlasTexture;
import editor2d.graphics.text.Texture;

import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public  class MeshForText   {

	private static final int NUMBER_FIRST_TEXTURE_IN_OPENGL = 33984;
	private int vao;
	private int vertexCount;
	private List<Integer> vboIdList;
	private AtlasTexture atlas;
	
	public   MeshForText(FloatBuffer vertex, IntBuffer index, 
			FloatBuffer texture, AtlasTexture atlas) {
		
		   vertexCount = index.capacity();
           vboIdList = new ArrayList();
           this.atlas = atlas;

           vao = glGenVertexArrays();
           glBindVertexArray(vao);

           // Position VBO
           int vboId = glGenBuffers();
           vboIdList.add(vboId);
           glBindBuffer(GL_ARRAY_BUFFER, vboId);
           glBufferData(GL_ARRAY_BUFFER, vertex, GL_STATIC_DRAW);
           glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

           // Texture coordinates VBO
           vboId = glGenBuffers();
           vboIdList.add(vboId);
           glBindBuffer(GL_ARRAY_BUFFER, vboId);
           glBufferData(GL_ARRAY_BUFFER, texture, GL_STATIC_DRAW);
           glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);

           // Index VBO
           vboId = glGenBuffers();
           vboIdList.add(vboId);
           glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboId);
           glBufferData(GL_ELEMENT_ARRAY_BUFFER, index, GL_STATIC_DRAW);

           glBindBuffer(GL_ARRAY_BUFFER, 0);
           glBindVertexArray(0);		
	}
	


	public  void render() {				
		Texture texture = atlas.getTexture();
        glActiveTexture(NUMBER_FIRST_TEXTURE_IN_OPENGL + texture.getNumberTexture());			
        texture.bind();         
		
        // Draw the mesh
        glBindVertexArray(vao);
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glDrawElements(GL_TRIANGLES, vertexCount, GL_UNSIGNED_INT, 0);

        // Restore state
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glBindVertexArray(0);
        glBindTexture(GL_TEXTURE_2D, 0);
	}

	
	public  void cleanUp() {
		 glDisableVertexAttribArray(0);
		 glDisableVertexAttribArray(1);

        // Delete the VBOs
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        for (int vboId : vboIdList) {
            glDeleteBuffers(vboId);
        }
        vboIdList.clear();
        // Delete the VAO
        glBindVertexArray(0);
        glDeleteVertexArrays(vao);
		
	}
	
	
	
	
	public  void deleteBuffers() {
		 glDisableVertexAttribArray(0);

	        // Delete the VBOs
	        glBindBuffer(GL_ARRAY_BUFFER, 0);
	        for (int vboId : vboIdList) {
	            glDeleteBuffers(vboId);
	        }     			

	        // Delete the VAO
	        glBindVertexArray(0);
	        glDeleteVertexArrays(vao);
		
	}


	public  AtlasTexture getAtlasTexture(){
		return atlas;
	}
	
	
	
}
