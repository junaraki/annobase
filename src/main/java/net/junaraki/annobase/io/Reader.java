package net.junaraki.annobase.io;

import java.io.File;
import java.util.List;

import net.junaraki.annobase.AnnotationBase;

public interface Reader {

  /**
   * Reads the given file, and returns an annotation base instance.
   * 
   * @param file
   * @return
   */
  public AnnotationBase read(File file);

  /**
   * Reads a list of the given files, and returns a list of annotation base instances.
   * 
   * @param files
   * @return
   */
  public List<AnnotationBase> read(List<File> files);

}
