package com.marwit23.cook.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoDishRepository extends JpaRepository<ToDoDish, Long> {
}
