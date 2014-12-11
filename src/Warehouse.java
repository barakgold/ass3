import java.util.*;
public class Warehouse implements WarehouseInterface {
	protected HashMap<String,RepairTool> tools;
	protected HashMap<String,RepairMaterial> materials;
	
	public Warehouse (){}
	
	public synchronized void acquireTool(Vector<RepairToolInformation> tools) {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void releaseTool(Vector<RepairToolInformation> tools) {
		// TODO Auto-generated method stub
	}
	
	public synchronized void acquireMaterial(Vector<RepairMaterialsInformation> materials) {
		
	}
	
	public synchronized void addTool(String tool,int quantity){

	}
	
	public synchronized void addMaterial(String materials,int quantity){
		
	}
	
	
	public synchronized boolean checkIfToolsAvailable(Vector<RepairToolInformation> tools){
		return true;
	}
}
