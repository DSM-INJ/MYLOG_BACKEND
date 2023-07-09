package com.example.mylogbackend.domain.user.domain

import com.example.mylogbackend.domain.user.domain.type.ProviderType
import com.example.mylogbackend.domain.user.domain.type.Role
import com.example.mylogbackend.global.entity.BaseUUIDEntity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_user")
@Entity
@DynamicInsert
class User(
    override val id: UUID,

    @field:NotNull
    @field:Length(max = 64)
    val email: String,

    @field:NotNull
    @field:Length(max = 60)
    val password: String,

    @field:NotNull
    @field:Length(max = 6)
    val name: String,

    @field:NotNull
    @field:Length(max = 10)
    val nickname: String,

    @field:Length(max = 2000)
    val profileFileName: String?,

    role: Role,

    providerType: ProviderType
) : BaseUUIDEntity() {
    @field:NotNull
    @field:Enumerated(STRING)
    var role: Role = role
        protected set

    @field:NotNull
    @field:Enumerated(STRING)
    var providerType: ProviderType = providerType
        protected set
}