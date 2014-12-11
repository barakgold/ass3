import java.util.Vector;


public interface WarehouseInterface {

	/**
	 * @inv each tool is exist in the warehouse 
	 * @post each tool quantity decrease by the demand
	 * @param tools
	 */
	
	void acquireTool(Vector<RepairToolInformation> tools);
	/**
	 * @inv each tool is exist in the warehouse all
	 * @post each tool quantity increase by the release details
	 * @param tools
	 */
	void releaseTool(Vector<RepairToolInformation> tools);
	/**
	 * @inv each material is still exist in the warehouse 
	 * @post each material quantity decrease by the demand
	 * @param materials
	 */
	void acquireMaterial(Vector<RepairMaterialsInformation> materials);
	/**
	 * @post the tool amount increase by  quantity value that given(if the tool wasn't exist, the amount will be quantity)
	 * @post the tool is exist in the warehouse  
	 * @post number of tools increased by the num of new tools
	 * @param tool
	 * @param quantity
	 */
	void addTool(String tool,int quantity);
	/**
	 * @post the material amount increased by quantity value that given(if the material wasn't exist, the amount will be quantity)
	 * @post the material is exist in the warehouse
	 * @post number of tools increased by the num of new tools
	 * @param materials
	 * @param quantity
	 */
	void addMaterial(String materials,int quantity);
	/**
	 * @return true if all tools are available, false otherwise
	 * @post all tools amounts didn't changed
	 * @param tools
	 */
	boolean checkIfToolsAvailable(Vector<RepairToolInformation> tools);
	
}
