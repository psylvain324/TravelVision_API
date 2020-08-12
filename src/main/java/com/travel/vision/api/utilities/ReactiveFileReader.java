package com.travel.vision.api.utilities;

import reactor.core.publisher.Flux;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;

public class ReactiveFileReader {

    public Flux<DataBuffer> FileReader(String filePath) {
        return DataBufferUtils
                .read(
                        new DefaultResourceLoader().getResource(filePath),
                        new DefaultDataBufferFactory(),
                        1024
                )
                .log();
    }
}
