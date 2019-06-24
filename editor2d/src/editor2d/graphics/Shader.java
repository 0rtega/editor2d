package editor2d.graphics;

import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_LINK_STATUS;
import static org.lwjgl.opengl.GL20.GL_VALIDATE_STATUS;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glDeleteProgram;
import static org.lwjgl.opengl.GL20.glDetachShader;
import static org.lwjgl.opengl.GL20.glGetProgramInfoLog;
import static org.lwjgl.opengl.GL20.glGetProgrami;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUniform1i;
import static org.lwjgl.opengl.GL20.glUniform1iv;
import static org.lwjgl.opengl.GL20.glUniform3f;
import static org.lwjgl.opengl.GL20.glUniform4f;
import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glValidateProgram;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

import org.joml.Matrix4f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.lwjgl.system.MemoryStack;

public class Shader {
	  private  int programId; // номер ячейки в памяти где хранится ссылка на программу шейдера
	    private int vertexShaderId; // номер ячейки в памяти где хранится ссылка на вершинный шейдер
	    private int fragmentShaderId; // номер ячейки в памяти где хранится ссылка на фрагментный шейдер
	    private int geometricShaderId; // номер ячейки в памяти где хранится ссылка на фрагментный шейдер
	    private Map<String, Integer> uniforms; // мапа с именами переменных в шейдере.

	    public Shader() throws Exception {
	        programId = glCreateProgram(); // создается программа
	        if (programId == 0) {
	            throw new Exception("Could not create Shader");
	        }
	        uniforms = new HashMap<>();

	    }

	    /*
	        В памяти видеокарты создается ячейка в которой будет хранится ссылка на uniform переменную, имя которой передали аргументом.
	     */
	    public void createUniform(String uniformName) throws Exception {
	        int uniformLocation = glGetUniformLocation(programId, uniformName);
	        if (uniformLocation < 0) {
	            throw new Exception("Could not find uniform:" + uniformName);
	        }
	        uniforms.put(uniformName, uniformLocation);
	    }

	    /*
	        Метод который помещает переданное аргументом значение(value)
	         в uniform переменную в шейдере название которой тоже передели аргументом uniformName. Метод специально для матриц.
	     */
	    public void setUniform(String uniformName, Matrix4f value) {
	        try (MemoryStack stack = MemoryStack.stackPush()) {
	            FloatBuffer fb = stack.mallocFloat(16);
	            value.get(fb);
	            glUniformMatrix4fv(uniforms.get(uniformName), false, fb);
	        }
	    }
	 

	    public void setUniform3f(String uniform3f, Vector3f position){
	        glUniform3f(uniforms.get(uniform3f), position.x, position.y, position.z);
	    }
	    
	    public void setUniform3d(String uniform3f, Vector3d position){
	        glUniform3f(uniforms.get(uniform3f), (float)position.x, (float)position.y, (float)position.z);
	    }
	    
	    public void setUniform4d(String uniform3f,  double x, double y, double z, double w){
	        glUniform4f(uniforms.get(uniform3f), (float)x, (float)y, (float)z, (float)w);
	    }
	    
	    public void setUniform3i(String uniform3f, Vector3i position){
	        glUniform3f(uniforms.get(uniform3f), (float)position.x, (float)position.y, (float)position.z);
	    }
	    
	    public void setUniform4f(String uniform3f, Vector4f position){
	        glUniform4f(uniforms.get(uniform3f), position.x, position.y, position.z, position.w);
	    }
	    
	    
	    
	    public void setUniformfa(String uniform, int [] values ){  	
	    	glUniform1iv(uniforms.get(uniform), values);
	    }

	    /*
	       Метод который помещает переданное аргументом значение(value)
	        в uniform переменную в шейдере название которой тоже передели аргументом uniformName. Метод специально для интовых значений.
	    */
	    public void setUniformi(String uniformName, int value) {
	        glUniform1i(uniforms.get(uniformName),value);
	    }

	    public void setUniform3d(String uniform, double x, double y, double z){
	        glUniform3f(uniforms.get(uniform), (float)x, (float)y, (float)z);       
	    }
	    
	    public  void setUniform3f(String uniform, float x, float y, float z){
	        glUniform3f(uniforms.get(uniform), x,y,z);       
	    }
	    
	    public void setUniform4f(String uniform, float x, float y, float z, float w){
	        glUniform4f(uniforms.get(uniform), x,y,z, w);       
	    }
	     
	    public  void setUniform4f(String uniform, Color color){
	         glUniform4f(uniforms.get(uniform), 
	        		 color.getRed()/255f,
	        		 color.getGreen()/255f,
	        		 color.getBlue()/255f,
	        		 color.getAlpha()/255f);       
	     }
	    
	    public  void setUniform1f(String uniform, float x){
	        glUniform1f(uniforms.get(uniform), x);
	    }
	    
	    public  void setUniform1i(String uniform, int x){
	        glUniform1i(uniforms.get(uniform), x);
	    }

	    /*
	        Создает вершинный шейдер.
	     */
	    public  void createVertexShader(String shaderCode) throws Exception {
	        vertexShaderId = createShader(shaderCode, GL_VERTEX_SHADER);
	    }
	    /*
	        Создает фрагментный шейдер.
	     */
	    public void createFragmentShader(String shaderCode) throws Exception {
	        fragmentShaderId = createShader(shaderCode, GL_FRAGMENT_SHADER);
	    }
	    public void createGeometricShader(String shaderCode) throws Exception {
	        geometricShaderId = createShader(shaderCode, GL_GEOMETRY_SHADER);

	    }
	    /*
	        Создает шейдер.
	     */
	    private int createShader(String shaderCode, int shaderType) throws Exception {
	        int shaderId = glCreateShader(shaderType); // создает шейдер и помещает адрес ячейки в памяти на него.
	        if (shaderId == 0) {
	            throw new Exception("Error creating shader. Type: " + shaderType);
	        }
	        glShaderSource(shaderId, shaderCode); // помещает  в созданный шейдер данные shaderCode
	        glCompileShader(shaderId); // компилирует шейдер

	        if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0) {
	            throw new Exception("Error compiling Shader code: " + glGetShaderInfoLog(shaderId, 1024));
	        }
	        glAttachShader(programId, shaderId); //помещает шейдер в программу
	        return shaderId;
	    }

	    /*
	        Соединяет шейдеры и программу.
	     */
	    public  void link() throws Exception {
	        glLinkProgram(programId);
	        if (glGetProgrami(programId, GL_LINK_STATUS) == 0) {
	            throw new Exception("Error linking Shader code: " + glGetProgramInfoLog(programId, 1024));
	        }

	        if (vertexShaderId != 0) {
	            glDetachShader(programId, vertexShaderId);
	        }
	        if (fragmentShaderId != 0) {
	            glDetachShader(programId, fragmentShaderId);
	        }
	        if(geometricShaderId != 0 ){
	            glDetachShader(programId, geometricShaderId);
	        }

	        glValidateProgram(programId);
	        if (glGetProgrami(programId, GL_VALIDATE_STATUS) == 0) {
	            System.err.println("Warning validating Shader code: " + glGetProgramInfoLog(programId, 1024));
	        }
	    }

	    /*
	        Запускает использование программы.
	     */
	    public  void bind() {
	        glUseProgram(programId);
	    }

	    /*
	        Прекращает использование программы.
	     */
	    public  void unbind() {
	        glUseProgram(0);
	    }

	    public void cleanup() {
	        unbind();
	        if (programId != 0) {
	            glDeleteProgram(programId);
	        }
	    }

	    public int getProgramId() {
			return programId;
		}
	    
	    
}
