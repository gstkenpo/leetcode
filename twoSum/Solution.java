package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {

    public static void main(final String args[]) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        Person p = new Person();
        int[] result=p.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }

    public int[] twoSum(int[] nums, int target){
        if (nums==null || nums.length <= 0) return null;
        List<Integer> sortedNumList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        sortedNumList = sortedNumList.stream().sorted().collect(Collectors.toList());
        Integer a = null, b = null, ia = null, ib = null;
        for (Integer num : sortedNumList){
            //if (num > target) return null; //no solution
            Integer reminder = target - num;
            b = sortedNumList.stream().filter(tempNum -> tempNum.equals(reminder)).findFirst().orElse(null);
            if (b != null){
                a = num;
                break;
            }
        }

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        
        if (a != null && b != null) {
            //find index
            for (int i = 0; i < nums.length; i++){
                if (a == nums[i] && ia == null) ia = i;
                else if (b == nums[i] && ib == null ) ib = i;
            }
            if (ia != null && ib != null){
                int result[] = {ia.intValue(), ib.intValue()};
                Arrays.sort(result);
                return result;
            }
        } else return null;//no solution
        return null;
    }
}