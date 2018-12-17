package com.syzo.waldos.imageprinter;

import com.syzo.waldos.domain.WaldField;
import com.syzo.waldos.imagereader.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePrinter {

    private WaldField waldField;

    private String path;
    private String name;
    public ImagePrinter(String path,String name){
        this.path=path;
        this.name=name;
    }



    public void print(WaldField waldField){


        BufferedImage combined = new BufferedImage(waldField.getFieldWidht(), waldField.getFieldHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics graphics=combined.getGraphics();
        waldField.getListImages().stream().forEach(
                waldImage -> {
                    BufferedImage auximg=getImage(waldImage.getPath());
                    if(auximg!=null){
                        graphics.drawImage(auximg,waldImage.getPositionx(),waldImage.getPositiony(),null);

                    }

                }
        );

        graphics.dispose();
        print(combined);





    }

    public void print(BufferedImage combined){
        try {
            ImageIO.write(combined, "PNG", new File(path, name));

            // create a blank, RGB, same width and height, and a white background
            BufferedImage newBufferedImage = new BufferedImage(combined.getWidth(),
                    combined.getHeight(), BufferedImage.TYPE_INT_RGB);
            newBufferedImage.createGraphics().drawImage(combined, 0, 0,combined.getWidth(),combined.getHeight(), Color.WHITE, null);

            // write to jpeg file
            ImageIO.write(newBufferedImage, "jpg", new File(path,"output.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BufferedImage getImage(String fullpath){
        try {
            BufferedImage img = ImageLoader.getImage(fullpath);
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
    return  null;
    }
}
