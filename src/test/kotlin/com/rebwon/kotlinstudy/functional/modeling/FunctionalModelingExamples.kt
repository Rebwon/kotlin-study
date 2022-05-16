package com.rebwon.kotlinstudy.functional.modeling

import arrow.core.Either
import arrow.core.computations.either
import java.time.LocalDate

suspend fun generateId(): Long = -1L

suspend fun createEvent(value: String): Either<Error.ValidationError, Event> =
    either {
        val id = EventId.create(generateId()).bind()
        val title = Title.create("            ").bind()
        val organizer = Organizer.create("").bind()
        val description = Description.create("").bind()
        val url = Url.create(value).bind()
        Event.Online(id, title, organizer, description, AgeRestriction.GENERAL, LocalDate.now(), url)
    }

fun printLocation(event: Event): Unit =
    when (event) {
        is Event.Online -> println(event.url.value)
        is Event.AtAddress -> println("${event.address.city}: ${event.address.street}")
    }

interface EventService {
    suspend fun fetchUpcomingEvent(id: EventId): Either<Error, Event>
}

sealed class Error {
    data class ErrorNotFound(val id: EventId) : Error()
    data class ErrorPassed(val event: Event) : Error()
    data class ValidationError(val reason: String) : Error()
}

sealed class Event {
    abstract val id: EventId
    abstract val title: Title
    abstract val organizer: Organizer
    abstract val description: Description
    abstract val ageRestriction: AgeRestriction
    abstract val date: LocalDate

    data class Online(
        override val id: EventId,
        override val title: Title,
        override val organizer: Organizer,
        override val description: Description,
        override val ageRestriction: AgeRestriction,
        override val date: LocalDate,
        val url: Url
    ) : Event()

    data class AtAddress(
        override val id: EventId,
        override val title: Title,
        override val organizer: Organizer,
        override val description: Description,
        override val ageRestriction: AgeRestriction,
        override val date: LocalDate,
        val address: Address
    ) : Event()
}

enum class AgeRestriction(val description: String) {
    GENERAL("All ages admitted. Nothing that would offend parents for viewing by children."),
    PG("Some material may not be suitable for children. Parents urged to give \"parental guidance\""),
    PG13("Some material may be inappropriate for children under 13. Parents are urged to be cautious."),
    RESTRICTED("Under 17 requires accompanying parent or adult guardian. Contains some adult material."),
    NC17("No One 17 and Under Admitted. Clearly adult.");
}

@JvmInline
value class EventId(val value: Long) {
    companion object {
        fun create(value: Long): Either<Error.ValidationError, EventId> =
            if (value > 0) Either.right(EventId(value))
            else Either.left(Error.ValidationError("EventId must be greater than 0"))
    }
}

@JvmInline
value class Organizer(val value: String) {
    companion object {
        fun create(value: String): Either<Error.ValidationError, Organizer> =
            when {
                value.isEmpty() -> Either.left(Error.ValidationError("Organizer cannot be empty"))
                value.isBlank() -> Either.left(Error.ValidationError("Organizer cannot be blank"))
                else -> Either.right(Organizer(value))
            }
    }
}

@JvmInline
value class Title(val value: String) {
    companion object {
        fun create(value: String): Either<Error.ValidationError, Title> =
            when {
                value.isEmpty() -> Either.left(Error.ValidationError("Title cannot be empty"))
                value.isBlank() -> Either.left(Error.ValidationError("Title cannot be blank"))
                else -> Either.right(Title(value))
            }
    }
}

@JvmInline
value class Description(val value: String) {
    companion object {
        fun create(value: String): Either<Error.ValidationError, Description> =
            when {
                value.isEmpty() -> Either.left(Error.ValidationError("Description cannot be empty"))
                value.isBlank() -> Either.left(Error.ValidationError("Description cannot be blank"))
                else -> Either.right(Description(value))
            }
    }
}

@JvmInline
value class Url(val value: String) {
    companion object {
        fun create(value: String): Either<Error.ValidationError, Url> =
            when {
                value.isEmpty() -> Either.left(Error.ValidationError("Url cannot be empty"))
                value.isBlank() -> Either.left(Error.ValidationError("Url cannot be blank"))
                else -> Either.right(Url(value))
            }
    }
}

@JvmInline
value class City(val value: String)

@JvmInline
value class Street(val value: String)

data class Address(val city: City, val street: Street)
