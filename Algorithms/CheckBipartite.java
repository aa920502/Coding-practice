//Check whether a tree is bipartite tree

class CheckBipartite{
	//BFS
	public boolean isBipartite(int adjacencyMatrix[][], int source){
        int[] colored = new int[numberOfVertices +  1];
        for (int vertex = 1; vertex <= numberOfVertices; vertex++)
        {
            colored[vertex] = NO_COLOR;
        }
        colored[source] = RED;
        queue.add(source);
 
        int element, neighbour;
        while (!queue.isEmpty())
        {
            element = queue.remove();
            neighbour = 1;
            while (neighbour <= numberOfVertices)
            { 
                if (adjacencyMatrix[element][neighbour] == 1 && colored[element]== colored[neighbour])
                {
                    return false;
                }
                if (adjacencyMatrix[element][neighbour] == 1 && colored[neighbour]== NO_COLOR)
                {
                    colored[neighbour] = (colored[element] == RED ) ? BLUE :RED;
                    queue.add(neighbour);
                }
                neighbour++;
            }
        }
        return true;
    }

}