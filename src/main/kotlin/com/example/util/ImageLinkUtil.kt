package com.example.util

import org.jsoup.Jsoup

class ImageLinkUtil {

    fun getUrlFromDuckDuckGoImagesHtml(htmlString: String): String {
        val startingPattern = "//external-content.duckduckgo.com/iu/"
        val endingPattern = "\" data-src="

        val url = buildString {
            append("https:")
            append(startingPattern)
            append(htmlString.substringAfter(startingPattern).substringBefore(endingPattern))
        }

        return url
    }

    fun getUrlFromYandexImagesHtml(htmlString: String): String {
        val startingPattern = "//external-content.duckduckgo.com/iu/"
        val endingPattern = "\" data-src="

        val url = buildString {
            append("https:")
            append(startingPattern)
            append(htmlString.substringAfter(startingPattern).substringBefore(endingPattern))
        }

        return url
    }

    fun getDocumentString(url: String): String {
        val document = Jsoup.connect(url).get()
        return document.toString()
    }
}