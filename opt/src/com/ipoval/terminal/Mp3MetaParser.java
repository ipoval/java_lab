/**
 * How to run: package='com/ipoval/terminal';
 *             javac $package/Mp3MetaParser.java
 *             java $package/Mp3MetaParser $package/test.mp3
 */

package com.ipoval.terminal;

import java.io.*;

/**
 * Extract meta info from *.mp3 file
 * ID3 section of *.mp3 contains:
 *   - title info
 *   - album info
 *   - artist info
 */
public abstract class Mp3MetaParser {
    static final short META_BYTES = 128;
    static byte[] META_BYTES_SLICE = new byte[META_BYTES];

    public static void main(String[] args) {
        try {
            File song = new File(args[0]);
            FileInputStream file = new FileInputStream(song);

            int fileSize = (int)song.length();

            file.skip(fileSize - META_BYTES);
            file.read(META_BYTES_SLICE);

            String id3String = new String(META_BYTES_SLICE);
            String tag = id3String.substring(0, 3);

            if (!tag.equals("TAG")) {
                System.err.println(args[0] + " does not contain ID3 information.");
                return;
            }

            System.out.println("FileSize: " + fileSize);
            System.out.println("Title: "    + id3String.substring(3, 32));
            System.out.println("Artist: "   + id3String.substring(33, 62));
            System.out.println("Album: "    + id3String.substring(63, 91));
            System.out.println("Year: "     + id3String.substring(93, 97));

            file.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
        }
    }
}
