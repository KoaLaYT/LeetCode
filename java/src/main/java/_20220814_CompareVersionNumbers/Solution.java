package _20220814_CompareVersionNumbers;

public class Solution {

  public int compareVersion(String version1, String version2) {
    String[] revisions1 = version1.split("\\.");
    String[] revisions2 = version2.split("\\.");

    int i = 0, j = 0;

    while (i < revisions1.length || j < revisions2.length) {
      if (i >= revisions1.length) {
        return notAllZeros(revisions2, j) ? -1 : 0;
      }

      if (j >= revisions2.length) {
        return notAllZeros(revisions1, i) ? 1 : 0;
      }

      int revision1 = Integer.parseInt(revisions1[i]);
      int revision2 = Integer.parseInt(revisions2[j]);
      if (revision1 > revision2) {
        return 1;
      }
      if (revision1 < revision2) {
        return -1;
      }

      i++;
      j++;
    }

    return 0;
  }

  private boolean notAllZeros(String[] revisions, int i) {
    while (i < revisions.length) {
      if (Integer.parseInt(revisions[i]) != 0) {
        return true;
      }
      i++;
    }
    return false;
  }

}
