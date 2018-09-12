package cz.urc.graphvizapi.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

/**
 * Created by frank on 2014/11/20.
 */
public class urcExample2 {

    private static String tmpPath = "/Users/mryska/prac/tmp";
    
    private List<TableDataContainer> containers;

   
    public static void main(String[] args)
    {
        urcExample2 ex = new urcExample2 ();
        ex.draw0();
    }

    private void draw0()
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            containers = mapper.readValue(json, new TypeReference<List<TableDataContainer>>() {
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   	
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


        String type = "png";

        File out = new File(tmpPath+"/outLINK0."+ type);
        this.writeGraphToFile( gv.getGraphByteArray(graph, type, "100"), out );
    }

    public int writeGraphToFile(byte[] img, File to)
    {
        try {
            FileOutputStream fos = new FileOutputStream(to);
            fos.write(img);
            fos.close();
        } catch (java.io.IOException ioe) { return -1; }
        return 1;
    }

    static final String json = "[  \n" + 
            "   {  \n" + 
            "      \"id\":\"Jedle 313\",\n" + 
            "      \"layoutX\":3108.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Jedle 313\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Jedle 31\":\"40125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"40125000\":[  \n" + 
            "            \"6992602a-b5b5-4fce-ae11-8bdc5087d779\",\n" + 
            "            \"980a3869-dfc2-423f-8530-5bef5978423b\",\n" + 
            "            \"f9456b59-d582-4be0-8c25-73bb64924c87\",\n" + 
            "            \"f9456b59-d582-4be0-8c25-73bb64924c87\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Jedle 312\",\n" + 
            "      \"layoutX\":2895.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Jedle 312\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Jedle 31\":\"40125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"40125000\":[  \n" + 
            "            \"6992602a-b5b5-4fce-ae11-8bdc5087d779\",\n" + 
            "            \"980a3869-dfc2-423f-8530-5bef5978423b\",\n" + 
            "            \"980a3869-dfc2-423f-8530-5bef5978423b\",\n" + 
            "            \"f9456b59-d582-4be0-8c25-73bb64924c87\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Pila 111\",\n" + 
            "      \"layoutX\":1314.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Pila 111\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Pila 11\":\"32125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"32125000\":[  \n" + 
            "            \"3be8cdea-e071-4013-a1ca-dbfcf8fd1289\",\n" + 
            "            \"3be8cdea-e071-4013-a1ca-dbfcf8fd1289\",\n" + 
            "            \"1261cf93-2397-4b64-b2f3-87bf0ba2a130\",\n" + 
            "            \"ad02ebc0-744f-4791-b8a5-be414b83d74a\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Jedle 311\",\n" + 
            "      \"layoutX\":2628.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Jedle 311\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Jedle 31\":\"40125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"40125000\":[  \n" + 
            "            \"6992602a-b5b5-4fce-ae11-8bdc5087d779\",\n" + 
            "            \"6992602a-b5b5-4fce-ae11-8bdc5087d779\",\n" + 
            "            \"980a3869-dfc2-423f-8530-5bef5978423b\",\n" + 
            "            \"f9456b59-d582-4be0-8c25-73bb64924c87\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Lípa 213\",\n" + 
            "      \"layoutX\":67.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Lípa 213\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Lípa 21\":\"35500000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"35500000\":[  \n" + 
            "            \"d08e9ec1-43ea-48d4-81bb-f0b4147f41c5\",\n" + 
            "            \"215962a1-0cc7-4fc8-b1a0-31cb2721d9e7\",\n" + 
            "            \"e3b075dc-ae9b-41fd-ae2c-debdfd329094\",\n" + 
            "            \"e3b075dc-ae9b-41fd-ae2c-debdfd329094\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Lípa 212\",\n" + 
            "      \"layoutX\":287.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Lípa 212\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Lípa 21\":\"35500000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"35500000\":[  \n" + 
            "            \"d08e9ec1-43ea-48d4-81bb-f0b4147f41c5\",\n" + 
            "            \"215962a1-0cc7-4fc8-b1a0-31cb2721d9e7\",\n" + 
            "            \"215962a1-0cc7-4fc8-b1a0-31cb2721d9e7\",\n" + 
            "            \"e3b075dc-ae9b-41fd-ae2c-debdfd329094\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Palcát 692\",\n" + 
            "      \"layoutX\":776.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Palcát 692\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Pohroma 69\":\"65125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"65125000\":[  \n" + 
            "            \"37d555bc-0136-41b2-8833-b595c685217d\",\n" + 
            "            \"78e55335-2ad1-48fc-a69a-ab834b7c4fb7\",\n" + 
            "            \"78e55335-2ad1-48fc-a69a-ab834b7c4fb7\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Lípa 211\",\n" + 
            "      \"layoutX\":500.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Lípa 211\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Lípa 21\":\"35500000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"35500000\":[  \n" + 
            "            \"d08e9ec1-43ea-48d4-81bb-f0b4147f41c5\",\n" + 
            "            \"d08e9ec1-43ea-48d4-81bb-f0b4147f41c5\",\n" + 
            "            \"215962a1-0cc7-4fc8-b1a0-31cb2721d9e7\",\n" + 
            "            \"e3b075dc-ae9b-41fd-ae2c-debdfd329094\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Jedle 31\",\n" + 
            "      \"layoutX\":2911.0,\n" + 
            "      \"layoutY\":100.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Jedle 31\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Jedle 313\":\"40125000\",\n" + 
            "         \"Jedle 312\":\"40125000\",\n" + 
            "         \"Jedle 311\":\"40125000\",\n" + 
            "         \"Bouře 63\":\"53725000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"53725000\":[  \n" + 
            "            \"8ace51cb-6302-49a3-b9b6-f9e703b3d0b3\",\n" + 
            "            \"745743e9-bcd5-423a-b8ff-5393a36f32d2\",\n" + 
            "            \"420125a6-c87b-4089-919d-94304518ee1a\",\n" + 
            "            \"420125a6-c87b-4089-919d-94304518ee1a\",\n" + 
            "            \"df716250-3987-4fb7-b922-d55cb6b33b24\",\n" + 
            "            \"f37ab1f7-6417-4c00-8b47-5aad6be3aeba\" \n" + 
            "         ],\n" + 
            "         \"40125000\":[  \n" + 
            "            \"6992602a-b5b5-4fce-ae11-8bdc5087d779\",\n" + 
            "            \"6992602a-b5b5-4fce-ae11-8bdc5087d779\",\n" + 
            "            \"980a3869-dfc2-423f-8530-5bef5978423b\",\n" + 
            "            \"f9456b59-d582-4be0-8c25-73bb64924c87\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":1\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Pila 11\",\n" + 
            "      \"layoutX\":1507.0,\n" + 
            "      \"layoutY\":200.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Pila 11\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Pila 111\":\"32125000\",\n" + 
            "         \"Pila 113\":\"32125000\",\n" + 
            "         \"Pila 112\":\"32125000\",\n" + 
            "         \"Bouře 63\":\"53725000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"32125000\":[  \n" + 
            "            \"3be8cdea-e071-4013-a1ca-dbfcf8fd1289\",\n" + 
            "            \"1261cf93-2397-4b64-b2f3-87bf0ba2a130\",\n" + 
            "            \"1261cf93-2397-4b64-b2f3-87bf0ba2a130\",\n" + 
            "            \"ad02ebc0-744f-4791-b8a5-be414b83d74a\" \n" + 
            "         ],\n" + 
            "         \"53725000\":[  \n" + 
            "            \"8ace51cb-6302-49a3-b9b6-f9e703b3d0b3\",\n" + 
            "            \"8ace51cb-6302-49a3-b9b6-f9e703b3d0b3\",\n" + 
            "            \"745743e9-bcd5-423a-b8ff-5393a36f32d2\",\n" + 
            "            \"420125a6-c87b-4089-919d-94304518ee1a\",\n" + 
            "            \"df716250-3987-4fb7-b922-d55cb6b33b24\",\n" + 
            "            \"f37ab1f7-6417-4c00-8b47-5aad6be3aeba\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":2\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Zásek 691\",\n" + 
            "      \"layoutX\":1982.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Zásek 691\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Zásek 69\":\"41125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"41125000\":[  \n" + 
            "            \"644e7186-38de-4060-8bd1-873bf35083c2\",\n" + 
            "            \"644e7186-38de-4060-8bd1-873bf35083c2\",\n" + 
            "            \"45786a9c-39ed-4536-b2ea-c1e74027b8d1\",\n" + 
            "            \"57657dc5-c395-40c0-89ac-17f0715e14df\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Zásek 69\",\n" + 
            "      \"layoutX\":2216.0,\n" + 
            "      \"layoutY\":100.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Zásek 69\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Zásek 691\":\"41125000\",\n" + 
            "         \"zásek 693\":\"41125000\",\n" + 
            "         \"Bouře 63\":\"53725000\",\n" + 
            "         \"zásek 692\":\"41125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"53725000\":[  \n" + 
            "            \"8ace51cb-6302-49a3-b9b6-f9e703b3d0b3\",\n" + 
            "            \"745743e9-bcd5-423a-b8ff-5393a36f32d2\",\n" + 
            "            \"420125a6-c87b-4089-919d-94304518ee1a\",\n" + 
            "            \"df716250-3987-4fb7-b922-d55cb6b33b24\",\n" + 
            "            \"f37ab1f7-6417-4c00-8b47-5aad6be3aeba\",\n" + 
            "            \"f37ab1f7-6417-4c00-8b47-5aad6be3aeba\" \n" + 
            "         ],\n" + 
            "         \"41125000\":[  \n" + 
            "            \"644e7186-38de-4060-8bd1-873bf35083c2\",\n" + 
            "            \"45786a9c-39ed-4536-b2ea-c1e74027b8d1\",\n" + 
            "            \"45786a9c-39ed-4536-b2ea-c1e74027b8d1\",\n" + 
            "            \"57657dc5-c395-40c0-89ac-17f0715e14df\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":1\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Lípa 21\",\n" + 
            "      \"layoutX\":286.0,\n" + 
            "      \"layoutY\":100.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Lípa 21\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Lípa 213\":\"35500000\",\n" + 
            "         \"Lípa 212\":\"35500000\",\n" + 
            "         \"Lípa 211\":\"35500000\",\n" + 
            "         \"Bouře 63\":\"53725000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"53725000\":[  \n" + 
            "            \"8ace51cb-6302-49a3-b9b6-f9e703b3d0b3\",\n" + 
            "            \"745743e9-bcd5-423a-b8ff-5393a36f32d2\",\n" + 
            "            \"745743e9-bcd5-423a-b8ff-5393a36f32d2\",\n" + 
            "            \"420125a6-c87b-4089-919d-94304518ee1a\",\n" + 
            "            \"df716250-3987-4fb7-b922-d55cb6b33b24\",\n" + 
            "            \"f37ab1f7-6417-4c00-8b47-5aad6be3aeba\" \n" + 
            "         ],\n" + 
            "         \"35500000\":[  \n" + 
            "            \"d08e9ec1-43ea-48d4-81bb-f0b4147f41c5\",\n" + 
            "            \"d08e9ec1-43ea-48d4-81bb-f0b4147f41c5\",\n" + 
            "            \"215962a1-0cc7-4fc8-b1a0-31cb2721d9e7\",\n" + 
            "            \"e3b075dc-ae9b-41fd-ae2c-debdfd329094\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":1\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Šiška 691\",\n" + 
            "      \"layoutX\":974.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Šiška 691\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Pohroma 69\":\"65125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"65125000\":[  \n" + 
            "            \"37d555bc-0136-41b2-8833-b595c685217d\",\n" + 
            "            \"37d555bc-0136-41b2-8833-b595c685217d\",\n" + 
            "            \"78e55335-2ad1-48fc-a69a-ab834b7c4fb7\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"zásek 693\",\n" + 
            "      \"layoutX\":2208.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"zásek 693\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Zásek 69\":\"41125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"41125000\":[  \n" + 
            "            \"644e7186-38de-4060-8bd1-873bf35083c2\",\n" + 
            "            \"45786a9c-39ed-4536-b2ea-c1e74027b8d1\",\n" + 
            "            \"57657dc5-c395-40c0-89ac-17f0715e14df\",\n" + 
            "            \"57657dc5-c395-40c0-89ac-17f0715e14df\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Pila 113\",\n" + 
            "      \"layoutX\":1701.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Pila 113\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Pila 11\":\"32125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"32125000\":[  \n" + 
            "            \"3be8cdea-e071-4013-a1ca-dbfcf8fd1289\",\n" + 
            "            \"1261cf93-2397-4b64-b2f3-87bf0ba2a130\",\n" + 
            "            \"ad02ebc0-744f-4791-b8a5-be414b83d74a\",\n" + 
            "            \"ad02ebc0-744f-4791-b8a5-be414b83d74a\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Bouře 63\",\n" + 
            "      \"layoutX\":1189.0,\n" + 
            "      \"layoutY\":0.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Bouře 63\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Zásek 69\":\"53725000\",\n" + 
            "         \"Lípa 21\":\"53725000\",\n" + 
            "         \"Jedle 31\":\"53725000\",\n" + 
            "         \"Pila 11\":\"53725000\",\n" + 
            "         \"Pohroma 69\":\"53725000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"53725000\":[  \n" + 
            "            \"8ace51cb-6302-49a3-b9b6-f9e703b3d0b3\",\n" + 
            "            \"745743e9-bcd5-423a-b8ff-5393a36f32d2\",\n" + 
            "            \"420125a6-c87b-4089-919d-94304518ee1a\",\n" + 
            "            \"df716250-3987-4fb7-b922-d55cb6b33b24\",\n" + 
            "            \"df716250-3987-4fb7-b922-d55cb6b33b24\",\n" + 
            "            \"f37ab1f7-6417-4c00-8b47-5aad6be3aeba\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":0\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Pila 112\",\n" + 
            "      \"layoutX\":1509.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Pila 112\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Pila 11\":\"32125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"32125000\":[  \n" + 
            "            \"3be8cdea-e071-4013-a1ca-dbfcf8fd1289\",\n" + 
            "            \"1261cf93-2397-4b64-b2f3-87bf0ba2a130\",\n" + 
            "            \"1261cf93-2397-4b64-b2f3-87bf0ba2a130\",\n" + 
            "            \"ad02ebc0-744f-4791-b8a5-be414b83d74a\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"Pohroma 69\",\n" + 
            "      \"layoutX\":898.0,\n" + 
            "      \"layoutY\":200.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"Pohroma 69\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Šiška 691\":\"65125000\",\n" + 
            "         \"Palcát 692\":\"65125000\",\n" + 
            "         \"Bouře 63\":\"53725000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"53725000\":[  \n" + 
            "            \"8ace51cb-6302-49a3-b9b6-f9e703b3d0b3\",\n" + 
            "            \"745743e9-bcd5-423a-b8ff-5393a36f32d2\",\n" + 
            "            \"420125a6-c87b-4089-919d-94304518ee1a\",\n" + 
            "            \"df716250-3987-4fb7-b922-d55cb6b33b24\",\n" + 
            "            \"df716250-3987-4fb7-b922-d55cb6b33b24\",\n" + 
            "            \"f37ab1f7-6417-4c00-8b47-5aad6be3aeba\" \n" + 
            "         ],\n" + 
            "         \"65125000\":[  \n" + 
            "            \"37d555bc-0136-41b2-8833-b595c685217d\",\n" + 
            "            \"37d555bc-0136-41b2-8833-b595c685217d\",\n" + 
            "            \"78e55335-2ad1-48fc-a69a-ab834b7c4fb7\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":2\n" + 
            "   },\n" + 
            "   {  \n" + 
            "      \"id\":\"zásek 692\",\n" + 
            "      \"layoutX\":2405.0,\n" + 
            "      \"layoutY\":400.0,\n" + 
            "      \"headerLabel\":\"Callsign\",\n" + 
            "      \"headerValue\":\"zásek 692\",\n" + 
            "      \"rows\":[  \n" + 
            "\n" + 
            "      ],\n" + 
            "      \"connections\":{  \n" + 
            "         \"Zásek 69\":\"41125000\" \n" + 
            "      },\n" + 
            "      \"connectionsActivities\":{  \n" + 
            "         \"41125000\":[  \n" + 
            "            \"644e7186-38de-4060-8bd1-873bf35083c2\",\n" + 
            "            \"45786a9c-39ed-4536-b2ea-c1e74027b8d1\",\n" + 
            "            \"45786a9c-39ed-4536-b2ea-c1e74027b8d1\",\n" + 
            "            \"57657dc5-c395-40c0-89ac-17f0715e14df\" \n" + 
            "         ]\n" + 
            "      },\n" + 
            "      \"hierarchy\":4\n" + 
            "   }\n" + 
            "]";


}
