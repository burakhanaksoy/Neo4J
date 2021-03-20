package com.thebman.neo4jstudy.repository;

import com.thebman.neo4jstudy.node.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends Neo4jRepository<Project,Long> {

    Project findByName(String projectName);
}
