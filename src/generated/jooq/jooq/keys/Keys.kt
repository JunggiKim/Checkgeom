/*
 * This file is generated by jOOQ.
 */
package jooq.keys


import jooq.tables.BookInterest
import jooq.tables.Users
import jooq.tables.records.BookInterestRecord
import jooq.tables.records.UsersRecord

import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val KEY_BOOK_INTEREST_PRIMARY: UniqueKey<BookInterestRecord> = Internal.createUniqueKey(BookInterest.BOOK_INTEREST, DSL.name("KEY_book_interest_PRIMARY"), arrayOf(BookInterest.BOOK_INTEREST.ID), true)
val KEY_USERS_PRIMARY: UniqueKey<UsersRecord> = Internal.createUniqueKey(Users.USERS, DSL.name("KEY_users_PRIMARY"), arrayOf(Users.USERS.ID), true)
val KEY_USERS_UK_6EFS5VMCE86YMF5Q7LMVN2UUF: UniqueKey<UsersRecord> = Internal.createUniqueKey(Users.USERS, DSL.name("KEY_users_UK_6efs5vmce86ymf5q7lmvn2uuf"), arrayOf(Users.USERS.USER_ID), true)
