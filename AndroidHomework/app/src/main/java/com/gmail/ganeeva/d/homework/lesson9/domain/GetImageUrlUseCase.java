package com.gmail.ganeeva.d.homework.lesson9.domain;

import com.gmail.ganeeva.d.homework.lesson9.data.ImageUrls;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by Diana on 16.08.2017 at 17:13.
 */

public class GetImageUrlUseCase extends UseCase<Integer, String>{
    @Override
    public String buildUseCase(Integer integer) {
        return ImageUrls.getImageUrl(integer);
    }
}
