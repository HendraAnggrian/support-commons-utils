package com.hendraanggrian.kota.test.content

import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.runner.AndroidJUnit4
import com.hendraanggrian.kota.content.getColor2
import com.hendraanggrian.kota.test.R
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
@RunWith(AndroidJUnit4::class)
class ThemesTest {

    @Test
    fun test() {
        assertNotEquals(getTargetContext().theme.getColor2(R.attr.colorAccent), 0)
    }
}