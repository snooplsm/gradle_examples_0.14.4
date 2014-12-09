package com.android.tests.flavored;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.TextView;

public class OtherActivityTest extends ActivityInstrumentationTestCase2<OtherActivity> {

    private TextView mTextView;

    /**
     * Creates an {@link ActivityInstrumentationTestCase2} that tests the {@link OtherActivity} activity.
     */
    public OtherActivityTest() {
        super(OtherActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        final OtherActivity a = getActivity();
        // ensure a valid handle to the activity has been returned
        assertNotNull(a);
        mTextView = (TextView) a.findViewById(R.id.text2);
    }

    /**
     * The name 'test preconditions' is a convention to signal that if this
     * test doesn't pass, the test case was not set up properly and it might
     * explain any and all failures in other tests.  This is not guaranteed
     * to run before other tests, as junit uses reflection to find the tests.
     */
    @MediumTest
    public void testPreconditions() {
        assertNotNull(mTextView);
    }
}

