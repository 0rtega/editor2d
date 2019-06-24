package editor2d.control;


import org.joml.Vector2f;

import editor2d.base.Window;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.joml.Vector2f;

public class Mouse {

    private Vector2f currentPos = new Vector2f(0,0); 
    private Vector2f previousPos = new Vector2f(-1,-1);
    private Vector2f deltaPosCursor = new Vector2f(); 
    private Window window;
    
    public Mouse(Window window) {
        this.window = window;
    }  

    public boolean leftButton = false;
    public boolean rightButton = false;
    

    public void init() {
    	
    	window.getAnimation().getCanvas().addMouseMoveListener(new MouseMoveListener() {
            @Override
            public void mouseMove(MouseEvent mouseEvent) {
                currentPos.x = mouseEvent.x;
                currentPos.y = mouseEvent.y;    
                input();
                if(leftButton) {
                	if(window.getCamera().getBeta() == - Math.PI/2){
                		window.getCamera().updateMoveCameraByMouseZPosition(deltaPosCursor);
    				}else {
    					window.getCamera().updateMoveCamera(deltaPosCursor);
    				}
                	window.getAnimation().render();
                }
                if(rightButton) {
                	
                }
            }
        });
    	window.getAnimation().getCanvas().addMouseListener(new MouseListener() {
            @Override
            public void mouseDoubleClick(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseDown(MouseEvent mouseEvent) {    
            	 if(mouseEvent.button == 1) {
            		 leftButton = true;           		
            	 }else if(mouseEvent.button == 3) {
            		 rightButton = true;
            	 }
            	 window.getAnimation().render();
            }

            @Override
            public void mouseUp(MouseEvent mouseEvent) {
            	 if(mouseEvent.button == 1) {
            		 leftButton = false;
            	 }else if(mouseEvent.button == 3) {
            		 rightButton = false;
            	 }
            	 window.getAnimation().render();
            } 
        });
    	
    	window.getAnimation().getCanvas().addMouseWheelListener(new MouseWheelListener(){
            @Override
            public void mouseScrolled(MouseEvent mouseEvent) {
            	window.getCamera().updateZoomCamera(mouseEvent.count);
            	window.getProjectMatrix().zoom(mouseEvent.count);
            	window.getAnimation().render();
            }
        });
    }

    private void updateMoveMouse(){
    	 deltaPosCursor.x = 0;
         deltaPosCursor.y = 0;
         if (previousPos.x > 0 && previousPos.y > 0) {
             float deltaX = currentPos.x - previousPos.x;
             float deltaY = currentPos.y - previousPos.y;
             
             deltaPosCursor.x = deltaX;
             deltaPosCursor.y = deltaY;
         }
         previousPos.x = currentPos.x;
         previousPos.y = currentPos.y;
    }
    
    public void input() {
        updateMoveMouse();
    }

    public Vector2f getCurrentPosCursor() {
        return currentPos;
    }

    public Vector2f getDeltaPosCursor() {
        return deltaPosCursor;
    }

	public Vector2f getPreviousPos() {
		return previousPos;
	}
    
}

