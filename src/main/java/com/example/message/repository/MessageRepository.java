package com.example.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.message.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
