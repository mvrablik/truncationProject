import java.util.ArrayList;
public class Polyhedron
{
	private ArrayList<Vertex> points;
	private ArrayList<Edge> edges;
	private ArrayList<Face> sides;

	
	public Polyhedron(ArrayList<Vertex> inputPoints, ArrayList<Edge> inputEdges,ArrayList<Face> inputSides) {
		points=inputPoints;
		edges=inputedges;
		sides=inputsides;
}
	public void pointTrun(Vertex point, double distance){
		ArrayList<Edge> tempEdges=new ArrayList(); //used to store the edges before truncation
		ArrayList<Face> tempFaces=new ArrayList(); //used to store the faces before truncation
		ArrayList<Edge> newEdges=new ArrayList();
		ArrayList<Vertex> newPoints=new ArrayList();
		ArrayList<Face> newFaces=new ArrayList();
		for(Edge e : edges){ //generates the list of edges that will be changed
			if(e.hasPoint(point)){
				tempEdges.add(e);
			}
		}
		for(Edge e: tempEdges){ //generates the list of faces that will be changed
			for(Face f: sides){
				if(f.hasEdge(e)){
					tempFaces.add(f);
				}
			}
		}
		for(int i=0;i<tempFaces.size();i+=0){ //supermessy way of getting rid of duplicates
			if(tempFaces.indexOf(tempFaces.get(i)).equals(tempFaces.lastIndexOf(tempFaces.get(i)))){
				i++;
			}
			else{
				tempFaces.remove(tempFaces.get(i));
				i=0;
			}
		}
		for(Face f: tempFaces){ //removes the faces that are going to be changed from the actual list
			if(sides.contains(f)){
				sides.remove(f);
			}
		}
		for(Edge e: tempEdges){ //removes  the edges that are going to be changed from the actual list
			if(edges.contains(e)){
				edges.remove(e);
			}
		}
		for(Edge e: tempEdges){
			
		}
	}
	public boolean hasVertexAtXY(double x, double y)
	{
		for (Vertex v: points)
		{
			if (v.getX == x && v.getX == y)
			return true;
		}
		return false;
	}
	
	public boolean hasEdgeAtXY(double x3, double y3)
	{
		double x1,x2,y1,y2;
		Vertex[] verticies = new Vertex[2];
		for (Edge e: edges)
		{
			verticies = e.getVerticies();
			x1 = verticies[0].getX;
			x2 = verticies[1].getX;
			y1 = verticies[0].getY;
			y2 = verticies[1].getY;
			if (y3-y1 == (y2-y1)*(x3-x1)/(x2-x1))
			{ 
				return true;
			}
		}
		return false;
			
	}
	
	public Edge getEdgeAtXY(double x3, double y3)
	{
		double x1,x2,y1,y2;
		Vertex[] verticies = new Vertex[2];
		currentEdge
		for (Edge e: edges)
		{
			verticies = e.getVerticies();
			x1 = verticies[0].getX;
			x2 = verticies[1].getX;
			y1 = verticies[0].getY;
			y2 = verticies[1].getY;
			if (y3-y1 == (y2-y1)*(x3-x1)/(x2-x1))
			{ 
				currentEdge = e;
			}
		}
		return currentEdge;
			
	}
	
	public Vertex getVertexAtXY(double x, double y)
	{
		Vertex closest;	
		points.get(0).getZ = z		//gets a z coordinate to check against
		for (Vertex v: points)
		{
			if (v.getX == x && v.getX == y && v.getZ > z)	
			{
				closest = v;
				z = v.getZ;
			}
		}
		return closest;
	}
	public ArrayList<Face> getFaces()
	{
		return sides;
	}
	
	public ArrayList<Edge> initiateEdges(ArrayList<Vertex> points)
	{
		ArrayList tempPoints = new ArrayList<Vertex>();
		tempPoints = points
		ArrayList edges = new ArrayList<Edge>
	
		do
		{
			for (int i = 0; i < tempPoints.size; i ++)
			{
				if (tempPoints.get(0).distance() = 1)
				{
					edges.add(new Edge(tempPoints.get(0), tempPoints.get(i));
				}
			}
			tempPoints.remove(0);
		}
		while (tempPoints.size > 0);
	}
		
}
