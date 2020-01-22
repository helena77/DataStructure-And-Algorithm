public class WeightedQuickUnionCompressPathUF {
    private int[] id;
    private int[] size;
    
    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            size[i] = 1;
        }
        
    }
    
    private int root(int n) {
        while (i != id[i]) {
            id[i] = id[id[i]];        // only one extra line of code
            i = id[i];
        }
        return i;
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    
    public void union(int p, int q) {
        int root_p = root(p);
        int root_q = root(q);
        if (root_p == root_q)
            return
        if (size[root_p] < size[root_q]) {
            id[root_p] = root_q;
            size[root_q] += size[root_p];
        } else {
            id[root_q] = root_p;
            size[root_p] += size[root_q];
        }
    }
}