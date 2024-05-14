package programmers;

import java.util.*;

class Edge {
    int next, cnt;
    
    Edge(int next, int cnt){
        this.next = next;
        this.cnt = cnt;
    }
}

class P43163 {
    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        
        int size = words.length;
        ArrayList<Integer>[] nodeList = new ArrayList[size];
        for(int i = 0; i < size; i++)
            nodeList[i] = new ArrayList<>();
        
        boolean[] visited = new boolean[size];
        Queue<Edge> queue = new ArrayDeque<>();
        
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++){
                if(checkLink(words[i], words[j])) {
                    nodeList[i].add(j);
                    nodeList[j].add(i);
                }
                   
            }
                   
            if(checkLink(begin, words[i])) {
                queue.add(new Edge(i, 1));
                visited[i] = true;
            }
            
            if(!flag && target.equals(words[i]))
                flag = true;
        }
        
        if(!flag)
            return 0;
        
        while(!queue.isEmpty()) {
            Edge temp = queue.poll();
            
            if(words[temp.next].equals(target))
                    return temp.cnt;
                
            for(int next : nodeList[temp.next]){
                
                if(!visited[next]){
                    queue.add(new Edge(next, temp.cnt + 1));
                    visited[next] = true;
                }
            }
        }
        
        return 0;
    }
    
    boolean checkLink(String a, String b) {
        int cnt = 0;
        
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                cnt++;
            
            if(cnt > 1)
                return false;
        }
        
        return true; 
    }
}
