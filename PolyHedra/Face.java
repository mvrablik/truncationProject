package polyhedra;

import java.util.ArrayList;

public class Face
{
	private ArrayList<Edge> edges;
	
	public Face(ArrayList<Edge> inputEdges)
	{
		edges=new ArrayList<>(inputEdges);
	}
	
	public ArrayList<Edge> getEdges()
	{
		return new ArrayList<Edge>(edges);
	}
	
	public boolean remove(Edge e)
	{
		return edges.remove(e);
	}
	
	public void add(Edge e)
	{
		edges.add(e);
	}

    public boolean hasEdge(Edge e)
    {
    	if(edges.contains(e))
    	{
    		return true;
    	}
    	return false;
    }
    
    public boolean hasVertex(Vertex v)
    {
    	if(getVertices().contains(v))
    	{
    		return true;
    	}
    	return false;
    }
    
    public boolean sameAs(Face f)
    {
    	if (f.edges.size() != this.edges.size())
    	{
    		return false;
    	}
    	for (int i=0;i<this.edges.size();i++)
    	{
    		if (!(f.edges.contains(this.edges.get(i)))) return false;
    	}
    	return true;
    }
    
    public Vertex getCentroid()
    {
    	double x=0, y=0, z=0;
    	int n=0;
    	for (int i = 0; i < edges.size(); i ++)
    	{
    		for (int k = 0; k < 2; k ++)
    		{
    			x = x + edges.get(i).getVertices()[k].getCoords()[0];
    			y = y + edges.get(i).getVertices()[k].getCoords()[1];
    			z = z + edges.get(i).getVertices()[k].getCoords()[2];
    			n++;
    		}
    	}
    	x = x / n;
    	y = y / n;
    	z = z / n;
    	Vertex centroid = new Vertex(x, y, z);
    	return centroid;
    }
    
    public int getNumVertices()
    {
    	return edges.size();
    }
    
    public ArrayList<Vertex> getOrderedVertices()
    {
    	///*
    	ArrayList<Edge> tempEdges = new ArrayList<Edge>(edges);
    	Edge e;
    	Vertex a, b;
    	int n = 2;
    	ArrayList<Vertex> orderedVertices = new ArrayList<Vertex>();
    	orderedVertices.add(tempEdges.get(0).getVertices()[0]);
    	orderedVertices.add(tempEdges.remove(0).getVertices()[1]);

    	do {
    		int startSize = tempEdges.size();
    		
    		for (int i = 0; i < tempEdges.size(); i ++)
    		{
    			e = tempEdges.get(i);
    			a = e.getVertices()[0];
    			b = e.getVertices()[1];
    			n = orderedVertices.size() - 1;
    			if (orderedVertices.get(n).equals(a))
    			{
    				orderedVertices.add(b);
    				tempEdges.remove(i);
    				break;
    			}
    			else if (orderedVertices.get(n).equals(b))
    			{
    				orderedVertices.add(a);
    				tempEdges.remove(i);
    				break;
    			}
    		}
    		//TODO FIX INFINITE LOOP (OCCURS WHEN VERTICES COME TOO CLOSE)
    		
    		//aborts infinite loops
    		if (tempEdges.size() == startSize)
    		{
    			System.out.print(""
    					+ "\n!! Infinite loop in Face.getOrderedVertices aborted"
    					+ "\n!! orderedVertices returned incomplete (tempEdges dumped)"
    					+ "\n!!     tempEdges.size(): " + tempEdges.size()
    					+ "\n!!     Face: " + this
    					+ "\n!!     tempEdges: " + tempEdges
    					+ "\n");
    			break;
    		}
    		
    	} while (tempEdges.size() > 0);
    	return orderedVertices;
        //*/return this.getOrder();
    }
    
    public ArrayList<Vertex> getOrder()
    {
        ArrayList<Vertex> unOrder=new ArrayList<Vertex>(this.getVertices());
        ArrayList<Vertex> out=new ArrayList<Vertex>();
        Vertex currentVertex=unOrder.get(0);
        Vertex nextVertex=unOrder.get(0);
        unOrder.remove(0);
        out.add(currentVertex);
        double smallestDistance=Double.MAX_VALUE;
        while(unOrder.size()!=0)
        {
        	for(Vertex testVertex:unOrder)
        	{
        		if(testVertex.distanceTo(currentVertex)<smallestDistance)
        		{
                    smallestDistance=testVertex.distanceTo(currentVertex);
                    nextVertex=testVertex;
                }
            }
            out.add(nextVertex);
            unOrder.remove(currentVertex);
            currentVertex=nextVertex;
            smallestDistance=Double.MAX_VALUE;
        }
        return out;
    }
    
    public ArrayList<Vertex> getVertices()
    {
        ArrayList<Vertex> out= new ArrayList<Vertex>();
        for(Edge e:edges)
        {
            out.add(e.getVertices()[0]);
            out.add(e.getVertices()[1]);
        }
        for(int i=0;i<out.size();i++)
        {
            for(int j=i+1;j<out.size();j+=0)
            {
                if(out.get(j).equals(out.get(i)))
                {
                    out.remove(j);
                    j=i+1;
                }
                else
                {
                    j++;
                }
            }
        }
        return out;
    }
}
