package kota.resources

import android.Manifest
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import junit.framework.Assert.assertEquals
import kota.isSelfPermissionsGranted
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
@RunWith(AndroidJUnit4::class)
class PermissionsTest {

    private val context = InstrumentationRegistry.getTargetContext()

    @Test
    @Throws(Exception::class)
    fun isGranted() {
        assertEquals(context.isSelfPermissionsGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE), false)
    }
}