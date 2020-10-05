package com.example.footballapp

import io.restassured.RestAssured
import net.serenitybdd.junit.runners.SerenityRunner
import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith

const val ROOT_API_URL = "https://api.football-data.org"

@RunWith(SerenityRunner::class)
class WinnersAPITest {
    @Test
    fun checkCountryName() {
        RestAssured.given().header("X-Auth-Token", "231366f27e944e4b8de3fd55de255947").`when`()
            .get("$ROOT_API_URL/v2/competitions/2021")
            .then().assertThat().statusCode(200)
            .and().body("area.name", `is`("England"))
    }
}
