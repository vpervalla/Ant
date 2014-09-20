//=== Run information ===
//
//Scheme:weka.classifiers.trees.J48 -C 0.25 -M 2
//Relation:     ant
//Instances:    200
//Attributes:   25
//              0
//              1
//              2
//              3
//              4
//              5
//              6
//              7
//              8
//              9
//              10
//              11
//              12
//              13
//              14
//              15
//              16
//              17
//              18
//              19
//              20
//              21
//              22
//              23
//              class
//Test mode:evaluate on training data
//
//=== Classifier model (full training set) ===
//
//J48 pruned tree
//------------------
//
//12 <= 0
//|   16 <= -1
//|   |   13 <= 0
//|   |   |   6 <= -1
//|   |   |   |   2 <= -1: A (2.0/1.0)
//|   |   |   |   2 > -1
//|   |   |   |   |   6 <= -12
//|   |   |   |   |   |   18 <= -1: W (3.0)
//|   |   |   |   |   |   18 > -1: D (2.0)
//|   |   |   |   |   6 > -12: D (3.0)
//|   |   |   6 > -1
//|   |   |   |   12 <= -1: A (2.0)
//|   |   |   |   12 > -1: W (40.0/8.0)
//|   |   13 > 0: D (4.0)
//|   16 > -1
//|   |   2 <= 0
//|   |   |   7 <= 0
//|   |   |   |   16 <= 0
//|   |   |   |   |   11 <= -1
//|   |   |   |   |   |   8 <= 0
//|   |   |   |   |   |   |   21 <= 0
//|   |   |   |   |   |   |   |   13 <= -1: W (3.0/1.0)
//|   |   |   |   |   |   |   |   13 > -1
//|   |   |   |   |   |   |   |   |   6 <= -1: D (7.0)
//|   |   |   |   |   |   |   |   |   6 > -1
//|   |   |   |   |   |   |   |   |   |   19 <= -1: D (4.0)
//|   |   |   |   |   |   |   |   |   |   19 > -1: S (6.0/2.0)
//|   |   |   |   |   |   |   21 > 0: S (4.0)
//|   |   |   |   |   |   8 > 0: W (2.0)
//|   |   |   |   |   11 > -1
//|   |   |   |   |   |   5 <= 0
//|   |   |   |   |   |   |   20 <= -12
//|   |   |   |   |   |   |   |   12 <= -1: A (4.0)
//|   |   |   |   |   |   |   |   12 > -1: D (5.0/1.0)
//|   |   |   |   |   |   |   20 > -12
//|   |   |   |   |   |   |   |   11 <= 0
//|   |   |   |   |   |   |   |   |   21 <= 0
//|   |   |   |   |   |   |   |   |   |   15 <= 0
//|   |   |   |   |   |   |   |   |   |   |   3 <= -12: S (9.0/1.0)
//|   |   |   |   |   |   |   |   |   |   |   3 > -12
//|   |   |   |   |   |   |   |   |   |   |   |   12 <= -1: A (9.0/1.0)
//|   |   |   |   |   |   |   |   |   |   |   |   12 > -1
//|   |   |   |   |   |   |   |   |   |   |   |   |   17 <= 0
//|   |   |   |   |   |   |   |   |   |   |   |   |   |   9 <= -1: A (2.0)
//|   |   |   |   |   |   |   |   |   |   |   |   |   |   9 > -1
//|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   2 <= -1
//|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   20 <= 0
//|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   1 <= -1: A (3.0/1.0)
//|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   1 > -1: S (6.0/2.0)
//|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   20 > 0: A (2.0)
//|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   2 > -1: S (7.0)
//|   |   |   |   |   |   |   |   |   |   |   |   |   17 > 0: S (4.0/1.0)
//|   |   |   |   |   |   |   |   |   |   15 > 0: A (5.0/1.0)
//|   |   |   |   |   |   |   |   |   21 > 0: S (4.0)
//|   |   |   |   |   |   |   |   11 > 0: A (2.0)
//|   |   |   |   |   |   5 > 0
//|   |   |   |   |   |   |   9 <= -1: A (2.0)
//|   |   |   |   |   |   |   9 > -1: W (2.0)
//|   |   |   |   16 > 0: S (24.0)
//|   |   |   7 > 0: W (4.0)
//|   |   2 > 0: W (5.0/1.0)
//12 > 0: D (19.0)
//
//Number of Leaves  : 	32
//
//Size of the tree : 	63
//
//
//Time taken to build model: 0.01 seconds
//
//=== Evaluation on training set ===
//=== Summary ===
//
//Correctly Classified Instances         179               89.5    %
//Incorrectly Classified Instances        21               10.5    %
//Kappa statistic                          0.8582
//Mean absolute error                      0.0823
//Root mean squared error                  0.2029
//Relative absolute error                 22.1567 %
//Root relative squared error             47.0753 %
//Total Number of Instances              200     
//
//=== Detailed Accuracy By Class ===
//
//               TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class
//                 0.98      0.067      0.831     0.98      0.899      0.974    W
//                 0.763     0.025      0.879     0.763     0.817      0.959    A
//                 0.935     0.043      0.906     0.935     0.921      0.99     S
//                 0.86      0.007      0.977     0.86      0.915      0.983    D
//Weighted Avg.    0.895     0.037      0.9       0.895     0.894      0.978
//
//=== Confusion Matrix ===
//
//  a  b  c  d   <-- classified as
// 49  0  1  0 |  a = W
//  7 29  1  1 |  b = A
//  1  3 58  0 |  c = S
//  2  1  4 43 |  d = D
//
//=== Source code ===

