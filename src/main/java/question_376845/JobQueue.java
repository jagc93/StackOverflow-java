package question_376845;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class JobQueue {

	private int numWorkers;
    private int[] jobs;
    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;
	
    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt(); 
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        assignedWorker = new int[jobs.length];
         startTime = new long[jobs.length];
         PriorityQueue<Integer> nextTimesQueue = new PriorityQueue<Integer>();
         HashMap<Integer, Set<Integer>> workersReadyAtTimeT = new HashMap<Integer,Set<Integer>>();
         long[] nextFreeTime = new long[numWorkers];
         int duration = 0;
         int bestWorker = 0;
         for (int i = 0; i < jobs.length; i++) {
          duration = jobs[i];
          if(i<numWorkers) {
            bestWorker = i;
            nextTimesQueue.add(duration);
            addToSet(workersReadyAtTimeT, duration, i,0);
          }else {
            int currentTime = nextTimesQueue.poll();
            Set<Integer> workersReady = workersReadyAtTimeT.get(currentTime);
            if (workersReady != null && workersReady.size()>1) { 
              bestWorker = workersReady.iterator().next();
              workersReady.remove(bestWorker);
              workersReadyAtTimeT.remove(currentTime);
              workersReadyAtTimeT.put(currentTime,workersReady);
              nextTimesQueue.add(currentTime);
            } else {
              bestWorker = workersReady.iterator().next();
              workersReadyAtTimeT.remove(currentTime);
              nextTimesQueue.add(currentTime+duration);
              addToSet(workersReadyAtTimeT, duration, bestWorker, currentTime);
            }
          }
          
          assignedWorker[i] = bestWorker;
          startTime[i] = nextFreeTime[bestWorker];
          nextFreeTime[bestWorker] += duration;
         }
        }
    
    private void addToSet(HashMap<Integer, Set<Integer>> workersReadyAtTimeT, int duration, int worker, int current) {
        if(workersReadyAtTimeT.get(current+duration)==null) {
          HashSet<Integer> s = new HashSet<Integer>();
          s.add(worker);
          workersReadyAtTimeT.put(current+duration, s);
        }else {
          Set<Integer> s = workersReadyAtTimeT.get(current+duration);
          s.add(worker);
          workersReadyAtTimeT.put(current+duration,s);
         }
        }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
