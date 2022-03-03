import java.util.Scanner;

public class Controler {
    static Scanner sc = new Scanner(System.in);
    static Service service = new Service();

    public static void menu(){
        while(true) {
            System.out.println("1 - Tìm kiếm bằng status");
            System.out.println("2 - Tìm kiếm theo id");
            System.out.println("3 - Cập nhật theo id");
            System.out.println("4 - Xoá bài viết theo id");
            System.out.println("5 - Thêm bài viết mới");
            System.out.println("Lựa chọn: ");
            int choose = sc.nextInt();
            sc.nextLine();
            String status = null;
            switch (choose){
                case 1:
                    System.out.println("1 - Bài viết ở chế độ public");
                    System.out.println("2 - Bài viết ở chế độ private");
                    System.out.println("Lựa chọn");
                    int chosen = sc.nextInt();
                    switch (chosen){
                        case 1: status = "public";
                        service.getPostByStatus(status);
                        break;
                        case 2: status = "private";
                        service.getPostByStatus(status);
                        break;
                        default:
                            System.out.println("không có lựa chọn này");
                    }
                    break;
                case 2:
                    System.out.println("Nhập id");
                    int id = sc.nextInt();
                    service.getPostById(id);
                    break;
                case 3:
                    updateMemu();
                    break;
                case 4:
                    System.out.println("Nhập id bài viết cần xoá: ");
                    int idPost = sc.nextInt();
                    service.delPostById(idPost);
                    break;
                case 5:
                    service.addPost();
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }


        }
    }
    public static void updateMemu(){
        System.out.println("1 - Cập nhật title");
        System.out.println("2 - Cập nhật Content");
        System.out.println("Lựa chọn: ");
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                System.out.println("Nhập id bài viết cần sửa tiêu đề");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập tiêu đề mới");
                String title = sc.nextLine();
                service.updatePostTitleById(id,title);
                break;
            case 2:
                System.out.println("Nhập id bài viết cần sửa nội dụng");
                int id2 = sc.nextInt();
                        sc.nextLine();
                System.out.println("Nhập nội dung mới");
                String content = sc.nextLine();
                service.updatePostContentById(id2,content);
                break;
            default:
                System.out.println("không có lựa chọn này");
        }
    }
}
