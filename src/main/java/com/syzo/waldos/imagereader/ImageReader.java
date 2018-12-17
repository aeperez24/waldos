package com.syzo.waldos.imagereader;

import com.syzo.waldos.domain.WaldImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {


    private String basePath;
    public ImageReader(String path){
        this.basePath=path;

    }

    public  WaldImage readImage(String filename,boolean addBasePath){


        String fullfilename=(addBasePath)?basePath+"/"+filename:filename;
        BufferedImage img = null;
        WaldImage waldImage= new WaldImage();
        try {
            img = ImageLoader.getImage(fullfilename);
            img.getWidth();
            waldImage.setLenght(img.getWidth());
            waldImage.setHeight(img.getHeight());
            waldImage.setPath(fullfilename);
            return waldImage;
        } catch (IOException e) {
            //TODO:HANDLE EXCEPTION
            e.printStackTrace();
        }
        return null;


    }
}
