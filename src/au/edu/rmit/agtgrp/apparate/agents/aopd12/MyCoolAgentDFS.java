package au.edu.rmit.agtgrp.apparate.agents.aopd12;

import au.edu.rmit.agtgrp.apparate.gui.interfaces.PlanningAgent;
import au.edu.rmit.agtgrp.apparate.gui.simviewer.model.GridCell;
import au.edu.rmit.agtgrp.apparate.gui.simviewer.model.GridDomain;
import au.edu.rmit.agtgrp.apparate.jpathplan.entites.ComputedPlan;
import au.edu.rmit.agtgrp.apparate.jpathplan.entites.SearchNode;
import au.edu.rmit.agtgrp.apparate.jpathplan.entites.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class MyCoolAgentDFS implements PlanningAgent {
	
       
    protected ComputedPlan path = null;
  
   
    
    private GridCell lastGoal = null;
    protected int	stepNo = 0;
    
	@Override
	public GridCell getNextMove(GridDomain map, GridCell sState, GridCell gState, int stepLeft,
                                long stepTime, long timeLeft) {
	
		// do we need to replan?
		boolean replan = 
				path == null ||			// no last path stored, have yet notr planned before?
				map.getChangedEdges().size() > 0 ||	// map has had changes 
				!lastGoal.equals(gState) || // Goal has changed (equals not implemented?)
				!path.contains(sState); // sNode is not in the path (sNode out of track)

		if (replan)	{ // Only do this if there is need to re-plan 
			path = DFS(map, sState, gState);
			stepNo = 0;
			lastGoal = gState;
		} 


		if (path != null && stepNo < path.getLength()) {
			stepNo++;
			return (GridCell) path.getStep(stepNo);
		} else
				return null;
		
	}
    
    
    
	private ComputedPlan DFS(GridDomain map, GridCell sState, GridCell gState) {
		
				// A naive agent that moves towards the target in a greedy way
				// So it will fail the moment it contacts an obstacle

	    Set<State> visited = new HashSet<State>();

	    ComputedPlan comppath = new ComputedPlan();
		LinkedList<SearchNode> open;
		
		SearchNode goal = null;
		
		open = new LinkedList<SearchNode>();		
		open.add(new SearchNode(sState));
		visited.clear();
		

		SearchNode s = null;
		while (!open.isEmpty()) {
			// get the first node from open list to expand
			s = open.removeFirst();
			
			// if we have seen this node in the search before, then skip it
			if (visited.contains(s.getNode())) continue;
			
			// add it to visited seen nodes
			visited.add(s.getNode());
			
			// if node is goal, then finito! get out of while loop
			if (s.getNode().equals(gState)) {
				goal = s;
				break;
			}
			
			// we will expand s now, first get all successors
			ArrayList<State> successors = map.getSuccessors(s.getNode());

			State nextnode = null;
			for (State snext: successors) {	// Iterate on all successors and add them to front of open list
				if (!map.isBlocked(snext) && !visited.contains(snext)) {
					SearchNode snextSearch = new SearchNode(snext); 
					snextSearch.setParent(s);
					open.addFirst(snextSearch); // user open.add(new SearchNode(snext)) para breadth-first search
				}
			}
		} // end of while
		
		if (goal==null) {
			System.out.println("No se pudo encontrar el objetivo!?");
			return null;
		}
		
		
		// we have a plan here, we need to reconstruct it from goal to source backwards
		while (goal.getParent()!=null) {
			comppath.prependStep(goal.getNode());
			goal = goal.getParent();
		}

		comppath.prependStep(sState);
		return comppath;
			

	} // end of method

			
			
			
			
			
			
			
			
			
			// You can if you want implement the methods below

			// Do we want to show extra info? (e.g., close and open nodes, current path)
			@Override
			public Boolean showInfo() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ArrayList<GridCell> expandedNodes() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ArrayList<GridCell> unexpandedNodes() {
				// TODO Auto-generated method stub
				return null;
			}


			@Override
			public ComputedPlan getPath() {
				// TODO Auto-generated method stub
				return null;
			}

}
