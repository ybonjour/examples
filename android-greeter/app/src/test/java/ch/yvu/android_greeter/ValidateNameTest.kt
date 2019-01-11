package ch.yvu.android_greeter

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class ValidateNameTest {
    @Test
    fun nonBlankNameIsValid() {
        val result = isValidName("Mary")

        assertThat(result, `is`(true))
    }

    @Test
    fun emptyNameIsInvalid() {
        val result = isValidName("")

        assertThat(result, `is`(false))
    }

    @Test
    fun nameWithWhitespacesOnlyIsInvalid() {
        val result = isValidName(" ")

        assertThat(result, `is`(false))
    }
}
