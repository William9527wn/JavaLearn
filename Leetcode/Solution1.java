import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return string字符串
     */
    public static String compress (String str) {
        if(!str.contains("[")){
            return str;
        }
        StringBuilder sb=new StringBuilder(str);
        int len=str.length();
        char[] ch=str.toCharArray();
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<len;i++){
            if(ch[i]=='['){
                stack.push(i);
            }else if(ch[i]==']'){
                int l=stack.pop();
                int r=i;
                String s=str.substring(l+1,r);
                String res=helper(s);
                sb.delete(l,r+1);
                sb.insert(l,res);
                break;
            }
        }
        return compress(sb.toString());
    }

    //拆分括号中的
    public static String helper(String str){
        StringBuilder sb=new StringBuilder();
        String[] d=str.split("\\|");
        int num=Integer.parseInt(d[0]);
        String s=d[1];
        for(int i=0;i<num;i++){
            sb.append(s);
        }
        return sb.toString();
    }
}