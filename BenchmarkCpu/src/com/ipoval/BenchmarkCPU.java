package com.ipoval;

import java.io.*;

/**
  Quickly benchmark CPU ops count.
  @param
  @return
*/
final public class BenchmarkCPU {
    private static final int ONE_MIN = 60 * 1000;
    private static long OPS = 0L;

    public static void main(String[] args) {
        echoProcCpuInfo();

        long t1 = getMs();
        long t2 = t1 + ONE_MIN;

        while(true) {
            long now = getMs();
            executeCPUOp(now);
            if (now > t2) { break; }
            if (++OPS % 1E7 == 0) { System.out.print('.'); }
        }

        System.out.println();
        System.out.printf("%.3f(B) %s", OPS / 1E9, "ops per minute.\n");
    }

    private static long getMs() {
        return System.currentTimeMillis();
    }

    private static void executeCPUOp(long number) {
        Math.sqrt(number);
    }

    private static void echoProcCpuInfo() {
        try {
            String cmd = "sysctl -n machdep.cpu.brand_string";
            StringBuffer stdOut = new StringBuffer();
            String stdOutline = "";

            Process proc = Runtime.getRuntime().exec(cmd);
            proc.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((stdOutline = reader.readLine()) != null) {
                stdOut.append(stdOutline + "\n");
            }

            AsciiBorderedText asciiTextFrame = new AsciiBorderedText(stdOut.toString());
            System.out.print(asciiTextFrame.getBorderedText());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
