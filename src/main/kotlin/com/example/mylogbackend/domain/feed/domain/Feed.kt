package com.example.diaryservice.domain.feed.domain

import com.example.diaryservice.domain.user.domain.User
import com.example.diaryservice.global.entity.BaseUUIDEntity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_diary")
@Entity
@DynamicInsert
class Feed(
    override val id: UUID,

    @field:NotNull
    @field:Length(max = 20)
    val title: String,

    @field:NotNull
    @field:Length(max = 1500)
    val content: String,

    createdAt: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User
) : BaseUUIDEntity() {
    @CreatedDate
    @field:NotNull
    var createdAt: LocalDateTime = createdAt
        protected set
}