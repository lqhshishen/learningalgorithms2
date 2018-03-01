package com.liqihao.math;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int [] arr = new int []{1,3,5,6};
        String a = "";
        String aa = "";
//        isPalindrome(-2147483648);
//        strStr(a,aa);
        Log.e("testStr", String.valueOf(searchInsert(arr,5)));
//        Log.e("test", String.valueOf(isPalindrome(-2147483648)));


//        quickSort(arr,0,arr.length - 1);
////        heapSort(arr);
//        Log.e("size", String.valueOf(arr.length));
//        int num = arr.length >> 1;
//        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
//        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
//        Log.e("split two array:",Arrays.toString(leftArr) + "and" + Arrays.toString(rightArr) + "andNum" + num);
    }

    public void quickSort(int [] arr ,int low ,int high) {
        if (arr.length <= 0) return;
        if (low >= high) return;

        int left = low;
        int right = high;

        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right --;
                Log.e("right", String.valueOf(right));
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
                Log.e("left", String.valueOf(left));
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        Log.e("arr",Arrays.toString(arr));
        quickSort(arr,low,left - 1);
        quickSort(arr,left + 1, high);
    }

    public static void heapSort(int[] arr){
        for(int i = arr.length; i > 0; i--){

            max_heapify(arr, i);

            int temp = arr[0];      //堆顶元素(第一个元素)与Kn交换
            arr[0] = arr[i-1];
            arr[i-1] = temp;
            Log.e("after",Arrays.toString(arr));
        }
    }

    private static void max_heapify(int[] arr, int limit){
        if(arr.length <= 0 || arr.length < limit) return;
        int parentIdx = limit / 2;

        for(; parentIdx >= 0; parentIdx--){
            if(parentIdx * 2 >= limit){
                continue;
            }
            int left = parentIdx * 2;       //左子节点位置
            int right = (left + 1) >= limit ? left : (left + 1);    //右子节点位置，如果没有右节点，默认为左节点位置

            int maxChildId = arr[left] >= arr[right] ? left : right;
            if(arr[maxChildId] > arr[parentIdx]){   //交换父节点与左右子节点中的最大值
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[maxChildId];
                arr[maxChildId] = temp;
            }
        }
//        System.out.println("Max_Heapify: " + Arrays.toString(arr));
        Log.e("Max_Heapify",Arrays.toString(arr));
    }

//    public int removeDuplicates(int[] nums) {
//        List<Integer> a = new ArrayList<>();
//        int [] x = new int[nums.length - 1];
//        for (int i = 0; i < nums.length; i++) {
//            boolean b = true;
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] == nums[j])
//                    b = false;
//            }
//            if(b){
//                a.add(i);
//            }
//        }
//        for (int i = 0; i < a.size(); i++) {
//            Log.e("test1",a.get(i).toString());
//        }
//        for (int i = 0; i < nums.length; i++) {
//            Log.e("test2", String.valueOf(nums[i]));
//        }
//        return a.size();
//    }

    public int[] twoSum(int[] nums, int target) {
        int result[];
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    temp.add(i);
                    temp.add(j);
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (Objects.equals(temp.get(i), temp.get(j)))
                    temp.remove(j);
            }
        }
        result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    ///Reverse Integer
    public int reverse(int x) {
        boolean zhengOrFu = false;
        int result = 0;
        if (x < 0) {
            zhengOrFu = true;
            x *= -1;
        }
        while (x != 0 ) {
            int newResult = result;
            result = (x % 10) + (result * 10);
            Log.e("testResult", String.valueOf(result));
            if (result / 10 != newResult )
                return 0;
            x /= 10;
            Log.e("testX", String.valueOf(x));
        }
        if (zhengOrFu)
            result *= -1;
        return result;
    }

    //Palindrome Number
    public boolean isPalindrome(int x) {
        int tempX = x;
        List<Integer>number = new ArrayList<>();
        if (x < 0) {
            return false;
        }
        while (tempX != 0){
            number.add(tempX % 10);
            tempX /= 10;
        }
        int i = 0,j = number.size() -1;
        while (i < j) {
            if (!Objects.equals(number.get(i), number.get(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    //Roman to Integer
//    public int romanToInt(String s) {
//        int result = 0;
//        if (s.contains("M"))
//        return result;
//    }
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0)
//            return "";
//        for (int i = 0; i < strs.length; i++) {
//            char a = strs[i].charAt()
//        }
//    }
    //Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 1 || s.isEmpty())
            return false;
        for (char temp : s.toCharArray()) {
            if (temp == '(')
                stack.push(')');
            else if (temp == '{')
                stack.push('}');
            else if ((temp == '['))
                stack.push(']');
            else if (temp != stack.pop() || stack.isEmpty())
                return false;
        }
        return true;
    }
    //Merge Two Sorted Lists
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//    }

//    public int removeDuplicates(int[] nums) {
//        int temp = 0;
//        for (int i = 0; i < nums.length; i++) {
//            boolean b = true;
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] == nums[j])
//                    b = false;
//            }
//            if(b ){
//            }
//        }
//        return list.length;
//    }
    //Remove Element
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

    //Implement strStr()
    public int strStr(String haystack, String needle) {
        boolean x = false;
        if (needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    x = false;
                    break;
                } else x = true;
            }
            if (x) return i;
        }
        return -1;
    }

    //Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        if (target > nums[nums.length - 1]) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) return i;
        }
        return result;
    }
    //Maximum Subarray
    public int maxSubArray(int[] nums) {
        int max = nums[0],temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int n = i;n < j;n ++) {
                    temp += nums[n];
                }
                if (temp > max) max = temp;
            }
        }
        return max;
    }
}
