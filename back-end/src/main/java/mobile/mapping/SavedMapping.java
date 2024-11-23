package mobile.mapping;

import mobile.model.Entity.Saved;
import mobile.model.payload.response.SavedResponse;

import java.util.ArrayList;
import java.util.List;

public class SavedMapping {
    public static SavedResponse EntityToResponse(Saved saved){
        SavedResponse savedResponse = new SavedResponse();
        savedResponse.setTentruyen(saved.getNovel().getName());
        savedResponse.setHinhanh(saved.getNovel().getImage());
        savedResponse.setUrl(saved.getNovel().getUrl());
        savedResponse.setTacgia(saved.getNovel().getArtist());
        savedResponse.setId(saved.getId());
        return savedResponse;
    }
    public static List<SavedResponse> ListEntityToResponse(List<Saved> savedList){
        List<SavedResponse> savedResponseList = new ArrayList<>();
        for (Saved saved: savedList ) {
            try{
                savedResponseList.add(EntityToResponse(saved));
            }
            catch (Exception ex){

            }

        }
        return savedResponseList;
    }
}
