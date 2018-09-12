package cz.urc.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.urc.graph.container.EdgesContainer;
import cz.urc.graph.container.EdgesContainerItem;
import cz.urc.graph.container.NodesContainer;
import cz.urc.graph.container.NodesContainerItem;
import cz.urc.graphvizapi.Attribute;
import cz.urc.graphvizapi.Edge;
import cz.urc.graphvizapi.Graph;
import cz.urc.graphvizapi.GraphType;
import cz.urc.graphvizapi.Graphviz;
import cz.urc.graphvizapi.Node;
import cz.urc.isrman.client.gui.utils.dragAndDrop.dataConteiner.TableDataContainer;

public class GraphService {
    
    
    public static String convertToGraphviz(List<TableDataContainer> containers) {
        Graphviz gv = new Graphviz();
        Graph graph = new Graph("g1", GraphType.DIGRAPH);
        graph.addAttribute(new Attribute("rankdir", "TB"));
        
        NodesContainer nodesContainer = new NodesContainer();
        nodesContainer.addNodes(containers);
        
        List<NodesContainerItem> nodeList = nodesContainer.getNodeList();
        Map<String,Node> nodeMap = new HashMap<>();
        for (NodesContainerItem item : nodeList) {
        	Node node = new Node(item.getId(), item.getName());
        	graph.addNode(node);
        	nodeMap.put(item.getId(), node);
		}
        
        EdgesContainer edgesContainer = new EdgesContainer();
        edgesContainer.addEdges(containers);

        List<EdgesContainerItem> edgeList = edgesContainer.getEdgeList();
        for (EdgesContainerItem item : edgeList) {
        	String idNode1 = item.getIdNode1();
        	String idNode2 = item.getIdNode2();
        	Edge edge = new Edge(nodeMap.get(idNode1), nodeMap.get(idNode2), item.getEdgeName());
        	graph.addEdge(edge);
		}
        
        System.out.println("graph:");
        System.out.println("=============================");
        System.out.println(gv.genDotStringByGraph(graph));
        System.out.println("=============================");

    	
    	return gv.genDotStringByGraph(graph);
    }

}
