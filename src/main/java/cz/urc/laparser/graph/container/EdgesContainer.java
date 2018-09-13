package cz.urc.laparser.graph.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import cz.urc.isrman.client.gui.utils.dragAndDrop.dataConteiner.TableDataContainer;

public class EdgesContainer {

    public List<EdgesContainerItem> getEdgeList() {
		return edgeList;
	}

	private List<EdgesContainerItem> edgeList = new ArrayList<>();
    
    
    private String removeWhitespaces(String st) {
        return st.replaceAll("\\s+","");
    }
    
    public void addEdge(String idNode1, String idNode2, String edgeName) {
    	EdgesContainerItem item = new EdgesContainerItem();
    	item.setIdNode1(idNode1);
    	item.setIdNode2(idNode2);
    	item.setEdgeName(edgeName);
    	edgeList.add(item);
    }
    
    public EdgesContainerItem findEdgeForNodes(String idNode1, String idNode2) {
        return edgeList
                .stream()
                .filter(x -> x.getIdNode1().equals(idNode1) && x.getIdNode2().equals(idNode2))
                .findAny()
                .orElse(null);
    }
    
    public EdgesContainerItem findOppositeEdgeForNodes(String idNode1, String idNode2) {
    	return findEdgeForNodes(idNode2, idNode1);
    }
    
    public void addEdges(TableDataContainer tableDataContainer) {
    	String idNode1;
    	String idNode2;
    	String edgeName;
    	idNode1 = (removeWhitespaces(tableDataContainer.getId()));
    	HashMap<String, String> connections = tableDataContainer.getConnections();
    	for (Entry<String, String> entry : connections.entrySet())
    	{
    		idNode2 = (removeWhitespaces(entry.getKey()));
    		edgeName = entry.getValue();
    		if ((findEdgeForNodes(idNode1, idNode2) == null) && (findOppositeEdgeForNodes(idNode1, idNode2) == null)) {
    			addEdge(idNode1, idNode2, edgeName);
    			//System.out.println(idNode1 + " -> " + idNode2 + " - " + edgeName + " added" );
    		} else {
    			//System.out.println(idNode1 + " -> " + idNode2 + " - " + edgeName + " exists !" );
    		}
    		
    	    
    	}    
    }
    
    public void addEdges(List<TableDataContainer> containers) {
        for (TableDataContainer tableDataContainer : containers) {
        	addEdges(tableDataContainer);
        }
    }
    

}
