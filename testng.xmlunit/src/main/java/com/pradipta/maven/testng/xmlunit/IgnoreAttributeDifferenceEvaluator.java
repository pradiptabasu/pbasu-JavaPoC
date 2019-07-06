/*
  This file is licensed to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

package com.pradipta.maven.testng.xmlunit;

import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonResult;
import org.xmlunit.diff.DifferenceEvaluator;

public final class IgnoreAttributeDifferenceEvaluator implements DifferenceEvaluator {

    private String attributeName;

    public IgnoreAttributeDifferenceEvaluator(String attributeName) {
        this.attributeName = attributeName;
    }

    public ComparisonResult evaluate(Comparison comparison, ComparisonResult outcome) {
        if (outcome == ComparisonResult.EQUAL) return outcome; // only evaluate differences.
        final Node controlNode = comparison.getControlDetails().getTarget();
        if (controlNode instanceof Attr) {
            Attr attr = (Attr) controlNode;
            if (attr.getName().equals(attributeName)) {
                return ComparisonResult.SIMILAR; // will evaluate this difference as similar
            }
        }
        return outcome;
    }
} 

