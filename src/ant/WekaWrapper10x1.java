//=== Run information ===
//
//Scheme:weka.classifiers.trees.J48 -C 0.25 -M 2
//Relation:     ant
//Instances:    200
//Attributes:   9
//              0
//              1
//              2
//              3
//              4
//              5
//              6
//              7
//              class
//Test mode:evaluate on training data
//
//=== Classifier model (full training set) ===
//
//J48 pruned tree
//------------------
//
//6 <= 0
//|   1 <= -1
//|   |   4 <= 0
//|   |   |   5 <= 0
//|   |   |   |   0 <= -1: S (16.0/5.0)
//|   |   |   |   0 > -1
//|   |   |   |   |   2 <= -1: A (7.0/1.0)
//|   |   |   |   |   2 > -1: S (12.0/4.0)
//|   |   |   5 > 0: A (6.0/2.0)
//|   |   4 > 0: D (4.0)
//|   1 > -1
//|   |   1 <= 0
//|   |   |   3 <= -1: D (52.0/23.0)
//|   |   |   3 > -1
//|   |   |   |   4 <= 0
//|   |   |   |   |   3 <= 0
//|   |   |   |   |   |   6 <= -1: W (36.0/14.0)
//|   |   |   |   |   |   6 > -1: A (25.0/11.0)
//|   |   |   |   |   3 > 0: A (6.0)
//|   |   |   |   4 > 0: D (6.0)
//|   |   1 > 0: W (14.0)
//6 > 0: S (16.0)
//
//Number of Leaves  : 	12
//
//Size of the tree : 	23
//
//
//Time taken to build model: 0 seconds
//
//=== Evaluation on training set ===
//=== Summary ===
//
//Correctly Classified Instances         140               70      %
//Incorrectly Classified Instances        60               30      %
//Kappa statistic                          0.5973
//Mean absolute error                      0.2049
//Root mean squared error                  0.3201
//Relative absolute error                 55.1879 %
//Root relative squared error             74.296  %
//Total Number of Instances              200     
//
//=== Detailed Accuracy By Class ===
//
//               TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class
//                 0.632     0.098      0.72      0.632     0.673      0.881    W
//                 0.811     0.086      0.682     0.811     0.741      0.941    A
//                 0.745     0.059      0.795     0.745     0.769      0.925    S
//                 0.661     0.163      0.629     0.661     0.645      0.84     D
//Weighted Avg.    0.7       0.106      0.704     0.7       0.7        0.891
//
//=== Confusion Matrix ===
//
//  a  b  c  d   <-- classified as
// 36  5  0 16 |  a = W
//  6 30  1  0 |  b = A
//  0  5 35  7 |  c = S
//  8  4  8 39 |  d = D
//
//=== Source code ===

// Generated with Weka 3.6.11
//
// This code is public domain and comes with no warranty.
//
// Timestamp: Sat Sep 20 20:19:50 CEST 2014

package ant;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

