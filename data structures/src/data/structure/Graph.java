package data.structure;

import java.util.*;

class Graph<E> {

    public static int simplePaths(Graph<Integer> graph, int vertices, int edges) {
        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= vertices; i++) {
            int slider = i;
            while (slider + 1 <= vertices) {
                ++slider;
                list.clear();
                result += graph.count(i, slider, list);
            }
        }
        if (result - edges < 0) {
            return 0;
        }
        return result - edges;
    }

    public int count(E base, E temp, ArrayList<E> list) {
        int counter = 0;
        list.add(base);
        if (temp == base) {
            list.remove(base);
            return 1;
        }
        for (E x : map.get(base)) {
            if (!list.contains(x)) {
                counter += count(x, temp, list);
            }
        }
        list.remove(base);
        return counter;
    }

    private HashMap<E, LinkedList<E>> map = new HashMap<>();

    public Graph() {

    }

    public void addVertex(E vertex) {
        map.put(vertex, new LinkedList<>());
    }

    public void addEdge(E source, E destination, boolean biDerctional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(destination)) {
            addVertex(destination);
        }
        map.get(source).add(destination);
        if (biDerctional) {
            map.get(destination).add(source);
        }
    }

    public int vertexCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int counter = 0;
        for (E key : map.keySet()) {
            counter += map.get(key).size();
        }
        return counter;
    }

    public boolean containsVertex(E vertex) {
        return map.containsKey(vertex);
    }

    public boolean hasDirectedEdge(E vertex1, E vertex2) {
        return map.get(vertex1).contains(vertex2);
    }

    public boolean hasUndirectedEdge(E vertex1, E vertex2) {
        return map.get(vertex1).contains(vertex2) || map.get(vertex2).contains(vertex1);
    }

    public String DFS(E start) {
        if (!map.containsKey(start)) {
            return null;
        }
        String result = "";
        HashSet<E> seen = new HashSet<>();
        Stack<E> stk = new Stack<>();
        stk.push(start);
        while (!stk.empty()) {
            E temp = stk.pop();
            if (!seen.contains(temp)) {
                seen.add(temp);
                result += temp + " ";
                pushAll(stk, map.get(temp));
            }
        }
        return result;
    }

    private Stack<E> pushAll(Stack<E> stk, List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            stk.push(list.get(i));
        }
        return stk;
    }

    @Override
    public String toString() {
        String s = "";
        for (E key : map.keySet()) {
            s += key + " " + map.get(key).toString() + "\n";
        }
        return s;
    }

    class Path<E> {

        ArrayList<E> list = new ArrayList<>();

        public Path() {

        }

        public void add(E e) {
            list.add(e);
        }

        public void remove(E e) {
            list.remove(e);
        }

        public boolean isSimple() {
            HashSet<E> set = new HashSet();
            for (int i = 0; i < list.size(); i++) {
                set.add(list.get(i));
            }
            return set.size() == list.size() && set.size() >= 2;
        }
    }
}
