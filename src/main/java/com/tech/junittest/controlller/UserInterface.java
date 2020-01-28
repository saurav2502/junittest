package com.tech.junittest.controlller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<SerializedUser,Integer> {
}
