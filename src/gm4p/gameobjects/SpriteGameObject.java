package gm4p.gameobjects;

import gm4p.GM;
import gm4p.utils.*;
import gm4p.utils.SpriteSheet;
import processing.core.*;

public class SpriteGameObject extends GameObject {
    private PImage spriteImage;
    private SpriteSheet spriteSheet;
    public float angle;
    public PVector origin, dimension;
    public String assetName;
    private GameObject lookatTarget;
    protected boolean visible;

    public SpriteGameObject(String assetName) {
        super();
        visible = true;
        setImage(assetName);
        origin = new PVector(0, 0);
        this.assetName = assetName;

        GM.debugMessage("SpriteGameObject created:" + this.toString());

    }

    public void setImage(String imageName) {

        try {
            if (imageName.matches(".*@X(\\d*)N(\\d*).png"))
                spriteSheet = new SpriteSheet(imageName);
            else
                spriteImage = GM.assetManager.get(imageName);

            if (spriteImage != null)
                dimension = new PVector(spriteImage.width, spriteImage.height);
            else if (spriteSheet != null)
                dimension = new PVector(spriteSheet.frameWidth, spriteSheet.frameHeight);
        } catch (Exception e) {
            GM.debugMessage(e.getMessage());
        }
    }

    void update() {
        if (spriteSheet != null)
            spriteSheet.update();
    }

    public PVector getCenter() {
        return PVector.div(dimension, 2);
    }

    public void draw(PGraphics ctx) {
        if (visible) {
            ctx.pushMatrix();
            {
                ctx.translate(position.x, position.y);
                ctx.pushMatrix();
                {
                    ctx.rotate(angle);
                    ctx.pushMatrix();
                    {
                        ctx.translate(-origin.x, -origin.y);

                        if (spriteImage != null)
                            ctx.image(spriteImage, 0, 0);
                        else {
                            ctx.translate(dimension.x / 2, dimension.y / 2);
                            spriteSheet.draw(ctx);
                        }
                        ctx.popMatrix();
                    }
                    ctx.popMatrix();
                }
            }
            ctx.popMatrix();
        }
    }

    public void update(int elapsedTimeMs) {
        super.update(elapsedTimeMs);
        if (lookatTarget != null)
            setAngularDirection(PVector.sub(lookatTarget.position, position));
    }

    public void setAngularDirection(PVector angularDirection) {
        angularDirection.normalize();
        angle = PApplet.atan2(angularDirection.y, angularDirection.x);
    }

    public PVector getAngularDirection() {
        return new PVector(PApplet.cos(angle), PApplet.sin((angle)));
    }

    public Rectangle getBoundingBox() {

        return new Rectangle(PVector.sub(position, origin), dimension);
    }

    public void setLookatTarget(GameObject lookatTarget) {
        this.lookatTarget = lookatTarget;
    }

    public boolean collidesWith(SpriteGameObject other) {

        if (isVisible() && other.isVisible()) {
            if (this.getBoundingBox().overlaps(other.getBoundingBox())) {
                Rectangle overlap = this.getBoundingBox().getOverlap(other.getBoundingBox());

                PVector p = this.position,
                        o = this.origin,
                        op = other.position,
                        oo = other.origin;

                for (int iX = 0; iX < overlap.dimension.x; iX++) {
                    for (int iY = 0; iY < overlap.dimension.y; iY++) {
                        int thisx = (int) overlap.position.x - (int) (p.x - o.x) + iX;
                        int thisy = (int) overlap.position.y - (int) (p.y - o.y) + iY;
                        int objx = (int) overlap.position.x - (int) (op.x - oo.x) + iX;
                        int objy = (int) overlap.position.y - (int) (op.y - oo.y) + iY;

                        char[][] birdCache = GM.assetManager.getPixelCache(this.assetName);
                        char[][] pipeCache = GM.assetManager.getPixelCache(other.assetName);

                        if ((birdCache[thisx][thisy] > 0) && (pipeCache[objx][objy] > 0))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
