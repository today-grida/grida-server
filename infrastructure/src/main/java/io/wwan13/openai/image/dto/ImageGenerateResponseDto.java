package io.wwan13.openai.image.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageGenerateResponseDto {

    private String created;
    private List<ImageUrl> data;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ImageUrl {
        private String url;
    }
}
