package nl.ttstudios.pi.sys_io;
/**
 * Sample code that finds files that match the specified glob pattern.
 * For more information on what constitutes a glob pattern, see
 * https://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob
 *
 * The file or directories that match the pattern are printed to
 * standard out.  The number of matches is also printed.
 *
 * When executing this application, you must put the glob pattern
 * in quotes, so the shell will not expand any wild cards:
 *              java Find . -name "*.java"
 */

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Find {

	public static class Finder extends SimpleFileVisitor<Path> {

		private final PathMatcher matcher;
		private int numMatches = 0;

		private List<String> fileNames = new ArrayList<>();

		Finder(String pattern) {
			matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
		}

		// Compares the glob pattern against
		// the file or directory name.
		List<String> find(Path file) {
			Path name = file.getFileName();
			if (name != null && matcher.matches(name)) {
				numMatches++;
				fileNames.add(file.toString());
				System.out.println(file);
			}
			return fileNames;
		}

		// Prints the total number of
		// matches to standard out.
		void done() {
			System.out.println("Matched: " + numMatches);
		}

		// Invoke the pattern matching
		// method on each file.
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			find(file);
			return CONTINUE;
		}

		// Invoke the pattern matching
		// method on each directory.
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
			find(dir);
			return CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) {
			System.err.println(exc);
			return CONTINUE;
		}

		public List<String> getFileNames() {
			return fileNames;
		}
	}

	static void usage() {
		System.err.println("java Find <path>" + " -name \"<glob_pattern>\"");
		System.exit(-1);
	}

	public static List<String> find(String baseDir, String pattern) throws IOException {
		Finder finder = new Finder(pattern);
		Path startingDir = Paths.get(baseDir);
		Files.walkFileTree(startingDir, finder);
		finder.done();
		return finder.getFileNames();
	}

	public static void main(String[] args) throws IOException {

		if (args.length < 3 || !args[1].equals("-name"))
			usage();

		Path startingDir = Paths.get(args[0]);
		String pattern = args[2];

		Finder finder = new Finder(pattern);
		Files.walkFileTree(startingDir, finder);
		finder.done();
	}
}