public class WekaWrapper10x1
  extends Classifier {

  /**
   * Returns only the toString() method.
   *
   * @return a string describing the classifier
   */
  public String globalInfo() {
    return toString();
  }

  /**
   * Returns the capabilities of this classifier.
   *
   * @return the capabilities
   */
  public Capabilities getCapabilities() {
    weka.core.Capabilities result = new weka.core.Capabilities(this);

    result.enable(weka.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.NUMERIC_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.DATE_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.MISSING_VALUES);
    result.enable(weka.core.Capabilities.Capability.NOMINAL_CLASS);
    result.enable(weka.core.Capabilities.Capability.MISSING_CLASS_VALUES);

    result.setMinimumNumberInstances(0);

    return result;
  }

  /**
   * only checks the data against its capabilities.
   *
   * @param i the training data
   */
  public void buildClassifier(Instances i) throws Exception {
    // can classifier handle the data?
    getCapabilities().testWithFail(i);
  }

  /**
   * Classifies the given instance.
   *
   * @param i the instance to classify
   * @return the classification result
   */
  public double classifyInstance(Instance i) throws Exception {
    Object[] s = new Object[i.numAttributes()];
    
    for (int j = 0; j < s.length; j++) {
      if (!i.isMissing(j)) {
        if (i.attribute(j).isNominal())
          s[j] = new String(i.stringValue(j));
        else if (i.attribute(j).isNumeric())
          s[j] = new Double(i.value(j));
      }
    }
    
    // set class value to missing
    s[i.classIndex()] = null;
    
    return WekaClassifier10x1.classify(s);
  }

  /**
   * Returns the revision string.
   * 
   * @return        the revision
   */
  public String getRevision() {
    return RevisionUtils.extract("1.0");
  }

  /**
   * Returns only the classnames and what classifier it is based on.
   *
   * @return a short description
   */
  public String toString() {
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.6.11).\n" + this.getClass().getName() + "/WekaClassifier10x1";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  public static void main(String args[]) {
    runClassifier(new WekaWrapper10x1(), args);
  }
}

class WekaClassifier10x1 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = WekaClassifier10x1.N5f532378172(i);
    return p;
  }
  static double N5f532378172(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() <= 0.0) {
    p = WekaClassifier10x1.N1564672f173(i);
    } else if (((Double) i[6]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N1564672f173(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 2;
    } else if (((Double) i[1]).doubleValue() <= -1.0) {
    p = WekaClassifier10x1.N634bfd9f174(i);
    } else if (((Double) i[1]).doubleValue() > -1.0) {
    p = WekaClassifier10x1.N238de8d1178(i);
    } 
    return p;
  }
  static double N634bfd9f174(Object []i) {
    double p = Double.NaN;
    if (i[4] == null) {
      p = 2;
    } else if (((Double) i[4]).doubleValue() <= 0.0) {
    p = WekaClassifier10x1.N6ff3b8d3175(i);
    } else if (((Double) i[4]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N6ff3b8d3175(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 2;
    } else if (((Double) i[5]).doubleValue() <= 0.0) {
    p = WekaClassifier10x1.N29fd0eb6176(i);
    } else if (((Double) i[5]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N29fd0eb6176(Object []i) {
    double p = Double.NaN;
    if (i[0] == null) {
      p = 2;
    } else if (((Double) i[0]).doubleValue() <= -1.0) {
      p = 2;
    } else if (((Double) i[0]).doubleValue() > -1.0) {
    p = WekaClassifier10x1.N1f9659b9177(i);
    } 
    return p;
  }
  static double N1f9659b9177(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
      p = 1;
    } else if (((Double) i[2]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[2]).doubleValue() > -1.0) {
      p = 2;
    } 
    return p;
  }
  static double N238de8d1178(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 3;
    } else if (((Double) i[1]).doubleValue() <= 0.0) {
    p = WekaClassifier10x1.N51caf953179(i);
    } else if (((Double) i[1]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N51caf953179(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 3;
    } else if (((Double) i[3]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[3]).doubleValue() > -1.0) {
    p = WekaClassifier10x1.N1003c562180(i);
    } 
    return p;
  }
  static double N1003c562180(Object []i) {
    double p = Double.NaN;
    if (i[4] == null) {
      p = 0;
    } else if (((Double) i[4]).doubleValue() <= 0.0) {
    p = WekaClassifier10x1.N3d750d4a181(i);
    } else if (((Double) i[4]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N3d750d4a181(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 0;
    } else if (((Double) i[3]).doubleValue() <= 0.0) {
    p = WekaClassifier10x1.N71f2a155182(i);
    } else if (((Double) i[3]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N71f2a155182(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 0;
    } else if (((Double) i[6]).doubleValue() <= -1.0) {
      p = 0;
    } else if (((Double) i[6]).doubleValue() > -1.0) {
      p = 1;
    } 
    return p;
  }
}
