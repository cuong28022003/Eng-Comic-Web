package mobile.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import mobile.model.Entity.Chapter;
import mobile.model.Entity.Comic;
import mobile.repository.ChapterRepository;
import mobile.repository.ComicRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private ComicRepository comicRepository;

    @PostMapping("/chapter")
    public ResponseEntity<?> uploadChapter(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("chapnumber") int chapnumber,
            @RequestParam("content") String content,
            @RequestParam("comicId") String comicId,
            @RequestParam("tenchap") String tenchap) {
        List<String> imageUrls = new ArrayList<>();
        try {
            // Upload từng ảnh lên Cloudinary và lưu URL
            for (MultipartFile file : files) {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String imageUrl = (String) uploadResult.get("secure_url");
                imageUrls.add(imageUrl);
            }

            // Kiểm tra comicId có tồn tại trong Comic không
            Comic comic = comicRepository.findById(new ObjectId(comicId))
                    .orElseThrow(() -> new IllegalArgumentException("Comic ID không hợp lệ!"));

            // Tạo đối tượng Chapter và lưu vào MongoDB
            Chapter chapter = new Chapter();
            chapter.setChapnumber(chapnumber);
//            chapter.setContent(content);
            chapter.setDautruyenId(comic);
            chapter.setTenchap(tenchap);
            chapter.setDanhSachAnh(imageUrls);
            chapter.setCreateAt(new Date());
            chapter.setUpdateAt(new Date());

            Chapter savedChapter = chapterRepository.save(chapter);

            return ResponseEntity.ok(savedChapter);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Upload failed!");
        }
    }
}
