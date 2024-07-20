package dsalgo.learning.coursera.algorithms.part1.week1.practice;

import dsalgo.learning.coursera.algorithms.part1.week1.uf.implementations.WeightedQuickUnionFindPathCompression;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

import java.util.Random;
import java.util.Scanner;

public class TestErdosRenyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int trials = sc.nextInt();
        int[] edges = new int[trials];

        for (int i = 0; i < trials; i++)
            edges[i] = count(n);

//        System.out.println("connections for each trial");
//        for (int i = 0; i < trials; i++) {
//            System.out.println("For trial " + (i + 1) + ": " + edges[i]);
//        }
//        System.out.println("total connections: " + count(n));


        StdOut.println("1/2 n ln n = " + 0.5 * n * Math.log(n));
        StdOut.println("mean       = " + StdStats.mean(edges));
        StdOut.println("stddev     = " + StdStats.stddev(edges));
    }

    private static int count(int n) {
        Random random = new Random();
        int p, q, connections = 0;
        WeightedQuickUnionFindPathCompression unionFind = new WeightedQuickUnionFindPathCompression(n);
        while (unionFind.count() != 1) {
            p = random.nextInt(n);
            q = random.nextInt(n);

            if (!unionFind.connected(p, q)) {
                unionFind.union(p, q);
//                System.out.println("Connected " + p + " and " + q);
            }
            connections++;
        }
//        System.out.println();
        return connections;
    }
}
