package dao;

import domain.Category;

import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 15:25 2019/12/12
 * @Version: $
 */
public interface CategoryDao {
    public List<Category> findAll();
}
