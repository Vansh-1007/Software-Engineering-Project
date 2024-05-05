package org.example;

import java.io.Serializable;

public class Vertex implements Serializable {

    private Long id;

    public Vertex(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
