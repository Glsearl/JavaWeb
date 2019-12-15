package service;

import domain.Province;

import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:54 2019/11/16
 * @Version: $
 */
public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
