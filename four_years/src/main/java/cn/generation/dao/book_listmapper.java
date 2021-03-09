package cn.generation.dao;

import cn.generation.pojo.book_list;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface book_listmapper {
    List<book_list> select_book(@Param("op")int op, @Param("ed")int ed);
    Integer save(book_list book);
    Integer select_allbook();
}
