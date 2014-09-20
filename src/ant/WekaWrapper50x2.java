
//Number of Leaves  : 	80
//
//Size of the tree : 	159
//
//
//Time taken to build model: 0.05 seconds
//
//=== Evaluation on training set ===
//=== Summary ===
//
//Correctly Classified Instances         818               81.8    %
//Incorrectly Classified Instances       182               18.2    %
//Kappa statistic                          0.7568
//Mean absolute error                      0.1385
//Root mean squared error                  0.2632
//Relative absolute error                 36.9751 %
//Root relative squared error             60.8073 %
//Total Number of Instances             1000     
//
//=== Detailed Accuracy By Class ===
//
//               TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class
//                 0.832     0.065      0.809     0.832     0.821      0.952    W
//                 0.759     0.037      0.865     0.759     0.809      0.957    A
//                 0.824     0.066      0.798     0.824     0.811      0.953    S
//                 0.85      0.076      0.809     0.85      0.829      0.953    D
//Weighted Avg.    0.818     0.061      0.82      0.818     0.818      0.954
//
//=== Confusion Matrix ===
//
//   a   b   c   d   <-- classified as
// 208  11   2  29 |   a = W
//  28 180  24   5 |   b = A
//   4  17 197  21 |   c = S
//  17   0  24 233 |   d = D
//
//=== Source code ===

// Generated with Weka 3.6.11
//
// This code is public domain and comes with no warranty.
//
// Timestamp: Sat Sep 20 19:43:26 CEST 2014

package ant;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

public class WekaWrapper50x2
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
    
    return WekaClassifier50x2.classify(s);
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
    runClassifier(new WekaWrapper50x2(), args);
  }
}

