package cz.urc.graphvizapi;

import org.enoir.graphvizapi.*;
import org.junit.Test;

import cz.urc.graphvizapi.Attribute;
import cz.urc.graphvizapi.Edge;
import cz.urc.graphvizapi.Graph;
import cz.urc.graphvizapi.GraphType;
import cz.urc.graphvizapi.Graphviz;
import cz.urc.graphvizapi.Node;

import static org.junit.Assert.assertTrue;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by frank on 2014/11/21.
 */
public class TestGraphviz {

    @Test
    public void testGenImage() {
        Graphviz gz = new Graphviz("/usr/local/bin/dot","./");
        Graph graph = genSimpleGraph();
        String type = "png";
        System.out.println("=============================");
        System.out.println(gz.genDotStringByGraph(graph));
        System.out.println("=============================");
        byte[] bytearray = gz.getGraphByteArray(graph, type, "100");
        assertTrue(bytearray.length>0);
    }

    @Test
    public void testGenImageWithDefault() {
        Graphviz gz = new Graphviz();
        gz.setTmpPath("./");
        Graph graph = genSimpleGraph();
        String type = "png";
        byte[] bytearray = gz.getGraphByteArray(graph, type, "100");
        assertTrue(bytearray.length>0);
    }
    @Test
    public void testGenImageFail() {
        Graphviz gz = new Graphviz("/dot","./");
        Graph graph = new Graph("g1", GraphType.DIGRAPH);
        byte[] bytearray = null;
        try {
            String type = "png";
            bytearray = gz.getGraphByteArray(graph, type, "100");
        }catch (Exception e){

        }
        assertTrue(bytearray==null);
    }

    private String getByteArrayMd5(byte[] bytes){
        String ret = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            ret = getChecksumString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    private Graph genSimpleGraph() {

        Graph graph = new Graph("g1", GraphType.DIGRAPH);
        graph.addAttribute(new Attribute("rankdir", "LR"));
        Node n1 = new Node("N");
        n1.addAttribute(new Attribute("label", "\" Node1 \""));
        Node n2 = new Node("N2");
        Node n3 = new Node("N3");

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addEdge(new Edge("", n1, n2));
        graph.addEdge(new Edge("", n2, n3));
        graph.addEdge(new Edge("",n3,n1));
        graph.addEdge(new Edge("",n3,n1));
        return graph;
    }

    private String getChecksumString(byte[] mdbyte){
        String result = "";
        for (int i=0; i < mdbyte.length; i++) {
            result += Integer.toString( ( mdbyte[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

}
