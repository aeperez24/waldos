package com.syzo.waldos.com.syzo.waldos;

import com.syzo.waldos.domain.WaldField;
import com.syzo.waldos.domain.WaldImage;
import com.syzo.waldos.imageprinter.ImagePrinter;
import com.syzo.waldos.imagereader.ImageLister;
import com.syzo.waldos.imagereader.ImageReader;

import java.util.List;
import java.util.Random;

public class WaldoGenerator {

    public WaldField generate(String pathImages,int rows,int width){

        WaldField wf=new WaldField(rows,width);
        ImageLister lister= new ImageLister(pathImages);
        ImageReader reader= new ImageReader(pathImages);
        List<String> images=lister.listFiles();
        while (!wf.isFull()) {
            String imageToAdd = getRamdonStringFromList(images);
            WaldImage waldImage = reader.readImage(imageToAdd, true);
            wf.insertImage(waldImage);
        }


       return wf;

    }


    public WaldField generate(String pathImages,String pathWaldoFigures,int rows,int width){

        //reading radomly a waldos image
        WaldField wf=generate(pathImages,rows,width);
        ImageLister waldofigurelister= new ImageLister(pathWaldoFigures);
        ImageReader waldofigurereader= new ImageReader(pathWaldoFigures);
        String waldoimg=getRamdonStringFromList(waldofigurelister.listFiles());
        WaldImage wimg=waldofigurereader.readImage(waldoimg,true);
        //getting a random image from waldos field
        List<WaldImage> images=wf.getListImages();
        Random random= new Random();
        int randomPosition=random.nextInt(images.size());
        WaldImage rimg=images.get(randomPosition);
        rimg.setId("waldo");
        rimg.setHeight(wimg.getHeight());
        rimg.setLenght(wimg.getLenght());
        rimg.setPath(wimg.getPath());
        rimg.setIswaldo(true);
        return wf;

    }

    public void generateAndPrint(String pathImages,String pathWaldoFigures,String pathResult,String nameFile,int rows,int width){
        WaldField wf=generate(pathImages,pathWaldoFigures, rows, width);
        ImagePrinter printer= new ImagePrinter(pathResult,nameFile);
        printer.print(wf);

    }

    public String getRamdonStringFromList(List<String> strings){
        int size= strings.size();
        Random random= new Random();
        int position=random.nextInt(size);
        return strings.get(position);
    }
}
