package org.example;
import java.util.ArrayList;
import java.util.List;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.graphframes.GraphFrame;

public class Main {
    static List<Vertex> vertices = new ArrayList<Vertex>();
    static List<Edge> edges = new ArrayList<Edge>();

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf()
                .setAppName("SparkGraphFrames")
                .setMaster("local[*]");

        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        javaSparkContext.setCheckpointDir("C:\\Projectbla");
        javaSparkContext.setLogLevel("WARN");

        //create spark session
        SparkSession session = SparkSession.builder()
                .appName("SparkGraphFrameSample")
                .config(sparkConf)
                .sparkContext(javaSparkContext.sc())
                .master("local[*]")
                .getOrCreate();

        JavaRDD<String> dataRDD = session.read().textFile("C:\\Projectbla\\ro.txt").javaRDD();


        dataRDD.map(new Function<String, String>() {

            public String call(String line) throws Exception {
                String[] parts = line.split(" ");
                Vertex v = new Vertex(Long.valueOf(parts[0].trim()));
                vertices.add(v);
                //System.out.println(vertices.size());

                Edge e = new Edge(Long.valueOf(parts[0].trim()), Long.valueOf(parts[1].trim()), Double.valueOf(parts[2].trim()));
                edges.add(e);
                return line;
            }

        }).count();
       // System.out.println(vertices.size());

        Dataset<Row> vDataset = session.createDataFrame(vertices, Vertex.class).toDF("id");
        Dataset<Row> eDataset = session.createDataFrame(edges, Edge.class).toDF("weight","src", "dst");
        GraphFrame graph = GraphFrame.apply(vDataset, eDataset);

        //graph.edges().show();

        System.out.println("Running PageRank algorithm on data set.");
        graph.pageRank()
                .maxIter(50)
                .resetProbability(0.15)
                .run()
                .vertices()
                .show();

        System.out.println("Running Connected components algorithm on data set.");
        graph.connectedComponents().run().show();

        System.out.println("Running Triangle counting algorithm on data set.");
        graph.triangleCount().run().show();

        System.out.println("Running SVD algorithm on data set.");
        graph.svdPlusPlus().run().show();








        System.out.println();



    }

}