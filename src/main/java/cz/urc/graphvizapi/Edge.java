package cz.urc.graphvizapi;

import lombok.ToString;

/**
 * The Edge class like Graphviz's edge.
 * Created by frank on 2014/11/20.
 */
@ToString
public class Edge extends BaseGraphObject {
    private Node fromNode;
    private Node toNode;

    /**
     * Edge constructor with edge id.
     * @param id Edge Id.
     * @param fromNode From Node.
     * @param toNode To Node.
     */
    public Edge(String id,Node fromNode,Node toNode){
        super(id);
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    /**
     * Edge constructor without edge id. Default id is blank.
     * @param fromNode
     * @param toNode
     */
    public Edge(Node fromNode,Node toNode){
        super("");
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    public Edge(Node fromNode,Node toNode, String label){
        super("");
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.addAttribute(new Attribute("label", "\"" + label  + "\""));
        this.addAttribute(new Attribute("style", "bold"));  // TODO
        this.addAttribute(new Attribute("arrowhead", "none"));  // TODO
        this.addAttribute(new Attribute("splines", "line"));  // TODO
    }

    /**
     * From node getter.
     * @return from Node
     */
    public Node getFromNode(){
        return this.fromNode;
    }

    /**
     * To node getter.
     * @return to node.
     */
    public Node getToNode(){
        return this.toNode;
    }

    @Override
    public String genDotString() {
        StringBuilder dotString = new StringBuilder();
        dotString.append("["+this.genAttributeDotString()+"]");
        return dotString.toString();
    }
}
