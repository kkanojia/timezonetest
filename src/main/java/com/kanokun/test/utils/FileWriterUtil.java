package com.kanokun.test.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Appends to file the content
 * @author Kunal
 *
 */
public class FileWriterUtil {

	public static void writetoFIle(String content, File file) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath(), true)))) {
		    out.println(content);
		}catch (IOException e) {
		   System.out.println(e.getLocalizedMessage());
		}

	}
}
