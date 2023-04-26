package com.example.friends.service;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.janusgraph.core.JanusGraph;
import org.janusgraph.core.JanusGraphFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class freindService {
    JanusGraph graph= JanusGraphFactory.open("D:\\friends\\src\\main\\conf\\JanusGrapsession.properties");
        GraphTraversalSource g = graph.traversal();

    public String addPerson(String name){

        g.addV("person").property("name",name).next();
        g.tx().commit();
        Long count=g.V().count().next();
        System.out.println("vertex count is:"+count);
        return "person added";
    }

    public List<Map<Object, Object>> getPersons(){
        List<Map<Object, Object>> map =g.V().valueMap().toList();
        return map;
    }

    public String makeFriend(String person1, String person2, int years){
        Vertex v1=null;
        Vertex v2=null;
        if (g.V().has("name", person1).hasNext())
             v1=g.V().has("name", person1).next();
        else
             v1=g.addV("person").property("name",person1).next();

        if (g.V().has("name", person2).hasNext())
            v2=g.V().has("name", person2).next();
        else
            v2=g.addV("person").property("name",person2).next();

        if (g.V(v1).out("friend").hasId(v2).hasNext())
            return person1+" and "+person2+" are already friends";
        else
            g.V(v1).addE("friend").to(v2).property("year",years).iterate();

        g.tx().commit();
        return person1+" and "+person2+" are friends now.";
    }
    public List<Map<Object, Object>> getPerson(String name){
        List<Map<Object, Object>> map =g.V().has("name",name).valueMap().toList();
        return map;
    }

    public List<Map<Object, Object>> getDirectFriend(String name){
        List<Map<Object, Object>> map =g.V().has("name",name).both("friend").valueMap().toList();
        //List<Map<Object, Object>> map1 =g.V().has("name",name).in("friend").valueMap().toList();
        //map.addAll(map1);
        return map;
    }
}
