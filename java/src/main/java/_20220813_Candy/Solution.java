package _20220813_Candy;

public class Solution {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int pre = 1; // previous child's candy
    int inc = 1; // inc length
    int dec = 0; // dec length
    int count = 1; // total candy

    for (int i = 1; i < n; i++) {
      if (ratings[i] >= ratings[i - 1]) {
        pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
        count += pre;
        dec = 0;
        inc = pre;
      } else {
        dec += 1;
        if (inc == dec) {
          dec += 1;
        }
        count += dec;
        pre = 1;
      }
    }

    return count;
  }

}
