//=== Classifier model (full training set) ===
//
//J48 pruned tree
//------------------
//
//11 <= 0
//|   10 <= -1: W (5.0/2.0)
//|   10 > -1
//|   |   8 <= -1: S (3.0/1.0)
//|   |   8 > -1
//|   |   |   3 <= -1: S (4.0/1.0)
//|   |   |   3 > -1: D (6.0)
//11 > 0: A (2.0)
//
//Number of Leaves  : 	5
//
//Size of the tree : 	9
//
//
//Time taken to build model: 0 seconds
//
//=== Evaluation on training set ===
//=== Summary ===
//
//Correctly Classified Instances          16               80      %
//Incorrectly Classified Instances         4               20      %
//Kappa statistic                          0.7232
//Mean absolute error                      0.1408
//Root mean squared error                  0.2654
//Relative absolute error                 39.5322 %
//Root relative squared error             63.1522 %
//Total Number of Instances               20     
//
//=== Detailed Accuracy By Class ===
//
//               TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class
//                 1         0.118      0.6       1         0.75       0.941    W
//                 0.667     0          1         0.667     0.8        0.98     A
//                 0.833     0.143      0.714     0.833     0.769      0.899    S
//                 0.75      0          1         0.75      0.857      0.932    D
//Weighted Avg.    0.8       0.061      0.854     0.8       0.806      0.931
//
//=== Confusion Matrix ===
//
// a b c d   <-- classified as
// 3 0 0 0 | a = W
// 0 2 1 0 | b = A
// 1 0 5 0 | c = S
// 1 0 1 6 | d = D
//
//=== Source code ===

// Generated with Weka 3.6.11
//
// This code is public domain and comes with no warranty.
//
// Timestamp: Sat Sep 20 19:57:34 CEST 2014

package ant;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

public class WekaWrapper1x2
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
    
    return WekaClassifier1x2.classify(s);
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
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.6.11).\n" + this.getClass().getName() + "/WekaClassifier1x2";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  public static void main(String args[]) {
    runClassifier(new WekaWrapper1x2(), args);
  }
}

class WekaClassifier1x2 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = WekaClassifier1x2.Naca3352141(i);
    return p;
  }
  static double Naca3352141(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 3;
    } else if (((Double) i[11]).doubleValue() <= 0.0) {
    p = WekaClassifier1x2.N2c646c4f142(i);
    } else if (((Double) i[11]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N2c646c4f142(Object []i) {
    double p = Double.NaN;
    if (i[10] == null) {
      p = 0;
    } else if (((Double) i[10]).doubleValue() <= -1.0) {
      p = 0;
    } else if (((Double) i[10]).doubleValue() > -1.0) {
    p = WekaClassifier1x2.Nb3c07b5143(i);
    } 
    return p;
  }
  static double Nb3c07b5143(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 2;
    } else if (((Double) i[8]).doubleValue() <= -1.0) {
      p = 2;
    } else if (((Double) i[8]).doubleValue() > -1.0) {
    p = WekaClassifier1x2.N389ac52e144(i);
    } 
    return p;
  }
  static double N389ac52e144(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 2;
    } else if (((Double) i[3]).doubleValue() <= -1.0) {
      p = 2;
    } else if (((Double) i[3]).doubleValue() > -1.0) {
      p = 3;
    } 
    return p;
  }
}
