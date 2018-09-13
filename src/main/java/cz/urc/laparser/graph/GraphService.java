package cz.urc.laparser.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cz.urc.isrman.client.gui.utils.dragAndDrop.dataConteiner.TableDataContainer;
import cz.urc.laparser.graph.container.EdgesContainer;
import cz.urc.laparser.graph.container.EdgesContainerItem;
import cz.urc.laparser.graph.container.NodesContainer;
import cz.urc.laparser.graph.container.NodesContainerItem;
import cz.urc.laparser.graph.graphvizapi.Attribute;
import cz.urc.laparser.graph.graphvizapi.Edge;
import cz.urc.laparser.graph.graphvizapi.Graph;
import cz.urc.laparser.graph.graphvizapi.GraphType;
import cz.urc.laparser.graph.graphvizapi.Graphviz;
import cz.urc.laparser.graph.graphvizapi.Node;

public class GraphService {
    
    
    public static String convertToGraphviz(List<TableDataContainer> inputContainers) {

        List<TableDataContainer> containers;
        containers = inputContainers
                .stream()
                .sorted(Comparator.comparing(TableDataContainer::getHierarchy))
                .collect(Collectors.toList());
        
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
