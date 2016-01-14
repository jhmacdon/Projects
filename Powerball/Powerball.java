class Powerball{
  int[] pick;
  private int count;
  private String name;
  public Powerball(String n){
    pick = new int[6];
    count = 0;
    name = n;
  }
  
  public void add(int val){
    pick[count++] =  val;
  }
  
  public int check(int[] nums){
    if(nums.length != 6){
      System.out.println("Something seems wrong, there were not 6 numbers in that pick");
      return -1;
    }
    pick = sortFive(pick);
    nums = sortFive(nums);
    int match = 0;
    for(int i = 0; i < 5; i++) if(in(pick[i], nums)) match++;
    if(pick[5] == nums[5]){
      if(match == 5) return 1500000000;
      if(match == 4) return 50000;
      if(match == 3) return 100;
      if(match == 2) return 7;
      return 4; 
    } else {
      if(match == 5) return 1000000;
      if(match == 4) return 100;
      if(match == 3) return 7;
      return 0;
    }
    
  }
  
  
  public int[] sortFive(int[] nums){
    //int index = 0;
    for(int i = 0; i < 5; i++){
      int min = findMin(i, nums);
      nums = swap(i, min, nums);
    }
    return nums;
  }
  
  public int findMin(int start, int[] nums){
    int min = start;
    for(int i = start; i < 5; i++){
      if(nums[i] < nums[min]) min = i;
    }
    return min;
  }
  
  public int[] swap(int a, int b, int[] nums){
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
    return nums;
  }
  
  public void print(int [] nums){
    for(int i = 0; i < nums.length - 1; i++) System.out.print(nums[i] + "\t");
    System.out.print("\t"+nums[5]+"\n");
  }
  
  public boolean in(int n, int[] nums){
    for(int i = 0; i < nums.length; i++){
      if(n == nums[i]) return true;
    }
    return false;
  }
  
  public String name(){
    return name;
  }
}