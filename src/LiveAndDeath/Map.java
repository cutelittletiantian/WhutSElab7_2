package LiveAndDeath;


public class Map {
    private static int len = 50;
    private int data[][]; // 细胞地图信息，0为死细胞，1为活细胞

    public Map() {
        init(0.5);
    }

    public Map(Double i) {
        init(i);
    }

    // 初始化地图数据,model作为每个小格子死细胞的概论，默认为0.5
    public void init(double model) {
        data = new int[len][len];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j] = Math.random() > (double) 0.5 ? 1 : 0;
            }
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j] = Math.random() > model ? 1 : 0;
            }
        }
    }

    // 返回地图大小
    public int getLen() {
        return len;
    }

    // 修改某个点的值
    public void set(int i, int j, int t) {
        data[i][j] = t;
    }

    // 得到某个点的值
    public int get(int i, int j) {
        return data[i][j];
    }

    public int getNeighbor(int i, int j) {
        int neiber = 0;
        for (int k = -1; k < 2; k++) {
            for (int k2 = -1; k2 < 2; k2++) {
                if (i + k >= 0 && i + k < len) {
                    if (j + k2 >= 0 && j + k2 < len) {
                        if (k == 0 && k2 == 0) {

                        } else {
                            if (get(i + k, j + k2) != 0) {
                                neiber++;
                            }
                        }
                    }
                }
            }
        }
        return neiber;
    }
}