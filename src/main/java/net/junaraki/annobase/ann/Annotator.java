package net.junaraki.annobase.ann;

import net.junaraki.annobase.AnnotationBase;

public interface Annotator {

  /**
   * Carries out annotation against the given annotation base instance.
   * 
   * @param annBase
   */
  public void annotate(AnnotationBase annBase);

}
