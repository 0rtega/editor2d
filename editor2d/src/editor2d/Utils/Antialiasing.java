package editor2d.Utils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL32.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import editor2d.graphics.Shader;
import editor2d.storages.StorageShaders;
import editor2d.storages.StorageShaders.Figures;

public class Antialiasing {

	private int SCR_WIDTH = 1280;
	private int SCR_HEIGHT = 720;
	public int framebuffer, textureColorBufferMultiSampled, rbo, intermediateFBO, screenTexture, quadVAO, quadVBO;
	private Shader screenShader;
	
	private float quadVertices[] = {   
	        -1.0f,  1.0f,  0.0f, 1.0f,
	        -1.0f, -1.0f,  0.0f, 0.0f,
	         1.0f, -1.0f,  1.0f, 0.0f,

	        -1.0f,  1.0f,  0.0f, 1.0f,
	         1.0f, -1.0f,  1.0f, 0.0f,
	         1.0f,  1.0f,  1.0f, 1.0f
	    };

	public Antialiasing() {

	}

	public void cleanUp() {
		glDisableVertexAttribArray(10);
		glDisableVertexAttribArray(11);
		
		glDeleteFramebuffers(framebuffer);
		glDeleteTextures(textureColorBufferMultiSampled);
		glDeleteRenderbuffers(rbo);
		glDeleteFramebuffers(intermediateFBO);
		glDeleteTextures(screenTexture);
		
		glDeleteVertexArrays(quadVAO);
		glDeleteBuffers(quadVBO);
	}

	public void init()  {
		    quadVAO = glGenVertexArrays();
		    quadVBO = glGenBuffers();
		    glBindVertexArray(quadVAO);
		    glBindBuffer(GL_ARRAY_BUFFER, quadVBO);
		    glBufferData(GL_ARRAY_BUFFER, quadVertices, GL_STATIC_DRAW);
		    glEnableVertexAttribArray(10);
		    glVertexAttribPointer(10, 2, GL_FLOAT, false, 4 * 4, 0);
		    glEnableVertexAttribArray(11);
		    glVertexAttribPointer(11, 2, GL_FLOAT, false, 4 * 4, 2*4);
		    screenShader = StorageShaders.getInstance().getShader(Figures.ANTIALISING);
	}

	public void update(int width, int height) {
		this.SCR_WIDTH = width;
		this.SCR_HEIGHT = height;

		glDeleteFramebuffers(framebuffer);
		glDeleteTextures(textureColorBufferMultiSampled);
		glDeleteRenderbuffers(rbo);
		glDeleteFramebuffers(intermediateFBO);
		glDeleteTextures(screenTexture);
		
		
		framebuffer = glGenFramebuffers();
		glBindFramebuffer(GL_FRAMEBUFFER, framebuffer);
		// create a multisampled color attachment texture
		textureColorBufferMultiSampled = glGenTextures();
		glBindTexture(GL_TEXTURE_2D_MULTISAMPLE, textureColorBufferMultiSampled);
		glTexImage2DMultisample(GL_TEXTURE_2D_MULTISAMPLE, 4, GL_RGB, SCR_WIDTH, SCR_HEIGHT, true);
		glBindTexture(GL_TEXTURE_2D_MULTISAMPLE, 0);
		glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D_MULTISAMPLE,
				textureColorBufferMultiSampled, 0);
		// create a (also multisampled) renderbuffer object for depth and stencil
		// attachments
		rbo = glGenRenderbuffers();
		glBindRenderbuffer(GL_RENDERBUFFER, rbo);
		glRenderbufferStorageMultisample(GL_RENDERBUFFER, 4, GL_DEPTH24_STENCIL8, SCR_WIDTH, SCR_HEIGHT);
		glBindRenderbuffer(GL_RENDERBUFFER, 0);
		glFramebufferRenderbuffer(GL_FRAMEBUFFER, GL_DEPTH_STENCIL_ATTACHMENT, GL_RENDERBUFFER, rbo);
		//
		if (glCheckFramebufferStatus(GL_FRAMEBUFFER) != GL_FRAMEBUFFER_COMPLETE) {
			System.out.println("Error anti");
		}
		glBindFramebuffer(GL_FRAMEBUFFER, 0);

		// configure second post-processing framebuffer
		intermediateFBO = glGenFramebuffers();
		glBindFramebuffer(GL_FRAMEBUFFER, intermediateFBO);
		// create a color attachment texture
		screenTexture = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, screenTexture);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, SCR_WIDTH, SCR_HEIGHT, 0, GL_RGB, GL_UNSIGNED_BYTE, NULL);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, screenTexture, 0);

		if (glCheckFramebufferStatus(GL_FRAMEBUFFER) != GL_FRAMEBUFFER_COMPLETE) {
			System.out.println("Error anti");
		}

		glBindFramebuffer(GL_FRAMEBUFFER, 0);
	}

	public void render() {
	    glBindFramebuffer(GL_READ_FRAMEBUFFER, framebuffer);
        glBindFramebuffer(GL_DRAW_FRAMEBUFFER, intermediateFBO);
        glBlitFramebuffer(0, 0, SCR_WIDTH, SCR_HEIGHT, 0, 0, SCR_WIDTH, SCR_HEIGHT, GL_COLOR_BUFFER_BIT, GL_NEAREST);

        // 3. now render quad with scene's visuals as its texture image
        glBindFramebuffer(GL_FRAMEBUFFER, 0);
        glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);
        glDisable(GL_DEPTH_TEST);

       
        // draw Screen quad
        screenShader.bind();
	    screenShader.setUniform1f("screenTexture", 0);
        
        glBindVertexArray(quadVAO);
        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, screenTexture); // use the now resolved color attachment as the quad's texture
        glDrawArrays(GL_TRIANGLES, 0, 6);

        screenShader.unbind();
	}

	
}
