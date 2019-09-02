package org.aj.we;

import net.coobird.thumbnailator.Thumbnails;
import org.aj.we.domain.Author;
import org.aj.we.domain.Blog;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) throws IOException {


        for(int i=0;i<20;i++){
            thumbnail("/Users/jianghai/test/bb/"+i+".jpeg","/Users/jianghai/test/bb/image_"+i+".jpeg",.6);
        }


    }

    public static void thumbnail(String srcImagePath, String desImagePath, double scale) throws IOException {
        Thumbnails.of(srcImagePath).scale(scale).toFile(desImagePath);
    }
}
