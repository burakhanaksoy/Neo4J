package com.thebman.neo4jstudy.node;

import lombok.*;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Employee {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private int age;
    private String project;

    public Employee(String name, int age, String project) {
        this.name = name;
        this.age = age;
        this.project = project;
    }
}
