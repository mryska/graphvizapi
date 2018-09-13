package cz.urc.laparser.graph.container;

import java.util.ArrayList;
import java.util.List;

import cz.urc.isrman.client.gui.utils.dragAndDrop.dataConteiner.TableDataContainer;

public class NodesContainer {

    private List<NodesContainerItem> nodeList = new ArrayList<>();
    
    
    private String removeWhitespaces(String st) {
        return st.replaceAll("\\s+","");
    }
    
    public void addNode(TableDataContainer tableDataContainer) {
        NodesContainerItem item = new NodesContainerItem();
        item.setId(removeWhitespaces(tableDataContainer.getId()));
        item.setName(tableDataContainer.getId());
        item.setHierarchy(tableDataContainer.getHierarchy());
        nodeList.add(item);
    }
    
    public void addNodes(List<TableDataContainer> containers) {
        for (TableDataContainer tableDataContainer : containers) {
            addNode(tableDataContainer);
        }
    }
    
    public NodesContainerItem findNodeByName(String name) {
        return nodeList
                .stream()
                .filter(x -> x.getName().equals(name))
                .findAny()
                .orElse(null);
    }
    
    public NodesContainerItem findNodeById(String id) {
        return nodeList
                .stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public List<NodesContainerItem> getNodeList() {
        return nodeList;
    }

}
