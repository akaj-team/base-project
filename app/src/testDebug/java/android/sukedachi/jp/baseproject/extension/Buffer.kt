package android.sukedachi.jp.baseproject.extension

import okio.Buffer

/**
 *
 * @author at-vinh.huynh.
 */
internal fun Buffer.getKeyValueMap(): Map<String, Any> {
    val map = HashMap<String, Any>()
    val source = readUtf8() ?: return map
    val array = source.split("; name=\"").toMutableList()
    array.removeAt(0)
    array.forEach {
        if (it.startsWith("image_file")) {
            val contentLength = it.split("Content-Length: ")[1].split("\r")[0].toLong()
            map.put("contentLength", contentLength)
        } else {
            val keyValueArray = it.split("\"\r\nContent-Transfer-Encoding: binary\r")
            val key = keyValueArray[0]
            val value = keyValueArray[1].split("\r\n\r\n")[1].split("\r")[0]
            map.put(key, value)
        }
    }
    return map
}
