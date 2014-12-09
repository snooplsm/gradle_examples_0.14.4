/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.tests.flavors;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.TextView;

/**
 * An example of an {@link ActivityInstrumentationTestCase2} of a specific activity {@link Focus2}.
 * By virtue of extending {@link ActivityInstrumentationTestCase2}, the target activity is automatically
 * launched and finished before and after each test.  This also extends
 * {@link android.test.InstrumentationTestCase}, which provides
 * access to methods for sending events to the target activity, such as key and
 * touch events.  See {@link #sendKeys}.
 *
 * In general, {@link android.test.InstrumentationTestCase}s and {@link ActivityInstrumentationTestCase2}s
 * are heavier weight functional tests available for end to end testing of your
 * user interface.  When run via a {@link android.test.InstrumentationTestRunner},
 * the necessary {@link android.app.Instrumentation} will be injected for you to
 * user via {@link #getInstrumentation} in your tests.
 *
 * See {@link com.example.android.apis.AllTests} for documentation on running
 * all tests and individual tests in this application.
 */
public class MainActivityGroup2Test extends ActivityInstrumentationTestCase2<MainActivity> {

    private TextView mResOverLay;
    private TextView mResOverLay2;
    private TextView mBuildConfig2;
    private TextView mCodeOverlay2;

    /**
     * Creates an {@link ActivityInstrumentationTestCase2} that tests the {@link Focus2} activity.
     */
    public MainActivityGroup2Test() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        final MainActivity a = getActivity();
        // ensure a valid handle to the activity has been returned
        assertNotNull(a);
        
        mResOverLay = (TextView) a.findViewById(R.id.resoverlay);
        mResOverLay2 = (TextView) a.findViewById(R.id.resoverlay2);
        mBuildConfig2 = (TextView) a.findViewById(R.id.buildconfig2);
        mCodeOverlay2 = (TextView) a.findViewById(R.id.codeoverlay2);
    }

    /**
     * The name 'test preconditions' is a convention to signal that if this
     * test doesn't pass, the test case was not set up properly and it might
     * explain any and all failures in other tests.  This is not guaranteed
     * to run before other tests, as junit uses reflection to find the tests.
     */
    @MediumTest
    public void testPreconditions() {
        assertNotNull(mResOverLay);
        assertNotNull(mResOverLay2);
        assertNotNull(mBuildConfig2);
        assertNotNull(mCodeOverlay2);
    }

    @MediumTest
    public void testResOverlay() {
        // because this group has lower priority, we check that the resource from
        // this flavor is not used.
        assertFalse("fb".equals(mResOverLay.getText().toString()));
        assertEquals("fb", mResOverLay2.getText().toString());
    }

    @MediumTest
    public void testBuildConfig() {
        assertEquals("fb", mBuildConfig2.getText().toString());
    }

    @MediumTest
    public void testCodeOverlay() {
        assertEquals("fb", mCodeOverlay2.getText().toString());
    }
}
