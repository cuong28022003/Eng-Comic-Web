package mobile.mapping;

import mobile.model.Entity.Comic;
import mobile.model.payload.request.novel.CreateNovelRequest;
import mobile.model.payload.request.novel.UpdateNovelRequest;
import mobile.model.payload.response.NovelDetailResponse;
import mobile.model.payload.response.NovelResponse;

public class NovelMapping {
    public static Comic CreateRequestToNovel(CreateNovelRequest createNovelRequest){
        Comic newComic = new Comic();
        newComic.setImage(createNovelRequest.getImage());
        newComic.setName(createNovelRequest.getName());
        newComic.setArtist(createNovelRequest.getArtist());
        newComic.setGenre(createNovelRequest.getGenre());
        newComic.setUrl(createNovelRequest.getUrl());
        newComic.setRating(0);
        newComic.setDescription(createNovelRequest.getDescription());
        return newComic;
    }

    public static NovelDetailResponse EntityToNovelDetailResponse(Comic comic, int sochap){
        NovelDetailResponse novelDetailResponse = new NovelDetailResponse();
        novelDetailResponse.setId(comic.getId().toString());
        novelDetailResponse.setImage(comic.getImage());
        novelDetailResponse.setName(comic.getName());
        novelDetailResponse.setArtist(comic.getArtist());
        novelDetailResponse.setUrl(comic.getUrl());
        novelDetailResponse.setRating(comic.getRating());
        novelDetailResponse.setDescription(comic.getDescription());
        novelDetailResponse.setUploader(comic.getUploader().getTenhienthi());
        novelDetailResponse.setViews(comic.getViews());
        novelDetailResponse.setReviewCount(comic.getReviewCount());
        novelDetailResponse.setChapterCount(sochap);
        novelDetailResponse.setGenre(comic.getGenre());
        novelDetailResponse.setStatus(comic.getStatus());
        return novelDetailResponse;
    }

    public static void UpdateRequestToNovel(UpdateNovelRequest updateNovelRequest, Comic oldComic){
        oldComic.setImage(updateNovelRequest.getImage());
        oldComic.setName(updateNovelRequest.getName());
        oldComic.setArtist(updateNovelRequest.getArtist());
        oldComic.setUrl(updateNovelRequest.getUrl());
        oldComic.setDescription(updateNovelRequest.getDescription());
    }

    public static NovelResponse EntityToNovelResponse(Comic comic){
        NovelResponse novelResponse = new NovelResponse();
        novelResponse.setHinhanh(comic.getImage());
        novelResponse.setTentruyen(comic.getName());
        novelResponse.setTacgia(comic.getArtist());
        novelResponse.setUrl(comic.getUrl());
        novelResponse.setDanhgia(comic.getRating());
        novelResponse.setNoidung(comic.getDescription());
        novelResponse.setLuotdoc(comic.getViews());
        novelResponse.setSoluongdanhgia(comic.getReviewCount());
        novelResponse.setTheloai(comic.getGenre());
        novelResponse.setTrangthai(comic.getStatus());
        return novelResponse;
    }
}
