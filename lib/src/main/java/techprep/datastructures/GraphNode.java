package techprep.datastructures;

import java.util.ArrayList;

/**
 * Created by smeghani on 3/16/2017.
 */

public class GraphNode {
    private ArrayList<GraphNode> adjacentNodes;
    private State state;



    public enum State {UNVISITED,VISITED,VISTING}


    public ArrayList<GraphNode> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(ArrayList<GraphNode> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
