import java.util.PriorityQueue;

public class Solution {


    public static double MinimiseMaxDistance(int []arr, int K){
        // Solution using Priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.first, a.first));
        
        int n = arr.length;

        for(int i=0;i<n-1;i++){
            pq.offer(new Pair((double)(arr[i+1]-arr[i]), i));
        }

        int[] howMany = new int[n-1];

        for(int i=0;i<K;i++){
            Pair top = pq.poll();
            howMany[top.second]++;
            double diff = (double)(arr[top.second+1]-arr[top.second]);
            double newSection = diff/(double)(howMany[top.second]+1);
            pq.offer(new Pair(newSection, top.second));
        }

        return pq.poll().first;
    }
}


    class Pair{
        double first;
        int second;

        public Pair(double first,int second){
            this.first = first;
            this.second = second;
        }
    }

//     public static double MinimiseMaxDistance1(int []arr, int K){
//         int n = arr.length;

//         int[] howMany = new int[n-1];

        

//         for(int i=0;i<K;i++){
//             double maxSection = -1;
//             int maxIndex = -1;
//             for(int j=0;j<n-1;j++){
//                 double diff = arr[j+1] - arr[j];
//                 double sectionLength = diff/(double)(howMany[j]+1);
//                 if(sectionLength > maxSection){
//                     maxSection = sectionLength;
//                     maxIndex = j;
//                 }
//             }
//             howMany[maxIndex]++;
//         }

//         double ans = -1;
//         for(int i=0;i<n-1;i++){
//             double diff = arr[i+1] - arr[i];
//             double sectionLength = diff/(double)(howMany[i]+1);
//             ans = Math.max(ans,sectionLength);
//         }

//         return ans;


//     }
// }