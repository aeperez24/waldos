package com.syzo.waldos.imagereader;

import com.syzo.waldos.domain.WaldImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {
    private  static final Map<String, BufferedImage> cache= new HashMap<String,BufferedImage>();

    public static final BufferedImage getImage(String fullpath) throws IOException {
        int targetWidth=100;
        int targetHeight=200;

        BufferedImage img = cache.get(fullpath);
        if(img!=null){
            return img;
        }

        WaldImage waldImage= new WaldImage();
        img = ImageIO.read(new File(fullpath));
        BufferedImage result=resize(targetWidth,targetHeight,img);
        cache.put(fullpath,result);
        return result;



    }
    public  static final void clearCache(){
        cache.clear();
    }

    public static BufferedImage resize(int targetWidth, int targetHeight,
                                       BufferedImage src) {
        double scaleW = (double) targetWidth / (double) src.getWidth() ;
        double scaleH = (double) targetHeight / (double) src.getHeight() ;

        double scale = scaleW < scaleH ? scaleW : scaleH;

        BufferedImage result = new BufferedImage((int) (src.getWidth() * scale),
                (int) (src.getHeight() * scale), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(src, 0, 0, result.getWidth(), result.getHeight(), null);
        g2d.dispose();

        return result;
    }


}
