//=== Run information ===
//
//Scheme:weka.classifiers.trees.J48 -C 0.25 -M 2
//Relation:     ant
//Instances:    20
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
//|   0 <= -1: D (2.0)
//|   0 > -1
//|   |   4 <= 0
//|   |   |   5 <= -1: W (3.0)
//|   |   |   5 > -1
//|   |   |   |   6 <= -1: W (5.0/2.0)
//|   |   |   |   6 > -1: A (6.0/2.0)
//|   |   4 > 0: D (2.0)
//6 > 0: S (2.0)
//
//Number of Leaves  : 	6
//
//Size of the tree : 	11
//
//
//Time taken to build model: 0 seconds
//
//=== Evaluation on training set ===
//=== Summary ===
//
//Correctly Classified Instances          16               80      %
//Incorrectly Classified Instances         4               20      %
//Kappa statistic                          0.7163
//Mean absolute error                      0.1367
//Root mean squared error                  0.2614
//Relative absolute error                 38.3626 %
//Root relative squared error             62.211  %
//Total Number of Instances               20     
//
//=== Detailed Accuracy By Class ===
//
//               TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class
//                 0.75      0.167      0.75      0.75      0.75       0.885    W
//                 0.8       0.133      0.667     0.8       0.727      0.893    A
//                 1         0          1         1         1          1        S
//                 0.8       0          1         0.8       0.889      0.973    D
//Weighted Avg.    0.8       0.1        0.817     0.8       0.804      0.921
//
//=== Confusion Matrix ===
//
// a b c d   <-- classified as
// 6 2 0 0 | a = W
// 1 4 0 0 | b = A
// 0 0 2 0 | c = S
// 1 0 0 4 | d = D
//
//=== Source code ===

// Generated with Weka 3.6.11
//
// This code is public domain and comes with no warranty.
//
// Timestamp: Sat Sep 20 20:05:06 CEST 2014

package ant;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

public class WekaWrapper1x1
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
    
    return WekaClassifier1x1.classify(s);
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
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.6.11).\n" + this.getClass().getName() + "/WekaClassifier1x1";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  public static void main(String args[]) {
    runClassifier(new WekaWrapper1x1(), args);
  }
}

class WekaClassifier1x1 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = WekaClassifier1x1.N502c4377160(i);
    return p;
  }
  static double N502c4377160(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 0;
    } else if (((Double) i[6]).doubleValue() <= 0.0) {
    p = WekaClassifier1x1.N1c3ea426161(i);
    } else if (((Double) i[6]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N1c3ea426161(Object []i) {
    double p = Double.NaN;
    if (i[0] == null) {
      p = 3;
    } else if (((Double) i[0]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[0]).doubleValue() > -1.0) {
    p = WekaClassifier1x1.N5f5d756f162(i);
    } 
    return p;
  }
  static double N5f5d756f162(Object []i) {
    double p = Double.NaN;
    if (i[4] == null) {
      p = 0;
    } else if (((Double) i[4]).doubleValue() <= 0.0) {
    p = WekaClassifier1x1.Nae13246163(i);
    } else if (((Double) i[4]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double Nae13246163(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 0;
    } else if (((Double) i[5]).doubleValue() <= -1.0) {
      p = 0;
    } else if (((Double) i[5]).doubleValue() > -1.0) {
    p = WekaClassifier1x1.N38e4ff96164(i);
    } 
    return p;
  }
  static double N38e4ff96164(Object []i) {
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
