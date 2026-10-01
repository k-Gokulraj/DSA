class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;

        int bucket1 = -1;
        int bucket2 = -1;

        int max = 0;

        while (right < fruits.length) {

            int current = fruits[right];

            if (current == bucket1 || current == bucket2) {
                right++;
            }

            else if (bucket1 == -1) {
                bucket1 = current;
                right++;
            }

            else if (bucket2 == -1) {
                bucket2 = current;
                right++;
            }

            else {

                while (left < right) {

                    if (fruits[left] == bucket1) {

                        int temp = fruits[left];
                        left++;

                        boolean stillExists = false;

                        for (int i = left; i < right; i++) {
                            if (fruits[i] == temp) {
                                stillExists = true;
                                break;
                            }
                        }

                        if (!stillExists) {
                            bucket1 = -1;
                            break;
                        }
                    }

                    else {

                        int temp = fruits[left];
                        left++;

                        boolean stillExists = false;

                        for (int i = left; i < right; i++) {
                            if (fruits[i] == temp) {
                                stillExists = true;
                                break;
                            }
                        }

                        if (!stillExists) {
                            bucket2 = -1;
                            break;
                        }
                    }
                }

                if (bucket1 == -1) {
                    bucket1 = current;
                } else {
                    bucket2 = current;
                }

                right++;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }
}