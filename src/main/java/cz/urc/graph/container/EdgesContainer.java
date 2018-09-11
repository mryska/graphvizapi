package cz.urc.graph.container;

import java.util.ArrayList;
import java.util.List;

public class EdgesContainer {

    private List<EdgesContainerItem> edgeList = new ArrayList<>();
    
    
    private String removeWhitespaces(String st) {
        return st.replaceAll("\\s+","");
    }
    
    public void addEdge(String nameNode1, String idNode2, String edgeName) {
        // TODO
    }
    

}
