package librerias;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class Graph {

	 public static final double INFINITY = Double.MAX_VALUE;
	 public static final double negINFINITY = Double.NEGATIVE_INFINITY;
	    private Map vertexMap = new HashMap( ); // Maps String to Vertex
	    

	    /**
	     * Add a new edge to the graph.
	     */
	    public void addEdge( String sourceName, String destName, double cost )
	    {
	        Vertex v = getVertex( sourceName );
	        Vertex w = getVertex( destName );
	        v.adj.add( new Edge( w, cost ) );
	    }

	    /**
	     * Driver routine to handle unreachables and print total cost.
	     * It calls recursive routine to print shortest path to
	     * destNode after a shortest path algorithm has run.
	     */
	    public void printPath( String destName )
	    {
	        Vertex w = (Vertex) vertexMap.get( destName );
	        if( w == null )
	            throw new NoSuchElementException( "Destination vertex not found" );
	        else if( w.dist == INFINITY )
	            System.out.println( destName + " is unreachable" );
	        else
	        {
	            System.out.print( "(Cost is: " + w.dist + ") " );
	            printPath( w );
	            System.out.println( );
	        }
	    }

	    /**
	     * If vertexName is not present, add it to vertexMap.
	     * In either case, return the Vertex.
	     */
	    private Vertex getVertex( String vertexName )
	    {
	        Vertex v = (Vertex) vertexMap.get( vertexName );
	        if( v == null )
	        {
	            v = new Vertex( vertexName );
	            vertexMap.put( vertexName, v );
	        }
	        return v;
	    }

	    /**
	     * Recursive routine to print shortest path to dest
	     * after running shortest path algorithm. The path
	     * is known to exist.
	     */
	    private void printPath( Vertex dest )
	    {
	        if( dest.prev != null )
	        {
	            printPath( dest.prev );
	            System.out.print( " to " );
	        }
	        System.out.print( dest.name );
	    }
	    
	    /**
	     * Initializes the vertex output info prior to running
	     * any shortest path algorithm.
	     */
	    private void clearAll( )
	    {
	        for( Iterator itr = vertexMap.values( ).iterator( ); itr.hasNext( ); )
	            ( (Vertex)itr.next( ) ).reset( );
	    }
	    
	    private void clearAllLP( )
	    {
	        for( Iterator itr = vertexMap.values( ).iterator( ); itr.hasNext( ); )
	            ( (Vertex)itr.next( ) ).reset2( );
	    }

	    /**
	     * Single-source unweighted shortest-path algorithm.
	     */
	    public void unweighted( String startName )  //BFS
	    {
	        clearAll( ); 

	        Vertex start = (Vertex) vertexMap.get( startName );
	        if( start == null )
	            throw new NoSuchElementException( "Start vertex not found" );

	        LinkedList q = new LinkedList( );
	        q.addLast( start ); start.dist = 0;
	       
	        while( !q.isEmpty( ) )
	        {
	            Vertex v = (Vertex) q.removeFirst( );

	            for( Iterator itr = v.adj.iterator( ); itr.hasNext( ); )
	            {
	                Edge e = (Edge) itr.next( );
	                Vertex w = e.dest;
	                if( w.dist == INFINITY )
	                {
	                    w.dist = v.dist + 1;
	                    w.prev = v;
	                    q.addLast( w );
	                }
	            }
	        }
	    }
	    
	    

	    /**
	     * Single-source weighted shortest-path algorithm.
	     */
	   /* public void dijkstra( String startName )
	    {
	        PriorityQueue pq = new BinaryHeap( );

	        Vertex start = (Vertex) vertexMap.get( startName );
	        if( start == null )
	            throw new NoSuchElementException( "Start vertex not found" );

	        clearAll( );
	        pq.insert( new Path( start, 0 ) ); start.dist = 0;
	        
	        int nodesSeen = 0;
	        while( !pq.isEmpty( ) && nodesSeen < vertexMap.size( ) )
	        {
	            Path vrec = (Path) pq.deleteMin( );
	            Vertex v = vrec.dest;
	            if( v.scratch != 0 )  // already processed v
	                continue;
	                
	            v.scratch = 1;
	            nodesSeen++;

	            for( Iterator itr = v.adj.iterator( ); itr.hasNext( ); )
	            {
	                Edge e = (Edge) itr.next( );
	                Vertex w = e.dest;
	                double cvw = e.cost;
	                
	                if( cvw < 0 )
	                    throw new Exception( "Graph has negative edges" );
	                    
	                if( w.dist > v.dist + cvw )
	                {
	                    w.dist = v.dist +cvw;
	                    w.prev = v;
	                    pq.insert( new Path( w, w.dist ) );
	                }
	            }
	        }
	    }*/

	    /**
	     * Single-source weighted shortest-path algorithm using pairing heaps.
	     * @throws Exception 
	     */
	    public void dijkstra2( String startName ) throws Exception
	    {
	        PriorityQueue pq = new PairingHeap( );

	        Vertex start = (Vertex) vertexMap.get( startName );
	        if( start == null )
	            throw new NoSuchElementException( "Start vertex not found" );

	        clearAll( );
	        start.pos = pq.insert( new Path( start, 0 ) ); start.dist = 0;

	        while ( !pq.isEmpty( ) )
	        {
	            Path vrec = (Path) pq.deleteMin( );
	            Vertex v = vrec.dest;
	                
	            for( Iterator itr = v.adj.iterator( ); itr.hasNext( ); )
	            {
	                Edge e = (Edge) itr.next( );
	                Vertex w = e.dest;
	                double cvw = e.cost;
	                
	                if( cvw < 0 )
	                    throw new Exception( "Graph has negative edges" );
	                    
	                if( w.dist > v.dist + cvw )
	                {
	                    w.dist = v.dist + cvw;
	                    w.prev = v;
	                    
	                    Path newVal = new Path( w, w.dist );                    
	                    if( w.pos == null )
	                        w.pos = pq.insert( newVal );
	                    else
	                        pq.decreaseKey( w.pos, newVal ); 
	                }
	            }
	        }
	    }

	    /**
	     * Single-source negative-weighted shortest-path algorithm.
	     * @throws Exception 
	     */
	    public void negative( String startName ) throws Exception
	    {
	        clearAll( ); 

	        Vertex start = (Vertex) vertexMap.get( startName );
	        if( start == null )
	            throw new NoSuchElementException( "Start vertex not found" );

	        LinkedList q = new LinkedList( );
	        q.addLast( start ); start.dist = 0; start.scratch++;

	        while( !q.isEmpty( ) )
	        {
	            Vertex v = (Vertex) q.removeFirst( );
	            if( v.scratch++ > 2 * vertexMap.size( ) )
	                throw new Exception( "Negative cycle detected" );

	            for( Iterator itr = v.adj.iterator( ); itr.hasNext( ); )
	            {
	                Edge e = (Edge) itr.next( );
	                Vertex w = e.dest;
	                double cvw = e.cost;
	                
	                if( w.dist > v.dist + cvw )
	                {
	                    w.dist = v.dist + cvw;
	                    w.prev = v;
	                      // Enqueue only if not already on the queue
	                    if( w.scratch++ % 2 == 0 )
	                        q.addLast( w );
	                    else
	                        w.scratch--;  // undo the enqueue increment    
	                }
	            }
	        }
	    }

	    /**
	     * Single-source negative-weighted acyclic-graph shortest-path algorithm.
	     * @throws Exception 
	     */
	    public void acyclic( String startName ) throws Exception  // 
	    {
	        Vertex start = (Vertex) vertexMap.get( startName );
	        if( start == null )
	            throw new NoSuchElementException( "Start vertex not found" );

	        clearAll( ); 
	        LinkedList q = new LinkedList( );
	        start.dist = 0;
	        
	          // Compute the indegrees
	        Collection vertexSet = vertexMap.values( );
	        for( Iterator vsitr = vertexSet.iterator( ); vsitr.hasNext( ); )
	        {
	            Vertex v = (Vertex) vsitr.next( );
	            for( Iterator witr = v.adj.iterator( ); witr.hasNext( ); )
	            	//a la lista de los ady de cada vertice se le agrega ++ 
	            	//segun la cantidad de enlace tenga cada vertice
	            	
	                ( (Edge) witr.next( ) ).dest.scratch++;
	        }    
	            
	          // Enqueue vertices of indegree zero
	        for( Iterator vsitr = vertexSet.iterator( ); vsitr.hasNext( ); )
	        {
	            Vertex v = (Vertex) vsitr.next( );
	            if( v.scratch == 0 )
	                q.addLast( v );
	        }    
	       
	        int iterations;
	        for( iterations = 0; !q.isEmpty( ); iterations++ )
	        {
	            Vertex v = (Vertex) q.removeFirst( );

	            for( Iterator itr = v.adj.iterator( ); itr.hasNext( ); )
	            {
	                Edge e = (Edge) itr.next( );
	                Vertex w = e.dest;
	                double cvw = e.cost;
	                
	                if( --w.scratch == 0 )
	                    q.addLast( w );
	                
	                if( v.dist == INFINITY )
	                    continue;    
	                
	                if( w.dist > v.dist + cvw )
	                	
	                {
	                    w.dist = v.dist + cvw;
	                    w.prev = v;
	                }
	            }
	        }
	        
	        if( iterations != vertexMap.size( ) )
	            throw new Exception( "Graph has a cycle!" );
	    }

	    /**
	     * Process a request; return false if end of file.
	     */
	    public static boolean processRequest( BufferedReader in, Graph g )
	    {
	        String startName = null;
	        String destName = null;
	        String alg = null;

	        try
	        {
	            System.out.print( "Enter start node:" );
	            if( ( startName = in.readLine( ) ) == null )
	                return false;
	            System.out.print( "Enter destination node:" );
	            if( ( destName = in.readLine( ) ) == null )
	                return false;
	            System.out.print( " Enter algorithm (u, d, n, a ): " );   
	            if( ( alg = in.readLine( ) ) == null )
	                return false;
	            
	            if( alg.equals( "u" ) )
	                g.unweighted( startName );
	            else if( alg.equals( "d" ) )    
	            {
	              //  g.dijkstra( startName );
	                
	                g.dijkstra2( startName );
	                g.printPath( destName );
	            }
	            else if( alg.equals( "n" ) )
	                g.negative( startName );
	            else if( alg.equals( "a" ) )
	                g.acyclic( startName );
	                    
	            g.printPath( destName );
	        }
	        catch( IOException e )
	          { System.err.println( e ); }
	        catch( NoSuchElementException e )
	          { System.err.println( e ); }          
	        catch( Exception e )
	          { System.err.println( e ); }
	        return true;
	    }




	   /* public Vertex[] criticalPath(){
		    //tasks whose critical cost has been calculated
		    HashSet<Vertex> completed = new HashSet<Vertex>();
		    //tasks whose ciritcal cost needs to be calculated
		    LinkedList q = tareas;
		    List tasks = new LinkedList();
		    
		    while( !q.isEmpty( ) )
	        {
	            Vertex v = (Vertex) vertexMap.get( q.removeFirst() );
	            tasks.add(v);
	            
	        }
		    
		    
		    
		    HashSet<Vertex> remaining = new HashSet<Vertex>(tasks);

		    //Backflow algorithm
		    //while there are tasks whose critical cost isn't calculated.
		    while(!remaining.isEmpty()){
		      boolean progress = false;

		      //find a new task to calculate
		      for(Iterator<Vertex> it = remaining.iterator();it.hasNext();){
		        Vertex task = it.next();
		        if(completed.containsAll(task.adj)){
		          //all adj calculated, critical cost is max dependency
		          //critical cost, plus our cost
		          double critical = 0;
		          for(Iterator<Vertex> itr = task.adj.iterator( ); itr.hasNext( )){
		            if(itr.next().criticalCost > critical){
		              critical = itr.next().criticalCost;
		           }
		          }
		          task.criticalCost = critical+task.dist;
		          //set task as calculated an remove
		          completed.add(task);
		          it.remove();
		          //note we are making progress
		          progress = true;
		        }
		      }
		      //If we haven't made any progress then a cycle must exist in
		      //the graph and we wont be able to calculate the critical path
		      if(!progress) throw new RuntimeException("Cyclic dependency, algorithm stopped!");
		    }

		    //get the tasks
		    Vertex[] ret = completed.toArray(new Vertex[0]);
		    //create a priority list
		    Arrays.sort(ret, new Comparator<Vertex>() {

		      @Override
		      public int compare(Vertex o1, Vertex o2) {
		        //sort by cost
		        double ii= o2.criticalCost-o1.criticalCost;
		        int i= (int)ii;
		        if(i != 0)return i;

		        //using dependency as a tie breaker
		        //note if a is dependent on b then
		        //critical cost a must be >= critical cost of b
		        if(o1.isDependent(o2))return -1;
		        if(o2.isDependent(o1))return 1;
		        return 0;
		      }
		    });

		    return ret;
		  }*/

	    public void acycliclp( String startName ) throws Exception  // 
	    {
	        Vertex start = (Vertex) vertexMap.get( startName );
	        if( start == null )
	            throw new NoSuchElementException( "Start vertex not found" );

	        clearAllLP( ); 
	        LinkedList q = new LinkedList( );
	        start.dist = 0;
	        
	          // Compute the indegrees
	        Collection vertexSet = vertexMap.values( );
	        for( Iterator vsitr = vertexSet.iterator( ); vsitr.hasNext( ); )
	        {
	            Vertex v = (Vertex) vsitr.next( );
	            for( Iterator witr = v.adj.iterator( ); witr.hasNext( ); )
	                ( (Edge) witr.next( ) ).dest.scratch++;
	        }    
	            
	          // Enqueue vertices of indegree zero
	        for( Iterator vsitr = vertexSet.iterator( ); vsitr.hasNext( ); )
	        {
	            Vertex v = (Vertex) vsitr.next( );
	            if( v.scratch == 0 )
	                q.addLast( v );
	        }    
	       
	        int iterations;
	        for( iterations = 0; !q.isEmpty( ); iterations++ )
	        {
	            Vertex v = (Vertex) q.removeFirst( );

	            for( Iterator itr = v.adj.iterator( ); itr.hasNext( ); )
	            {
	                Edge e = (Edge) itr.next( );
	                Vertex w = e.dest;
	                double cvw = e.cost;
	                
	                if( --w.scratch == 0 )
	                    q.addLast( w );
	                
	                if( v.dist == negINFINITY )
	                    continue;    
	                
	                if( w.dist < v.dist + cvw )
	                {
	                    w.dist = v.dist + cvw;
	                    w.prev = v;
	                }
	            }
	        }
	        
	        if( iterations != vertexMap.size( ) )
	            throw new Exception( "Graph has a cycle!" );
	    }
	    
	    
	    
	    
	    public String destinoLp(String startName){
	    	
	    	Vertex start = (Vertex) vertexMap.get( startName );
	        if( start == null )
	            throw new NoSuchElementException( "Start vertex not found" );
	        Vertex v;
	        Iterator it = vertexMap.entrySet().iterator();
	        
	        Map.Entry f = (Map.Entry)it.next();
        	v = (Vertex)f.getValue();
	        
	        while (it.hasNext()) {
	        	Map.Entry e = (Map.Entry)it.next();
	        	Vertex w = (Vertex)e.getValue();
	        	if (v.dist < w.dist){
	        		//comprara en cada vertice.cost cual es el que tiene mayor costo
	        		
	        		v= w;
	        	}
	        }
	        //retorna el nombre del vertice que tiene mas peso
	        return v.name;

	       
	    }
	    
	    
	    public double tiempoTotal(LinkedList q){
	    	
	    	double time=0;
	    	 
	    	 while( !q.isEmpty( ) )
		        {
		            Vertex v = (Vertex) q.removeFirst( );
		            
		           for( Iterator itr = v.adj.iterator( ); itr.hasNext( ); )
		            {
		                Edge e = (Edge) itr.next( );
		                Vertex w = e.dest;
		                Vertex x = (Vertex)q.getFirst();
		                double cvw = e.cost;
		                if( x.name.equals(w.name) )
		                {
		                    time= time + cvw;
		                }
		            }
		        }
	    	return time;
	    }
	    
	    public Vertex getVert( String vertexName )
	    {
	        Vertex v = (Vertex) vertexMap.get( vertexName );
	        if( v == null )
	        {
	           System.out.println("El vertice no existe");
	        }
	        else{return v;}
	        
	        return null;
	        
	    }

	    
	    public void predInm(String task,ArrayList pred){
	    	
	    	
	        Vertex v;
	        Iterator it = vertexMap.entrySet().iterator();
	        
	        Map.Entry f = (Map.Entry)it.next();
        	v = (Vertex)f.getValue();
        	if (contiene(task,v)){
        		pred.add(v.name);
        	}
	        while (it.hasNext()) {
	        	Map.Entry e = (Map.Entry)it.next();
	        	Vertex w = (Vertex)e.getValue();
	        	
	        	if (contiene(task,w)){
	        		pred.add(w.name);
	        	}
	        }
	        
	        
	    	
	    }
	    
	    
	    public boolean contiene(String task,Vertex v){
	    	
	    	for(Iterator itr=v.adj.iterator();itr.hasNext();){
	    		Vertex x=(Vertex)itr.next();
	    		if (x.name.equals(task)){return true;}
	    		
	    	
	    	}
	    	return false;
	    }
	    
	    public void eliminaVertice(String s){
	    	Vertex v=(Vertex)vertexMap.get(s);
	    	v= new Vertex("Tarea eliminada");
	    	
	    	vertexMap.remove(s);
	    }

		public Map getVertexMap() {
			return vertexMap;
		}

		public void setVertexMap(Map vertexMap) {
			this.vertexMap = vertexMap;
		}
	    
	    
	    
	    
	    
	    
	    
}
