/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spritemap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author NGUYEN T THUY DUNG 
 */
public class SpriteMap {

    private static final int COT = 2;
   private static final int HANG = 2;
   public static void join(String inputPath, String outputPath) throws IOException{
       File directory = new File(inputPath);
        File[] files = directory.listFiles();

    
        BufferedImage sprite = ImageIO.read(files[0]);
        int width = sprite.getWidth() * files.length;
        int height = sprite.getHeight();

                                
        BufferedImage spritemap = new BufferedImage(width, height*HANG, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = spritemap.createGraphics();

        int x = sprite.getWidth();
        int y=sprite.getHeight();
        int v=0;
        
        
        for(int i=0;i<HANG;i++){
            for(int j=0;j<COT;j++){
                sprite=ImageIO.read(files[v]);
                g2d.drawImage(sprite,null,x*j,y*i);
                v++;
            }     
        }
        ImageIO.write(spritemap, "png", new File(outputPath));//lay hinh ra
    }              
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            SpriteMap.join("D:\\Myproject\\Image\\input", "D:\\Myproject\\Image\\pokemonsprite");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
}
