package editor2d.graphics.text;

import static org.lwjgl.opengl.GL11.GL_MAX_TEXTURE_SIZE;
import static org.lwjgl.opengl.GL11.glGetInteger;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import editor2d.storages.StorageFonts;



 public class AtlasTexture {
	
	private static  String ALL_CHARS1 = "1234567890!@#$%^&*()-=_+|\\qwertyuiop[]asdfghjkl;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?"
			+ "éöóêåíãøùçõúôûâàïğîëäæıÿ÷ñìèòüáşÉÖÓÊÅÍÃØÙÇÕÚÔÛÂÀÏĞÎËÄÆİß×ÑÌÈÒÜÁŞ ";
	private static  String ALL_CHARS = "1234567890!¹@#$%^&*()-=_+|\\qwertyuiop[]asdfghjkl;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?"
			+ "éöóêåíãøùçõúôûâàïğîëäæıÿ÷ñìèòüáşÉÖÓÊÅÍÃØÙÇÕÚÔÛÂÀÏĞÎËÄÆİß×ÑÌÈÒÜÁŞ ";
	private static final String IMAGE_FORMAT = "png";
	
	private Texture texture;
	private List<Integer> sampleTexture2D;
	private Font sourceFont;
	private Map<Character, CharInfo> charsInfo;
	
	public AtlasTexture (String name, int style) {
		sourceFont = new Font(name, style, 100);
		charsInfo = new HashMap<>();
		sampleTexture2D = new ArrayList<>();
	
		buildAtlas();		
	}
	
	private void buildAtlas() {
	    BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2D = img.createGraphics();
        g2D.setFont(sourceFont);
        FontMetrics fontMetrics = g2D.getFontMetrics();

        int widthTexture = 0;
        int heightTexture = 0;
        
        for (int i = 0; i < ALL_CHARS.length(); i++) {
        	char c = ALL_CHARS.charAt(i);
        	
	        CharInfo charInfo = new CharInfo(widthTexture, fontMetrics.charWidth(c),
	        		StorageFonts.getInstance().getNumberOfOccupiedTextures());
	        charsInfo.put(c, charInfo);
	        widthTexture += charInfo.getWidth();
	        heightTexture = Math.max(heightTexture, fontMetrics.getHeight());  
        }
        
        createTexture( ALL_CHARS, widthTexture, heightTexture);
	    g2D.dispose();
	}
	
	private void createTexture( String charInTexture, int width, int height ){		
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2D = img.createGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setFont(sourceFont);
        FontMetrics fontMetrics = g2D.getFontMetrics();
        g2D.drawString(charInTexture, 0, fontMetrics.getAscent());      
        g2D.dispose();
        
        InputStream is1 = null;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ImageIO.write(img, IMAGE_FORMAT, out);
            out.flush();
            is1 = new ByteArrayInputStream(out.toByteArray());          
        }catch (Exception e) {
			e.printStackTrace();
		}
        Texture texture = new Texture(is1, StorageFonts.getInstance().getNumberOfOccupiedTextures());
        sampleTexture2D.add(texture.getNumberTexture());
        this.texture = texture;
        StorageFonts.getInstance().incrementNumberOfOccupiedTextures();
	}

	public CharInfo getCharsInfo(char c){
		return charsInfo.get(c);
	}
	  public Texture getTexture() {
		return texture;
	}
	  
	  public void cleanUp(){
		  texture.cleanup();
	  }
	  
	  public List<Integer> getListSampleTexture2D(){
		  return Collections.unmodifiableList(sampleTexture2D);
	  }
	  
	  public int getSizeFontFotAtlas(){
		  return sourceFont.getSize();
	  }

	  public  static class CharInfo {

	        private final float startX;

	        private final float width;
	        private final int numberTexture;

	        public CharInfo(float startX, float width, int numberTexture) {
	            this.startX = startX;
	            this.width = width;
	            this.numberTexture = numberTexture;
	        }

	        public float getStartX() {
	            return startX;
	        }

	        public float getWidth() {
	            return width;
	        }
	        
	        public int getNumberTexture(){
	        	return numberTexture;
	        }
	    }
}
