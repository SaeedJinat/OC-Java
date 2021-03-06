package com.oc.programmer.objectives.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A symbolic link can point to a real directory, and by default isDirectory() follows links.
 * In this case, the symbolic link, not the directory, would be deleted.
 *
 * In the case of a directory with content, it would allow the code to reach the execution block of the if/then statement,
 * but the method deleteIfExists() would throw a DirectoryNotEmptyException.
 */
public class PathsOperations {

  public static void main(String[] args) {
    Path dirPath = Paths.get("c:\\temp\\");

    System.out.println("Symbolic Link: " + Files.isSymbolicLink(dirPath));

    // If the path value refers to a regular file, isDirectory() will return false and the statement will be skipped, so A is incorrect.
    if (Files.isDirectory(dirPath)) {

      try {
        /**
         * Will print success only given:
         * - path refers to a symbolic link in the file system.
         * - path refers to an empty directory in the file system.
         */
        System.out.println(Files.deleteIfExists(dirPath) ? "Successfully Deleted" : "Failed Delete, Try Again");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

}
