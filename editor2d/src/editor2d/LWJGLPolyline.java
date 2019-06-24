package editor2d;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.joml.Vector4f;
import org.lwjgl.BufferUtils;

import editor2d.Utils.Identifier;
import editor2d.Utils.Util;
import editor2d.datamodel.Point;
import editor2d.graphics.Shader;
import editor2d.meshs.Mesh;
import editor2d.storages.StorageColors;
import editor2d.storages.StorageShaders;
import editor2d.storages.StorageShaders.Figures;


public class LWJGLPolyline  {

	private List<Point> points = new CopyOnWriteArrayList<>();
	private Vector4f colorId = new Vector4f();
	private Color color;
	private Mesh mesh;
	private Shader shader;
	private double height;
	private double lineWidth;
	private boolean init = false;
	private StorageShaders shadersStorage;
	private int id;
	private boolean select = false;
	
	
	public LWJGLPolyline(List<Point> points,  Color color, double lineWidth, double height ) {
		this.points.addAll(points);
		id = Identifier.getInstance().getId();
		colorId = Util.getColotId(id);
		this.color = color;
		this.height = height;
		this.lineWidth= lineWidth;
		shadersStorage = StorageShaders.getInstance();
	}
	
	
	
	public void cleanUp() {
		if(mesh != null) {
			mesh.cleanUp();
		}
	}
	
	
	

	public void draw() {
		if(!init) {
			buildMesh();
		}
		
		if (shader == null) {
			shader = shadersStorage.getShader(Figures.TRIANGLE3D);
		}
		
		
		shader.bind();
		
		if(select) {
			shader.setUniform1f("select", 1);
			shader.setUniform4f("colorId", colorId);
		}else {
			shader.setUniform1f("select", 0);
		}	
		
		mesh.render();		
		shader.unbind();
	}
	

	public void fillPoints(){

	}
	
	
	private IntBuffer indexBuffer;
	private IntBuffer colorBuffer;
	private FloatBuffer vertexBuffer;
	private IntBuffer visibleBuffer;
	
	private List<Point> listPoint = new ArrayList<>();
	private List<Integer> index  = new ArrayList<>();
	private List<Integer> colors  = new ArrayList<>();	
	private List<Integer> visible = new ArrayList<>();
	
	private int t = 0;
	
