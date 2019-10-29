/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uema.wifivouchers.repository;

import br.uema.wifivouchers.model.Voucher;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author lccf
 */
public interface VoucherRepository extends PagingAndSortingRepository<Voucher, Long>{
    
}
