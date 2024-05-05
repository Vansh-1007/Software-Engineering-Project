//package org.example;
//
//import java.io.Serializable;
//import java.util.UUID;
//
//public class Edge implements Serializable {
//
//    private Long x;
//    private Long y;
//    private double weight;
//    private UUID src;
//
//    public Edge(Long x, Long y, double weight) {
//        super();
//        this.x = x;
//        this.y = y;
//        this.weight = weight;
//        this.src = UUID.randomUUID();
//    }
//
//    public Long getX() {
//        return x;
//    }
//
//    public void setX(Long x) {
//        this.x= x;
//    }
//
//    public Long getY() {
//        return y;
//    }
//
//    public void setY(Long y) {
//        this.y = y;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public UUID getId() {
//        return src;
//    }
//
//    public void setId(UUID id) {
//        this.src = id;
//    }
//
//}
package org.example;

import java.io.Serializable;

public class Edge implements Serializable {

    private Long src;
    private Long dst;
    private double weight;

    public Edge(Long src, Long dst, double weight) {
        super();
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }

    public Long getX() {
        return src;
    }

    public void setX(Long x) {
        this.src= src;
    }

    public Long getY() {
        return dst;
    }

    public void setY(Long dst) {
        this.dst = dst;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    }