	public void buildMesh(){
		init = true;
		cleanUp();
		fillPoints();	
		
		List<Point> pol1 = getParallelPolyline(lineWidth / 2);
		List<Point> pol2 = getParallelPolyline(-lineWidth / 2);
		int size = points.size() - 1;
		
		for(int i = 0; i < size; i++){
			
			Point p1 = new Point(pol1.get(i).getX(), pol1.get(i).getY(), pol1.get(i).getZ());
			Point p2 = new Point(pol1.get(i + 1).getX(), pol1.get(i + 1).getY(), pol1.get(i + 1).getZ());
			Point p3 = new Point(pol2.get(i).getX(), pol2.get(i).getY(), pol2.get(i).getZ());
			Point p4 = new Point(pol2.get(i + 1).getX(), pol2.get(i + 1).getY(), pol2.get(i + 1).getZ());
			

			Point p5 = new Point(pol1.get(i).getX(), pol1.get(i).getY(), pol1.get(i).getZ() + height);
			Point p6 = new Point(pol1.get(i + 1).getX(), pol1.get(i + 1).getY(), pol1.get(i + 1).getZ() + height);
			Point p7 = new Point(pol2.get(i).getX(), pol2.get(i).getY(), pol2.get(i).getZ() + height);
			Point p8 = new Point(pol2.get(i + 1).getX(), pol2.get(i + 1).getY(), pol2.get(i + 1).getZ() + height);
						
			
			listPoint.add(p1);
			listPoint.add(p2);
			listPoint.add(p3);		
			listPoint.add(p4);
			listPoint.add(p5);
			listPoint.add(p6);
			listPoint.add(p7);
			listPoint.add(p8);
			
			
			Integer [] p = {t+7,t+6,t+2, t+7,t+2,t+3,   t+5,t+7,t+3, t+3,t+1,t+5,   t+4,t+6,t+5, t+5,t+6,t+7,
					t+6,t+0,t+2, t+6,t+4,t+0,   t+2,t+0,t+3, t+3,t+0,t+1,   t+4,t+5,t+1, t+4,t+1,t+0};
			
//			Integer [] p = {t+2,t+6,t+7, t+3,t+2,t+7,   t+3,t+7,t+5, t+5,t+1,t+3,   t+5,t+6,t+4, t+7,t+6,t+5,
//					t+2,t+0,t+6, t+0,t+4,t+6,   t+3,t+0,t+2, t+1,t+0,t+3,   t+1,t+5,t+4, t+0,t+1,t+4};
//			
			index.addAll(Arrays.asList(p));
			t += 8;
			
			StorageColors.NnspgColor cc = StorageColors.getInstance().new NnspgColor(
					color.getRed()/255f,
					color.getGreen()/255f,
					color.getBlue()/255f,
					color.getAlpha()/255f);
			StorageColors.getInstance().addColor(cc);
			int in = StorageColors.getInstance().getIndexMyColor(cc);	
			
			for(int e = 0; e < 8; e++){
				colors.add(in);
				visible.add(1);
			}
		}		
	
		
		indexBuffer = BufferUtils.createIntBuffer(index.size());
		for(Integer i: index){
			indexBuffer.put(i);
		}
		indexBuffer.flip();	
		
		colorBuffer = BufferUtils.createIntBuffer(colors.size());
		for(Integer i: colors){
			colorBuffer.put(i);
		}
		colorBuffer.flip();		
		
		visibleBuffer = BufferUtils.createIntBuffer(visible.size());
		for(Integer i: visible){
			visibleBuffer.put(i);
		}
		visibleBuffer.flip();	
		
		vertexBuffer = BufferUtils.createFloatBuffer(listPoint.size() * 3);
		
		for(Point p: listPoint){	
			vertexBuffer.put((float)p.getX());
			vertexBuffer.put(-(float)p.getY());
			vertexBuffer.put((float)p.getZ());
		}
		vertexBuffer.flip();	
		
		listPoint.clear();
		index.clear();
		colors.clear();
		visible.clear();
		t = 0;
		
		mesh  = new Mesh(vertexBuffer, indexBuffer, colorBuffer, visibleBuffer, GL_TRIANGLES);
	}
	
    List<Point> getParallelPolyline( double distance ) {
    	
    	ArrayList<Point> pointsOfParallelPolyline = new ArrayList<Point>();
    	Point p = new Point( 0, distance, 0 );
    	p = p.rotateZ(points.get(0).headingZTo(points.get(1)) + Math.PI / 2).plus( points.get(0));
    	pointsOfParallelPolyline.add(p);

    	for( int pointIndex = 1; pointIndex < points.size() - 1; pointIndex++ ) {   		
    		double angle = ( points.get(pointIndex).headingZTo(points.get(pointIndex + 1))
    				+ points.get(pointIndex - 1).headingZTo(points.get(pointIndex)) ) / 2 + Math.PI / 2;   				
    		double newPointDistance = distance / Math.cos( angle - ( points.get(pointIndex).headingZTo(points.get(pointIndex + 1)) + Math.PI / 2 ) );
    		pointsOfParallelPolyline.add( 
    				new Point( 0, newPointDistance, 0 ).rotateZ(angle).plus( points.get( pointIndex ) ) );
    	}

    	p = new Point( 0, distance, 0 );
    	p = p.rotateZ(points.get(points.size() - 2).headingZTo(points.get(points.size() - 1)) + Math.PI / 2).plus( points.get(points.size() - 1));
    	pointsOfParallelPolyline.add(p);   
    	return pointsOfParallelPolyline;
    }
	

	
}