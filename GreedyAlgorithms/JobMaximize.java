

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;


public class JobMaximize{
    public static void main(String args[]){
        int job[][] = {{4,20},{1,10},{1,40},{1,30}};

        int jobs[][] = new int[job.length][3];
        for(int i = 0 ; i < jobs.length ; i++){
            jobs[i][0] = i;
            jobs[i][1]  = job[i][0];
            jobs[i][2]  = job[i][1];
        }

        
        Arrays.sort(jobs , Comparator.comparingDouble(o -> o[1]) );
        
               

        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < jobs.length ; i++){
            s.push(jobs[i][0]);
            if(i < jobs.length -2){

                while(jobs[i][1] == jobs[i+1][1] ){
                    if(jobs[i+1][2] > jobs[i][2]){
                        s.pop();
                        s.push(jobs[i+1][0]);
                    }
                    i++;
                }
            }
        }

        Stack<Integer> s2 = new Stack<>();
        while(!s.isEmpty()){
            s2.push(s.pop());
        }

          while(!s2.isEmpty()){
            System.out.print("JOB "+ (char)(s2.pop() + 'A') + " ");
        }

    }
}