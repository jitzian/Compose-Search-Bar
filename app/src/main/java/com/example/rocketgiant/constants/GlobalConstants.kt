package com.example.rocketgiant.constants

class GlobalConstants {
    companion object {
        //https://www.giantbomb.com/api/games/?api_key=[API_KEY]&filter=name:[GAME_NAME]&format=json
        //https://www.giantbomb.com/api/games/?api_key=9d45436f87d3848d2bdcce810bacb6df57dfd134&filter=name:SEGA&format=json
        const val baseUrl = "https://www.giantbomb.com/api/"
        const val MAX_TIMEOUT = 10000L
    }
}