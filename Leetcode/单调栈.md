### 单调栈题型

---

### 1、[接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

> 单调栈解法

```java
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int sum=0;
        for(int i=0;i<len;i++){
            while(!stack.isEmpty()&&height[stack.peek()]<=height[i]){
                int mid = stack.pop();
                if(!stack.isEmpty()){
                    int c = (Math.min(height[i],height[stack.peek()])-height[mid])*(i-stack.peek()-1);
                    sum+=c;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
```

> 动态规划解法

```java
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        left[0]=height[0];
        int[] right = new int[len];
        right[len-1]=height[len-1];
        //找左边比最高的柱子
        for(int i=1;i<len;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        //找最右边最高的柱子
        for(int j=len-2;j>=0;j--){
            right[j]=Math.max(right[j+1],height[j]);
        }
        int sum=0;
        //当前柱子能装的水
        for(int i=1;i<len-1;i++){
            int h=left[i]>right[i]?right[i]:left[i];
            sum+=h-height[i];
        }
        return sum;
    }
}
```

### 2、[下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)

>单调栈解法

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums2.length;i++){
            map.put(nums2[i],-1);
        }
        LinkedList<Integer> stack = new LinkedList<>();
       	//利用单调栈，记录每个数的下一个大的数，保存在map中
        for(int i =0;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[i]>stack.peek()){
                int j=stack.pop();
                map.put(j,nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}
```

### 3、[下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii/)

>单调栈
>
>本题相对“[下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)”只是需要循环去找下一个大的数，那就循环两次即可。

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int time =2;
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        LinkedList<Integer> stack = new LinkedList<>();
        while(time>0){
            for(int i=0;i<nums.length;i++){
                while(!stack.isEmpty()&&nums[i]>nums[stack.peek()]){
                    res[stack.peek()]=nums[i];
                    stack.pop();
                }
                stack.push(i);
            }
            time--;
        }
        return res;
    }
}
```

### 3、[每日温度](https://leetcode-cn.com/problems/daily-temperatures/)

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                res[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
```



