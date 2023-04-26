package com.example.friends;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.janusgraph.core.JanusGraphFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class FriendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendsApplication.class, args);
		//Graph graph= JanusGraphFactory.open("D:\\friends\\src\\main\\conf\\JanusGrapsession.properties");
	//	GraphTraversalSource g = graph.traversal();
		//Long count = g.V().count().next();
		System.out.printf("application started");
	}

}
