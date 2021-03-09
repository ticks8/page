package cn.generation.controller;

import cn.generation.dao.book_listmapper;
import cn.generation.pojo.book_list;
import cn.generation.service.book_listservice;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class listcontrol {
    private final int book_number=20;
    private int cunnrent_page;
    @Resource
    private book_listservice listservice;

    @RequestMapping(value="/save")
    public String save(MultipartFile file, book_list book, ModelMap map){
        try{
            return this.listservice.save(file,book,map);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value="/listImages")
    public String list(Model model){
        System.out.println("list已经运行了！");
        List<book_list> page_lists=listservice.select_book(1,10);
        Integer numbers=listservice.select_allbook();
        //ModelAndView mav=new ModelAndView();
        int all_page=(int)Math.ceil(numbers/book_number);
        model.addAttribute("all_page",all_page);
        model.addAttribute("page_lists",page_lists);
        System.out.println(page_lists);
        //return mav;
        return "show_list";
    }
  // @RequestMapping(value="/page",method = RequestMethod.POST )
   // public String list2(Model model,HttpServletRequest req) throws JSONException {
       //System.out.println(req.getParameter("current"));
    //  JSONObject json1=new JSONObject();

      //  int page_number=Integer.parseInt(req.getParameter("current"));
        //System.out.println(page_number);
      //  int recent_number=(page_number-1)*10+1;
      //  List<book_list> page_lists=listservice.select_book(recent_number,recent_number+9);
      //  Integer numbers=listservice.select_allbook();
        //ModelAndView mav=new ModelAndView();
      //  int all_page=(int)Math.ceil(numbers/book_number);
      //  model.addAttribute("all_page",all_page);
      //  model.addAttribute("page_lists",page_lists);
      //  model.addAttribute("page_number",page_number);
      //  model.addAttribute("fuck","fuck");
        /*json1.put("all_page",all_page);
        json1.put("page_lists",page_lists);
        json1.put("page_number",page_number);
        json1.put("fuck","fuck");*/
        //model.getClass("fuck");
        //System.out.println(page_lists);
        //return mav;
        //System.out.println(json.get("page_list"));
        //return json;
        //return "redirect:/mine.html";
       // System.out.println(page_lists.get(0).getBookname());
      //return "show_list::section1";
   // }

   // @RequestMapping(value="/page1",method = RequestMethod.GET )
  //  public String list3(Model model)  {
   //     return "show_list::section1";
  //  }
@RequestMapping(value="/getpage",method=RequestMethod.POST)
public void setcurrent_page(HttpServletRequest req){
    this.cunnrent_page=Integer.parseInt(req.getParameter("current"));
}
 @RequestMapping(value="/page",method = RequestMethod.GET )
 public String list2(Model model)  {

  int recent_number=(cunnrent_page-1)*10+1;
  List<book_list> page_lists=listservice.select_book(recent_number,recent_number+9);
  Integer numbers=listservice.select_allbook();
ModelAndView mav=new ModelAndView();
  int all_page=(int)Math.ceil(numbers/book_number);
  model.addAttribute("all_page",all_page);
 model.addAttribute("page_lists",page_lists);
 model.addAttribute("current_page",cunnrent_page);
  model.addAttribute("fuck","fuck");
        /*json1.put("all_page",all_page);
        json1.put("page_lists",page_lists);
        json1.put("page_number",page_number);
        json1.put("fuck","fuck");*/
//model.getClass("fuck");
//System.out.println(page_lists);
//return mav;
//System.out.println(json.get("page_list"));
//return json;
//return "redirect:/mine.html";
// System.out.println(page_lists.get(0).getBookname());
return "show_list::section1";
    }


}
