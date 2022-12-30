package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl implements Graph<String> {

    private Map<String,Set<String>>graphic;

    public GraphImpl() {
        graphic=new HashMap<>();
    }

    @Override
    public void addNode(String node){
        
        Set<String>edgeGroup= new HashSet<>();
        this.graphic.put(node, edgeGroup);

    }

    @Override
    public void addEdge(String source, String target) {

        Set<String>tmpEdgeGroup=this.graphic.get(source);;
        tmpEdgeGroup.add(target);
        this.graphic.replace(source, tmpEdgeGroup);

    }

    @Override
    public Set<String> nodeSet() {
        return this.graphic.keySet();
    }

    @Override
    public Set<String> linkedNodes(String node) {
        return this.graphic.get(node);
    }

    @Override
    public List<String> getPath(String source, String target) {
        
        return null;
        //implementazione molto articolata vai a vedere nelle soluzioni nel caso
    }

}
