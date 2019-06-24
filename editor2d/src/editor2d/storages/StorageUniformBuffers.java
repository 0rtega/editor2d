package editor2d.storages;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.glBindBufferRange;
import static org.lwjgl.opengl.GL31.GL_UNIFORM_BUFFER;

import org.joml.Matrix4f;
import org.joml.Vector3f;


public class StorageUniformBuffers {

	private int ubo;

	private static StorageUniformBuffers instance = new StorageUniformBuffers();
	
	
	public static StorageUniformBuffers getInstance() {
		return instance;
	}

	private StorageUniformBuffers() {
	}

	 public void init() {

		ubo = glGenBuffers();
		glBindBuffer(GL_UNIFORM_BUFFER, ubo);
		glBufferData(GL_UNIFORM_BUFFER, (data.length + matrix.length + matrix1.length + colors.length) * 4, GL_DYNAMIC_DRAW);
		glBindBuffer(GL_UNIFORM_BUFFER, 0);

		glBindBufferRange(GL_UNIFORM_BUFFER, 4, ubo, 0, (data.length + matrix.length + matrix1.length + colors.length) * 4);
	}
	
	 private float [] data = new float[4];
	 private float [] matrix = new float[16];
	 private float [] matrix1 = new float[16];
	 private float [] colors = new float[160];
	
	
	public void fillUniformBuffer(Matrix4f PVMatrix, Matrix4f view, Vector3f positionLightSource ) {		
		data[0] = positionLightSource.x;
		data[1] = positionLightSource.y;
		data[2] = positionLightSource.z;
		
		PVMatrix.get(matrix);
		view.get(matrix1);
		
		glBindBuffer(GL_UNIFORM_BUFFER, ubo);
		glBufferSubData(GL_UNIFORM_BUFFER, 0, data);
		glBindBuffer(GL_UNIFORM_BUFFER, 0);

		glBindBuffer(GL_UNIFORM_BUFFER, ubo);
		glBufferSubData(GL_UNIFORM_BUFFER, 16, matrix);
		glBindBuffer(GL_UNIFORM_BUFFER, 0);	
		
		glBindBuffer(GL_UNIFORM_BUFFER, ubo);
		glBufferSubData(GL_UNIFORM_BUFFER, 80, matrix1);
		glBindBuffer(GL_UNIFORM_BUFFER, 0);	
		

	}
	

	private int currentIndexMyColor = 0;
	public void addColorInGPU(StorageColors.NnspgColor myColor){
		if(currentIndexMyColor > 39){
			throw new NullPointerException("Переполнен буффер с цветом");
		}		
		
		glBindBuffer(GL_UNIFORM_BUFFER, ubo);
		glBufferSubData(GL_UNIFORM_BUFFER, 144 + currentIndexMyColor * 16, myColor.getAsBuffer());
		glBindBuffer(GL_UNIFORM_BUFFER, 0);
		
		currentIndexMyColor++;
	}
	
	public void removeColorInGPU(StorageColors.NnspgColor myColor){
		
	}
	
	public void updateColorInGPU(StorageColors.NnspgColor myColor, int index){
		if(index > 39){
			throw new NullPointerException("Переполнен буффер с цветом");
		}
		
		glBindBuffer(GL_UNIFORM_BUFFER, ubo);
		glBufferSubData(GL_UNIFORM_BUFFER, 144 + index  * 16, myColor.getAsBuffer());
		glBindBuffer(GL_UNIFORM_BUFFER, 0);	
	}


	public int getUbo() {
		return ubo;
	}

	public void cleanUp() {
		glDeleteBuffers(ubo);
		currentIndexMyColor = 0;
	}
	
}
