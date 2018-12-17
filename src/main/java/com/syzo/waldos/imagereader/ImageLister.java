package com.syzo.waldos.imagereader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ImageLister {

    String basePath;
    List<String> allowedFormats=new ArrayList<>();

    public  List<String> listFiles(){
        File folder = new File(basePath);
        File[] listOfFiles = folder.listFiles();
        List<String> formats= new ArrayList<>();
        List<String> lista= Arrays.stream(listOfFiles)
                .filter(s->s.isFile())
                .map(s->s.getName())
                .filter(s->allowedFormats.stream().
                        anyMatch(format->s.contains("."+format)))
                .collect(Collectors.toList());

        return  lista;
    }
    public ImageLister(String basepath){

        allowedFormats.add("png");
        allowedFormats.add("jpg");
        this.basePath=basepath;

    }
    public void addFormat(String format){
        this.allowedFormats.add(format);
    }

}
