package librerias;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Vertex {

	public String     name;   // Vertex name
    public List       adj;    // Adjacent vertices
    public double     dist;   // Cost
    public Vertex     prev;   // Previous vertex on shortest path
    public int        scratch;// Extra variable used in algorithm

    public Vertex( String nm )
      { name = nm; adj = new LinkedList( ); reset( ); }

    public void reset( )
      { dist = Graph.INFINITY; prev = null; pos = null; scratch = 0; }  
    
    public void reset2( )
    { dist = Graph.negINFINITY; prev = null; pos = null; scratch = 0; }  
      
    public PriorityQueue.Position pos;  // Used for dijkstra2 (Chapter 23)
    
    
    public boolean isDependent(Vertex t){
	      //is t a direct dependency?
	      if(adj.contains(t)){
	        return true;
	      }
	      //is t an indirect dependency
	      for(Iterator itr = adj.iterator( ); itr.hasNext( );){
	        if(isDependent(t)){
	          return true;
	        }
	      }
	      return false;
	}

}
