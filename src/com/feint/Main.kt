package com.feint

fun main(args: Array<String>) {
    var u=url {
        protocal { "http" }
        hostname { "www.feintkotlin.com" }
        port { 8080 }
        path { "article/all" }
        paramList {
            param {
                key { "name" }
                value { "feint" }
            }
            param {
                key { "age" }
                value { "11" }
            }
        }
    }

    println("""
    |protocal:${u.protocal};
    |hostname:${u.hostname};
    |port:${u.port};
    |path:${u.path};
    |full_path:${u.toString()};
    |param("name"):${u.paramList["name"]}
    """.trimMargin())
}

