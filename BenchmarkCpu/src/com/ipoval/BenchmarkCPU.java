package com.ipoval;

public class BenchmarkCPU {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime   = startTime + 60000;
        long idx       = 0;

        while(true) {
            double x = Math.sqrt(idx);
            long now = System.currentTimeMillis();
            if (now > endTime) { break; }
            if (idx % 1E6 == 0) {
                System.out.print('.');
            }
            idx++;
        }

        System.out.println();
        System.out.printf("%.3fB %s", idx / 1E9, "OPS in one minute.\n");
    }
}
