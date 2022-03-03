public class Post {
    private int id;
    private String tittle;
    private String content;
    private String description;
    private String thumbnail;
    private String category;
    private String author;
    private String create_at;
    private String status;
    private String tag;

    public Post(int id, String tittle, String content, String description, String thumbnail, String category, String author, String create_at, String status, String tag) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.author = author;
        this.create_at = create_at;
        this.status = status;
        this.tag = tag;
    }

    public Post() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
