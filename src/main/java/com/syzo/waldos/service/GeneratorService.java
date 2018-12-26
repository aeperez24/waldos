package com.syzo.waldos.service;

import com.syzo.waldos.com.syzo.waldos.WaldoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service

public class GeneratorService {


    @Autowired
    private Environment env;
    private WaldoGenerator wgenerator= new WaldoGenerator();

    public byte [] generate(int row,int width){
        String waldoFigurePath=env.getProperty("waldo.path.source.figure.waldo");
        System.out.println(waldoFigurePath);
        String genericFigurePath=env.getProperty("waldo.path.source.figure.generic");
        String resultPath=env.getProperty("waldo.path.result.image");
        String resultName=""+System.currentTimeMillis();

        wgenerator.generateAndPrint(genericFigurePath,waldoFigurePath,resultPath,resultName,row,width);
        //TODO: READ IMAGE resultName and converit to byte array

        byte [] data=null;
        try {
            BufferedImage bImage = ImageIO.read(new File(resultPath+"/"+resultName+".jpg"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            ImageIO.write(bImage, "jpg", bos );
            data = bos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }
}
