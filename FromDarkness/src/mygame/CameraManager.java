package mygame;

import com.jme3.app.Application;
import com.jme3.app.FlyCamAppState;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.input.ChaseCamera;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;


public class CameraManager extends AbstractAppState{

private SimpleApplication app;
private AppStateManager   stateManager;
private InputManager      inputManager;
private Camera            cam;

public FlyByCamera       flyCam;
public ChaseCamera       chaseCam;

    
public Player player;
  
  @Override
  public void initialize(AppStateManager stateManager, Application app) {
    super.initialize(stateManager, app);
    
    this.app = (SimpleApplication) app; // can cast Application to something more specific
    this.stateManager = this.app.getStateManager();
    this.inputManager = this.app.getInputManager();
    this.cam          = this.app.getCamera();
    this.player        = this.stateManager.getState(Player.class).player;
    this.flyCam        = this.stateManager.getState(FlyCamAppState.class).getCamera();
    
    flyCam.setEnabled(false);
    flyCam.setDragToRotate(false);
    Node model = (Node)player.Model.getChild("FaceNode");
    chaseCam = new ChaseCamera(cam, model, inputManager);
    chaseCam.setSmoothMotion(false);
    chaseCam.setDragToRotate(false);
    chaseCam.setMaxDistance(10f);
    System.out.println("Camera State Attached");
  
    }
    
    @Override
    public void update(float tpf){
    }
        
    
    
}
