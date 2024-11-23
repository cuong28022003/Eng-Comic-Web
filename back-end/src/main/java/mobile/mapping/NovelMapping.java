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
        novelDetailResponse.setHinhanh(comic.getImage());
        novelDetailResponse.setTentruyen(comic.getName());
        novelDetailResponse.setTacgia(comic.getArtist());
        novelDetailResponse.setUrl(comic.getUrl());
        novelDetailResponse.setDanhgia(comic.getRating());
        novelDetailResponse.setNoidung(comic.getDescription());
        novelDetailResponse.setNguoidangtruyen(comic.getUploader().getTenhienthi());
        novelDetailResponse.setLuotdoc(comic.getViews());
        novelDetailResponse.setSoluongdanhgia(comic.getSoluongdanhgia());
        novelDetailResponse.setSochap(sochap);
        novelDetailResponse.setTheloai(comic.getGenre());
        novelDetailResponse.setTrangthai(comic.getTrangthai());
        return novelDetailResponse;
    }

    public static void UpdateRequestToNovel(UpdateNovelRequest updateNovelRequest, Comic oldComic){
        oldComic.setImage(updateNovelRequest.getHinhanh());
        oldComic.setName(updateNovelRequest.getTentruyen());
        oldComic.setArtist(updateNovelRequest.getTacgia());
        oldComic.setUrl(updateNovelRequest.getUrl());
        oldComic.setDescription(updateNovelRequest.getNoidung());
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
        novelResponse.setSoluongdanhgia(comic.getSoluongdanhgia());
        novelResponse.setTheloai(comic.getGenre());
        novelResponse.setTrangthai(comic.getTrangthai());
        return novelResponse;
    }
}
