import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    //括号匹配
    public static  boolean matchP(String s){
        Stack<Character> stack  = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }else if(s.charAt(i)==']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
            }else if(s.charAt(i)=='}' && !stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
            }else{
                return  false;
            }
        }
        return stack.isEmpty();
    }
    //输出括号
    public static List<String> generateP(int num){
        List<String> res = new ArrayList<>();
        generateOneByOne("",res,num,num);
        return res;
    }
    public  static  void generateOneByOne(String temp, List<String> res, int left, int right){
        if(left>right){
            return;
        }
        if(left>0){
            generateOneByOne(temp+"(",res,left-1,right);
        }
        if(right>0){
            generateOneByOne(temp+")",res,left,right-1);
        }
        if(left==0 && right==0){
            res.add(temp);
        }
    }

    public  static  int tryTest(){
        int t = 0;
        try {
            return t;
        }finally {
            ++t;
            return  t;
        }
    }
    public static void main(String[] args) {
        boolean flag = false;
        if(flag == true){
            System.out.println(flag);
        }
        System.out.println("Hello World!");
        System.out.println(matchP("()()"));
        int res = tryTest();
        System.out.println(res);
        System.out.println(generateP(2));

    }
}
