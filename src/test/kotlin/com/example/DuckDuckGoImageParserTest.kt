package com.example

import com.example.util.ImageLinkUtil
import org.junit.Assert
import org.junit.Test

class DuckDuckGoImageParserTest {

    @Test
    fun `given html text, get url back`() {
        // Given
        val data = TestHtmlData.htmlText1

        // When
        val result = ImageLinkUtil().getUrlFromDuckDuckGoImagesHtml(data)

        // Then
        val expectedUrl =
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.-E46ANZ7Gh5PXJDz75Dm9QHaE8%26pid%3DApi&f=1"
        Assert.assertEquals(expectedUrl, result)
    }
}