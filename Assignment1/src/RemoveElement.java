
public class RemoveElement {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int val = 3;
        System.out.println(removeElement(array,val));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length; i++){
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}