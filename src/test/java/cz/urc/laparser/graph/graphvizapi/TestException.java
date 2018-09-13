package cz.urc.laparser.graph.graphvizapi;
import org.junit.Assert;
import org.junit.Test;

import cz.urc.laparser.graph.graphvizapi.Attribute;
import cz.urc.laparser.graph.graphvizapi.Graph;
import cz.urc.laparser.graph.graphvizapi.GraphType;
import cz.urc.laparser.graph.graphvizapi.Graphviz;
import cz.urc.laparser.graph.graphvizapi.Node;
import cz.urc.laparser.graph.graphvizapi.exception.AttributeNotFondException;
import cz.urc.laparser.graph.graphvizapi.exception.GraphException;

/**
 * Created by frank on 2014/11/27.
 */
public class TestException {
    @Test
    public void TestAttributeNotFond(){
        try {
            Node node = new Node("testId");
            node.addAttribute(new Attribute("color", "#000"));
            node.removeAttribute("label");
        }catch (AttributeNotFondException e) {
            Assert.assertTrue(true);
        }catch (Exception ex){
            Assert.assertTrue(false);
        }
    }

    @Test
    public void TestDotCommandNotFound() {
        Graphviz gz = new Graphviz("/usr/bin/dot1","./");
        Graph graph = new Graph("g1", GraphType.DIGRAPH);
        String type = "png";
        try {
            byte[] bytearray = gz.getGraphByteArray(graph, type, "100");
            Assert.assertTrue(false);
        }catch (GraphException ge){
            Assert.assertTrue(true);
        }
    }


}

