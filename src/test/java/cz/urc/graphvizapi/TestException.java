package cz.urc.graphvizapi;
import org.junit.Assert;
import org.junit.Test;

import cz.urc.graphvizapi.exception.AttributeNotFondException;
import cz.urc.graphvizapi.exception.GraphException;

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

