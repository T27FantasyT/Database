import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    ConnectDB connectDB = new ConnectDB();
    Connection conn = connectDB.connect();
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

    public void getPostByStatus(String status){

        String query = "Select post.id,post.title,post.description,post.thumnail,post.create_at, post.status from post where status = '" + status + "'";
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);

            while(result.next()){
                List<Post> list = new ArrayList<>();
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                String thumbnail = result.getString("thumnail");
                String create_at = result.getString("create_at");
                String postStatus = result.getString("status");

                list.add(new Post(id,title,null,description,thumbnail,null,null,create_at,postStatus, null));
                list.forEach(i -> System.out.println(
                        "Id: " + i.getId() +
                        " - Title: "+ i.getTittle() +
                        " - Description: " + i.getDescription() +
                        " - Thumbnail: " + i.getThumbnail() +
                        " - Create_at: " + i.getCreate_at() +
                        " - Status: " + i.getStatus()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getPostById(int id){
        List<Post> list = new ArrayList<>();
        String query = "select post.id,post.title,post.content,author.name,tag.name, post.create_at " +
                "from post " +
                "inner join author on post.id_author = author.id " +
                "inner join post_tag on post.id = post_tag.id_post " +
                "inner join tag on post_tag.id_tag = tag.id " +
                "where post.id = " + id;
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);

            while(result.next()){
                int idPost = result.getInt("id");
                String title = result.getString("title");
                String content = result.getString("content");
                String author = result.getString("author.name");
                String tag = result.getString("tag.name");
                String create_at = result.getString("create_at");

                list.add(new Post(idPost,title,content,null,null,null,author,create_at,null, tag));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        list.forEach(i -> System.out.println("Id: "+i.getId() +
                " - Title: " + i.getTittle() +
                " - Content: " + i.getContent() +
                " - Author: "+ i.getAuthor() +
                " - Tag: " + i.getTag() +
                " - Create at: "+ i.getCreate_at()));

    }

    public void updatePostTitleById(int id,String title){
        String query = "update post" +
                " set post.title = '" + title + "'" +
                " where id = " + id;
        System.out.println("Cập nhật thành công");
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePostContentById(int id,String content){
        String query = "update post" +
                " set post.content = '" + content + "'" +
                " where id = " + id;
        System.out.println("Cập nhật thành công");
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delPostById(int id){
        String query = "delete from post" +
                       " where id = " + id;
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> showAuthor(){
        List<Author> authors = new ArrayList<>();
        String query ="select id,name,gender " +
                "from author";
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String gender = result.getString("gender");
                authors.add(new Author(id,name,gender));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public List<Category> showCategory(){
        List<Category> categories = new ArrayList<>();
        String query ="select id,name " +
                "from category";
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                categories.add(new Category(id,name));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public int getCategoryId(String name){
        int id = 0;
        String query = "insert into category(name)" +
                "values ('"+name+"')";
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query2 = "select id from category where name = '" + name + "'";
        try {
            Statement stm2 = conn.createStatement();
            ResultSet result = stm2.executeQuery(query2);
            id = result.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int getAuthorId(String name){
        int id = 0;
        String query = "insert into author(name)" +
                "values ('"+name+"')";
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query2 = "select id from author where name = '" + name + "'";
        try {
            Statement stm2 = conn.createStatement();
            ResultSet result = stm2.executeQuery(query2);
            id = result.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public void addPost(){
        System.out.println("Nhập title bài viết");
        String title = sc.nextLine();
        System.out.println("Nhập nội dung bài viết");
        String content = sc.nextLine();
        System.out.println("Nhập chú thích cho bài viết");
        String description = sc.nextLine();
        System.out.println("Chọn hình ảnh cho bài viết");
        String thumbnail = sc.nextLine();
        int id_author = 0;
        System.out.println("Nhập tên tác giả");
        String author = sc.nextLine();
        List<Author> authors = showAuthor();
        for(Author a : authors){
            if(a.getName().equalsIgnoreCase(author)){
                id_author = a.getId();
            } else id_author = getAuthorId(author);
        }
        int id_category = 0;
        System.out.println("Nhập Category");
        String category = sc.nextLine();
        List<Category> categories = showCategory();
        for(Category c : categories){
            if(c.getName().equalsIgnoreCase(category)){
                id_category = c.getId();
            } else id_category =getCategoryId(category);
        }
        String create_at = LocalDate.now().format(formatter);
        System.out.println("Chọn trạng thái");
        System.out.println("1 - Public\n2 - Private");
        int choose = sc.nextInt();
        String status = null;
        switch (choose){
            case 1: status = "public";
            break;
            case 2: status = "private";
            break;
            default:
                System.out.println("Không có lựa chọn này");
                break;
        }

        String query = "insert into post (title,content,description,thumnail,id_category,id_author,create_at,status)" +
                " values ('" + title +
                "','" + content +
                "','" + description +
                "','" + thumbnail +
                "','" + id_category +
                "','" + id_author +
                "','" + create_at +
                "','" + status+"')";
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Thêm post thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
