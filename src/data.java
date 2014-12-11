import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class data {
	
public static void initialData(){
	    try {
	 
			File initialData = new File("/users/studs/bsc/2015/barakgo/Dropbox/spl/as3/InitialData.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(initialData);
			doc.getDocumentElement().normalize();
		 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getElementsByTagName("Tool");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					//warehosuse.addTool(eElement.getElementsByTagName("name").item(0).getTextContent(),
					//					eElement.getElementsByTagName("quantity").item(0).getTextContent());
					
					System.out.println("tool name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("quantity : " + eElement.getElementsByTagName("quantity").item(0).getTextContent());
		 
				}
			}
			nList = doc.getElementsByTagName("Material");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					//warehosuse.addMaterial(eElement.getElementsByTagName("name").item(0).getTextContent(),
					//					eElement.getElementsByTagName("quantity").item(0).getTextContent());
					
					System.out.println("Material name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("quantity : " + eElement.getElementsByTagName("quantity").item(0).getTextContent());
		 
				}
			}
			nList = doc.getElementsByTagName("Clerk");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Node nNode1 = eElement.getElementsByTagName("Location").item(0);
					Element e1Element = (Element) nNode1;
					//warehosuse.addClerk(eElement.getElementsByTagName("Clerk").item(0).getTextContent(),
					//					e1Element.getAttribute("x"),e1Element.getAttribute("y"));
					
					System.out.println("Clerk name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Location: " + e1Element.getAttribute("x") +" " + e1Element.getAttribute("y"));
		 
				}
			}
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	  }
public static void Assets(){
    try {
 
		File initialData = new File("/users/studs/bsc/2015/barakgo/Dropbox/spl/as3/Assets.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(initialData);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("Asset");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				Element eElement = (Element) nNode;
				Node nNode1 = eElement.getElementsByTagName("Location").item(0);
				Element e1Element = (Element) nNode1;
				String assetName=eElement.getElementsByTagName("Name").item(0).getTextContent();
				String Type=eElement.getElementsByTagName("Type").item(0).getTextContent();
				int size=Integer.parseInt(eElement.getElementsByTagName("Size").item(0).getTextContent());
				int xLocation=Integer.parseInt(e1Element.getAttribute("x"));
				System.out.println("xlocation= "+xLocation);
				int yLocation=Integer.parseInt(e1Element.getAttribute("y"));
				
				int costPerNight=Integer.parseInt(eElement.getElementsByTagName("CostPerNight").item(0).getTextContent());
				NodeList nList1 = e1Element.getElementsByTagName("AssetContent");
				for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) 
				{
					Node nNode2 = nList1.item(temp1);
					if (nNode2.getNodeType() == Node.ELEMENT_NODE)
					{
						Element eElement1 = (Element) nNode2;
						String AssetContent=eElement1.getElementsByTagName("Name").item(0).getTextContent();
						System.out.println("AssetContent= "+AssetContent);
						int repairMultiplier=Integer.parseInt(eElement1.getElementsByTagName("RepairMultiplier").item(0).getTextContent());
					}
				}
			}
			
		}
    }
    catch (Exception e) {
	e.printStackTrace();
    }}
    public static void CustomersGroups(){
        try {
     
    		File initialData = new File("/users/studs/bsc/2015/barakgo/Dropbox/spl/as3/CustomersGroups.xml");
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    		Document doc = dBuilder.parse(initialData);
    		doc.getDocumentElement().normalize();
    		NodeList nList = doc.getElementsByTagName("CustomerGroupDetails");
    		for (int temp = 0; temp < nList.getLength(); temp++)
    		{
    			Node nNode = nList.item(temp);
    			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
    			{
    				Element eElement = (Element) nNode;
    				String groupManagerName=eElement.getElementsByTagName("GroupManagerName").item(0).getTextContent();
    				NodeList nList1 = eElement.getElementsByTagName("Customer");
    				for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) 
    				{
    					Node nNode2 = nList1.item(temp1);
    					if (nNode2.getNodeType() == Node.ELEMENT_NODE)
    					{
    						Element eElement1 = (Element) nNode2;
    						String customerName=eElement1.getElementsByTagName("Name").item(0).getTextContent();
    						String vandalism=eElement1.getElementsByTagName("Vandalism").item(0).getTextContent();
    						int minimumDamage=Integer.parseInt(eElement1.getElementsByTagName("MinimumDamage").item(0).getTextContent());
    						int MaximumDamage=Integer.parseInt(eElement1.getElementsByTagName("MaximumDamage").item(0).getTextContent());
    						System.out.println("minimumDamage= "+minimumDamage);
    					}
    				}
    				NodeList nList2 = eElement.getElementsByTagName("Request");
    				for (int temp1 = 0; temp1 < nList2.getLength(); temp1++) 
    				{
    					Node nNode3 = nList2.item(temp1);
    					if (nNode3.getNodeType() == Node.ELEMENT_NODE)
    					{
    						Element eElement2 = (Element) nNode3;
    						String id=eElement2.getAttribute("id");
    						String type=eElement2.getElementsByTagName("Type").item(0).getTextContent();
    						int size=Integer.parseInt(eElement2.getElementsByTagName("Size").item(0).getTextContent());
    						int duration=Integer.parseInt(eElement2.getElementsByTagName("Duration").item(0).getTextContent());
    						System.out.println("duration= "+duration);
    						System.out.println("id= "+id);
    					}
    				}
    			}
    			
    		}
        }
        catch (Exception e) {
    	e.printStackTrace();
        }
	  }
  }
	 
	

