package com.syzo.waldos.com.syzo.waldos;

import com.syzo.waldos.domain.WaldField;
import com.syzo.waldos.domain.WaldImage;
import com.syzo.waldos.imageprinter.ImagePrinter;
import com.syzo.waldos.imagereader.ImageLister;
import com.syzo.waldos.imagereader.ImageReader;

import java.util.List;
import java.util.Random;

public class WaldoGenerator {

    public void generate(String pathImages,String pathResult,String nameFile,int rows,int width){

        WaldField wf=new WaldField(rows,width);
        ImageLister lister= new ImageLister(pathImages);
        ImageReader reader= new ImageReader(pathImages);
        ImagePrinter printer= new ImagePrinter(pathResult,nameFile);
        List<String> images=lister.listFiles();
        while (!wf.isFull()) {
            String imageToAdd = getRamdonStringFromList(images);
            WaldImage waldImage = reader.readImage(imageToAdd, true);
            wf.insertImage(waldImage);
        }
        printer.print(wf);

    }

    public String getRamdonStringFromList(List<String> strings){
        int size= strings.size();
        Random random= new Random();
        int position=random.nextInt(size);
        return strings.get(position);
    }
}
