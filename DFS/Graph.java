/**Graph.java + test program
  * <p>
  * Creates a graph 
  * @author Josiah MacDonald
  * 
  * NOTE: class is named Graph, though this does NOT use Mains Graph class as is described on the assignment page
  * 
  */
import java.util.*;

public class Graph{
  /**
   * Makes a LinkedList always an int, so it can be
   * placed in arrays */
  class MyLinkedList extends LinkedList<Integer>{}
  
  /**MyLinkedList for topological graph*/
  private MyLinkedList top = new MyLinkedList();
  /**number of vertices*/
  private int verts = 0;
  /**graph containing MyLinkedLists*/
  private MyLinkedList[] graph;
  /**array of the colors*/
  private String[] color;
  /**boolean flaggin if its cyclic*/
  private boolean cyclic;
  
  /**
   * Constructor
   * <p>
   * Creates a new Graph*/
  public Graph(int a){
    cyclic = false;//sets cyclic to false originally
    verts = a;
    graph = new MyLinkedList[a];
    color = new String[a];
    for(int i=0;i<a;i++){
      graph[i] = new MyLinkedList();
    }
  }
  /**Method for adding a verticy
    * @param n link from
    * @param k link to*/
  public void add(int n, int k){
    if (n<0 || k<0 || n>= verts || k >= verts)
      throw new IllegalArgumentException();
    Integer kk = new Integer(k);
    if (!graph[n].contains(kk))
      graph[n].add(kk);
  }
  /**Method for removing a verticy
    * @param n link from
    * @param k link to*/
  public void remove(int n, int k){
    if (n<0 || k<0 || n>= verts || k >= verts)
      throw new IllegalArgumentException();
    Integer kk = new Integer(k);
    if(graph[n].contains(kk))
      graph[n].remove(kk);
  }
  
  /**Method for printing the graph
    * Will return each element verticies on a line*/
  public void print(){
    for(int i=0;i<verts;i++){
      if(graph[i].size() > 0){
        for(int k=0;k<graph[i].size();k++){
          System.out.print(i+"->"+graph[i].get(k)+"\t");
        }
      }
      else{
        System.out.print("No edges from "+i);
      }
      System.out.print("\n");
    }
  }
  
  /**Method for testing if an edge exists
    * @param i link from
    * @param j link to
    * @return boolean value of if g contains i->j*/
  public Boolean contains(int i, int j){
    Integer jj = new Integer(j);
    return(graph[i].contains(jj));
  }
  
  /**Method which performs DFS search
    * Will perform function to test DFS colors of verticies
    */
  public void DFS() {
    for(int i=0;i<graph.length;i++) 
    {
      color[i] = "White";
    }
    
    for(int i=0;i<graph.length;i++)
    {
      if (color[i]=="White")
        DFSVisit(i);
    }
  }
  
  /**Method which recursively calls itself to check every verticy
    * @param n link from
    * @param k link to*/
  public void DFSVisit(int u) {
    color[u] = "Gray";
    for(int v=0;v<graph[u].size();v++){ 
      if (color[graph[u].get(v)] == "White")
        DFSVisit(graph[u].get(v));
      else if(color[graph[u].get(v)] == "Gray")
        cyclic = true;
    }
    color[u] = "Black";
    top.addFirst(u);
  }
  
  /**Method to return cyclic variable
    * First will perform DFS sort
    * @return boolean value of cyclic*/
  public boolean isAcyclic(){
    DFS();
    return !cyclic;
  }
  
  /**Method topologically sort the graph
    * @return MyLinkedList of topological sort*/
  public MyLinkedList top(){
    if(cyclic)
      return new MyLinkedList();
    return top;
  }
  
  /**Program to test functionality of the Graph class*/
  public static void main(String argv[]) {
    Graph g = new Graph(14);
    g.add(0,4);    g.add(0,5);    g.add(0,11);
    g.add(1,2);    g.add(1,4);    g.add(1,8);
    g.add(2,5);    g.add(2,6);    g.add(2,9);
    g.add(3,2);    g.add(3,6);    g.add(3,13);
    g.add(4,7);
    g.add(5,8);    g.add(5,12);  
    g.add(6,5);  
    g.add(8,7);  
    g.add(9,10);   g.add(9,11);  
    g.add(10,13);  
    g.add(12,9);
    System.out.println("Printing graph:");
    g.print();
    g.DFS();
    System.out.println("topological sort: "+g.top());
    System.out.println("graph is acyclic: "+g.isAcyclic());
    System.out.println("making cyclic...");
    g.add(13,1);
    g.DFS();
    System.out.println("graph is acyclic: "+g.isAcyclic());
    
    
  }
}