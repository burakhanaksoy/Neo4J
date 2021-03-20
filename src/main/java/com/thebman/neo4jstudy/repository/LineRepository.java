package com.thebman.neo4jstudy.repository;

import com.thebman.neo4jstudy.node.Line;
import com.thebman.neo4jstudy.node.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LineRepository extends Neo4jRepository<Line,Long> {
    public Line findByName(String lineName);
//    public Set<Project> findByProjectSet(String projectName);
//    public void addProjectSet(Set<Project> projectSet);
}
