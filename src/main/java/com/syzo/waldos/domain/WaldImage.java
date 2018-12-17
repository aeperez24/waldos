package com.syzo.waldos.domain;

import java.io.Serializable;

public class WaldImage implements Serializable {

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getOpasity() {
        return opasity;
    }

    public void setOpasity(float opasity) {
        this.opasity = opasity;
    }

    public int getPositionx() {
        return positionx;
    }

    public void setPositionx(int position) {
        this.positionx = position;
    }


    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int position) {
        this.positiony = position;
    }

    protected  int height;
    protected int lenght;
    protected String path;
    protected String id;
    protected float opasity;
    protected int positionx;
    protected int positiony;

    @Override
    public String toString() {
        return "WaldImage{" +
                "height=" + height +
                ", lenght=" + lenght +
                ", path='" + path + '\'' +
                ", id='" + id + '\'' +
                ", opasity=" + opasity +
                ", positionx=" + positionx +
                ", positiony=" + positiony +
                '}';
    }
}
