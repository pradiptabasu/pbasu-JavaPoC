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


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

public class IgnoreAttributeDifferenceEvaluatorTest {

    @Test
    public void testUserguideExample() throws Exception {
        final String control = "<a><b attr=\"abc\"></b></a>";
        final String test = "<a><b attr=\"xyz\"></b></a>";

        Diff myDiff = DiffBuilder.compare(control).withTest(test)
            .withDifferenceEvaluator(new IgnoreAttributeDifferenceEvaluator("attr"))
            .checkForSimilar()
            .build();

        AssertJUnit.assertFalse(myDiff.toString(), myDiff.hasDifferences());
    }
}
