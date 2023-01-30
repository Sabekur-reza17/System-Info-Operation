package com.sabekur2017.systeminfooperation.extensions

import android.net.Uri
import com.sabekur2017.systeminfooperation.TEL_PREFIX

fun String.removeTelPrefix() = this.replace(TEL_PREFIX, "")

/**
 * Phone call numbers can contain prefix of country like '+385' and '+' sign will be interpreted
 * like '%2B', so this must be decoded.
 */
fun String.parseCountryCode(): String = Uri.decode(this)