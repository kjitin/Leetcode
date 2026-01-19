package com.jitin.oreilly;

public class QuickFindUF {

    private final int[] id;
    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(9);
        quickFindUF.union(0,1);
        quickFindUF.union(6,7);
        quickFindUF.union(0,2);

        System.out.println(quickFindUF.connected(0,2));
    }

    QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }
}
