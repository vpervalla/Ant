//=== Run information ===
//
//Scheme:weka.classifiers.trees.J48 -C 0.25 -M 2
//Relation:     ant
//Instances:    100
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
//|   4 <= -1
//|   |   1 <= 0: A (18.0/7.0)
//|   |   1 > 0: W (2.0)
//|   4 > -1
//|   |   3 <= 0
//|   |   |   6 <= -1
//|   |   |   |   3 <= -1: D (7.0/2.0)
//|   |   |   |   3 > -1: W (22.0/8.0)
//|   |   |   6 > -1
//|   |   |   |   5 <= 0: D (38.0/12.0)
//|   |   |   |   5 > 0: S (2.0)
//|   |   3 > 0: A (5.0)
//6 > 0: S (6.0)
//
//Number of Leaves  : 	8
//
//Size of the tree : 	15
//
//
//Time taken to build model: 0 seconds
//
//=== Evaluation on training set ===
//=== Summary ===
//
//Correctly Classified Instances          71               71      %
//Incorrectly Classified Instances        29               29      %
//Kappa statistic                          0.594 
//Mean absolute error                      0.2159
//Root mean squared error                  0.3285
//Relative absolute error                 59.0307 %
//Root relative squared error             76.8691 %
//Total Number of Instances              100     
//
//=== Detailed Accuracy By Class ===
//
//               TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class
//                 0.593     0.11       0.667     0.593     0.627      0.81     W
//                 0.727     0.09       0.696     0.727     0.711      0.89     A
//                 0.5       0          1         0.5       0.667      0.866    S
//                 0.886     0.215      0.689     0.886     0.775      0.866    D
//Weighted Avg.    0.71      0.125      0.734     0.71      0.704      0.856
//
//=== Confusion Matrix ===
//
//  a  b  c  d   <-- classified as
// 16  4  0  7 |  a = W
//  4 16  0  2 |  b = A
//  0  3  8  5 |  c = S
//  4  0  0 31 |  d = D
//
//=== Source code ===

// Generated with Weka 3.6.11
//
// This code is public domain and comes with no warranty.
//
// Timestamp: Sat Sep 20 20:13:13 CEST 2014

package ant;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

public class WekaWrapper5x1
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
    
    return WekaClassifier5x1.classify(s);
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
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.6.11).\n" + this.getClass().getName() + "/WekaClassifier5x1";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  public static void main(String args[]) {
    runClassifier(new WekaWrapper5x1(), args);
  }
}

class WekaClassifier5x1 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = WekaClassifier5x1.N77a2fb18165(i);
    return p;
  }
  static double N77a2fb18165(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() <= 0.0) {
    p = WekaClassifier5x1.N511e91f0166(i);
    } else if (((Double) i[6]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N511e91f0166(Object []i) {
    double p = Double.NaN;
    if (i[4] == null) {
      p = 1;
    } else if (((Double) i[4]).doubleValue() <= -1.0) {
    p = WekaClassifier5x1.N5b854ef6167(i);
    } else if (((Double) i[4]).doubleValue() > -1.0) {
    p = WekaClassifier5x1.N5af38daf168(i);
    } 
    return p;
  }
  static double N5b854ef6167(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 1;
    } else if (((Double) i[1]).doubleValue() <= 0.0) {
      p = 1;
    } else if (((Double) i[1]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N5af38daf168(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 3;
    } else if (((Double) i[3]).doubleValue() <= 0.0) {
    p = WekaClassifier5x1.N3a69d7d2169(i);
    } else if (((Double) i[3]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N3a69d7d2169(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 0;
    } else if (((Double) i[6]).doubleValue() <= -1.0) {
    p = WekaClassifier5x1.N1fdd507e170(i);
    } else if (((Double) i[6]).doubleValue() > -1.0) {
    p = WekaClassifier5x1.N6ede5f8d171(i);
    } 
    return p;
  }
  static double N1fdd507e170(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 3;
    } else if (((Double) i[3]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[3]).doubleValue() > -1.0) {
      p = 0;
    } 
    return p;
  }
  static double N6ede5f8d171(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 3;
    } else if (((Double) i[5]).doubleValue() <= 0.0) {
      p = 3;
    } else if (((Double) i[5]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
}
