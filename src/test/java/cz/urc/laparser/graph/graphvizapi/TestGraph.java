package cz.urc.laparser.graph.graphvizapi;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cz.urc.laparser.graph.graphvizapi.Edge;
import cz.urc.laparser.graph.graphvizapi.Graph;
import cz.urc.laparser.graph.graphvizapi.GraphType;
import cz.urc.laparser.graph.graphvizapi.Node;

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
