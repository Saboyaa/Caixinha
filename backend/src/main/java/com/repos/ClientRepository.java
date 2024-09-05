package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classes.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}