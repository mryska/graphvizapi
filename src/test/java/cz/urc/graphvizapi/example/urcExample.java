package cz.urc.graphvizapi.example;

import java.io.File;
import java.io.FileOutputStream;

import cz.urc.graphvizapi.Attribute;
import cz.urc.graphvizapi.Edge;
import cz.urc.graphvizapi.Graph;
import cz.urc.graphvizapi.GraphType;
import cz.urc.graphvizapi.Graphviz;
import cz.urc.graphvizapi.Node;

/**
 * Created by frank on 2014/11/20.
 */
public class urcExample {

    private static String tmpPath = "/Users/mryska/prac/tmp";
    public static void main(String[] args)
    {
        urcExample ex = new urcExample ();
        ex.draw0();
    }

    private void draw0()
    {
        Graphviz gv = new Graphviz();
        Graph graph = new Graph("g1", GraphType.DIGRAPH);
        graph.addAttribute(new Attribute("rankdir", "TB"));
        
        Node boure63 = new Node("boure63", "Bouře 63");
        graph.addNode(boure63);
        
        Node lipa21 =  new Node("lipa21", "Lípa 21");
        Node lipa211 = new Node("lipa211", "Lípa 211");
        Node lipa222 = new Node("lipa222", "Lípa 212");
        Node lipa233 = new Node("lipa233", "Lípa 213");
        
        graph.addNode(lipa21);
        graph.addNode(lipa211);
        graph.addNode(lipa222);
        graph.addNode(lipa233);
        
        graph.addEdge(new Edge(boure63, lipa21, "53.725 MHz"));
        graph.addEdge(new Edge(lipa21, lipa211, "35.5 MHz"));
        graph.addEdge(new Edge(lipa21, lipa222, "35.5 MHz"));
        graph.addEdge(new Edge(lipa21, lipa233, "35.5 MHz"));
        
     // opačný směr
     // graph.addEdge(new Edge(lipa21, boure63, "53.725 MHz"));
     // graph.addEdge(new Edge(lipa211, lipa21, "35.5 MHz"));
     // graph.addEdge(new Edge(lipa222, lipa21, "35.5 MHz"));
     // graph.addEdge(new Edge(lipa233, lipa21, "35.5 MHz"));

        Node pohroma69 = new Node("pohroma69", "Pohroma 69");
        Node siska691 = new Node("siska691", "Šiška 691");
        Node palcat692 = new Node("palcat692", "Palcát 692");

        graph.addNode(pohroma69);
        graph.addNode(siska691);
        graph.addNode(palcat692);

        graph.addEdge(new Edge(boure63, pohroma69, "53.725 MHz"));
        graph.addEdge(new Edge(pohroma69, palcat692, "65.125 MHz"));
        graph.addEdge(new Edge(pohroma69, siska691, "65.125 MHz"));
        
        Node pila11 =  new Node("pila11", "Pila 11");
        Node pila111 =  new Node("pila111", "Pila 111");
        Node pila112 =  new Node("pila112", "Pila 112");
        Node pila113 =  new Node("pila113", "Pila 113");

        graph.addNode(pila11);
        graph.addNode(pila111);
        graph.addNode(pila112);
        graph.addNode(pila113);

        graph.addEdge(new Edge(boure63, pila11, "53.725 MH"));
        graph.addEdge(new Edge(pila11, pila111, "32.125 MHz"));
        graph.addEdge(new Edge(pila11, pila112, "32.125 MHz"));
        graph.addEdge(new Edge(pila11, pila113, "32.125 MHz"));


        System.out.println("graph:");
        System.out.println("=============================");
        System.out.println(gv.genDotStringByGraph(graph));
        System.out.println("=============================");


        String type = "png";

        File out = new File(tmpPath+"/outEX0."+ type);
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
}
