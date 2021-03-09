package cn.generation.service.lmpl;

import cn.generation.dao.book_listmapper;
import cn.generation.pojo.book_list;
import cn.generation.service.book_listservice;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.awt.image.MultiPixelPackedSampleModel;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("book_listservice")
public class book_listservicelmpl implements book_listservice {
    @Resource
    private book_listmapper bookListmapper;

    @Override
    public List<book_list> select_book(int op,int ed){
        return this.bookListmapper.select_book(op,ed);
    }

    @Override
    public Integer select_allbook(){
        return this.bookListmapper.select_allbook();
    }

    @Override
    @Transactional
    public String save(MultipartFile file, book_list book, ModelMap map) throws IOException {
        // 保存图片的路径，图片上传成功后，将路径保存到数据库
        String filePath="C:\\Users\\ASUS\\Desktop\\github\\four_years\\src\\main\\webapp\\WEB-INF\\templates\\images";
        //获取原始图片扩展名
        String originalFilename=file.getOriginalFilename();
        //生成文件新的名字
        String newFileName= UUID.randomUUID()+originalFilename;
        //封装上传文件位置的全路径
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);
        //保存到数据库
        book.setPimage(newFileName);
        bookListmapper.save(book);
        return "redirect:/listImages";
    }

}
