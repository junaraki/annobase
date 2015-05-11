package net.junaraki.annobase.pipeline;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.junaraki.annobase.AnnotationBase;
import net.junaraki.annobase.ann.Annotator;
import net.junaraki.annobase.io.Reader;
import net.junaraki.annobase.io.Writer;

public abstract class AbstractPipeline implements Pipeline {

  private Reader reader;

  private Writer writer;

  private List<Annotator> annotators;

  /**
   * Public constructor.
   */
  public AbstractPipeline() {
    annotators = new ArrayList<Annotator>();
  }

  /**
   * Public constructor.
   * 
   * @param reader
   * @param writer
   */
  public AbstractPipeline(Reader reader, Writer writer) {
    this.reader = reader;
    this.writer = writer;
    annotators = new ArrayList<Annotator>();
  }

  /**
   * Public constructor.
   * 
   * @param annotators
   */
  public AbstractPipeline(List<Annotator> annotators) {
    this.annotators = annotators;
  }

  /**
   * Public constructor.
   * 
   * @param reader
   * @param writer
   * @param annotators
   */
  public AbstractPipeline(Reader reader, Writer writer, List<Annotator> annotators) {
    this.reader = reader;
    this.writer = writer;
    this.annotators = annotators;
  }

  /**
   * Runs this pipeline against the given files.
   * 
   * @param inputFiles
   * @param outputFiles
   */
  public void run(List<File> inputFiles, List<File> outputFiles) {
    List<AnnotationBase> annBases = reader.read(inputFiles);
    for (AnnotationBase annBase : annBases) {
      for (Annotator annotator : annotators) {
        annotator.annotate(annBase);
      }
    }
    writer.write(annBases, outputFiles);
  }

  public Reader getReader() {
    return reader;
  }

  public void setReader(Reader reader) {
    this.reader = reader;
  }

  public Writer getWriter() {
    return writer;
  }

  public void setWriter(Writer writer) {
    this.writer = writer;
  }

  public List<Annotator> getAnnotators() {
    return annotators;
  }

  public void setAnnotators(List<Annotator> annotators) {
    this.annotators = annotators;
  }

  /**
   * Adds the given annotator to this pipeline.
   * 
   * @param annotator
   */
  @Override
  public void addAnnotator(Annotator annotator) {
    annotators.add(annotator);
  }

}
