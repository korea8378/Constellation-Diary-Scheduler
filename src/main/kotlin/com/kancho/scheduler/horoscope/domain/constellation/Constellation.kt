package com.kancho.scheduler.horoscope.domain.constellation

import javax.persistence.*

@Entity
@Table(name = "constellations")
class Constellation private constructor(id: Long? = null, name: String,
                                        date: String, description: String,
                                        crawlingUrl: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        private set

    var name: String = name
        private set

    var date: String = date
        private set

    var description: String = description
        private set

    var crawlingUrl: String = crawlingUrl

    constructor(name: String, date: String, description: String, crawlingUrl: String)
            : this(null, name, date, description, crawlingUrl)
}