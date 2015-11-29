package lop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Huang
 *
 */
public class FileOperator {
	/**
	 * read string from file
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> readFile(String path) {
		List<String> lines = new ArrayList<String>();
		File file = new File(path);
		try {
			Reader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			while (line != null) {
				lines.add(line);
				line = br.readLine();
			}
			reader.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	/**
	 * write text to file
	 * 
	 * @param path
	 * @param text
	 */
	public static void writeToFile(String path, String text) {
		File file = new File(path);
		try {
			Writer writer = new PrintWriter(file);
			writer.write(text);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
