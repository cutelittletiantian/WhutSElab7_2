package ds;

public class CellStorage {
	private int SIZE = 100; // 二维数组下标范围是[0, SIZE]
	private Boolean[][] status = null; // 每个单元格的存活状态
	private int[][] neighbors = null; // 每个单元格当前状态的邻居个数
	
	// 默认初始化构造函数
	CellStorage(){
		status = new Boolean[SIZE + 1][SIZE + 1];
		neighbors = new int[SIZE +1][SIZE + 1];
		for(int i=0; i<=SIZE; i++) {
			for(int j=0; j<=SIZE; j++) {
				status[i][j] = false;
				neighbors[i][j] = 0;
			}
		}
	}
	
	// 初始化构造函数
	CellStorage(Boolean[][] _status){
		status = _status;
		SIZE = _status[0].length + 1;
	}
	
	// 初始化
	public void init(Boolean[][] _status){
		status = _status;
		SIZE = _status[0].length + 1;
	}
	
	
	public Boolean[][] getStatus(){
		return status;
	}
	
	public void setStatus(Boolean[][] _status) {
		status = _status;
	}
	
	public int getSize() {
		return SIZE;
	}
	
	public void setSize(int _size) {
		SIZE = _size;
	}
	
	public int[][] getNeighbor(){
		return neighbors;
	}
	
	// 每个单元格的下一状态
	public boolean nextUnit(int row, int col) {
		int cntNeighbor = neighbors[row][col];
		if(cntNeighbor == 3) {
			return true;
		}
		else if(cntNeighbor != 2) {
			return false;
		}
		else { // cntNeighbor == 2
			return status[row][col]; // 不变
		}
	}
	
	// 更新当前状态
	public void update(CellStorage tempCells) {
		status = tempCells.getStatus();
		neighbors = tempCells.getNeighbor();
	}
	
	// 计算每一个单元格邻近活细胞数
	public void calcNeighbors() {
		int row, col;
		// 在最外层内部的所有单元格
		for(row = 1; row <= SIZE-1; row++) {
			for(col = 1; col <= SIZE-1; col++) {
				if(status[row-1][col-1] == true) neighbors[row][col]++;
				if(status[row-1][col] == true) neighbors[row][col]++;
				if(status[row-1][col+1] == true) neighbors[row][col]++;
				if(status[row][col-1] == true) neighbors[row][col]++;
				if(status[row][col+1] == true) neighbors[row][col]++;
				if(status[row+1][col-1] == true) neighbors[row][col]++;
				if(status[row+1][col] == true) neighbors[row][col]++;
				if(status[row+1][col+1] == true) neighbors[row][col]++;
			}
		}
		// 在首行和最后一行非角落处的单元格
		for(col = 1; col <= SIZE-1; col++) {
			row = 0; // 首行
			if(status[row][col-1] == true) neighbors[row][col]++;
			if(status[row][col+1] == true) neighbors[row][col]++;
			if(status[row+1][col-1] == true) neighbors[row][col]++;
			if(status[row+1][col] == true) neighbors[row][col]++;
			if(status[row+1][col+1] == true) neighbors[row][col]++;
			row = SIZE; // 最后一行
			if(status[row-1][col-1] == true) neighbors[row][col]++;
			if(status[row-1][col] == true) neighbors[row][col]++;
			if(status[row-1][col+1] == true) neighbors[row][col]++;
			if(status[row][col-1] == true) neighbors[row][col]++;
			if(status[row][col+1] == true) neighbors[row][col]++;
		}
		// 在首列和最后一列非角落处的单元格
		for(row = 1; row <= SIZE-1; row++) {
			col = 0; // 首列
			if(status[row-1][col] == true) neighbors[row][col]++;
			if(status[row-1][col+1] == true) neighbors[row][col]++;
			if(status[row][col+1] == true) neighbors[row][col]++;
			if(status[row+1][col] == true) neighbors[row][col]++;
			if(status[row+1][col+1] == true) neighbors[row][col]++;
			col = SIZE; // 最后一列
			if(status[row-1][col-1] == true) neighbors[row][col]++;
			if(status[row-1][col] == true) neighbors[row][col]++;
			if(status[row][col-1] == true) neighbors[row][col]++;
			if(status[row+1][col-1] == true) neighbors[row][col]++;
			if(status[row+1][col] == true) neighbors[row][col]++;
		}
		// 左上角
		row = 0;
		col = 0;
		if(status[row][col+1] == true) neighbors[row][col]++;
		if(status[row+1][col] == true) neighbors[row][col]++;
		if(status[row+1][col+1] == true) neighbors[row][col]++;
		// 右上角
		row = 0;
		col = SIZE;
		if(status[row][col-1] == true) neighbors[row][col]++;
		if(status[row+1][col-1] == true) neighbors[row][col]++;
		if(status[row+1][col] == true) neighbors[row][col]++;
		// 左下角
		row = SIZE;
		col = 0;
		if(status[row-1][col] == true) neighbors[row][col]++;
		if(status[row-1][col+1] == true) neighbors[row][col]++;
		if(status[row][col+1] == true) neighbors[row][col]++;
		// 右下角
		row = SIZE;
		col = SIZE;
		if(status[row-1][col-1] == true) neighbors[row][col]++;
		if(status[row-1][col] == true) neighbors[row][col]++;
		if(status[row][col-1] == true) neighbors[row][col]++;
	}
	
	// 计算整体下一个状态
	public void nextStatus() {
		int row, col;
		for(row = 0; row <= SIZE; row++) {
			for(col = 0; col <= SIZE; col++) {
				if(neighbors[row][col] == 3) 
					status[row][col] = true; // 活
				else if(neighbors[row][col] != 2)
					status[row][col] = false; //死亡
				// else neighbors[row][col] == 2 不变
			}
		}
	}
	
	// 展示世界
	public void Display() {
		
	}
}
