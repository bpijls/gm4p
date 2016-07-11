package gm4p.utils;

import gm4p.GM;
import processing.core.*;

public class Rectangle {
    public PVector position, dimension;

    public Rectangle(PVector position, PVector dimension) {
        this.position = position.copy();
        this.dimension = dimension.copy();
    }

    public float getTop() {
        return position.y;
    }

    public float getBottom() {
        return position.y + dimension.y;
    }

    public float getLeft() {
        return position.x;
    }

    public float getRight() {
        return position.x + dimension.x;
    }

    public PVector getLocalCenter() {
        return PVector.div(dimension, 2);
    }

    public PVector getCenter() {
        return PVector.add(position, getLocalCenter());
    }

    public boolean overlaps(Rectangle other) {
        return this.position.x < other.position.x + other.dimension.x &&
                this.position.x + this.dimension.x > other.position.x &&
                this.position.y < other.position.y + other.dimension.y &&
                this.position.y + this.dimension.y > other.position.y;
    }

    public Rectangle getOverlap(Rectangle other) {
        int xmin = (int) PApplet.max(this.getLeft(), other.getLeft());
        int xmax = (int) PApplet.min(this.getRight(), other.getRight());
        int ymin = (int) PApplet.max(this.getTop(), other.getTop());
        int ymax = (int) PApplet.min(this.getBottom(), other.getBottom());
        return new Rectangle(new PVector(xmin, ymin), new PVector(xmax - xmin, ymax - ymin));
    }

    public void draw(PGraphics ctx) {
        ctx.noFill();
        ctx.stroke(0, 255, 0);
        ctx.rect(position.x, position.y, dimension.x, dimension.y);

    }
}
