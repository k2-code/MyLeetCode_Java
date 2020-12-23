package UnionFind_Algorithm;

public abstract class UF {

    protected int[] id;

    //构造大小为N的并查集
    public UF(int N){
        id=new int[N];
        for (int i=0;i<N;i++){
            id[i]=i;
        }
    }

    //判断p、q是否联通
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    //查找p所在的连通分量编号
    public abstract int find(int p);

    //连接p和q节点
    public abstract void union(int p,int q);
}
