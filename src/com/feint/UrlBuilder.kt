package com.feint

fun url(init: URL.() -> Unit): URL {
    val url = URL()
    url.init()
    return url
}


class URL(var protocal: String = "http",
          var hostname: String = "localhost",
          var port: Int = 80,
          var path: String = "",
          var paramList: MutableMap<String, String> = HashMap()) {

    fun protocal(pro: () -> String) {
        protocal = pro()
    }

    fun hostname(host: () -> String) {
        hostname = host()
    }

    fun port(port: () -> Int) {
        this.port = port()
    }

    fun path(path: () -> String) {
        this.path = path()
    }

    fun paramList(init: ParamList.() -> Unit) {
        val pL = ParamList()
        pL.init()
        this.paramList = pL.paramList
    }

    override fun toString(): String {
        var baseUrl = "$protocal://$hostname:$port/$path"
        var firstParam = true;
        paramList.forEach { key, value ->
            baseUrl += if (firstParam) {
                firstParam = false
                "/?$key=$value"
            } else "&$key=$value"
        }

        return baseUrl
    }
}

class ParamList(var paramList: MutableMap<String, String> = HashMap()) {
    fun param(init: Param.() -> Unit) {
        val param = Param()
        param.init()
        paramList[param.key] = param.value
    }
}

class Param(var key: String = "", var value: String = "") {
    fun key(key: () -> String) {
        this.key = key()
    }

    fun value(value: () -> String) {
        this.value = "=${value()}"
    }

}