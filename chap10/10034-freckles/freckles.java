import java.util.*;
import java.util.Vector;
import java.util.Scanner;

class Edge
{
    protected int      origin;
    protected int      destination;

    protected String      label;

    protected double      weight;

    protected double      capacity;
    protected double      flow;
    protected double      residual;

    public Edge( int origin, int destination )
    {
        this.origin = origin;
        this.destination = destination;
        this.label = null;
        reset();
    }
    public Edge( int origin, int destination, String label )
    {
        this.origin = origin;
        this.destination = destination;
        this.label = label;
        reset();
    }

    public void reset()
    {
        weight   = 1.0;
        capacity = 1.0;
        flow     = 0.0;
        residual = 0.0;
    }

    public int getOrigin() { return origin; }
    public int getDestination() { return destination; }
    public String getLabel() { return label; }

    public double getWeight() { return weight; }

    public void setWeight( double w ) { weight=w; }

    public double getCapacity() { return capacity; }
    public double getFlow()     { return flow; }
    public double getResidual() { return residual; }


    public void setCapacity( double c ) { capacity=c; }
    public void setFlow(double f ) { flow=f; }
    public void setResidual( double r ) { residual=r; }


    public String toString()
    {
        return origin + " --> " + destination;
    }
}
class Main
{
    static int v;
    static Edge [] edges;
    static Scanner sc = new Scanner( System.in ).useLocale(Locale.ENGLISH);

    public static double distancia (double x1 , double y1 , double x2 , double y2) {
        return  Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static void main(String [] args)
    {
        int num_cases = sc.nextInt();
        int edge;
        double total;
        Vector<Edge> g;
        Edge e;

        while(num_cases-- > 0 )
        {
            v = sc.nextInt();
            double x [] = new double[v];
            double y [] = new double[v];
            edges=new Edge[(v * (v-1))/2];
            for (int i = 0; i < v; i++)
            {
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
            }
            edge = 0;
            for (int i = 0; i < v-1; ++i)
            {
                for (int j = i + 1; j < v; ++j)
                {

                    e = new Edge(i,j);
                    e.setWeight(distancia(x[i],y[i],x[j],y[j]));
                    edges[edge] = e;
                    edge++;
                }
            }

            g = minimumSpanningTreeKruskal();
            total=0;

            for( Edge ed : g)total+=ed.getWeight();

            String s = String.format(Locale.US, "%.2f\n", total);
            System.out.printf(s);
            if(num_cases>0)System.out.println();
        }
    }

    public static Vector<Edge> minimumSpanningTreeKruskal()
    {

        // 'setId' contains the id of nodes. Nodes with the same id are in the same connected component.
        int setId[] = new int [v];
        for( int i=0; i < setId.length; i++ ) setId[i] = i;

        Vector<Edge>  mst = new Vector<Edge>();

        while( mst.size() < v-1 ) {

            // Search for the edge with lowest weight between vertices of different sets (or groups).
            Edge bestEdge = null;
            for( Edge e : edges ) {

                // If the edge connects nodes in the same connected component then is ignored.
                if ( setId[ e.getOrigin()] == setId[ e.getDestination() ] ) continue;

                if ( bestEdge == null  ||  e.getWeight() < bestEdge.getWeight() ) bestEdge = e;
            }

            if ( bestEdge != null ) {

                // Marking the vertices as belonging to the same set (or group)

                int setIdMin = Math.min( setId[ bestEdge.getOrigin() ], setId[ bestEdge.getDestination() ] );
                int setIdMax = Math.max( setId[ bestEdge.getOrigin()], setId[ bestEdge.getDestination()] );

                for( int i=0; i < setId.length; i++ )
                    setId[i] = ( setId[i] == setIdMax ) ? setIdMin : setId[i];

                mst.add( bestEdge );
            }
        }

        return mst;
    }

}