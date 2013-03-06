package anonymousSrm;

import java.util.ArrayList;
import java.util.Collections;

public class KingdomReorganization {
    class Edge implements Comparable<Edge> {
        public int a, b, cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge e) {
            return cost-e.cost;
        }
    }

    int getValue(char c) {
        if (c >= 'A' && c <= 'Z')
            return c-'A';
        return c-'a'+26;
    }

    public int getCost(String[] kingdom, String[] build, String[] destroy) {
        int N = kingdom.length, massiveCost = 0, mstCost = 0;
        // get the cost of each edge + destroy all the existing edges
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                if (kingdom[i].charAt(j) == '0')
                    edges.add(new Edge(i, j, getValue(build[i].charAt(j))));
                else
                {
                    int val = getValue(destroy[i].charAt(j));
                    edges.add(new Edge(i, j, -val));
                    massiveCost += val;
                }
            }
        // solve the MST on the graph, using Kruskal's algorithm
        Collections.sort(edges);
        int[] color = new int[N];
        for (int i = 0; i < N; ++i)
            color[i] = i;

        for (int i = 0; i < edges.size(); ++i) {
            Edge e = edges.get(i);
            // vertices of the edge are not in the same component
            if (color[e.a] != color[e.b]) {
                mstCost += e.cost;
                // recolor the component
                int oldColor = color[e.b];
                for (int j = 0; j < N; ++j)
                    if (color[j] == oldColor)
                        color[j] = color[e.a];
            }
        }
        return massiveCost + mstCost;
    }
}