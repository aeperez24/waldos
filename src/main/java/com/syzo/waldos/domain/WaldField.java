package com.syzo.waldos.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaldField {

    protected List<WaldImage> rows[];
    protected int minSpread=0;
    protected int maxSpread=1;
    protected int width;
    protected int cursor=0;
    protected  int rowHeigh=110;

    protected boolean full=false;

    public WaldField(int cuantityRows,int width){

        this.rows=new List[cuantityRows];
        this.width=width;
        for(int i=0;i<rows.length;i++){
            rows[i]=new ArrayList<WaldImage>();
        }
    }

    public int getFieldWidht(){

        return  width;
    }
    public int getFieldHeight(){

        return rowHeigh*(cursor+1);
    }

    public WaldField(int cuantityRows,int width,int minSpread,int maxSpread){

        this(cuantityRows,width);
        this.minSpread=minSpread;
        this.maxSpread=maxSpread;

    }
    public WaldField(int cuantityRows,int rowHeight,int width,int minSpread,int maxSpread){

        this(cuantityRows,width);
        this.minSpread=minSpread;
        this.maxSpread=maxSpread;
        this.rowHeigh=rowHeight;

    }


    public List<WaldImage> getListImages(){

        final List<WaldImage> result=new ArrayList<>();
        Arrays.stream(rows).forEach(s->s.stream()
                .forEach(wimage->{result.add(wimage);}));
        return  result;
    }
    public void insertImage(WaldImage image){

        if(full){
            System.out.println("Wald field is full!!");
            return;
        }

        int margin=generateSeparation();
        int posx=0;
        int posy=0;

       if(getRowWidth(rows[cursor])+image.getLenght()+margin>width){

           cursor++;

       }


       if(cursor>=rows.length){
           full=true;
           return;
       }
       List<WaldImage> row=rows[cursor];


       posx=getRowWidth(rows[cursor])+margin;
       posy=cursor*rowHeigh;

        image.setPositionx(posx);
        image.setPositiony(posy);
        image.setOpasity(cursor);
        row.add(image);




    }

    private int generateSeparation(){

        //TODO: LOGIC TO GENERATE SEPARATION RANDOMLY

        return -40;

    }

    private int getRowWidth(List<WaldImage> row){
        return row.isEmpty()?0:row.get(row.size()-1).getPositionx()+row.get(row.size()-1).getLenght();

    }
    public void print(){
        for(List<WaldImage> row:rows){

            row.stream().forEach(s->System.out.println(s));
        }
    }

    public boolean isFull(){
        return full;
    }




}
