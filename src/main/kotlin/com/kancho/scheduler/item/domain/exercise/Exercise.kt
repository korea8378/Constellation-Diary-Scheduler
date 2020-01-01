package com.kancho.scheduler.item.domain.exercise

import javax.persistence.*

@Entity
@Table(name = "exercises")
class Exercise private constructor(id: Long? = null, content: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        private set

    var content: String = content
        private set

    constructor(content: String) : this(null, content)
}