import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class WarehouseTest {
	
	private Warehouse test;
	@Before
	public void setUp() throws Exception {
		Warehouse test=new Warehouse();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAcquireTool() {
		test.addTool("Hammer",5);
		test.addTool("Drill",10);
		test.addTool("Screw Drivers",3);
		RepairToolInformation hammer=new RepairToolInformation("Hammer",5);
		RepairToolInformation drill=new RepairToolInformation("Drill",10);
		RepairToolInformation ScrewDrivers=new RepairToolInformation("Screw Drivers",3);
		Vector<RepairToolInformation> stove=new Vector<RepairToolInformation>() ;
		stove.addElement(hammer);
		stove.addElement(drill);
		stove.addElement(ScrewDrivers);
		assertTrue(test.tools.get("Hammer")!=null);
		assertTrue(test.tools.get("Drill")!=null);
		assertTrue(test.tools.get("Screw Drivers")!=null);
		test.acquireTool(stove);
		assertTrue(test.tools.get("Hammer")!=null);
		assertTrue(test.tools.get("Drill")!=null);
		assertTrue(test.tools.get("Screw Drivers")!=null);
		assertEquals(test.tools.get("Hammer")._quantity,0);
		assertEquals(test.tools.get("Drill")._quantity,0);
		assertEquals(test.tools.get("Screw Drivers")._quantity,0);
	}

	@Test
	public void testReleaseTool() {
		test.addTool("Hammer",0);
		test.addTool("Drill",0);
		test.addTool("Screw Drivers",0);
		RepairToolInformation hammer=new RepairToolInformation("Hammer",5);
		RepairToolInformation drill=new RepairToolInformation("Drill",10);
		RepairToolInformation ScrewDrivers=new RepairToolInformation("Screw Drivers",3);
		Vector<RepairToolInformation> stove=new Vector<RepairToolInformation>() ;
		stove.addElement(hammer);
		stove.addElement(drill);
		stove.addElement(ScrewDrivers);
		assertTrue(test.tools.get("Hammer")!=null);
		assertTrue(test.tools.get("Drill")!=null);
		assertTrue(test.tools.get("Screw Drivers")!=null);
		test.releaseTool(stove);
		assertTrue(test.tools.get("Hammer")!=null);
		assertTrue(test.tools.get("Drill")!=null);
		assertTrue(test.tools.get("Screw Drivers")!=null);
		assertEquals(test.tools.get("Hammer")._quantity,5);
		assertEquals(test.tools.get("Drill")._quantity,10);
		assertEquals(test.tools.get("Screw Drivers")._quantity,3);
		
	}

	@Test
	public void testAcquireMaterial() {
		test.addMaterial("Nails",5);
		test.addMaterial("Screws",10);
		test.addMaterial("Sand Cloth",3);
		RepairMaterialsInformation nails=new RepairMaterialsInformation("Nails",5);
		RepairMaterialsInformation screws=new RepairMaterialsInformation("Screws",10);
		RepairMaterialsInformation sand=new RepairMaterialsInformation("Sand Cloth",3);
		Vector<RepairMaterialsInformation> stove=new Vector<RepairMaterialsInformation>() ;
		stove.addElement(nails);
		stove.addElement(screws);
		stove.addElement(sand);
		test.acquireMaterial(stove);
		assertTrue(test.tools.get("Nails")!=null);
		assertTrue(test.tools.get("Screws")!=null);
		assertTrue(test.tools.get("Sand Cloth")!=null);
		assertEquals(test.tools.get("Nails")._quantity,0);
		assertEquals(test.tools.get("Screws")._quantity,0);
		assertEquals(test.tools.get("Sand Cloth")._quantity,0);

	}

	@Test
	public void testAddTool() {
		test.addTool("Hammer",5);
		assertTrue(test.tools.get("Hammer")!=null);
		assertEquals(test.tools.size(),1);
		test.addTool("Drill",10);
		assertEquals(test.tools.size(),2);
		assertTrue(test.tools.get("Drill")!=null);
		assertEquals(5,test.tools.get("Hammer")._quantity);
		assertEquals(10,test.tools.get("Drill")._quantity);
	}

	@Test
	public void testAddMaterial() {
		test.addMaterial("Sand",5);
		assertTrue(test.materials.get("Sand")!=null);
		assertEquals(test.materials.size(),1);
		test.addTool("Nails",10);
		assertEquals(test.materials.size(),2);
		assertTrue(test.materials.get("Nails")!=null);
		assertEquals(5,test.materials.get("Sand")._quantity);
		assertEquals(10,test.materials.get("Nails")._quantity);
	}
	@Test
	public void testCheckIfToolsAvailable()
	{
		test.addTool("Hammer",5);
		test.addTool("Drill",10);
		test.addTool("Screw Drivers",3);
		RepairToolInformation hammer=new RepairToolInformation("Hammer",5);
		RepairToolInformation drill=new RepairToolInformation("Drill",10);
		RepairToolInformation ScrewDrivers=new RepairToolInformation("Screw Drivers",3);
		Vector<RepairToolInformation> stove=new Vector<RepairToolInformation>() ;
		stove.addElement(hammer);
		stove.addElement(drill);
		stove.addElement(ScrewDrivers);
		RepairToolInformation hammer2=new RepairToolInformation("Hammer",15);
		RepairToolInformation drill2=new RepairToolInformation("Drill",10);
		RepairToolInformation ScrewDrivers2=new RepairToolInformation("Screw Drivers",4);
		Vector<RepairToolInformation> stove2=new Vector<RepairToolInformation>() ;
		stove.addElement(hammer2);
		stove.addElement(drill2);
		stove.addElement(ScrewDrivers2);
		assertTrue(test.checkIfToolsAvailable(stove));
		assertFalse(test.checkIfToolsAvailable(stove2));
		assertEquals(test.tools.get("Hammer")._quantity,5);
		assertEquals(test.tools.get("Drill")._quantity,10);
		assertEquals(test.tools.get("Screw Drivers")._quantity,3);
	}

}
