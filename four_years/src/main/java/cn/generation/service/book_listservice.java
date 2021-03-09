package cn.generation.service;

import cn.generation.pojo.book_list;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface book_listservice {
    List<book_list> select_book(int op, int ed);
    String save(MultipartFile file, book_list book, ModelMap map) throws IOException;
    Integer select_allbook();
}
