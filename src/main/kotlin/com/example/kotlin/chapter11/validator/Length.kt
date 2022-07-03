package com.example.kotlin.chapter11.validator

class Length(private val length: Int, private val msg: String?): Rule {
    override fun check(target: RuleResult): RuleResult {
        return if (
            target is RuleResult.Value<*> &&
            target.value is String &&
            target.value.length == length
        ) target
        else RuleResult.fail(msg)
    }
}
