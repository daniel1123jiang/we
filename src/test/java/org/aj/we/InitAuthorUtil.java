package org.aj.we;

import org.aj.we.domain.Author;
import org.aj.we.domain.Image;
import org.aj.we.service.author.AuthorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class InitAuthorUtil {

    @Autowired
    AuthorService authorService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Test
    public void initAuthor() {
        //Lucille Daniel
        Author author = authorService.getAuthorByUsername("lucille");
        if(author == null){
            Author.Bio bio = new Author.Bio();
            bio.setTitle("Lucille");
            bio.setContent("content");
            author = Author.builder()
                    .username("lucille")
                    .password(passwordEncoder.encode(":?753951"))
                    .firstName("Lucille")
                    .lastName("Yang")
                    .portrait(Image.builder().url("/image/temp/icon.png").build())
                    .brief("bio")
                    .bio(bio)
                    .createdTime(System.currentTimeMillis())
                    .updateTime(System.currentTimeMillis())
                    .build();
            authorService.add(author);
        }

        Author author1 = authorService.getAuthorByUsername("daniel");
        if(author1 == null){
            Author.Bio bio = new Author.Bio();
            bio.setTitle("Daniel");
            bio.setContent("content");
            author1 = Author.builder()
                    .username("daniel")
                    .password(passwordEncoder.encode(":?753951"))
                    .firstName("Daniel")
                    .lastName("Jiang")
                    .portrait(Image.builder().url("/image/temp/icon.png").build())
                    .brief("bio")
                    .bio(bio)
                    .createdTime(System.currentTimeMillis())
                    .updateTime(System.currentTimeMillis())
                    .build();
            authorService.add(author1);
        }

    }
}
