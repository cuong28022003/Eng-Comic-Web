package mobile.model.payload.response;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RatingResponse {
    private ObjectId id;
    private ObjectId userId;
    private String userName; // Tên người dùng (nếu cần hiển thị)
    private ObjectId comicId;
    private String comicTitle; // Tiêu đề truyện (nếu cần hiển thị)
    private int rating;
}
