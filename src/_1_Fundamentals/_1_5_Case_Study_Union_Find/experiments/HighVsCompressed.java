package _1_Fundamentals._1_5_Case_Study_Union_Find.experiments;

import _1_Fundamentals._1_4_Analysis_of_Algorithms.Stopwatch;
import _1_Fundamentals._1_5_Case_Study_Union_Find.creative.WeightedQuickUnionByHeight;
import _1_Fundamentals._1_5_Case_Study_Union_Find.creative.WeightedQuickUnionWithPathCompression;
import common.In;

public class HighVsCompressed {

    public static void main(String[] args) {
        In in2 = new In("largeUF.txt");
        int n2 = in2.readInt();
        Stopwatch stopwatch2 = new Stopwatch();
        WeightedQuickUnionWithPathCompression compression = new WeightedQuickUnionWithPathCompression(n2);
        while (!in2.isEmpty()) {
            int p = in2.readInt();
            int q = in2.readInt();
            compression.union(p, q);
        }
        double t2 = stopwatch2.elapsedTime();
        System.out.println("compression time = " + t2);
        System.out.println("compression count = " + compression.count());


        In in1 = new In("largeUF.txt");
        int n1 = in1.readInt();
        Stopwatch stopwatch1 = new Stopwatch();
        WeightedQuickUnionByHeight height = new WeightedQuickUnionByHeight(n1);
        while (!in1.isEmpty()) {
            int p = in1.readInt();
            int q = in1.readInt();
            height.union(p, q);
        }
        double t1 = stopwatch1.elapsedTime();
        System.out.println("height time = " + t1);
        System.out.println("height count = " + height.count());
    }

}
