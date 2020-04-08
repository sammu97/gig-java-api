package com.jordan.gigjavaapi.dao;

import com.jordan.gigjavaapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account,String> {

}
