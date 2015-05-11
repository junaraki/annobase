package net.junaraki.annobase.pipeline;

import net.junaraki.annobase.ann.Annotator;

public interface Pipeline {

  /**
   * Adds the given annotator to this pipeline.
   * 
   * @param annotator
   */
  public void addAnnotator(Annotator annotator);

}
