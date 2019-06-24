package editor2d.graphics.text;


import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import de.matthiasmann.twl.utils.PNGDecoder;
import de.matthiasmann.twl.utils.PNGDecoder.Format;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL30.*;

public  class Texture {

	  private int id;
	  private int numberTexture;

	  private int width;

	  private int height;

	  public    Texture(InputStream is, int numberTexture)  {
	        try {	        
	            PNGDecoder decoder = new PNGDecoder(is);
	            this.numberTexture = numberTexture;
	            this.width = decoder.getWidth();
	            this.height = decoder.getHeight();
	            ByteBuffer buf = ByteBuffer.allocateDirect(
	                    4 * decoder.getWidth() * decoder.getHeight());
	            decoder.decode(buf, decoder.getWidth() * 4, Format.RGBA);
	            buf.flip();
	            
	            this.id = glGenTextures();

	            glActiveTexture(getNumberTexture());			
	            glBindTexture(GL_TEXTURE_2D, this.id);
	          
	            glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
	            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width, this.height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
	            glGenerateMipmap(GL_TEXTURE_2D);
	            is.close();
	        	
	        } catch(Exception e){
	        	e.printStackTrace();
	        }finally {
	            if (is != null) {
	                try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	            }
	        }	       
	    }	 
	  public     int getWidth() {
	        return this.width;
	    }

	  public    int getHeight() {
	        return this.height;
	    }

	  public     void bind() {
	        glBindTexture(GL_TEXTURE_2D, id);
	    }

	  public  int getId() {
	        return id;
	    }

	  public    void cleanup() {
	        glDeleteTextures(id);
	    }
	  public  int getNumberTexture() {
			return numberTexture;
		}
	    
}


	