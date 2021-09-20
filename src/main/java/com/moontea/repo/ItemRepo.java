package com.moontea.repo;

import com.moontea.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, String> {
}
