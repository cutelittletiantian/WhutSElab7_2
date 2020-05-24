package LiveAndDeath;

public class Logic {

    // 更新map数据
    public void update(Map map){
    	
    	// 杜文添增补：临时存放迭代结果
    	Map nextMap = new Map();
    	
    	int neighbor=0;
    	// 更新信息暂存
        for (int i = 0; i < map.getLen(); i++) {
            for (int j = 0; j < map.getLen(); j++) {
                neighbor = map.getNeighbor(i, j);
                if(neighbor == 2){
                	nextMap.set(i,j,map.get(i, j));
                }
                else if(neighbor==3){
                	nextMap.set(i,j,1);
                }
                else{
                	nextMap.set(i,j,0);
                }
            }
        }
        
        int tmpStatus = -1;
        // 更新信息
        for (int i = 0; i < map.getLen(); i++) {
            for (int j = 0; j < map.getLen(); j++) {
                tmpStatus = nextMap.get(i, j);
                map.set(i, j, tmpStatus);
            }
        }
    }
}