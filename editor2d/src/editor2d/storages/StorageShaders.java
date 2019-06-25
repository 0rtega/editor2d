package editor2d.storages;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import editor2d.Utils.LoaderResources;
import editor2d.graphics.Shader;

public class StorageShaders {

	private static StorageShaders instance = new StorageShaders();
	
	public static StorageShaders getInstance() {
		return instance;
	}
	private ResourceBundle res = ResourceBundle.getBundle("paths");
	private StorageShaders(){}
	private Map<TypeShader, Shader> shaders;
	
	
	public void init() {
		shaders = new HashMap<>();
		try {
			initShaders();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cleanUp(){
		for(Map.Entry<TypeShader, Shader> pair: shaders.entrySet()){
			pair.getValue().cleanup();
		}		
		shaders.clear();
	}

	public void initShaders() throws Exception{	
		
		Shader shader = createShader(res.getString("millhole(v)"), null, res.getString("millhole(f)") , "scale", "color", "colorId", "currentPosition", "select");
		
		shaders.put(TypeShader.MILLHOLE, shader);
		
		
		shader = createShader(res.getString("text3d(v)"), null, res.getString("text3d(f)"),
				 "scale", "color", "currentPosition", "texture_sampler",  "select", "colorId");		
			shaders.put(TypeShader.TEST_TEXT3D, shader);
		
		
		shader = createShader(res.getString("model(v)"), null , res.getString("model(f)") , "position", "scale",
				 "uAmbientColor", "uDiffuseColor", "uSpecularColor", "rotate", "select", "colorId");
		shaders.put(TypeShader.MODEL, shader);
		shader = createShader(  res.getString("triangle(v)"),res.getString("triangle(g)"), res.getString("triangle(f)"), "select", "colorId");
		shaders.put(TypeShader.TRIANGLE3D, shader);
		
		shader = createShader(  res.getString("antialiasing(v)"),null, res.getString("antialiasing(f)"), "screenTexture");
		shaders.put(TypeShader.ANTIALISING, shader);
		
		shader = createShader(  res.getString("line(v)"),null, res.getString("line(f)"), "color", "currentPosition");
		shaders.put(TypeShader.LINE, shader);
		
		shader = createShader(  res.getString("circle(v)"), null, res.getString("circle(f)"), "currentPosition", "color", "scale");
		shaders.put(TypeShader.CIRCLE, shader);
	}
	
	private Shader createShader(String v, String g, String f, String... uniform)throws Exception{
		Shader shader = new Shader();
		shader.createVertexShader(LoaderResources.getnstance().loadShader(v));
		shader.createFragmentShader(LoaderResources.getnstance().loadShader(f));  
		if(g != null){
			shader.createGeometricShader(LoaderResources.getnstance().loadShader(g));
		}
		shader.link();
		for(String str: uniform){
			shader.createUniform(str);	
		}
		return shader;
	}
	
	public  Shader getShader(TypeShader figures){
		return shaders.get(figures);
	}
		
	 public   enum TypeShader{
   		POINT2D, POINT3D, LINE, ROAD, CIRCLE, RECTAGLE,
   		ROUNDED_RECTANGLE, TEXT2D, 
   		CYLINDER, MODEL, PARALLELEPIPED, TRIANGLE2D, TRIANGLE3D,
   		
   		STATIC_2D_GROUP,
   		
   		STATIC_3D_GROUP_INSTANCE, 
   		STATIC_3D_GROUP_LINE, 
   		STATIC_3D_GROUP_TRIANGLE,
   		MILLHOLE,
   		ROAD_LINE,
   		TEST_TEXT3D,
   		ANTIALISING
   }
}