// Generated with Weka 3.6.11
//
// This code is public domain and comes with no warranty.
//
// Timestamp: Sat Sep 20 19:28:25 CEST 2014

package ant;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

public class WekaWrapper10x2
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
    
    return WekaClassifier.classify(s);
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
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.6.11).\n" + this.getClass().getName() + "/WekaClassifier";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  public static void main(String args[]) {
    runClassifier(new WekaWrapper10x2(), args);
  }
}

class WekaClassifier {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = WekaClassifier.Nbbcadef31(i);
    return p;
  }
  static double Nbbcadef31(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 2;
    } else if (((Double) i[12]).doubleValue() <= 0.0) {
    p = WekaClassifier.Nf05b90332(i);
    } else if (((Double) i[12]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double Nf05b90332(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 0;
    } else if (((Double) i[16]).doubleValue() <= -1.0) {
    p = WekaClassifier.N335a3a5233(i);
    } else if (((Double) i[16]).doubleValue() > -1.0) {
    p = WekaClassifier.N764b631839(i);
    } 
    return p;
  }
  static double N335a3a5233(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 0;
    } else if (((Double) i[13]).doubleValue() <= 0.0) {
    p = WekaClassifier.N5e2797ad34(i);
    } else if (((Double) i[13]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N5e2797ad34(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() <= -1.0) {
    p = WekaClassifier.N301a9a5335(i);
    } else if (((Double) i[6]).doubleValue() > -1.0) {
    p = WekaClassifier.N12e7bb1538(i);
    } 
    return p;
  }
  static double N301a9a5335(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
      p = 1;
    } else if (((Double) i[2]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[2]).doubleValue() > -1.0) {
    p = WekaClassifier.N1275e0f236(i);
    } 
    return p;
  }
  static double N1275e0f236(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 0;
    } else if (((Double) i[6]).doubleValue() <= -12.0) {
    p = WekaClassifier.N701fc04437(i);
    } else if (((Double) i[6]).doubleValue() > -12.0) {
      p = 3;
    } 
    return p;
  }
  static double N701fc04437(Object []i) {
    double p = Double.NaN;
    if (i[18] == null) {
      p = 0;
    } else if (((Double) i[18]).doubleValue() <= -1.0) {
      p = 0;
    } else if (((Double) i[18]).doubleValue() > -1.0) {
      p = 3;
    } 
    return p;
  }
  static double N12e7bb1538(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() > -1.0) {
      p = 0;
    } 
    return p;
  }
  static double N764b631839(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
      p = 2;
    } else if (((Double) i[2]).doubleValue() <= 0.0) {
    p = WekaClassifier.N4b847f5340(i);
    } else if (((Double) i[2]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N4b847f5340(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 2;
    } else if (((Double) i[7]).doubleValue() <= 0.0) {
    p = WekaClassifier.N45978b8741(i);
    } else if (((Double) i[7]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N45978b8741(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 2;
    } else if (((Double) i[16]).doubleValue() <= 0.0) {
    p = WekaClassifier.N6a07af3342(i);
    } else if (((Double) i[16]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N6a07af3342(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 3;
    } else if (((Double) i[11]).doubleValue() <= -1.0) {
    p = WekaClassifier.N47f942c843(i);
    } else if (((Double) i[11]).doubleValue() > -1.0) {
    p = WekaClassifier.N5d34b9bb48(i);
    } 
    return p;
  }
  static double N47f942c843(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 3;
    } else if (((Double) i[8]).doubleValue() <= 0.0) {
    p = WekaClassifier.N2fefd38344(i);
    } else if (((Double) i[8]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N2fefd38344(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 3;
    } else if (((Double) i[21]).doubleValue() <= 0.0) {
    p = WekaClassifier.N56ddae4a45(i);
    } else if (((Double) i[21]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N56ddae4a45(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 0;
    } else if (((Double) i[13]).doubleValue() <= -1.0) {
      p = 0;
    } else if (((Double) i[13]).doubleValue() > -1.0) {
    p = WekaClassifier.N174fd9546(i);
    } 
    return p;
  }
  static double N174fd9546(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() > -1.0) {
    p = WekaClassifier.Nc16107147(i);
    } 
    return p;
  }
  static double Nc16107147(Object []i) {
    double p = Double.NaN;
    if (i[19] == null) {
      p = 3;
    } else if (((Double) i[19]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[19]).doubleValue() > -1.0) {
      p = 2;
    } 
    return p;
  }
  static double N5d34b9bb48(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 2;
    } else if (((Double) i[5]).doubleValue() <= 0.0) {
    p = WekaClassifier.N66a0f3a949(i);
    } else if (((Double) i[5]).doubleValue() > 0.0) {
    p = WekaClassifier.N75d2e0d561(i);
    } 
    return p;
  }
  static double N66a0f3a949(Object []i) {
    double p = Double.NaN;
    if (i[20] == null) {
      p = 1;
    } else if (((Double) i[20]).doubleValue() <= -12.0) {
    p = WekaClassifier.N409e22bd50(i);
    } else if (((Double) i[20]).doubleValue() > -12.0) {
    p = WekaClassifier.N7c37274751(i);
    } 
    return p;
  }
  static double N409e22bd50(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() > -1.0) {
      p = 3;
    } 
    return p;
  }
  static double N7c37274751(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 0.0) {
    p = WekaClassifier.N4b6b01b52(i);
    } else if (((Double) i[11]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N4b6b01b52(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 2;
    } else if (((Double) i[21]).doubleValue() <= 0.0) {
    p = WekaClassifier.N656a369f53(i);
    } else if (((Double) i[21]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N656a369f53(Object []i) {
    double p = Double.NaN;
    if (i[15] == null) {
      p = 2;
    } else if (((Double) i[15]).doubleValue() <= 0.0) {
    p = WekaClassifier.N54506b4554(i);
    } else if (((Double) i[15]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N54506b4554(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 2;
    } else if (((Double) i[3]).doubleValue() <= -12.0) {
      p = 2;
    } else if (((Double) i[3]).doubleValue() > -12.0) {
    p = WekaClassifier.N1198739755(i);
    } 
    return p;
  }
  static double N1198739755(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() > -1.0) {
    p = WekaClassifier.N201f3fd756(i);
    } 
    return p;
  }
  static double N201f3fd756(Object []i) {
    double p = Double.NaN;
    if (i[17] == null) {
      p = 2;
    } else if (((Double) i[17]).doubleValue() <= 0.0) {
    p = WekaClassifier.N14752b8557(i);
    } else if (((Double) i[17]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N14752b8557(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() > -1.0) {
    p = WekaClassifier.N43a8700d58(i);
    } 
    return p;
  }
  static double N43a8700d58(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
      p = 1;
    } else if (((Double) i[2]).doubleValue() <= -1.0) {
    p = WekaClassifier.N11feb72459(i);
    } else if (((Double) i[2]).doubleValue() > -1.0) {
      p = 2;
    } 
    return p;
  }
  static double N11feb72459(Object []i) {
    double p = Double.NaN;
    if (i[20] == null) {
      p = 2;
    } else if (((Double) i[20]).doubleValue() <= 0.0) {
    p = WekaClassifier.N48c6d34b60(i);
    } else if (((Double) i[20]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N48c6d34b60(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 1;
    } else if (((Double) i[1]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[1]).doubleValue() > -1.0) {
      p = 2;
    } 
    return p;
  }
  static double N75d2e0d561(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() > -1.0) {
      p = 0;
    } 
    return p;
  }
}
