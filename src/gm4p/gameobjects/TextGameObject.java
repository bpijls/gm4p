package gm4p.gameobjects;
import gm4p.*;

import processing.core.PGraphics;

public class TextGameObject extends GameObject {
    protected String text;
    private int size;

    public  TextGameObject(String text){
        this.text = text;
        this.size = 24;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public float getWidth(){
        return GM.p.textWidth(this.text);
    }

    public float getHeight(){
        return (float)this.size;
    }

    @Override
    public void draw(PGraphics ctx){
        ctx.textSize(this.size);
        ctx.text(this.text, position.x, position.y+size);
    }
}
