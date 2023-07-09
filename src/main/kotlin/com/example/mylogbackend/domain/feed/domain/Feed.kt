package com.example.mylogbackend.domain.feed.domain

import com.example.mylogbackend.domain.feed.type.StarScore
import com.example.mylogbackend.domain.feed.type.Whether
import com.example.mylogbackend.domain.user.domain.User
import com.example.mylogbackend.global.entity.BaseUUIDEntity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Entity(name = "tbl_feed")
@DynamicInsert
class Feed(
    override val id: UUID,

    @field:NotNull
    @field:Length(max = 20)
    var title: String,

    @field:NotNull
    @field:Length(max = 1500)
    var content: String,

    createdAt: LocalDateTime,

    whether: Whether,

    @field:NotNull
    @field:Length(max = 100)
    var sleepTime: Int,

    @field:NotNull
    @field:Length(max = 100)
    var sportsTime: Int,

    @field:NotNull
    var image: String,

    starScore: StarScore,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User

) : BaseUUIDEntity() {
    @CreatedDate
    @field:NotNull
    var createdAt: LocalDateTime = createdAt
        protected set

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    var starScore = starScore
        protected set

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    var whether = whether
        protected set

    fun modifyFeed(title: String, content: String, starScore: StarScore, whether: Whether, sportsTime: Int, sleepTime: Int, image: String) {
        this.title = title
        this.content = content
        this.starScore = starScore
        this.whether = whether
        this.sportsTime = sportsTime
        this.sleepTime = sleepTime
        this.image = image
    }
}