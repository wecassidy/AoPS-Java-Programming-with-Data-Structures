
public class Week6Problem6 {

	public static boolean isNonDecreasing(int[] nums) {
		for (int i = 1; i < nums.length; i ++) {
			if (nums[i] < nums[i-1]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		int[] thing = {1, 2, 3, 4, 5};
		int[] anotherThing = {1, 1, 2, 3};
		int[] yetAnotherThing = {1, 0, 3, 2};
		
		System.out.println(isNonDecreasing(thing));
		System.out.println(isNonDecreasing(anotherThing));
		System.out.println(isNonDecreasing(yetAnotherThing));

	}

}
