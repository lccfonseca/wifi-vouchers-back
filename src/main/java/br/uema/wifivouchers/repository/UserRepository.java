/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uema.wifivouchers.repository;

import br.uema.wifivouchers.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lccf
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Page<User> findByUsername(String username, Pageable pageable);

}