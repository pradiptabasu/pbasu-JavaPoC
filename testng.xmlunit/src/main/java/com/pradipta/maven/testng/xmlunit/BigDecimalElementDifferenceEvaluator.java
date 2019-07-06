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

import java.math.BigDecimal;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonResult;
import org.xmlunit.diff.DifferenceEvaluator;

public class BigDecimalElementDifferenceEvaluator implements DifferenceEvaluator {

    private String elementName;

    public BigDecimalElementDifferenceEvaluator(String elementName) {
        this.elementName = elementName;
    }

    public ComparisonResult evaluate(Comparison comparison, ComparisonResult outcome) {
        if (outcome == ComparisonResult.EQUAL) return outcome; // only evaluate differences.
        final Node controlNode = comparison.getControlDetails().getTarget();
        final Node testNode = comparison.getTestDetails().getTarget();
        if (controlNode.getParentNode() instanceof Element && testNode.getParentNode() instanceof Element) {
            Element controlElement = (Element) controlNode.getParentNode();
            Element testElement = (Element) testNode.getParentNode();
            if (controlElement.getNodeName().equals(elementName)) {
                final String controlValue = controlElement.getTextContent();
                final String testValue = testElement.getTextContent();
                if (new BigDecimal(controlValue).compareTo(new BigDecimal(testValue)) == 0) {
                    return ComparisonResult.SIMILAR;
                }
            }
        }
        return outcome;
    }
}
