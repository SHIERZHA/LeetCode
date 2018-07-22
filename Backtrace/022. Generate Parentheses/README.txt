/*
 * Backtrack V1
 **/
class Solution {
    
    public List<String> generateParenthesis(int n) {
        
        if(n == 0) return null; // corner case;
        
        List<String> ans = new ArrayList();
        backtrack(n, "", 0, 0, ans);
        return ans;
        
    }
    
    public void backtrack(int n, String temp, int open, int close, List<String> ans){
        
        if(open == n && close == n){
               ans.add(new String(temp));
        }
        else{
                if(open < n)
                backtrack(n, temp + "(", open + 1, close, ans);
                if(close < open)
                backtrack(n, temp + ")", open, close + 1, ans);   
        }
    }
    
}

/*
 * Backtrack V2 for loop, which is not very necessary
 **/

class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if(n == 0) return null;
        backtrack(n, "", 0, 0, ans);
        return ans;
        
    }
    
    public void backtrack(int n, String temp, int open, int close, List<String> ans){
        
        if(open == n && close == n){  // open and close should be n when the answer is right
           
               ans.add(new String(temp));
          
        }
        else{
            for(int i = 0; i < 2;i++){
                
                if(close > n) continue;
                if(open > n) continue;
                if(close > open) continue;
                
                temp = i == 0? temp + "(" : temp + ")";
                if(i == 0){
                    //backtrack(n, temp, open + 1, close, ans);    two different versions
                    open++;
                    backtrack(n, temp, open, close, ans);
                    open--;

                }else{
                    backtrack(n, temp, open, close + 1, ans);
                }
                
                
             
                
                temp = temp.substring(0, temp.length() - 1);
            }
            
        }
        
    }
    
    
    
}

/*
 *Brute Force:
 **/
class Solution {
    List<String> ans = new ArrayList();
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if(n == 0) return null;
        backtrack(n, "", 0, 0, ans);
        return ans;
        
    }
    
    public void backtrack(int n, String temp, int open, int close, List<String> ans){
        
        if(temp.length() == n * 2){
           if(isValid(temp)){
               ans.add(new String(temp));
           }
        }
        else{
            for(int i = 0; i < 2;i++){
                
                if(close > n) continue;
                if(open > n) continue;
                if(close > open) continue;
                
                
                temp = i == 0? temp + "(" : temp + ")";
                if(i == 0){
                    open++;
                }else{
                    close++;
                }
                backtrack(n, temp, open, close, ans);
                if(i == 0){
                    open--;
                }else{
                    close--;
                }
                
                temp = temp.substring(0, temp.length() - 1);
            }
        }
        
    }
    
    public boolean isValid(String s) {
        
        Stack st = new Stack();
            
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }
            
            else{
                if(st.empty()){
                    return false;
                }
                else if((char)st.peek() == ')'){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        } 
        
        return st.empty();
            
    }
    
    
}