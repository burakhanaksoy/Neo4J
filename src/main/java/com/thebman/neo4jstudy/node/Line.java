package com.thebman.neo4jstudy.node;

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
public class Line {

    private String name;

    @Id
    @GeneratedValue
    private long id;

    @Relationship(type = "belongs_to", direction = Relationship.Direction.INCOMING)
    private Set<Project> projectSet;

    public Line(String lineId, Set<Project> projectSet) {
        this.name = lineId;
        this.projectSet = projectSet;
    }

}
