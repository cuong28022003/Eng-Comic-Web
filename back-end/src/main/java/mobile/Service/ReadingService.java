package mobile.Service;

import mobile.model.Entity.Comic;
import mobile.model.Entity.User;

import mobile.model.Entity.Reading;

import java.util.List;


public interface ReadingService {
   void upsertReading(Reading reading);
   List<Reading> getReadings(User user);
   void deleteAllReadingByNovel(Comic comic);

}
