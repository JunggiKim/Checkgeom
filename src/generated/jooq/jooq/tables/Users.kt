/*
 * This file is generated by jOOQ.
 */
package jooq.tables


import java.time.LocalDateTime

import jooq.Checkgeom
import jooq.keys.KEY_USERS_PRIMARY
import jooq.keys.KEY_USERS_UK_6EFS5VMCE86YMF5Q7LMVN2UUF
import jooq.tables.records.UsersRecord

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Users(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UsersRecord>?,
    aliased: Table<UsersRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UsersRecord>(
    alias,
    Checkgeom.CHECKGEOM,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>checkgeom.users</code>
         */
        val USERS: Users = Users()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UsersRecord> = UsersRecord::class.java

    /**
     * The column <code>checkgeom.users.created_date_time</code>.
     */
    val CREATED_DATE_TIME: TableField<UsersRecord, LocalDateTime?> = createField(DSL.name("created_date_time"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>checkgeom.users.updated_date_time</code>.
     */
    val UPDATED_DATE_TIME: TableField<UsersRecord, LocalDateTime?> = createField(DSL.name("updated_date_time"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>checkgeom.users.id</code>.
     */
    val ID: TableField<UsersRecord, String?> = createField(DSL.name("id"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>checkgeom.users.user_id</code>.
     */
    val USER_ID: TableField<UsersRecord, String?> = createField(DSL.name("user_id"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<UsersRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UsersRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>checkgeom.users</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>checkgeom.users</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>checkgeom.users</code> table reference
     */
    constructor(): this(DSL.name("users"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UsersRecord>): this(Internal.createPathAlias(child, key), child, key, USERS, null)
    override fun getSchema(): Schema? = if (aliased()) null else Checkgeom.CHECKGEOM
    override fun getPrimaryKey(): UniqueKey<UsersRecord> = KEY_USERS_PRIMARY
    override fun getUniqueKeys(): List<UniqueKey<UsersRecord>> = listOf(KEY_USERS_UK_6EFS5VMCE86YMF5Q7LMVN2UUF)
    override fun `as`(alias: String): Users = Users(DSL.name(alias), this)
    override fun `as`(alias: Name): Users = Users(alias, this)
    override fun `as`(alias: Table<*>): Users = Users(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Users = Users(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Users = Users(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Users = Users(name.getQualifiedName(), null)
}