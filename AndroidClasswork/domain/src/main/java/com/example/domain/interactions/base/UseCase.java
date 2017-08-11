package com.example.domain.interactions.base;

/**
 * Created by Diana on 11.08.2017.
 */

public abstract class UseCase<InParam, OutParam> {

    public OutParam execute(InParam param) {
        return buildUseCase();
    }

    public abstract OutParam buildUseCase();
}
