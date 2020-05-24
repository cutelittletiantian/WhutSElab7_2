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
        for(int i = 0; i < getLen(); i++) {
			for(int j = 0; j < getLen(); j++) {
				set(i, j, 0);
			}
		}
        
//		以下为测试用代码，闲着没事时候要注释掉
//		
//		set(0, 6, 1);
//		set(0, 7, 1);
//		set(1, 7, 1);
//		set(1, 8, 1);
//		set(2, 6, 1);
//		set(2, 7, 1);
//		
//		set(6, 0, 1);
//		set(6, 1, 1);
//		set(7, 1, 1);
//		set(7, 2, 1);
//		set(8, 0, 1);
//		set(8, 1, 1);
//		
//		set(46, 6, 1);
//		set(46, 7, 1);
//		set(47, 7, 1);
//		set(47, 8, 1);
//		set(48, 6, 1);
//		set(48, 7, 1);
//		
//		set(6, 46, 1);
//		set(6, 47, 1);
//		set(7, 47, 1);
//		set(7, 48, 1);
//		set(8, 46, 1);
//		set(8, 47, 1);
//		
//		set(1, 1, 1);
//		set(1, 48, 1);
//		set(1, 49, 1);
//		set(48, 0, 1);
//		set(48, 1, 1);
//		set(48, 49, 1);
//		set(49, 1, 1);
//		
//		set(21, 20, 1);
//		set(21, 21, 1);
//		set(21, 22, 1);
//		set(21, 24, 1);
//		set(21, 25, 1);
//		set(21, 26, 1);
//		set(22, 25, 1);
//		set(23, 21, 1);
//		set(23, 25, 1);
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
        int neighbor = 0;
        for (int k = -1; k < 2; k++) {
            for (int k2 = -1; k2 < 2; k2++) {
                if (i + k >= 0 && i + k < len) {
                    if (j + k2 >= 0 && j + k2 < len) {
                        if (k == 0 && k2 == 0) {
                        	// 什么也不做
                        } else {
                            if (get(i + k, j + k2) != 0) {
                                neighbor++;
                            }
                        }
                    }
                }
            }
        }
        return neighbor;
    }
}