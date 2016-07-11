package gm4p.gameobjects;

import java.util.ArrayList;
import gm4p.utils.InputHelper;
import processing.core.*;

public class GameObjectList extends GameObject {
	
	public ArrayList<GameObject> objects;
	
	public GameObjectList(){
		objects = new ArrayList<GameObject>();
	}
	
	public void add(GameObject go){
		objects.add(go);
	}
	
	void remove(GameObject go){
		objects.remove(go);
	}
	
	@Override
	public void update(int elapsedTimeMs){
		for (GameObject go : objects)
			go.update(elapsedTimeMs);
	}
	
	@Override
	public void integrate(int elapsedTimeMs){
		for (GameObject go : objects)
			go.integrate(elapsedTimeMs);
	}
	
	@Override
	public void draw(PGraphics ctx){
		for (GameObject go : objects)
			go.draw(ctx);
	}
	
	@Override
	public void handleInput(InputHelper inputHelper){
		for (GameObject go : objects)
			go.handleInput(inputHelper);
	}
	
	@Override
	public void reset(){
		for (GameObject go : objects)
			go.reset();
	}
	
}
