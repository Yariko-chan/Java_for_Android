package com.gmail.ganeeva.d.homework.lesson9.domain;

import com.gmail.ganeeva.d.homework.lesson9.data.ImageUrls;

/**
 * Created by Diana on 17.08.2017 at 16:27.
 */

public class GetImageCountUseCase extends UseCase<Void, Integer> {
    @Override
    public Integer buildUseCase(Void aVoid) {
        return ImageUrls.getImagesCount();
    }
}
