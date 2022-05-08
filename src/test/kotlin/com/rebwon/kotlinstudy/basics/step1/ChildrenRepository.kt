package com.rebwon.kotlinstudy.basics.step1

import org.springframework.data.jpa.repository.JpaRepository

interface ChildrenRepository : JpaRepository<Children, String>
