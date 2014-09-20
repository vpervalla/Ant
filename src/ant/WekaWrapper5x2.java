//=== Classifier model (full training set) ===
//
//J48 pruned tree
//------------------
//
//16 <= 0
//|   7 <= 0
//|   |   11 <= -1
//|   |   |   9 <= -12: W (5.0/3.0)
//|   |   |   9 > -12: D (19.0/4.0)
//|   |   11 > -1
//|   |   |   13 <= 0
//|   |   |   |   12 <= 0
//|   |   |   |   |   21 <= 0
//|   |   |   |   |   |   7 <= -1
//|   |   |   |   |   |   |   18 <= -12
//|   |   |   |   |   |   |   |   3 <= -1: A (3.0)
//|   |   |   |   |   |   |   |   3 > -1
//|   |   |   |   |   |   |   |   |   11 <= 0: S (2.0)
//|   |   |   |   |   |   |   |   |   11 > 0: A (2.0)
//|   |   |   |   |   |   |   18 > -12
//|   |   |   |   |   |   |   |   6 <= -1: D (3.0/1.0)
//|   |   |   |   |   |   |   |   6 > -1: S (3.0/1.0)
//|   |   |   |   |   |   7 > -1
//|   |   |   |   |   |   |   5 <= -12: D (3.0/1.0)
//|   |   |   |   |   |   |   5 > -12
//|   |   |   |   |   |   |   |   15 <= -1
//|   |   |   |   |   |   |   |   |   3 <= -1: A (3.0)
//|   |   |   |   |   |   |   |   |   3 > -1: W (7.0)
//|   |   |   |   |   |   |   |   15 > -1: A (26.0/5.0)
//|   |   |   |   |   21 > 0: S (3.0)
//|   |   |   |   12 > 0: D (3.0)
//|   |   |   13 > 0: D (4.0)
//|   7 > 0: W (9.0/1.0)
//16 > 0: S (5.0)
//
//Number of Leaves  : 	16
//
//Size of the tree : 	31
//
//
//Time taken to build model: 0.01 seconds
//
//=== Evaluation on training set ===
//=== Summary ===
//
//Correctly Classified Instances          84               84      %
//Incorrectly Classified Instances        16               16      %
//Kappa statistic                          0.7824
//Mean absolute error                      0.1213
//Root mean squared error                  0.2462
//Relative absolute error                 32.6472 %
//Root relative squared error             57.1482 %
//Total Number of Instances              100     
//
//=== Detailed Accuracy By Class ===
//
//               TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class
//                 0.739     0.052      0.81      0.739     0.773      0.92     W
//                 0.967     0.071      0.853     0.967     0.906      0.971    A
//                 0.632     0.012      0.923     0.632     0.75       0.929    S
//                 0.929     0.083      0.813     0.929     0.867      0.967    D
//Weighted Avg.    0.84      0.059      0.845     0.84      0.835      0.95 
//
//=== Confusion Matrix ===
//
//  a  b  c  d   <-- classified as
// 17  3  0  3 |  a = W
//  1 29  0  0 |  b = A
//  2  2 12  3 |  c = S
//  1  0  1 26 |  d = D
//
//=== Source code ===

// Generated with Weka 3.6.11
//
// This code is public domain and comes with no warranty.
//
// Timestamp: Sat Sep 20 19:59:39 CEST 2014

package ant;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

public class WekaWrapper5x2
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
    
    return WekaClassifier5x2.classify(s);
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
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.6.11).\n" + this.getClass().getName() + "/WekaClassifier5x2";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  public static void main(String args[]) {
    runClassifier(new WekaWrapper5x2(), args);
  }
}

class WekaClassifier5x2 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = WekaClassifier5x2.N69213e9e145(i);
    return p;
  }
  static double N69213e9e145(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 1;
    } else if (((Double) i[16]).doubleValue() <= 0.0) {
    p = WekaClassifier5x2.N753cdeaa146(i);
    } else if (((Double) i[16]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N753cdeaa146(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (((Double) i[7]).doubleValue() <= 0.0) {
    p = WekaClassifier5x2.N558d8ea5147(i);
    } else if (((Double) i[7]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N558d8ea5147(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 3;
    } else if (((Double) i[11]).doubleValue() <= -1.0) {
    p = WekaClassifier5x2.N14ab1108148(i);
    } else if (((Double) i[11]).doubleValue() > -1.0) {
    p = WekaClassifier5x2.N741e18cd149(i);
    } 
    return p;
  }
  static double N14ab1108148(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 0;
    } else if (((Double) i[9]).doubleValue() <= -12.0) {
      p = 0;
    } else if (((Double) i[9]).doubleValue() > -12.0) {
      p = 3;
    } 
    return p;
  }
  static double N741e18cd149(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() <= 0.0) {
    p = WekaClassifier5x2.N67c4416a150(i);
    } else if (((Double) i[13]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N67c4416a150(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() <= 0.0) {
    p = WekaClassifier5x2.N5e050391151(i);
    } else if (((Double) i[12]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N5e050391151(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 1;
    } else if (((Double) i[21]).doubleValue() <= 0.0) {
    p = WekaClassifier5x2.N12ea6a08152(i);
    } else if (((Double) i[21]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N12ea6a08152(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (((Double) i[7]).doubleValue() <= -1.0) {
    p = WekaClassifier5x2.N1636c0e8153(i);
    } else if (((Double) i[7]).doubleValue() > -1.0) {
    p = WekaClassifier5x2.N44b9bd5d157(i);
    } 
    return p;
  }
  static double N1636c0e8153(Object []i) {
    double p = Double.NaN;
    if (i[18] == null) {
      p = 1;
    } else if (((Double) i[18]).doubleValue() <= -12.0) {
    p = WekaClassifier5x2.N533c1c55154(i);
    } else if (((Double) i[18]).doubleValue() > -12.0) {
    p = WekaClassifier5x2.N642800b0156(i);
    } 
    return p;
  }
  static double N533c1c55154(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 1;
    } else if (((Double) i[3]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[3]).doubleValue() > -1.0) {
    p = WekaClassifier5x2.N25d39428155(i);
    } 
    return p;
  }
  static double N25d39428155(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 0.0) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N642800b0156(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() > -1.0) {
      p = 2;
    } 
    return p;
  }
  static double N44b9bd5d157(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 3;
    } else if (((Double) i[5]).doubleValue() <= -12.0) {
      p = 3;
    } else if (((Double) i[5]).doubleValue() > -12.0) {
    p = WekaClassifier5x2.N7754cf2b158(i);
    } 
    return p;
  }
  static double N7754cf2b158(Object []i) {
    double p = Double.NaN;
    if (i[15] == null) {
      p = 0;
    } else if (((Double) i[15]).doubleValue() <= -1.0) {
    p = WekaClassifier5x2.N4e9f773d159(i);
    } else if (((Double) i[15]).doubleValue() > -1.0) {
      p = 1;
    } 
    return p;
  }
  static double N4e9f773d159(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 1;
    } else if (((Double) i[3]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[3]).doubleValue() > -1.0) {
      p = 0;
    } 
    return p;
  }
}
