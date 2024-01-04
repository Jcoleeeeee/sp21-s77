package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        System.out.println("Timing table for getLast");
        AList<Integer> Ns = new AList<>();
        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);
        AList<Integer> ops = new AList<>();
        ops.addLast(10000);
        ops.addLast(10000);
        ops.addLast(10000);
        ops.addLast(10000);
        ops.addLast(10000);
        ops.addLast(10000);
        ops.addLast(10000);
        ops.addLast(10000);
        AList<Double> Times = new AList<>();
        for (int i = 0; i < 8; i++) {
            SLList<Integer> List = new SLList<>();
            for (int j = 0; j < Ns.get(i); j++) {
                List.addLast(j);
            }
            int M = 10000;
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < M; j++) {
                List.getLast();
            }
            double timeInSecongds = sw.elapsedTime();
            Times.addLast(timeInSecongds);

        }
        printTimingTable(Ns,Times,ops);
    }

}
