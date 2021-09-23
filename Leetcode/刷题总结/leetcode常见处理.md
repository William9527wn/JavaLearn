leetcode常见处理
-------------
一、对字符串进行处理
1、字符串和字符数组之间的转换
- 将字符串转换为字符数组
```java
class Solution{
    public static void main(String[] args) {
        String str = "str";
        char[] chars = str.toCharArray();
    }
}
```
- 将字符数组转换为字符串
```java
class Solution{
    public static void main(String[] args) {
        char[] chars = {'a','b','c'};
        String str = new String(chars);
    }
}
```
2、字符与整型变量的转换
```java
class Sulution{
    public static void main(String[] args) {
        char ch = '1';
        //将字符转换为整型
        int num = ch-'0';
        //将整型变量转换为字符
        char ch1 = num + '0';
    }
}
```
3、list与数组之间的转换
- 将list转换为数组

```java
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        
        String s = new String[list.size()];
        list.toArray(s);
    }
}
```
- 将数组转换为list

```java
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String[] s = {"a", "b", "c"};
        List list = Arrays.asList(s);
    }
}
```
