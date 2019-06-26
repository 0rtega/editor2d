package editor2d.Utils;


import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;

public class FrustumCullingFilter {

	 private static final int NUM_PLANES = 6;

	    private final Matrix4f prjViewMatrix;

	    private final Vector4f[] frustumPlanes;

	    public FrustumCullingFilter() {
	        prjViewMatrix = new Matrix4f();
	        frustumPlanes = new Vector4f[NUM_PLANES];
	        for (int i = 0; i < NUM_PLANES; i++) {
	            frustumPlanes[i] = new Vector4f();
	        }
	    }

	    public void updateFrustum(Matrix4f projMatrix, Matrix4f viewMatrix) {
	        prjViewMatrix.set(projMatrix);
	        prjViewMatrix.mul(viewMatrix);
	        for (int i = 0; i < NUM_PLANES; i++) {
	            prjViewMatrix.frustumPlane(i, frustumPlanes[i]);
	        }
	    }

//	    public void filter(List<CubeForFigures> cubes, Vector3f cameraPosition) throws Exception {
//	        for (CubeForFigures cube: cubes) {
//	        	cube.setDraw(insideFrustum(InversionPosition.getInstance().getInversionPosition(cube.getCenter()), cube.getBoundingRadius()));
//	        	if(cube.isDraw()){
//		        	double dis = cameraPosition.distance(InversionPosition.getInstance().getInversionPosition(cube.getCenter()));
//		    		if(dis < cube.getDistanceOfChangeShape()){
//		    			cube.getMeshInstances().setNormalCountInstance();
//		    			cube.getMeshInstances().changeFigure("Point(high-quality)");
//		    		}else if(dis < cube.getDistanceOfDeleteFigure()){
//		    			cube.getMeshInstances().setNormalCountInstance();
//		    			cube.getMeshInstances().changeFigure("Point(low-quality)");
//		    		}else {	    			
//		    			cube.getMeshInstances().setZeroInstance();
//		    		}
//	        	}
//	  	    }	        
//	    }

	    public boolean insideFrustum(Vector3d pos, float boundingRadius) {
	        boolean result = true;
	        for (int i = 0; i < NUM_PLANES; i++) {
	            Vector4f plane = frustumPlanes[i];
	            if (plane.x * pos.x + plane.y * pos.y + plane.z * pos.z + plane.w <= -boundingRadius) {
	                result = false;
	                return result;
	            }
	        }
	        return result;
	    }
	    
	    public boolean insideFrustum(Vector3i pos, float boundingRadius) {
	        boolean result = true;
	        for (int i = 0; i < NUM_PLANES; i++) {
	            Vector4f plane = frustumPlanes[i];
	            if (plane.x * pos.x + plane.y * pos.y + plane.z * pos.z + plane.w <= -boundingRadius) {
	                result = false;
	                return result;
	            }
	        }
	        return result;
	    }
	
}
