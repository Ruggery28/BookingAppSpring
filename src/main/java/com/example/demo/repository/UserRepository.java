/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruggery
 */

/* This interface when connected with repository will automatic build the engine to
communicate with Mysql and use all the CRUD system with User as they know id is the
primary key.
*/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //this stays empty
}
