package android.sukedachi.jp.baseproject

import org.mockito.Mockito

/**
 * Use for mockito
 * @author at-tienhoang on 01/03/18.
 */
open class BaseTest {

    @Suppress("UNCHECKED_CAST")
    fun <T> any(): T {
        Mockito.any<T>()
        return null as T
    }
}
