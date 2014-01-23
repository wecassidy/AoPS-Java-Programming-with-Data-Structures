
public class Week11Problem4 {
	public static void towersOfHanoi(int numDisks) {
		int[] disks = new int[numDisks];
		
		for (int i = 0; i < numDisks; i ++) {
			disks[i] = i;
		}
		
		int[][] pegs = new int[3][numDisks];
		
		pegs[0] = disks;
		for (int i = 1; i < 3; i ++) {
			for (int j = 0; j < numDisks; j ++) {
				pegs[i][j] = -1;
			}
		}
	}
	
	public static void move(int[][] pegs, int disk, String moveTo) {
		
	}
	
	public static void moveStack(int[][] pegs, int[] disks, String moveTo) {
		for (int disk : disks) {
			move(pegs, disk, moveTo);
		}
	}
}