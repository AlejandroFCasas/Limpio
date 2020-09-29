package librerias;

public class Path implements Comparable {

	public Vertex     dest;   // w
    public double     cost;   // d(w)
    
    public Path( Vertex d, double c )
    {
        dest = d;
        cost = c;
    }
    
    public int compareTo( Object rhs )
    {
        double otherCost = ((Path)rhs).cost;
        
        return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
    }

}
