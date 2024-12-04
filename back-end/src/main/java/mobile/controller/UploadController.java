package mobile.controller;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mobile.repository.*;
import mobile.model.Entity.*;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ChuongRepository chuongRepository;

    @PostMapping("/chuong")
    public ResponseEntity<?> uploadChuong(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("tieuDe") String tieuDe) {
        List<String> imageUrls = new ArrayList<>();
        try {
            // Upload từng ảnh lên Cloudinary và lưu URL
            for (MultipartFile file : files) {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String imageUrl = (String) uploadResult.get("secure_url");
                imageUrls.add(imageUrl);
            }

            // Lưu thông tin chương vào MongoDB
            Chuong chuong = new Chuong();
            chuong.setTieuDe(tieuDe);
            chuong.setDanhSachAnh(imageUrls);
            Chuong savedChuong = chuongRepository.save(chuong);

            return ResponseEntity.ok(savedChuong);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Upload failed!");
        }
    }
}
