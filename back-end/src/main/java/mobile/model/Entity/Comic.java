package mobile.model.Entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;

@RestResource(exported=false)
@Document(collection = "novels")
public class Comic {
    @Id
    protected ObjectId _id;
    protected int rating;
    protected String image;
    protected int views;
    @DBRef
    protected User uploader;
    protected String description;
    protected int soluongdanhgia;
    protected String artist;
    protected String name;
    protected String genre;
    protected String trangthai;
    protected String status;
    protected String url;
    @CreatedDate
    protected Date createAt;
    @LastModifiedDate
    protected Date updateAt;

    public Comic() {
    }

    public Comic(ObjectId _id, int danhgia, String hinhanh, int luotdoc, User nguoidangtruyen, String noidung, int soluongdanhgia, String tacgia, String tentruyen, String theloai, String trangthai, String status, String url, Date createAt, Date updateAt) {
        this._id = _id;
        this.rating = danhgia;
        this.image = hinhanh;
        this.views = luotdoc;
        this.uploader = nguoidangtruyen;
        this.description = noidung;
        this.soluongdanhgia = soluongdanhgia;
        this.artist = tacgia;
        this.name = tentruyen;
        this.genre = theloai;
        this.trangthai = trangthai;
        this.status = status;
        this.url = url;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSoluongdanhgia() {
        return soluongdanhgia;
    }

    public void setSoluongdanhgia(int soluongdanhgia) {
        this.soluongdanhgia = soluongdanhgia;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}