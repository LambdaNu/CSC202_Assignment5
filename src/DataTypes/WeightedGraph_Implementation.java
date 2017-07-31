package DataTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import SpecializedObjects.Restaurant;
import SpecializedObjects.UtilityMethods;

public class WeightedGraph_Implementation<T> {
	ArrayList<GraphNode<Restaurant>> gn = new ArrayList<GraphNode<Restaurant>>();
	ArrayList<Edge> edgelist = new ArrayList<Edge>();
	ArrayList<Edge> copyEdge;
	ArrayList<GraphNode<Restaurant>> copyGraph;
    private Set<GraphNode> settledNodes;
    private Set<GraphNode> unSettledNodes;
    private Map<GraphNode, GraphNode> predecessors;
    private Map<GraphNode, Double> distance;
    
	
	public WeightedGraph_Implementation(){
		
		try{
		String mypath = "src/restaurantLookup/relfiles/RESTAURANT_LIST.xls";
		UtilityMethods ul = new UtilityMethods(); 
		Restaurant[] restarr = ul.excelDataToRestaurant(ul.ReadExcel(mypath));
		gn = new ArrayList<GraphNode<Restaurant>>();
		
		for(int i = 0; i < restarr.length; i++ ){
			GraphNode<Restaurant> g = new GraphNode(restarr[i]);
			gn.add(g);
		}
		//System.out.println(gn.get(1).getData().toString());
		gn.get(0).addEdge(gn.get(0).getData().compareGeoLocation(gn.get(18).getData()), gn.get(18),true);
		gn.get(0).addEdge(gn.get(0).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);
		gn.get(0).addEdge(gn.get(0).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(3).getData()), gn.get(3),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(5).getData()), gn.get(5),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);	
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(5).getData()), gn.get(5),true);
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(8).getData()), gn.get(8),true);
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(2).getData()), gn.get(2),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(5).getData()), gn.get(5),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(45).getData()), gn.get(45),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(2).getData()), gn.get(2),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(8).getData()), gn.get(8),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(22).getData()), gn.get(22),true);		
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(19).getData()), gn.get(19),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);		
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(36).getData()), gn.get(36),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);		
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);		
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(17).getData()), gn.get(17),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(31).getData()), gn.get(31),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(17).getData()), gn.get(17),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(19).getData()), gn.get(19),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(22).getData()), gn.get(22),true);	
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);	
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(10).getData()), gn.get(10),true);					
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);			
		gn.get(10).addEdge(gn.get(10).getData().compareGeoLocation(gn.get(11).getData()), gn.get(11),true);
		gn.get(10).addEdge(gn.get(10).getData().compareGeoLocation(gn.get(12).getData()), gn.get(12),true);	
		gn.get(10).addEdge(gn.get(10).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(10).addEdge(gn.get(10).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);		
		gn.get(11).addEdge(gn.get(11).getData().compareGeoLocation(gn.get(12).getData()), gn.get(12),true);	
		gn.get(11).addEdge(gn.get(11).getData().compareGeoLocation(gn.get(24).getData()), gn.get(24),true);
		gn.get(12).addEdge(gn.get(12).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);	
		gn.get(12).addEdge(gn.get(12).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(14).getData()), gn.get(14),true);
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(12).getData()), gn.get(12),true);	
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(25).getData()), gn.get(25),true);
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);		
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);	
		gn.get(14).addEdge(gn.get(14).getData().compareGeoLocation(gn.get(16).getData()), gn.get(16),true);
		gn.get(14).addEdge(gn.get(14).getData().compareGeoLocation(gn.get(35).getData()), gn.get(35),true);	
		gn.get(14).addEdge(gn.get(14).getData().compareGeoLocation(gn.get(25).getData()), gn.get(25),true);
		gn.get(14).addEdge(gn.get(14).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);		
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);			
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(58).getData()), gn.get(58),true);				
		gn.get(16).addEdge(gn.get(16).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(16).addEdge(gn.get(16).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(16).addEdge(gn.get(16).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);	
		gn.get(16).addEdge(gn.get(16).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(22).getData()), gn.get(22),true);		
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(19).getData()), gn.get(19),true);	
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);		
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(38).getData()), gn.get(38),true);
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(27).getData()), gn.get(27),true);
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(31).getData()), gn.get(31),true);
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(22).getData()), gn.get(22),true);	
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);	
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);	
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(2).getData()), gn.get(2),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(35).getData()), gn.get(35),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(31).getData()), gn.get(31),true);		
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(16).getData()), gn.get(16),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(26).getData()), gn.get(26),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(45).getData()), gn.get(45),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(0).getData()), gn.get(0),true);		
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);		
		gn.get(22).addEdge(gn.get(22).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);	
		gn.get(22).addEdge(gn.get(22).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(22).addEdge(gn.get(22).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);	
		gn.get(22).addEdge(gn.get(22).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);		
		gn.get(23).addEdge(gn.get(23).getData().compareGeoLocation(gn.get(11).getData()), gn.get(11),true);	
		gn.get(23).addEdge(gn.get(23).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(23).addEdge(gn.get(23).getData().compareGeoLocation(gn.get(14).getData()), gn.get(14),true);
		gn.get(23).addEdge(gn.get(23).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);	
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(14).getData()), gn.get(14),true);	
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(13).getData()), gn.get(13),true);
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(25).getData()), gn.get(25),true);
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(25).addEdge(gn.get(25).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);
		gn.get(25).addEdge(gn.get(25).getData().compareGeoLocation(gn.get(11).getData()), gn.get(11),true);	
		gn.get(25).addEdge(gn.get(25).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(25).addEdge(gn.get(25).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);		
		gn.get(26).addEdge(gn.get(26).getData().compareGeoLocation(gn.get(27).getData()), gn.get(27),true);
		gn.get(26).addEdge(gn.get(26).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);	
		gn.get(26).addEdge(gn.get(26).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(26).addEdge(gn.get(26).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);		
		gn.get(27).addEdge(gn.get(27).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);
		gn.get(27).addEdge(gn.get(27).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);	
		gn.get(27).addEdge(gn.get(27).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);
		gn.get(27).addEdge(gn.get(27).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);		
		gn.get(28).addEdge(gn.get(28).getData().compareGeoLocation(gn.get(50).getData()), gn.get(50),true);
		gn.get(28).addEdge(gn.get(28).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);	
		gn.get(28).addEdge(gn.get(28).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);		
		gn.get(29).addEdge(gn.get(29).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(29).addEdge(gn.get(29).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);	
		gn.get(29).addEdge(gn.get(29).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(29).addEdge(gn.get(29).getData().compareGeoLocation(gn.get(54).getData()), gn.get(54),true);			
		gn.get(30).addEdge(gn.get(30).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(30).addEdge(gn.get(30).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);		
		gn.get(30).addEdge(gn.get(30).getData().compareGeoLocation(gn.get(38).getData()), gn.get(38),true);
		gn.get(30).addEdge(gn.get(30).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(49).getData()), gn.get(49),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(56).getData()), gn.get(56),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);	
		gn.get(32).addEdge(gn.get(32).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(32).addEdge(gn.get(32).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(32).addEdge(gn.get(32).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(32).addEdge(gn.get(32).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);
		gn.get(33).addEdge(gn.get(33).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);
		gn.get(33).addEdge(gn.get(33).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(34).addEdge(gn.get(34).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(34).addEdge(gn.get(34).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);		
		gn.get(34).addEdge(gn.get(34).getData().compareGeoLocation(gn.get(38).getData()), gn.get(38),true);
		gn.get(34).addEdge(gn.get(34).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(2).getData()), gn.get(2),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(3).getData()), gn.get(3),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);
		gn.get(36).addEdge(gn.get(36).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);
		gn.get(36).addEdge(gn.get(36).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(36).addEdge(gn.get(36).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(36).addEdge(gn.get(36).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);	
		gn.get(37).addEdge(gn.get(37).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(37).addEdge(gn.get(37).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(37).addEdge(gn.get(37).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);		
		gn.get(38).addEdge(gn.get(38).getData().compareGeoLocation(gn.get(25).getData()), gn.get(25),true);
		gn.get(38).addEdge(gn.get(38).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);		
		gn.get(38).addEdge(gn.get(38).getData().compareGeoLocation(gn.get(36).getData()), gn.get(36),true);
		gn.get(38).addEdge(gn.get(38).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);	
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(45).getData()), gn.get(45),true);		
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(36).getData()), gn.get(36),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(48).getData()), gn.get(48),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);		
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);	
		gn.get(40).addEdge(gn.get(40).getData().compareGeoLocation(gn.get(0).getData()), gn.get(0),true);		
		gn.get(40).addEdge(gn.get(40).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(40).addEdge(gn.get(40).getData().compareGeoLocation(gn.get(48).getData()), gn.get(48),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(26).getData()), gn.get(26),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);	
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(24).getData()), gn.get(24),true);
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);	
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(43).addEdge(gn.get(43).getData().compareGeoLocation(gn.get(55).getData()), gn.get(55),true);
		gn.get(43).addEdge(gn.get(43).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(43).addEdge(gn.get(43).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(44).addEdge(gn.get(44).getData().compareGeoLocation(gn.get(12).getData()), gn.get(12),true);	
		gn.get(44).addEdge(gn.get(44).getData().compareGeoLocation(gn.get(24).getData()), gn.get(24),true);	
		gn.get(45).addEdge(gn.get(45).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);	
		gn.get(45).addEdge(gn.get(45).getData().compareGeoLocation(gn.get(31).getData()), gn.get(31),true);
		gn.get(46).addEdge(gn.get(46).getData().compareGeoLocation(gn.get(35).getData()), gn.get(35),true);	
		gn.get(46).addEdge(gn.get(46).getData().compareGeoLocation(gn.get(36).getData()), gn.get(36),true);
		gn.get(47).addEdge(gn.get(47).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);	
		gn.get(48).addEdge(gn.get(48).getData().compareGeoLocation(gn.get(10).getData()), gn.get(10),true);
		gn.get(48).addEdge(gn.get(48).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(48).addEdge(gn.get(48).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);		
		gn.get(48).addEdge(gn.get(48).getData().compareGeoLocation(gn.get(35).getData()), gn.get(35),true);		
		gn.get(49).addEdge(gn.get(49).getData().compareGeoLocation(gn.get(50).getData()), gn.get(50),true);
		gn.get(49).addEdge(gn.get(49).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(49).addEdge(gn.get(49).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(49).addEdge(gn.get(49).getData().compareGeoLocation(gn.get(27).getData()), gn.get(27),true);
		gn.get(50).addEdge(gn.get(50).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(50).addEdge(gn.get(50).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(50).addEdge(gn.get(50).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(51).addEdge(gn.get(51).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(51).addEdge(gn.get(51).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(51).addEdge(gn.get(51).getData().compareGeoLocation(gn.get(18).getData()), gn.get(18),true);
		gn.get(52).addEdge(gn.get(52).getData().compareGeoLocation(gn.get(56).getData()), gn.get(56),true);
		gn.get(53).addEdge(gn.get(53).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(54).addEdge(gn.get(54).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);		
		gn.get(54).addEdge(gn.get(54).getData().compareGeoLocation(gn.get(24).getData()), gn.get(24),true);
		gn.get(54).addEdge(gn.get(54).getData().compareGeoLocation(gn.get(55).getData()), gn.get(55),true);	
		gn.get(55).addEdge(gn.get(55).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(55).addEdge(gn.get(55).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(55).addEdge(gn.get(55).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(55).addEdge(gn.get(55).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(56).addEdge(gn.get(56).getData().compareGeoLocation(gn.get(58).getData()), gn.get(58),true);		
		gn.get(56).addEdge(gn.get(56).getData().compareGeoLocation(gn.get(49).getData()), gn.get(49),true);
		gn.get(56).addEdge(gn.get(56).getData().compareGeoLocation(gn.get(55).getData()), gn.get(55),true);	
		gn.get(57).addEdge(gn.get(57).getData().compareGeoLocation(gn.get(58).getData()), gn.get(58),true);		
		gn.get(57).addEdge(gn.get(57).getData().compareGeoLocation(gn.get(49).getData()), gn.get(49),true);
		gn.get(57).addEdge(gn.get(57).getData().compareGeoLocation(gn.get(55).getData()), gn.get(55),true);
		gn.get(57).addEdge(gn.get(57).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);
		gn.get(58).addEdge(gn.get(58).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(58).addEdge(gn.get(58).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(58).addEdge(gn.get(58).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		
		for(int i = 0; i > gn.size(); i++){
			edgelist.addAll(gn.get(i).getEdges());
		}
		
		this.copyEdge = edgelist;
		this.copyGraph = gn; 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public WeightedGraph_Implementation(GraphNode<Restaurant> src) throws Exception{
		try{
		String mypath = "src/restaurantLookup/relfiles/RESTAURANT_LIST.xls";
		UtilityMethods ul = new UtilityMethods(); 
		Restaurant[] restarr = ul.excelDataToRestaurant(ul.ReadExcel(mypath));
		gn = new ArrayList<GraphNode<Restaurant>>();
		
		//Add a means of connecting the user input to a real restaurant --> to a graphnode and then connect the graphnode to its nearest compatriot (given by min heap)
		for(int i = 0; i < restarr.length; i++ ){
			GraphNode<Restaurant> g = new GraphNode(restarr[i]);
			gn.add(g);

			
			
		}
	
		gn.add(src);
		gn.get(gn.indexOf(src)).addEdge(gn.get(gn.indexOf(src)).getData().compareGeoLocation(gn.get(0).getData()), gn.get(0),true);
		gn.get(gn.indexOf(src)).addEdge(gn.get(gn.indexOf(src)).getData().compareGeoLocation(gn.get(10).getData()), gn.get(10),true);
		gn.get(gn.indexOf(src)).addEdge(gn.get(gn.indexOf(src)).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(gn.indexOf(src)).addEdge(gn.get(gn.indexOf(src)).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(gn.indexOf(src)).addEdge(gn.get(gn.indexOf(src)).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);
		
		
		gn.get(0).addEdge(gn.get(0).getData().compareGeoLocation(gn.get(18).getData()), gn.get(18),true);
		gn.get(0).addEdge(gn.get(0).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);
		gn.get(0).addEdge(gn.get(0).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(3).getData()), gn.get(3),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(5).getData()), gn.get(5),true);
		gn.get(2).addEdge(gn.get(2).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);	
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(5).getData()), gn.get(5),true);
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(8).getData()), gn.get(8),true);
		gn.get(3).addEdge(gn.get(3).getData().compareGeoLocation(gn.get(2).getData()), gn.get(2),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(5).getData()), gn.get(5),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(45).getData()), gn.get(45),true);
		gn.get(4).addEdge(gn.get(4).getData().compareGeoLocation(gn.get(2).getData()), gn.get(2),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(8).getData()), gn.get(8),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(22).getData()), gn.get(22),true);		
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(19).getData()), gn.get(19),true);
		gn.get(5).addEdge(gn.get(5).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);		
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(36).getData()), gn.get(36),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);		
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);		
		gn.get(6).addEdge(gn.get(6).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(17).getData()), gn.get(17),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(31).getData()), gn.get(31),true);
		gn.get(7).addEdge(gn.get(7).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(17).getData()), gn.get(17),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(19).getData()), gn.get(19),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(22).getData()), gn.get(22),true);	
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);	
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(8).addEdge(gn.get(8).getData().compareGeoLocation(gn.get(10).getData()), gn.get(10),true);					
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(9).addEdge(gn.get(9).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);			
		gn.get(10).addEdge(gn.get(10).getData().compareGeoLocation(gn.get(11).getData()), gn.get(11),true);
		gn.get(10).addEdge(gn.get(10).getData().compareGeoLocation(gn.get(12).getData()), gn.get(12),true);	
		gn.get(10).addEdge(gn.get(10).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(10).addEdge(gn.get(10).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);		
		gn.get(11).addEdge(gn.get(11).getData().compareGeoLocation(gn.get(12).getData()), gn.get(12),true);	
		gn.get(11).addEdge(gn.get(11).getData().compareGeoLocation(gn.get(24).getData()), gn.get(24),true);
		gn.get(12).addEdge(gn.get(12).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);	
		gn.get(12).addEdge(gn.get(12).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(14).getData()), gn.get(14),true);
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(12).getData()), gn.get(12),true);	
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(25).getData()), gn.get(25),true);
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);		
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(13).addEdge(gn.get(13).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);	
		gn.get(14).addEdge(gn.get(14).getData().compareGeoLocation(gn.get(16).getData()), gn.get(16),true);
		gn.get(14).addEdge(gn.get(14).getData().compareGeoLocation(gn.get(35).getData()), gn.get(35),true);	
		gn.get(14).addEdge(gn.get(14).getData().compareGeoLocation(gn.get(25).getData()), gn.get(25),true);
		gn.get(14).addEdge(gn.get(14).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);		
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);			
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(15).addEdge(gn.get(15).getData().compareGeoLocation(gn.get(58).getData()), gn.get(58),true);				
		gn.get(16).addEdge(gn.get(16).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(16).addEdge(gn.get(16).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(16).addEdge(gn.get(16).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);	
		gn.get(16).addEdge(gn.get(16).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(22).getData()), gn.get(22),true);		
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);
		gn.get(17).addEdge(gn.get(17).getData().compareGeoLocation(gn.get(19).getData()), gn.get(19),true);	
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);		
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(38).getData()), gn.get(38),true);
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(27).getData()), gn.get(27),true);
		gn.get(18).addEdge(gn.get(18).getData().compareGeoLocation(gn.get(31).getData()), gn.get(31),true);
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(22).getData()), gn.get(22),true);	
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);	
		gn.get(19).addEdge(gn.get(19).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(20).addEdge(gn.get(20).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);	
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(2).getData()), gn.get(2),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(35).getData()), gn.get(35),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(31).getData()), gn.get(31),true);		
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(16).getData()), gn.get(16),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(26).getData()), gn.get(26),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(45).getData()), gn.get(45),true);
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(0).getData()), gn.get(0),true);		
		gn.get(21).addEdge(gn.get(21).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);		
		gn.get(22).addEdge(gn.get(22).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);	
		gn.get(22).addEdge(gn.get(22).getData().compareGeoLocation(gn.get(28).getData()), gn.get(28),true);
		gn.get(22).addEdge(gn.get(22).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);	
		gn.get(22).addEdge(gn.get(22).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);		
		gn.get(23).addEdge(gn.get(23).getData().compareGeoLocation(gn.get(11).getData()), gn.get(11),true);	
		gn.get(23).addEdge(gn.get(23).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(23).addEdge(gn.get(23).getData().compareGeoLocation(gn.get(14).getData()), gn.get(14),true);
		gn.get(23).addEdge(gn.get(23).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);	
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(14).getData()), gn.get(14),true);	
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(13).getData()), gn.get(13),true);
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(25).getData()), gn.get(25),true);
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);
		gn.get(24).addEdge(gn.get(24).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(25).addEdge(gn.get(25).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);
		gn.get(25).addEdge(gn.get(25).getData().compareGeoLocation(gn.get(11).getData()), gn.get(11),true);	
		gn.get(25).addEdge(gn.get(25).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(25).addEdge(gn.get(25).getData().compareGeoLocation(gn.get(29).getData()), gn.get(29),true);		
		gn.get(26).addEdge(gn.get(26).getData().compareGeoLocation(gn.get(27).getData()), gn.get(27),true);
		gn.get(26).addEdge(gn.get(26).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);	
		gn.get(26).addEdge(gn.get(26).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(26).addEdge(gn.get(26).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);		
		gn.get(27).addEdge(gn.get(27).getData().compareGeoLocation(gn.get(9).getData()), gn.get(9),true);
		gn.get(27).addEdge(gn.get(27).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);	
		gn.get(27).addEdge(gn.get(27).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);
		gn.get(27).addEdge(gn.get(27).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);		
		gn.get(28).addEdge(gn.get(28).getData().compareGeoLocation(gn.get(50).getData()), gn.get(50),true);
		gn.get(28).addEdge(gn.get(28).getData().compareGeoLocation(gn.get(23).getData()), gn.get(23),true);	
		gn.get(28).addEdge(gn.get(28).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);		
		gn.get(29).addEdge(gn.get(29).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(29).addEdge(gn.get(29).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);	
		gn.get(29).addEdge(gn.get(29).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(29).addEdge(gn.get(29).getData().compareGeoLocation(gn.get(54).getData()), gn.get(54),true);			
		gn.get(30).addEdge(gn.get(30).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(30).addEdge(gn.get(30).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);		
		gn.get(30).addEdge(gn.get(30).getData().compareGeoLocation(gn.get(38).getData()), gn.get(38),true);
		gn.get(30).addEdge(gn.get(30).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(21).getData()), gn.get(21),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(49).getData()), gn.get(49),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(56).getData()), gn.get(56),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(31).addEdge(gn.get(31).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);	
		gn.get(32).addEdge(gn.get(32).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(32).addEdge(gn.get(32).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(32).addEdge(gn.get(32).getData().compareGeoLocation(gn.get(33).getData()), gn.get(33),true);
		gn.get(32).addEdge(gn.get(32).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);
		gn.get(33).addEdge(gn.get(33).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);
		gn.get(33).addEdge(gn.get(33).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(34).addEdge(gn.get(34).getData().compareGeoLocation(gn.get(57).getData()), gn.get(57),true);
		gn.get(34).addEdge(gn.get(34).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);		
		gn.get(34).addEdge(gn.get(34).getData().compareGeoLocation(gn.get(38).getData()), gn.get(38),true);
		gn.get(34).addEdge(gn.get(34).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(2).getData()), gn.get(2),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(3).getData()), gn.get(3),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(35).addEdge(gn.get(35).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);
		gn.get(36).addEdge(gn.get(36).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);
		gn.get(36).addEdge(gn.get(36).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(36).addEdge(gn.get(36).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(36).addEdge(gn.get(36).getData().compareGeoLocation(gn.get(37).getData()), gn.get(37),true);	
		gn.get(37).addEdge(gn.get(37).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(37).addEdge(gn.get(37).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);
		gn.get(37).addEdge(gn.get(37).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);		
		gn.get(38).addEdge(gn.get(38).getData().compareGeoLocation(gn.get(25).getData()), gn.get(25),true);
		gn.get(38).addEdge(gn.get(38).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);		
		gn.get(38).addEdge(gn.get(38).getData().compareGeoLocation(gn.get(36).getData()), gn.get(36),true);
		gn.get(38).addEdge(gn.get(38).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);	
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(40).getData()), gn.get(40),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(45).getData()), gn.get(45),true);		
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(36).getData()), gn.get(36),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(48).getData()), gn.get(48),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);		
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(39).addEdge(gn.get(39).getData().compareGeoLocation(gn.get(4).getData()), gn.get(4),true);	
		gn.get(40).addEdge(gn.get(40).getData().compareGeoLocation(gn.get(0).getData()), gn.get(0),true);		
		gn.get(40).addEdge(gn.get(40).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(40).addEdge(gn.get(40).getData().compareGeoLocation(gn.get(48).getData()), gn.get(48),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(32).getData()), gn.get(32),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(26).getData()), gn.get(26),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(41).addEdge(gn.get(41).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);	
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(24).getData()), gn.get(24),true);
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);	
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(42).addEdge(gn.get(42).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(43).addEdge(gn.get(43).getData().compareGeoLocation(gn.get(55).getData()), gn.get(55),true);
		gn.get(43).addEdge(gn.get(43).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(43).addEdge(gn.get(43).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(44).addEdge(gn.get(44).getData().compareGeoLocation(gn.get(12).getData()), gn.get(12),true);	
		gn.get(44).addEdge(gn.get(44).getData().compareGeoLocation(gn.get(24).getData()), gn.get(24),true);	
		gn.get(45).addEdge(gn.get(45).getData().compareGeoLocation(gn.get(47).getData()), gn.get(47),true);	
		gn.get(45).addEdge(gn.get(45).getData().compareGeoLocation(gn.get(31).getData()), gn.get(31),true);
		gn.get(46).addEdge(gn.get(46).getData().compareGeoLocation(gn.get(35).getData()), gn.get(35),true);	
		gn.get(46).addEdge(gn.get(46).getData().compareGeoLocation(gn.get(36).getData()), gn.get(36),true);
		gn.get(47).addEdge(gn.get(47).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);	
		gn.get(48).addEdge(gn.get(48).getData().compareGeoLocation(gn.get(10).getData()), gn.get(10),true);
		gn.get(48).addEdge(gn.get(48).getData().compareGeoLocation(gn.get(20).getData()), gn.get(20),true);
		gn.get(48).addEdge(gn.get(48).getData().compareGeoLocation(gn.get(30).getData()), gn.get(30),true);		
		gn.get(48).addEdge(gn.get(48).getData().compareGeoLocation(gn.get(35).getData()), gn.get(35),true);		
		gn.get(49).addEdge(gn.get(49).getData().compareGeoLocation(gn.get(50).getData()), gn.get(50),true);
		gn.get(49).addEdge(gn.get(49).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(49).addEdge(gn.get(49).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(49).addEdge(gn.get(49).getData().compareGeoLocation(gn.get(27).getData()), gn.get(27),true);
		gn.get(50).addEdge(gn.get(50).getData().compareGeoLocation(gn.get(51).getData()), gn.get(51),true);
		gn.get(50).addEdge(gn.get(50).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(50).addEdge(gn.get(50).getData().compareGeoLocation(gn.get(1).getData()), gn.get(1),true);
		gn.get(51).addEdge(gn.get(51).getData().compareGeoLocation(gn.get(53).getData()), gn.get(53),true);		
		gn.get(51).addEdge(gn.get(51).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(51).addEdge(gn.get(51).getData().compareGeoLocation(gn.get(18).getData()), gn.get(18),true);
		gn.get(52).addEdge(gn.get(52).getData().compareGeoLocation(gn.get(56).getData()), gn.get(56),true);
		gn.get(53).addEdge(gn.get(53).getData().compareGeoLocation(gn.get(6).getData()), gn.get(6),true);
		gn.get(54).addEdge(gn.get(54).getData().compareGeoLocation(gn.get(7).getData()), gn.get(7),true);		
		gn.get(54).addEdge(gn.get(54).getData().compareGeoLocation(gn.get(24).getData()), gn.get(24),true);
		gn.get(54).addEdge(gn.get(54).getData().compareGeoLocation(gn.get(55).getData()), gn.get(55),true);	
		gn.get(55).addEdge(gn.get(55).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(55).addEdge(gn.get(55).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		gn.get(55).addEdge(gn.get(55).getData().compareGeoLocation(gn.get(44).getData()), gn.get(44),true);	
		gn.get(55).addEdge(gn.get(55).getData().compareGeoLocation(gn.get(46).getData()), gn.get(46),true);
		gn.get(56).addEdge(gn.get(56).getData().compareGeoLocation(gn.get(58).getData()), gn.get(58),true);		
		gn.get(56).addEdge(gn.get(56).getData().compareGeoLocation(gn.get(49).getData()), gn.get(49),true);
		gn.get(56).addEdge(gn.get(56).getData().compareGeoLocation(gn.get(55).getData()), gn.get(55),true);	
		gn.get(57).addEdge(gn.get(57).getData().compareGeoLocation(gn.get(58).getData()), gn.get(58),true);		
		gn.get(57).addEdge(gn.get(57).getData().compareGeoLocation(gn.get(49).getData()), gn.get(49),true);
		gn.get(57).addEdge(gn.get(57).getData().compareGeoLocation(gn.get(55).getData()), gn.get(55),true);
		gn.get(57).addEdge(gn.get(57).getData().compareGeoLocation(gn.get(52).getData()), gn.get(52),true);
		gn.get(58).addEdge(gn.get(58).getData().compareGeoLocation(gn.get(41).getData()), gn.get(41),true);
		gn.get(58).addEdge(gn.get(58).getData().compareGeoLocation(gn.get(42).getData()), gn.get(42),true);	
		gn.get(58).addEdge(gn.get(58).getData().compareGeoLocation(gn.get(43).getData()), gn.get(43),true);
		
		for(int i = 0; i > gn.size(); i++){
			edgelist.addAll(gn.get(i).getEdges());
		}
		
		this.copyEdge = edgelist;
		this.copyGraph = gn; 
		System.out.println(gn.get(gn.indexOf(src)).edgesToString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void fuckittry(GraphNode src, GraphNode target){
		for(int i = 0; i < copyGraph.size(); i++){
			ArrayList<GraphNode> unvisited = new ArrayList<GraphNode>();
			ArrayList<GraphNode> prev = new ArrayList<GraphNode>();
		}
		
		
	}
	
	
	
	
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void findMinDistance(GraphNode src){
		settledNodes = new HashSet<GraphNode>();
        unSettledNodes = new HashSet<GraphNode>();
        distance = new HashMap<GraphNode, Double>();
        predecessors = new HashMap<GraphNode, GraphNode>();
		distance.put(src, (double) 0);
		unSettledNodes.add(src);
		while (unSettledNodes.size() > 0){
			GraphNode node = getMin(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findsmallestDistance(node);
		}
		
	}
	  
	  private void findsmallestDistance(GraphNode node) {
		  List<GraphNode> adjacentNodes = getNeighbors(node);
	        for (GraphNode target : adjacentNodes) {
	            if (getShortestDistance(target) > getShortestDistance(node)
	                    + getDistance(node, target)) {
	                distance.put(target, getShortestDistance(node)
	                        + getDistance(node, target));
	                predecessors.put(target, node);
	                unSettledNodes.add(target);
	            }
	        }
		
	}

	  private double getDistance(GraphNode node, GraphNode target) {
	        for (Edge edge : copyEdge) {
	            if (edge.getSource().equals(node)
	                    && edge.getDestination().equals(target)) {
	                return edge.getWeight();
	            }
	        }
	        throw new RuntimeException("Just in case...");
	    }

	private List<GraphNode> getNeighbors(GraphNode node) {
		List<GraphNode> neighbors = new ArrayList<GraphNode>();
        for (Edge edge : copyEdge) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
	}

    private boolean isSettled(GraphNode vertex) {
        return settledNodes.contains(vertex);
    }

	private GraphNode getMin(Set<GraphNode> vertexes) {
        GraphNode minimum = null;
        for (GraphNode vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
	}
        return minimum; 
}

	private double getShortestDistance(GraphNode destination) {
	        Double d = distance.get(destination);
	        if (d == null) {
	            return Double.MAX_VALUE;
	        } else {
	            return d;
	        }
	    }
	 public LinkedList<GraphNode> getPath(GraphNode target) {
	        LinkedList<GraphNode> path = new LinkedList<GraphNode>();
	        GraphNode step = target;
	        // check if a path exists
	        if (predecessors.get(step) == null) {
	            return null;
	        }
	        path.add(step);
	        while (predecessors.get(step) != null) {
	            step = predecessors.get(step);
	            path.add(step);
	        }
	        // Put it into the correct order
	        Collections.reverse(path);
	        return path;
	    }
	 public LinkedList<GraphNode> getPath(int targ) {
	        LinkedList<GraphNode> path = new LinkedList<GraphNode>();
	        GraphNode target = copyGraph.get(targ);
	        GraphNode step = target;
	        // check if a path exists
	        if (predecessors.get(step) == null) {
	            return null;
	        }
	        path.add(step);
	        while (predecessors.get(step) != null) {
	            step = predecessors.get(step);
	            path.add(step);
	        }
	        // Put it into the correct order
	        Collections.reverse(path);
	        return path;
	    }
	
	
}
