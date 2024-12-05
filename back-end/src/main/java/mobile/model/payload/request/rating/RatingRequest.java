package mobile.model.payload.request.rating;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RatingRequest {
    private ObjectId userId;
    private ObjectId comicId;
    private int rating;
}
