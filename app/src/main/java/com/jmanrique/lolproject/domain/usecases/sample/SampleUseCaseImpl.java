package com.jmanrique.lolproject.domain.usecases.sample;

import com.jmanrique.lolproject.domain.usecases.SingleUseCase;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.reactivex.rxjava3.core.Single;


public class SampleUseCaseImpl implements SampleUseCase, SingleUseCase<String, String> {

    @NotNull
    @Override
    public Single<String> execute(@Nullable Void s) {
        return Single.just("Sample");
    }
}
