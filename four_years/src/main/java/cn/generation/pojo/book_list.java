package cn.generation.pojo;

import javax.xml.crypto.Data;

public class book_list {
        private int bookid;
        private String bookname;
        private String pimage;
        //private String type;
        private Data data;

        public int getBookid() {
            return bookid;
        }

        public void setBookid(int bookid) {
            this.bookid = bookid;
        }

        public String getBookname() {
            return bookname;
        }

        public void setBookname(String bookname) {
            this.bookname = bookname;
        }

        public String getPimage() {
            return pimage;
        }

        public void setPimage(String pimage) {
            this.pimage = pimage;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

}
