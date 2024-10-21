package com.smartGift.smartGift.repository;

import com.smartGift.smartGift.entity.Gift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GiftRepository extends CrudRepository<Gift, String> {

}