class WekaClassifier50x2 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = WekaClassifier50x2.N1257ac5f62(i);
    return p;
  }
  static double N1257ac5f62(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.N6f5fec163(i);
    } else if (((Double) i[12]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N65f04b294(i);
    } 
    return p;
  }
  static double N6f5fec163(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 1;
    } else if (((Double) i[16]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N3a70e51964(i);
    } else if (((Double) i[16]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N3a70e51964(Object []i) {
    double p = Double.NaN;
    if (i[22] == null) {
      p = 1;
    } else if (((Double) i[22]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N4468510265(i);
    } else if (((Double) i[22]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N4468510265(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (((Double) i[7]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N6b72288466(i);
    } else if (((Double) i[7]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N4bd1497091(i);
    } 
    return p;
  }
  static double N6b72288466(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (((Double) i[7]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.N4258c0dd67(i);
    } else if (((Double) i[7]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N795b130669(i);
    } 
    return p;
  }
  static double N4258c0dd67(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N7f3dada268(i);
    } else if (((Double) i[11]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N7f3dada268(Object []i) {
    double p = Double.NaN;
    if (i[19] == null) {
      p = 1;
    } else if (((Double) i[19]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[19]).doubleValue() > -1.0) {
      p = 2;
    } 
    return p;
  }
  static double N795b130669(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 0;
    } else if (((Double) i[11]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.N31722a170(i);
    } else if (((Double) i[11]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N74d543671(i);
    } 
    return p;
  }
  static double N31722a170(Object []i) {
    double p = Double.NaN;
    if (i[19] == null) {
      p = 0;
    } else if (((Double) i[19]).doubleValue() <= -1.0) {
      p = 0;
    } else if (((Double) i[19]).doubleValue() > -1.0) {
      p = 2;
    } 
    return p;
  }
  static double N74d543671(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 1;
    } else if (((Double) i[21]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N150fb9c072(i);
    } else if (((Double) i[21]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N1554904e90(i);
    } 
    return p;
  }
  static double N150fb9c072(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 1;
    } else if (((Double) i[11]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N346d5b4473(i);
    } else if (((Double) i[11]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N346d5b4473(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 0;
    } else if (((Double) i[16]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.Ned5654274(i);
    } else if (((Double) i[16]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N303841f379(i);
    } 
    return p;
  }
  static double Ned5654274(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 0;
    } else if (((Double) i[5]).doubleValue() <= -12.0) {
      p = 0;
    } else if (((Double) i[5]).doubleValue() > -12.0) {
    p = WekaClassifier50x2.N63546c4a75(i);
    } 
    return p;
  }
  static double N63546c4a75(Object []i) {
    double p = Double.NaN;
    if (i[15] == null) {
      p = 1;
    } else if (((Double) i[15]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[15]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.Nbfd185976(i);
    } 
    return p;
  }
  static double Nbfd185976(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 1;
    } else if (((Double) i[21]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.N5594d51977(i);
    } else if (((Double) i[21]).doubleValue() > -1.0) {
      p = 0;
    } 
    return p;
  }
  static double N5594d51977(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 0;
    } else if (((Double) i[21]).doubleValue() <= -12.0) {
      p = 0;
    } else if (((Double) i[21]).doubleValue() > -12.0) {
    p = WekaClassifier50x2.N70ce459c78(i);
    } 
    return p;
  }
  static double N70ce459c78(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 0;
    } else if (((Double) i[12]).doubleValue() <= -12.0) {
      p = 0;
    } else if (((Double) i[12]).doubleValue() > -12.0) {
      p = 1;
    } 
    return p;
  }
  static double N303841f379(Object []i) {
    double p = Double.NaN;
    if (i[15] == null) {
      p = 1;
    } else if (((Double) i[15]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N53e4b87d80(i);
    } else if (((Double) i[15]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N77733d289(i);
    } 
    return p;
  }
  static double N53e4b87d80(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 1;
    } else if (((Double) i[3]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N20ab930581(i);
    } else if (((Double) i[3]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N20ab930581(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
      p = 1;
    } else if (((Double) i[2]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N224bd02982(i);
    } else if (((Double) i[2]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N224bd02982(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N500e3a4a83(i);
    } else if (((Double) i[9]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N500e3a4a83(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 1;
    } else if (((Double) i[6]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N265f476684(i);
    } else if (((Double) i[6]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N75b201487(i);
    } 
    return p;
  }
  static double N265f476684(Object []i) {
    double p = Double.NaN;
    if (i[10] == null) {
      p = 0;
    } else if (((Double) i[10]).doubleValue() <= -12.0) {
      p = 0;
    } else if (((Double) i[10]).doubleValue() > -12.0) {
    p = WekaClassifier50x2.N5a10cb1385(i);
    } 
    return p;
  }
  static double N5a10cb1385(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 1;
    } else if (((Double) i[21]).doubleValue() <= -12.0) {
    p = WekaClassifier50x2.N26a692e086(i);
    } else if (((Double) i[21]).doubleValue() > -12.0) {
      p = 1;
    } 
    return p;
  }
  static double N26a692e086(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() > -1.0) {
      p = 0;
    } 
    return p;
  }
  static double N75b201487(Object []i) {
    double p = Double.NaN;
    if (i[22] == null) {
      p = 1;
    } else if (((Double) i[22]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[22]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N5be333ee88(i);
    } 
    return p;
  }
  static double N5be333ee88(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() <= -12.0) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() > -12.0) {
      p = 0;
    } 
    return p;
  }
  static double N77733d289(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 2;
    } else if (((Double) i[13]).doubleValue() <= -1.0) {
      p = 2;
    } else if (((Double) i[13]).doubleValue() > -1.0) {
      p = 1;
    } 
    return p;
  }
  static double N1554904e90(Object []i) {
    double p = Double.NaN;
    if (i[0] == null) {
      p = 2;
    } else if (((Double) i[0]).doubleValue() <= -12.0) {
      p = 2;
    } else if (((Double) i[0]).doubleValue() > -12.0) {
      p = 1;
    } 
    return p;
  }
  static double N4bd1497091(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 0;
    } else if (((Double) i[5]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N96f6fa792(i);
    } else if (((Double) i[5]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N96f6fa792(Object []i) {
    double p = Double.NaN;
    if (i[22] == null) {
      p = 0;
    } else if (((Double) i[22]).doubleValue() <= -12.0) {
    p = WekaClassifier50x2.N373824fb93(i);
    } else if (((Double) i[22]).doubleValue() > -12.0) {
      p = 0;
    } 
    return p;
  }
  static double N373824fb93(Object []i) {
    double p = Double.NaN;
    if (i[14] == null) {
      p = 0;
    } else if (((Double) i[14]).doubleValue() <= -1.0) {
      p = 0;
    } else if (((Double) i[14]).doubleValue() > -1.0) {
      p = 2;
    } 
    return p;
  }
  static double N65f04b294(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 3;
    } else if (((Double) i[11]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N478457c095(i);
    } else if (((Double) i[11]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N20d0df99138(i);
    } 
    return p;
  }
  static double N478457c095(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 0;
    } else if (((Double) i[16]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.N35e41ac096(i);
    } else if (((Double) i[16]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N659cadf2109(i);
    } 
    return p;
  }
  static double N35e41ac096(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 0;
    } else if (((Double) i[12]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N438dff7b97(i);
    } else if (((Double) i[12]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N438dff7b97(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (((Double) i[7]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N3d09192c98(i);
    } else if (((Double) i[7]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N3d09192c98(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N5856631a99(i);
    } 
    return p;
  }
  static double N5856631a99(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (((Double) i[7]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.N4d7150ca100(i);
    } else if (((Double) i[7]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N612b1838101(i);
    } 
    return p;
  }
  static double N4d7150ca100(Object []i) {
    double p = Double.NaN;
    if (i[4] == null) {
      p = 1;
    } else if (((Double) i[4]).doubleValue() <= 0.0) {
      p = 1;
    } else if (((Double) i[4]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N612b1838101(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 0;
    } else if (((Double) i[5]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N141ebd48102(i);
    } else if (((Double) i[5]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N141ebd48102(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 0;
    } else if (((Double) i[6]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N7f3b4262103(i);
    } else if (((Double) i[6]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N207c633c108(i);
    } 
    return p;
  }
  static double N7f3b4262103(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 0;
    } else if (((Double) i[9]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N388bba4f104(i);
    } else if (((Double) i[9]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N4540e019107(i);
    } 
    return p;
  }
  static double N388bba4f104(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 3;
    } else if (((Double) i[1]).doubleValue() <= -12.0) {
    p = WekaClassifier50x2.N1d88fbe105(i);
    } else if (((Double) i[1]).doubleValue() > -12.0) {
    p = WekaClassifier50x2.N60cd9630106(i);
    } 
    return p;
  }
  static double N1d88fbe105(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() <= -12.0) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() > -12.0) {
      p = 3;
    } 
    return p;
  }
  static double N60cd9630106(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 0;
    } else if (((Double) i[13]).doubleValue() <= 0.0) {
      p = 0;
    } else if (((Double) i[13]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N4540e019107(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
      p = 3;
    } else if (((Double) i[2]).doubleValue() <= 0.0) {
      p = 3;
    } else if (((Double) i[2]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N207c633c108(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 1;
    } else if (((Double) i[5]).doubleValue() <= -12.0) {
      p = 1;
    } else if (((Double) i[5]).doubleValue() > -12.0) {
      p = 0;
    } 
    return p;
  }
  static double N659cadf2109(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 3;
    } else if (((Double) i[16]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N69ecdb67110(i);
    } else if (((Double) i[16]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N159b23f7137(i);
    } 
    return p;
  }
  static double N69ecdb67110(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 2;
    } else if (((Double) i[7]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.N2b6eae6b111(i);
    } else if (((Double) i[7]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N5a7234d8118(i);
    } 
    return p;
  }
  static double N2b6eae6b111(Object []i) {
    double p = Double.NaN;
    if (i[10] == null) {
      p = 2;
    } else if (((Double) i[10]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N68484db9112(i);
    } else if (((Double) i[10]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N68484db9112(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 2;
    } else if (((Double) i[13]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N68bb8e7f113(i);
    } else if (((Double) i[13]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N68bb8e7f113(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 2;
    } else if (((Double) i[12]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N670357ec114(i);
    } else if (((Double) i[12]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N670357ec114(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 3;
    } else if (((Double) i[21]).doubleValue() <= -12.0) {
    p = WekaClassifier50x2.N3940a091115(i);
    } else if (((Double) i[21]).doubleValue() > -12.0) {
    p = WekaClassifier50x2.N134f1785116(i);
    } 
    return p;
  }
  static double N3940a091115(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[9]).doubleValue() > -1.0) {
      p = 3;
    } 
    return p;
  }
  static double N134f1785116(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 2;
    } else if (((Double) i[9]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N2733bbe5117(i);
    } else if (((Double) i[9]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N2733bbe5117(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 2;
    } else if (((Double) i[8]).doubleValue() <= 0.0) {
      p = 2;
    } else if (((Double) i[8]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N5a7234d8118(Object []i) {
    double p = Double.NaN;
    if (i[15] == null) {
      p = 3;
    } else if (((Double) i[15]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N668a432f119(i);
    } else if (((Double) i[15]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N1c7b736d136(i);
    } 
    return p;
  }
  static double N668a432f119(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 3;
    } else if (((Double) i[7]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.Nd928344120(i);
    } else if (((Double) i[7]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double Nd928344120(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 3;
    } else if (((Double) i[6]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N37c4ed80121(i);
    } else if (((Double) i[6]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N37c4ed80121(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
      p = 3;
    } else if (((Double) i[2]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N7c5bcb54122(i);
    } else if (((Double) i[2]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N72b8e8dd134(i);
    } 
    return p;
  }
  static double N7c5bcb54122(Object []i) {
    double p = Double.NaN;
    if (i[21] == null) {
      p = 3;
    } else if (((Double) i[21]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N48fc6ccb123(i);
    } else if (((Double) i[21]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N6ffcc2af133(i);
    } 
    return p;
  }
  static double N48fc6ccb123(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 3;
    } else if (((Double) i[11]).doubleValue() <= -1.0) {
    p = WekaClassifier50x2.N516d4e33124(i);
    } else if (((Double) i[11]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N1a575b8c129(i);
    } 
    return p;
  }
  static double N516d4e33124(Object []i) {
    double p = Double.NaN;
    if (i[9] == null) {
      p = 0;
    } else if (((Double) i[9]).doubleValue() <= -12.0) {
    p = WekaClassifier50x2.N41d50173125(i);
    } else if (((Double) i[9]).doubleValue() > -12.0) {
    p = WekaClassifier50x2.N4847d1e7127(i);
    } 
    return p;
  }
  static double N41d50173125(Object []i) {
    double p = Double.NaN;
    if (i[0] == null) {
      p = 3;
    } else if (((Double) i[0]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[0]).doubleValue() > -1.0) {
    p = WekaClassifier50x2.N63766376126(i);
    } 
    return p;
  }
  static double N63766376126(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 1;
    } else if (((Double) i[1]).doubleValue() <= -1.0) {
      p = 1;
    } else if (((Double) i[1]).doubleValue() > -1.0) {
      p = 0;
    } 
    return p;
  }
  static double N4847d1e7127(Object []i) {
    double p = Double.NaN;
    if (i[22] == null) {
      p = 3;
    } else if (((Double) i[22]).doubleValue() <= 0.0) {
      p = 3;
    } else if (((Double) i[22]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N7360120a128(i);
    } 
    return p;
  }
  static double N7360120a128(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 2;
    } else if (((Double) i[8]).doubleValue() <= 0.0) {
      p = 2;
    } else if (((Double) i[8]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N1a575b8c129(Object []i) {
    double p = Double.NaN;
    if (i[0] == null) {
      p = 3;
    } else if (((Double) i[0]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N4a6af663130(i);
    } else if (((Double) i[0]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N4a6af663130(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 3;
    } else if (((Double) i[12]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N3cd4ce20131(i);
    } else if (((Double) i[12]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N3cd4ce20131(Object []i) {
    double p = Double.NaN;
    if (i[10] == null) {
      p = 3;
    } else if (((Double) i[10]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N4f576bf2132(i);
    } else if (((Double) i[10]).doubleValue() > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N4f576bf2132(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 3;
    } else if (((Double) i[3]).doubleValue() <= 0.0) {
      p = 3;
    } else if (((Double) i[3]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N6ffcc2af133(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 2;
    } else if (((Double) i[12]).doubleValue() <= 0.0) {
      p = 2;
    } else if (((Double) i[12]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N72b8e8dd134(Object []i) {
    double p = Double.NaN;
    if (i[23] == null) {
      p = 0;
    } else if (((Double) i[23]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N68078d64135(i);
    } else if (((Double) i[23]).doubleValue() > 0.0) {
      p = 2;
    } 
    return p;
  }
  static double N68078d64135(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 0;
    } else if (((Double) i[8]).doubleValue() <= 0.0) {
      p = 0;
    } else if (((Double) i[8]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N1c7b736d136(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= -1.0) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() > -1.0) {
      p = 1;
    } 
    return p;
  }
  static double N159b23f7137(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 2;
    } else if (((Double) i[12]).doubleValue() <= 0.0) {
      p = 2;
    } else if (((Double) i[12]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N20d0df99138(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() <= 0.0) {
    p = WekaClassifier50x2.N74e80a4a139(i);
    } else if (((Double) i[13]).doubleValue() > 0.0) {
      p = 3;
    } 
    return p;
  }
  static double N74e80a4a139(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() <= 0.0) {
      p = 1;
    } else if (((Double) i[12]).doubleValue() > 0.0) {
    p = WekaClassifier50x2.N33cfefa1140(i);
    } 
    return p;
  }
  static double N33cfefa1140(Object []i) {
    double p = Double.NaN;
    if (i[17] == null) {
      p = 3;
    } else if (((Double) i[17]).doubleValue() <= -1.0) {
      p = 3;
    } else if (((Double) i[17]).doubleValue() > -1.0) {
      p = 1;
    } 
    return p;
  }
}
