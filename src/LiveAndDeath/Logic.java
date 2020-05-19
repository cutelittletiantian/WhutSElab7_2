package LiveAndDeath;

public class Logic {

    // 更新map数据
    public void update(Map map){
        for (int i = 0; i < map.getLen(); i++) {
            for (int j = 0; j < map.getLen(); j++) {
                int neighbor=0;
                neighbor = map.getNeighbor(i, j);
                if(neighbor==2){

                }
                else if(neighbor==3){
                    map.set(i,j,1);
                }
                else{
                    map.set(i,j,0);
                }
            }
        }
    }
}