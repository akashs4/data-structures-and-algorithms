package dsalgo.learning.coursera.algorithms.part1.module2.practice;

import dsalgo.learning.coursera.algorithms.part1.module2.uf.implementations.QUFPathCompression;
import edu.princeton.cs.algs4.StdStats;

import java.util.Random;

public class UFPerformanceTestClient {
    public static void main(String[] args) {
        int n = 10000000;
        int trials = 1;
        double[] trialTimes = new double[trials];
        double[] connectedComponents = new double[trials];
        int[] maxHeights = new int[trials];
        long numOfUnionCommands = 100000000;
        Random random = new Random();

        for (int j = 0; j < trials; j++) {
            int i = 0;
            QUFPathCompression uf = new QUFPathCompression(n);
            long startTime = System.currentTimeMillis();
            while (i < numOfUnionCommands && uf.count() > 1) {
                int p = random.nextInt(n);
                int q = random.nextInt(n);
                if (uf.find(p) == uf.find(q)) {
                    i++;
                    continue;
                }

                uf.union(p, q);
                i++;
            }
            long endTime = System.currentTimeMillis();
            trialTimes[j] = (endTime - startTime);
            connectedComponents[j] = uf.count();
            maxHeights[j] = uf.getMaxHeight();
        }

        System.out.println("Max Heights");
        for (int j = 0; j < maxHeights.length; j++)
            System.out.print(maxHeights[j] + ", ");
        System.out.println();

        System.out.println("trial times");
        for (int j = 0; j < trialTimes.length; j++)
            System.out.print(trialTimes[j] + ", ");
        System.out.println();

        System.out.println("number of connected components in each trial");
        for (int j = 0; j < connectedComponents.length; j++)
            System.out.print(connectedComponents[j] + ", ");

        System.out.println();
        System.out.println("Average connected components : " + StdStats.mean(connectedComponents));
        System.out.println("Average trial times : " + StdStats.mean(trialTimes));
    }
}
