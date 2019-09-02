package org.dj.we.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.dj.we.domain.Author;
import org.dj.we.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.dj.we.service.image.ImageService.IMAGE_SIGN;


@Slf4j
@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/image/upload")
    @ResponseBody
    public UploadImageResponse uploadImage(@RequestParam("upload") MultipartFile file, Author user) {
        String url = imageService.uploadImage(file, user);
        if (url == null) {
            return UploadImageResponse.fail();
        }
        return UploadImageResponse.succeed(url);

    }



    @GetMapping("/" + IMAGE_SIGN + "{path:.+}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String path, @PathVariable String filename) {

        Resource file = imageService.loadImage(path, filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @Data
    static class UploadImageResponse {

        public static UploadImageResponse succeed(String url) {
            return new UploadImageResponse(true, url);
        }

        public static UploadImageResponse fail() {
            return new UploadImageResponse(false, null);
        }


        private UploadImageResponse(boolean success, String url) {
            this.success = success;
            this.url = url;
        }

        private boolean success;

        private String fileName;

        private String url;
    }

}

