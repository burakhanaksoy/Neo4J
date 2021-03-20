package com.thebman.neo4jstudy.node;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class Project {
    @Id
    @GeneratedValue
    private Long entityId;
    private String name;
    private String location;

    @Relationship(type = "works_for", direction = Relationship.Direction.INCOMING)
    private Set<Employee> employee;
}
