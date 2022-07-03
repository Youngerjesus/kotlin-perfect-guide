package com.example.kotlin.chapter11.validator

// TODO 1) `trim` 등의 값의 변형도 허용함. (`validation` 을 통과한다면 어느 정도 정제한 값으로의 변형도 허용한다는 뜻.)
//
// TODO 2) 검사 결과 잘못된 경우 적절한 에러메시지를 얻을 수 있음.
interface Rule {
    fun check(target: RuleResult): RuleResult
}
