package cz.urc.graphvizapi;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cz.urc.graphvizapi.Edge;
import cz.urc.graphvizapi.Graph;
import cz.urc.graphvizapi.GraphType;
import cz.urc.graphvizapi.Node;

/**
 * Created by frank on 2014/11/20.
 */
public class TestGraph {
    @Test
    public void testTypeEdge() {
        Graph g = new Graph("g1", GraphType.DIGRAPH);
        g.addEdge(new Edge(new Node("A"),new Node("B")));
        String dotString = g.genDotString();
        assertTrue(dotString.contains("->"));
    }

    @Test
    public void testTypeEdge2() {
        Graph g = new Graph("g1", GraphType.GRPAH);
        g.addEdge(new Edge(new Node("A"),new Node("B")));
        String dotString = g.genDotString();
        assertTrue(dotString.contains("--"));
    }
}
